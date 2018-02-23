package com.wangcpp.appstore.ui.impl.acticity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.wangcpp.appstore.R;
import com.wangcpp.appstore.presenter.IMainPresenter;
import com.wangcpp.appstore.presenter.impl.MainPresenter;
import com.wangcpp.appstore.repository.impl.PostRequestRepository;
import com.wangcpp.appstore.ui.IMainView;
import com.wangcpp.appstore.ui.impl.fragment.AppStoreFragment;
import com.wangcpp.appstore.ui.impl.fragment.BaseFragment;


public class MainActivity extends BaseActivity<IMainPresenter> implements IMainView {

    private final String TAG = MainActivity.class.getSimpleName();

    //================= View ===================
    private Toolbar toolbar = null;

    private FloatingActionButton fab = null;


    //================= Fragment ===================
    private FragmentManager mFragmentManger = getSupportFragmentManager();

    private SparseArray<BaseFragment> mFragmentStack = new SparseArray<>();

    private BaseFragment currentFragment = null;

    private AppStoreFragment appStoreFragment = null;


    private final int FRAGMENT_ONE = 1001;

    private final int FRAGMENT_TWO = 1002;


    @Override
    protected IMainPresenter initPresenter() {
        return new MainPresenter(new PostRequestRepository());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment();

        mPresenter.login(); // 登录
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void initEvent() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initFragment() {
        appStoreFragment = new AppStoreFragment();
        appStoreFragment.setFragmentId(FRAGMENT_ONE);
    }

    private void setDefaultFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManger.beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment_mainActivity, fragment);
        fragmentTransaction.commit();
        mFragmentStack.put(fragment.getFragmentId(), fragment);
        currentFragment = fragment;
    }

    private void replaceFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManger.beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment_mainActivity, fragment);
        fragmentTransaction.commit();
        mFragmentStack.put(fragment.getFragmentId(), fragment);
        currentFragment = fragment;
    }

    @Override
    public void onLoginResult(boolean result) {
        if (result) {
            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            setDefaultFragment(appStoreFragment); // 拿到登录成功的结果后，立即创建“应用商店”Fragment
        } else {
            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 记录拥护首次点击返回键的时间
     */
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;
                    return true;
                } else {
                    System.exit(0);
                }
                break;
            default:
                break;
        }

        return super.onKeyDown(keyCode, event);
    }
}
