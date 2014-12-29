package com.fightfive.track.login;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import com.fightfive.track.App;
import com.fightfive.track.http.HttpTools;
import com.google.gson.Gson;

public class Login {

	private static final String tag = Login.class.getSimpleName();

	public static void getToken(User user) {
		// ת������
		Gson gson = new Gson();
		String json = gson.toJson(user);
		Log.d(tag, "user json: " + json);

		// �ύ����
		String url = "http://1.traineeapp.sinaapp.com/my_land.php";
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("user_land", json));
		String result = HttpTools.uploadJSON(url, pairs);
		Log.d(tag, "result: " + result);

		// ����token
		if (result.startsWith("token=")) {
			String token = result.substring("token=".length());
			App.setToken(token);
			Log.d(tag, "token: " + token);
		}
	}
}
