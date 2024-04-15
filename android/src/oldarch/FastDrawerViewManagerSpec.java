package com.fastdrawer;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ViewGroupManager;

public abstract class FastDrawerViewManagerSpec extends ViewGroupManager<com.fastdrawer.FastDrawerView> {
  public abstract void setDrawerPosition(FastDrawerView view, String position);
  public abstract void openDrawer(DrawerLayout view);
  public abstract void closeDrawer(DrawerLayout view);
}
