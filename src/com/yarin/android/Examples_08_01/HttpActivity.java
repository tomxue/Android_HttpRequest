package com.yarin.android.Examples_08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//直接获取数据
public class HttpActivity extends Activity {
	private final String DEBUG_TAG = "HttpActivity";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.http);
		TextView mTextView = (TextView) this.findViewById(R.id.TextView_HTTP);
		// http地址
		String httpUrl = "http://192.168.0.7:8080/http.jsp";
		// 获得的数据
		String resultData = "";
		URL url = null;
		try {
			// 构造一个URL对象
			url = new URL(httpUrl);
		} catch (MalformedURLException e) {
			Log.e(DEBUG_TAG, "MalformedURLException");
		}
		if (url != null) {
			try {
				// Tom Xue: HttpURLConnection --getInputStream--> 
				// InputStreamReader(byte stream->character stream) -> 
				// BufferedReader(8192 characters) --readLine(1 line)--> ...
				// 使用HttpURLConnection打开连接
				HttpURLConnection urlConn = (HttpURLConnection) url
						.openConnection();
				// 得到读取的内容(流)
				InputStreamReader in = new InputStreamReader(
						urlConn.getInputStream());
				// 为输出创建BufferedReader
				BufferedReader buffer = new BufferedReader(in);
				String inputLine = null;
				// 使用循环来读取获得的数据
				while (((inputLine = buffer.readLine()) != null)) {
					// 我们在每一行后面加上一个"\n"来换行
					resultData += inputLine + "\n";
				}
				// 关闭InputStreamReader
				in.close();
				// 关闭http连接
				urlConn.disconnect();
				// 设置显示取得的内容
				if (resultData != null) {
					mTextView.setText(resultData);
				} else {
					mTextView.setText("读取的内容为NULL");
				}
			} catch (IOException e) {
				Log.e(DEBUG_TAG, "IOException");
			}
		} else {
			Log.e(DEBUG_TAG, "Url NULL");
		}
		// 设置按键事件监听
		Button button_Back = (Button) findViewById(R.id.Button_Back);
		/* 监听button的事件信息 */
		button_Back.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				intent.setClass(HttpActivity.this, MainActivity.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				HttpActivity.this.finish();
			}
		});
	}
}