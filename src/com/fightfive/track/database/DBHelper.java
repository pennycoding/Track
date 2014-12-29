package com.fightfive.track.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static final String name = "track.db";
	private static final int version = 1;

	public DBHelper(Context context) {
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// 创建周记表
		db.execSQL("CREATE TABLE IF NOT EXISTS diary(week_id TEXT, sid TEXT, content TEXT, harvest TEXT, suggestion TEXT, is_upload TEXT DEFAULT N)");
		// 创建信息表
		db.execSQL("CREATE TABLE IF NOT EXISTS information(sid TEXT, name TEXT, class_name TEXT, phone TEXT, email TEXT, company_name TEXT, company_address TEXT, modify_time TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}
