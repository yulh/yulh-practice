package net.practice.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;

import net.practice.R;
import net.practice.app.StaticParamterUtil;
import net.practice.ui.base.BaseActivity;
import net.practice.ui.main.fragment.MainFragment;
import net.practice.ui.main.fragment.MineFragment;
import net.practice.mvp.model.MainModel;
import net.practice.mvp.presenter.MainPresenter;
import net.practice.mvp.view.MainView;
import net.practice.utlis.SharePerferenUtil;
import net.practice.utlis.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView{

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MainFragment mainFragment;
    private MineFragment mineFragment;
    private List<Fragment> lists;

    @BindView(R.id.main_viewPager)
    public ViewPager viewPager;
    @BindView(R.id.radioButton_main)
    public RadioButton radioButtonMain;
    @BindView(R.id.radioButton_mine)
    public RadioButton radioButtonMine;


    @Override

    public int findLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        mainFragment = new MainFragment();
        mineFragment = new MineFragment();

        lists = new ArrayList<Fragment>();

        lists.add(mainFragment);
        lists.add(mineFragment);

        viewPager.setAdapter(new MyPagerAdpter(fragmentManager, lists));
        viewPager.setCurrentItem(0);
        radioButtonMain.setChecked(true);

        setListener();
    }

    @Override
    public void initData() {
    }

    @Override
    protected MainPresenter createPresenter() {
        return null;
    }

    public void setListener() {
        radioButtonMain.setOnClickListener(this);
        radioButtonMine.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    radioButtonMain.setChecked(true);
                    radioButtonMine.setChecked(false);
                } else if (position == 1) {
                    radioButtonMain.setChecked(false);
                    radioButtonMine.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButton_main:
                viewPager.setCurrentItem(0);
                radioButtonMain.setChecked(true);
                radioButtonMine.setChecked(false);
                break;
            case R.id.radioButton_mine:
                viewPager.setCurrentItem(1);
                radioButtonMain.setChecked(false);
                radioButtonMine.setChecked(true);
                break;
        }
    }

    @Override
    public void getDataSuccess(MainModel model) {

    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    class MyPagerAdpter extends FragmentPagerAdapter {

        private List<Fragment> lists;

        public MyPagerAdpter(FragmentManager fm, List<Fragment> lists) {
            super(fm);
            this.lists = lists;
        }

        @Override
        public Fragment getItem(int position) {
            return lists.get(position);
        }

        @Override
        public int getCount() {
            return lists.size();
        }
    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    /**
     * 第一种解决办法 通过监听keyUp
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                ToastUtil.showShort(MainActivity.this, "再按一次退出程序");
                firstTime = secondTime;
                return true;
            } else {
                SharePerferenUtil.setParam(mContext, StaticParamterUtil.IS_AlREADY_LOGIN,false);
                System.exit(0);
            }
        }

        return super.onKeyUp(keyCode, event);
    }
}