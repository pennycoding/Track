package com.fightfive.track.information;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.fightfive.track.App;
import com.fightfive.track.database.DBHelper;
import com.fightfive.track.http.HttpTools;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class InformationService extends Service {

	public static final String tag = InformationService.class.getSimpleName();

	private InformationDao dao;

	@Override
	public void onCreate() {
		super.onCreate();

		DBHelper helper = new DBHelper(this);
		dao = new InformationDao(helper);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new Thread(new SyncInformation()).start();

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ͬ����������������������߳�
	 * 
	 * @author Crysty
	 * 
	 */
	class SyncInformation implements Runnable {

		@Override
		public void run() {
			// �Ա�����
			Information information = dao.select();
			Information info = downloadInformation();
			if (information == null && info != null) {
				// dao.insert(info); TODO ���͹㲥
				Intent intent = new Intent();
				intent.setAction("com.fightfive.track.action.info.cache");
				sendBroadcast(intent);
				Log.d(tag, "sync over");
				return;
			}
			if (information != null && info != null) {
				// TODO �Ƚ�ʱ������
				if (information.getModify_time().equals(info.getModify_time())) {
					Log.d(tag, "do not sync");
					return;
				}
			}

			// ת������
			Gson gson = new Gson();
			String json = gson.toJson(information);
			Log.d(tag, "upload json: " + json);

			// �ϴ�����
			String url = "http://1.traineeapp.sinaapp.com/my_information.php";
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("information", json));
			String result = HttpTools.uploadJSON(url, pairs);
			Log.d(tag, "result: " + result);
		}
	}

	/**
	 * ��ȡ��������󱣴�ĸ�����Ϣ����
	 * 
	 * @return ������Ϣ
	 */
	private Information downloadInformation() {
		// ��ȡ����
		String url = "http://1.traineeapp.sinaapp.com/return_information.php";
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("student_token", App.token));
		String json = HttpTools.uploadJSON(url, pairs);
		Log.d(tag, "download json: " + json);

		// ��װ����
		Gson gson = new Gson();
		Information information = gson.fromJson(json,
				new TypeToken<Information>() {
				}.getType());
		return information;
	}
}
