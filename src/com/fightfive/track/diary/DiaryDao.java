package com.fightfive.track.diary;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DiaryDao {

	private static final String table = "diary";

	private SQLiteOpenHelper helper;

	public DiaryDao(SQLiteOpenHelper helper) {
		this.helper = helper;
	}

	public void insert(Diary diary) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("week_id", diary.getWeek_id());
		values.put("sid", diary.getSid());
		values.put("content", diary.getContent());
		values.put("harvest", diary.getHarvest());
		values.put("suggestion", diary.getSuggestion());
		db.insert(table, null, values);
		db.close();
	}

	public void update(Diary diary) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("week_id", diary.getWeek_id());
		values.put("sid", diary.getSid());
		values.put("content", diary.getContent());
		values.put("harvest", diary.getHarvest());
		values.put("suggestion", diary.getSuggestion());
		values.put("is_upload", diary.getIs_upload());
		db.update(table, values, "week_id = ?",
				new String[] { diary.getWeek_id() + "" });
		db.close();
	}

	public Diary selectByWeekId(int weekId) {
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.query(table, null, "week_id = ?",
				new String[] { weekId + "" }, null, null, null);
		Diary diary = null;
		while (cursor.moveToNext()) {
			diary = new Diary();
			int week_id = cursor.getInt(0);
			String sid = cursor.getString(1);
			String content = cursor.getString(2);
			String harvest = cursor.getString(3);
			String suggestion = cursor.getString(4);

			diary.setWeek_id(week_id);
			diary.setSid(sid);
			diary.setContent(content);
			diary.setHarvest(harvest);
			diary.setSuggestion(suggestion);
		}
		db.close();
		return diary;
	}

	public List<Diary> selectAllIsN() {
		List<Diary> diaries = new ArrayList<Diary>();
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.query(table, null, "is_upload = ?",
				new String[] { "N" }, null, null, null);
		Diary diary = null;
		while (cursor.moveToNext()) {
			diary = new Diary();
			int week_id = cursor.getInt(0);
			String sid = cursor.getString(1);
			String content = cursor.getString(2);
			String harvest = cursor.getString(3);
			String suggestion = cursor.getString(4);

			diary.setWeek_id(week_id);
			diary.setSid(sid);
			diary.setContent(content);
			diary.setHarvest(harvest);
			diary.setSuggestion(suggestion);
			diaries.add(diary);
		}
		db.close();
		return diaries;
	}
}
