package com.fastdrawer;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.SimpleViewManager;

public abstract class FastDrawerViewManagerSpec<T extends View> extends SimpleViewManager<T> {
  public abstract void setColor(T view, @Nullable String value);
  public abstract void setDrawerPosition(T view, String position);

  @ReactMethod
  public abstract void openDrawer(DrawerLayout view);

  @ReactMethod
  public abstract void closeDrawer(DrawerLayout view);
}
