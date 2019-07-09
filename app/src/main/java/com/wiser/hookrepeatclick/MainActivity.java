package com.wiser.hookrepeatclick;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.tv_click).setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(View v) {
				Log.e("--------->>", "点击了");
			}
		});
	}
}
