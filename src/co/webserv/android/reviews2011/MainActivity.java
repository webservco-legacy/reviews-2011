package co.webserv.android.reviews2011;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	protected WebView mWebView;

	public static final String LOG_TAG = "COWEBSERVANDROID";

	float mProgression = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Remove notification bar
		// this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		mWebView = (WebView) findViewById(R.id.browserWindow);

		WebSettings mWebSettings = mWebView.getSettings();

		mWebSettings.setDomStorageEnabled(true);

		mWebSettings.setDatabaseEnabled(true);

		mWebSettings.setAppCachePath(Environment.getDataDirectory().toString()
				+ "/data/" + getPackageName() + "/cache");

		mWebSettings.setAllowFileAccess(true);

		mWebSettings.setAppCacheEnabled(true);

		mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

		// mWebView.setVerticalScrollBarEnabled(false);

		mWebView.setHorizontalScrollBarEnabled(false);
		
		final SharedPreferences shared_preferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
		
		String url = shared_preferences.getString("url", "");
		
		if (url.length() == 0) {
			
			url = "file:///android_asset/index.htm";
		}
		
		Log.d(LOG_TAG, "onCreate: url: " + url);
		
		mWebView.setWebViewClient(new WebViewClient() {
			
			@Override
			public void onPageFinished(WebView view, String url) {
				
				Log.d(LOG_TAG, "onPageFinished: url: " + url);
				
				shared_preferences.edit().putString("url", url).apply();
				
				super.onPageFinished(view, url);
			}
		});

		mWebView.loadUrl(url);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
