package net.practice.ui.register;

import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import net.practice.R;
import net.practice.app.StaticParamterUtil;
import net.practice.bean.UserBean;
import net.practice.ui.base.BaseActivity;
import net.practice.ui.base.BasePresenter;
import net.practice.ui.main.MainActivity;
import net.practice.utlis.ActivityManager;
import net.practice.utlis.SharePerferenUtil;
import net.practice.utlis.ToastUtil;

import org.litepal.crud.DataSupport;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActiviy extends BaseActivity {

    @BindView(R.id.userName)
    EditText userNameView;
    @BindView(R.id.password)
    EditText passwordView;
    @BindView(R.id.pwdIsVisable)
    ImageView isVisablePassword;

    @BindView(R.id.register)
    Button register;

    @Override
    public int findLayoutID() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {

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

    @OnClick({R.id.pwdIsVisable, R.id.register})
    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.pwdIsVisable:
                setPasswordVisibility();
                break;
            case R.id.register:
                register();
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

    private void register() {

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

        boolean isExist = DataSupport.isExist(UserBean.class, "UserName=? ", userName);

        if (!isExist) {
            UserBean userBean = new UserBean();
            userBean.setUserName(userName);
            userBean.setPassword(passWord);
            boolean flag = userBean.save();
            if (flag == true) {
                userNameView.setText("");
                passwordView.setText("");
                ToastUtil.showShort(mContext, "注册成功");
                return;
            }
        }

        ToastUtil.showShort(mContext, "用户已存在");
    }
}
