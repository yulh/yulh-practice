package simcpux.sourceforge.net.refreshview_sample.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.mylhyl.crlayout.SwipeRefreshGridView;

import simcpux.sourceforge.net.refreshview_sample.R;


/**
 * Created by hupei on 2016/5/16.
 */
public class MySwipeRefreshGridView extends SwipeRefreshGridView {
    public MySwipeRefreshGridView(Context context) {
        super(context);
    }

    public MySwipeRefreshGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getLoadLayoutResource() {
        return R.layout.swipe_refresh_footer;
    }
}
