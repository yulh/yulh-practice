package simcpux.sourceforge.net.pullrefreshsample.activity;


import android.app.Activity;
import android.os.Bundle;

import simcpux.sourceforge.net.pullrefreshsample.MyListener;
import simcpux.sourceforge.net.pullrefreshsample.PullToRefreshLayout;
import simcpux.sourceforge.net.pullrefreshsample.R;

public class PullableImageViewActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imageview);
		((PullToRefreshLayout) findViewById(R.id.refresh_view))
				.setOnRefreshListener(new MyListener());
	}
}
