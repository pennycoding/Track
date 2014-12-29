package com.fightfive.track.information;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InformationDao {

	private static final String table = "information";

	private SQLiteOpenHelper helper;

	public InformationDao(SQLiteOpenHelper helper) {
		this.helper = helper;
	}

	public void insert(Information information) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("sid", information.getSid());
		values.put("name", information.getName());
		values.put("class_name", information.getClass_name());
		values.put("phone", information.getPhone());
		values.put("email", information.getEmail());
		values.put("company_name", information.getCompany_name());
		values.put("company_address", information.getCompany_address());
		values.put("modify_time", information.getModify_time());
		db.insert(table, null, values);
		db.close();
	}
	
	public int update(Information information) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("sid", information.getSid());
		values.put("name", information.getName());
		values.put("class_name", information.getClass_name());
		values.put("phone", information.getPhone());
		values.put("email", information.getEmail());
		values.put("company_name", information.getCompany_name());
		values.put("company_address", information.getCompany_address());
		values.put("modify_time", information.getModify_time());
		int rows = db.update(table, values, "sid = ?",
				new String[] { information.getSid() });
		db.close();
		return rows;
	}

	public Information select() {
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.query(table, null, null, null, null, null, null);
		Information information = null;
		while (cursor.moveToNext()) {
			information = new Information();
			String sid = cursor.getString(0);
			String name = cursor.getString(1);
			String class_name = cursor.getString(2);
			String phone = cursor.getString(3);
			String email = cursor.getString(4);
			String company_name = cursor.getString(5);
			String company_address = cursor.getString(6);
			String modify_time =cursor.getString(7);
				

			information.setSid(sid);
			information.setName(name);
			information.setClass_name(class_name);
			information.setPhone(phone);
			information.setEmail(email);
			information.setCompany_name(company_name);
			information.setCompany_address(company_address);
			information.setModify_time(modify_time);
		}
		db.close();
		return information;
	}
}
