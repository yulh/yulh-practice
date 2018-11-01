package net.practice.ui.login;

import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import net.practice.R;
import net.practice.app.StaticParamterUtil;
import net.practice.bean.UserBean;
import net.practice.mvp.model.LoginModel;
import net.practice.mvp.presenter.LoginPresenter;
import net.practice.mvp.view.LoginView;
import net.practice.ui.base.BaseActivity;
import net.practice.ui.base.BasePresenter;
import net.practice.ui.main.MainActivity;
import net.practice.utlis.ActivityManager;
import net.practice.utlis.AppUtils;
import net.practice.utlis.LogUtil;
import net.practice.utlis.ProgressDialogUtil;
import net.practice.utlis.SharePerferenUtil;
import net.practice.utlis.ToastUtil;

import org.litepal.crud.DataSupport;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.userName)
    EditText userNameView;
    @BindView(R.id.password)
    EditText passwordView;
    @BindView(R.id.pwdIsVisable)
    ImageView isVisablePassword;

    @BindView(R.id.login)
    Button login;

    @Override
    public int findLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        userNameView.setText(SharePerferenUtil.getParam(mContext, "userName", "123456").toString());
        passwordView.setText(SharePerferenUtil.getParam(mContext, "password", "123456").toString());
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

    @OnClick({R.id.pwdIsVisable, R.id.login})
    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.pwdIsVisable:
                setPasswordVisibility();
                break;
            case R.id.login:
                login();
                break;
        }
    }

    /**
     * 设置密码可见和不可见的相互转换
     */
    private void setPasswordVisibility() {
        if (isVisablePassword.isSelected()) {
            isVisablePassword.setSelected(false);
            //密码不可见
            passwordView.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            isVisablePassword.setBackgroundResource(R.drawable.pwd_visitno);
        } else {
            isVisablePassword.setSelected(true);
            //密码可见
            passwordView.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            isVisablePassword.setBackgroundResource(R.drawable.pwd_visit);
        }

    }


    private String userName;
    private String passWord;

    public void login() {

        userName = userNameView.getText().toString();
        passWord = passwordView.getText().toString();

        if (userName == null || userName.equals("")) {
            ToastUtil.showShort(mContext, "用户名不能为空");
            userNameView.requestFocus();
            return;
        }

        if (passWord == null || passWord.equals("")) {
            ToastUtil.showShort(mContext, "密码不能为空");
            passwordView.requestFocus();
            return;
        }

        boolean isExist = DataSupport.isExist(UserBean.class, "UserName=? AND Password=? ", userName, passWord);

        if (isExist) {
            SharePerferenUtil.setParam(mContext, StaticParamterUtil.IS_AlREADY_LOGIN, true);
            startActivity(new Intent(mContext, MainActivity.class));
            ActivityManager.getInstance().finishActivity(this);
        } else {
            ToastUtil.showShort(mContext, "用户不存在");
        }
    }
}
