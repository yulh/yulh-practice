package net.practice.ui.splash;

import android.content.Intent;
import android.view.View;

import net.practice.R;
import net.practice.ui.base.BaseActivity;
import net.practice.ui.base.BasePresenter;
import net.practice.ui.login.LoginActivity;
import net.practice.ui.main.MainActivity;
import net.practice.utlis.ActivityManager;
import net.practice.utlis.AppUtils;
import net.practice.utlis.SharePerferenUtil;

public class SplashActivity extends BaseActivity {
    @Override
    public int findLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        Intent intent = new Intent();
        boolean IsAlreadyLogin = Boolean.parseBoolean(SharePerferenUtil.getParam(mContext, AppUtils.IS_AlREADY_LOGIN, false).toString());
        if (IsAlreadyLogin == false) {
            intent.setClass(mContext, LoginActivity.class);
            startActivity(intent);
        } else {
            intent.setClass(mContext, MainActivity.class);
            startActivity(intent);
        }

        ActivityManager.getInstance().finishActivity(this);
    }

    @Override
    public void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }


}
