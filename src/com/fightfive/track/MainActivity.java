package com.fightfive.track;
//https://github.com/pennycoding/Track.git
import com.fightfive.track.activity.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

	Button btn_infomation, btn_diary, btn_login;

	Dialog dialog = null;
	 String name,password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_infomation = (Button) findViewById(R.id.btn_infomation);
		btn_diary = (Button) findViewById(R.id.btn_diary);
		btn_login = (Button) findViewById(R.id.btn_login);

		btn_infomation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub\
				Intent intent = new Intent(MainActivity.this, MyInfo.class);
				MainActivity.this.startActivity(intent);
			}
		});

		btn_diary.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub\
				Intent intent = new Intent(MainActivity.this, MyDiary.class);
				MainActivity.this.startActivity(intent);

			}
		});

		btn_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub\

				// Intent intent = new Intent(MainActivity.this, MyDiary.class);
				// MainActivity.this.startActivity(intent);
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				LayoutInflater layoutInflator = getLayoutInflater();
				View temp = layoutInflator.inflate(R.layout.land,
						null);

				Button btn_ok = (Button) temp.findViewById(R.id.btn_login_ok);
				Button btn_cancel = (Button) temp.findViewById(R.id.btn_cancel);
				
				EditText et_name=(EditText) temp.findViewById(R.id.et_name);
				EditText et_password=(EditText) temp.findViewById(R.id.et_password);
				
				
				name=et_name.getText().toString();
				password=et_password.getText().toString();
				 
				 
				
				btn_ok.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						System.out.println("确定登录");
						System.out.println(name);
						System.out.println(password);

						/*System.out.println(name);
						System.out.println(password);*/
						

					/*	if (dialog != null) {
							dialog.dismiss();
						}*/

					}
				});
				
				
				btn_cancel.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						System.out.println("取消登录");
						/*
						if (dialog != null) {
							dialog.dismiss();
						}*/

					}
				});

				builder.setView(temp);

				dialog = builder.create();

				dialog.show();

			}
		});
		/*
		 * Intent intent = new Intent(); intent.setClass(this,
		 * DiaryService.class); intent.setClass(this, InformationService.class);
		 * startService(intent);
		 */

	}
}
