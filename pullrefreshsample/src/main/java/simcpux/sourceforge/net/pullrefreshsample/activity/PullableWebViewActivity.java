package simcpux.sourceforge.net.pullrefreshsample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import simcpux.sourceforge.net.pullrefreshsample.MyListener;
import simcpux.sourceforge.net.pullrefreshsample.PullToRefreshLayout;
import simcpux.sourceforge.net.pullrefreshsample.R;


public class PullableWebViewActivity extends Activity
{
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		((PullToRefreshLayout) findViewById(R.id.refresh_view))
				.setOnRefreshListener(new MyListener());
		webView = (WebView) findViewById(R.id.content_view);
		webView.loadUrl("http://blog.csdn.net/zhongkejingwang");
	}
}
