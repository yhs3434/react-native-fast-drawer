package com.fastdrawer;

import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ViewGroupManager;

import java.util.Map;

public abstract class FastDrawerViewManagerSpec extends ViewGroupManager<com.fastdrawer.FastDrawerView> {
  public abstract void setDrawerPosition(FastDrawerView view, String position);
  public abstract void setDrawerWidth(FastDrawerView view, Integer drawerWidth);
  public abstract void openDrawer(DrawerLayout view);
  public abstract void closeDrawer(DrawerLayout view);
}
