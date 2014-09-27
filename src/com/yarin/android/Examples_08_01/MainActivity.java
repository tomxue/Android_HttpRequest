package com.yarin.android.Examples_08_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button_http = (Button) findViewById(R.id.Button_HTTP);
		/* 监听button的事件信息 */
		button_http.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				intent.setClass(MainActivity.this, HttpActivity.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				MainActivity.this.finish();
			}
		});

		Button button_Get = (Button) findViewById(R.id.Button_Get);
		/* 监听button的事件信息 */
		button_Get.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				intent.setClass(MainActivity.this, GetActivity.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				MainActivity.this.finish();
			}
		});

		Button button_Post = (Button) findViewById(R.id.Button_Post);
		/* 监听button的事件信息 */
		button_Post.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				intent.setClass(MainActivity.this, PostActivity.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				MainActivity.this.finish();
			}
		});
	}
}
