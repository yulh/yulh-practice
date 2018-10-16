package simcpux.sourceforge.net.custom_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

public class CustomPopWindow extends PopupWindow {

    private Context mContext;
    private View mPopView;

    public CustomPopWindow(Context context) {
        super(context);
        mContext = context;
        initView();
        setPopWindow();
    }

    private void setPopWindow() {
        this.setContentView(mPopView);
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mPopView = inflater.inflate(R.layout.layout_custom_pop, null);
    }

    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 18);
        } else {
            this.dismiss();
        }
    }
}
