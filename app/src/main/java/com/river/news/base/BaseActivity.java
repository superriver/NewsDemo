package com.river.news.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import com.river.news.annotation.ActivityFragmentInject;

/**
 * Created by Administrator on 2016/7/29.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
  /**
   * 将代理类通用行为抽c出来
   */
  protected T mPresenter;

  /**
   * 标示该Activity是否可滑动退出，默认false
   */
  protected boolean mEnableSlider;

  /**
   * 布局的id
   */
  protected int mContentViewId;
  /**
   * 是否存在NavigationView
   */
  protected boolean mHasNavigationView;
  /**
   * 菜单Id
   */
  private int mMenuId;
  /**
   * Toolbar标题
   */
  private int mToolbarTitle;
  /**
   * 默认选中的菜单项
   */
  private int mMenuDefaultCheckedItem;
  /**
   * Toolbar左侧按钮的样式
   */
  private int mToolbarIndicator;

  /**
   * 滑动布局
   */
  protected DrawerLayout mDrawerLayout;
  /**
   * 侧滑导航布局
   */
  protected NavigationView mNavigationView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getClass().isAnnotationPresent(ActivityFragmentInject.class)) {
      ActivityFragmentInject annotation = getClass().getAnnotation(ActivityFragmentInject.class);
      mEnableSlider = annotation.enableSlider();
      mContentViewId = annotation.contentViewId();
      mHasNavigationView = annotation.hasNavigationView();
      mMenuId = annotation.menuId();
      mToolbarTitle = annotation.toolbarTitle();
      mMenuDefaultCheckedItem = annotation.menuDefaultCheckedItem();
      mToolbarIndicator = annotation.toolbarIndicator();
    }else{
      throw new RuntimeException("Class must add annotations of ActivityFragmentInitParams.class");
    }
  }
}
