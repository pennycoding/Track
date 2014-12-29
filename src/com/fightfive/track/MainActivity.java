package com.fightfive.track;

import com.fightfive.track.diary.DiaryService;
import com.fightfive.track.information.InformationService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = new Intent();
//		intent.setClass(this, DiaryService.class);
		intent.setClass(this, InformationService.class);
		startService(intent);
	}
}
