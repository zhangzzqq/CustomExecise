package com.example.testscrollheaderhide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnSrcoll = (Button) findViewById(R.id.btn_srcoll);
		btnSrcoll.setOnClickListener(new btnClickListener());
		Button btnXlist = (Button) findViewById(R.id.btn_xlist);
		btnXlist.setOnClickListener(new btnClickListener());
	}

	private class btnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btn_srcoll:
				startActivity(new Intent(MainActivity.this,
						SrcollActivity.class));
				break;
			case R.id.btn_xlist:
				startActivity(new Intent(MainActivity.this, XListActivity.class));
				break;
			default:
				break;
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
