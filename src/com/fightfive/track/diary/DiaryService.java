package com.fightfive.track.diary;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.fightfive.track.database.DBHelper;
import com.fightfive.track.http.HttpTools;
import com.google.gson.Gson;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DiaryService extends Service {

	private List<Diary> diaries = new ArrayList<Diary>();
	private DiaryDao dao;

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("onCreate...");// TODO

		DBHelper helper = new DBHelper(this);
		dao = new DiaryDao(helper);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand...");// TODO

		new Thread(new UploadDiary()).start();

		return super.onStartCommand(intent, flags, startId);
	}

	class UploadDiary implements Runnable {

		@Override
		public void run() {
			diaries = dao.selectAllIsN();
			if (diaries.size() == 0) {
				return;
			}

			Gson gson = new Gson();
			String json = gson.toJson(diaries);
			String url = "http://1.traineeapp.sinaapp.com/my_diary.php";
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("diary", json));
			String result = HttpTools.uploadJSON(url, pairs);
			System.out.println("result: " + result);

			if ("success".equals(result)) {
				for (Diary diary : diaries) {
					diary.setIs_upload("Y");
					dao.update(diary);
				}
			}
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("onDestroy...");// TODO
	}
}
