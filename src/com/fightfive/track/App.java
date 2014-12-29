package com.fightfive.track;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class App extends Application {

	public static String token = "0dbd67e6c0f9a6ca0aec127d6c344d05";//TODO

	public static SharedPreferences preferences;

	@Override
	public void onCreate() {
		super.onCreate();

		System.out.println("App onCreate...");

		preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
		token = preferences.getString("token", "");
	}

	public static void setToken(String token) {
		App.token = token;
		Editor editor = App.preferences.edit();
		editor.putString("token", token);
		editor.commit();
	}
}
