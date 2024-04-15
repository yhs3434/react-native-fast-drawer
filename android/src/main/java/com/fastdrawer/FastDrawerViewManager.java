package com.fastdrawer;

import android.graphics.Color;
import android.view.Gravity;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@ReactModule(name = FastDrawerViewManager.NAME)
public class FastDrawerViewManager extends com.fastdrawer.FastDrawerViewManagerSpec<FastDrawerView> {

  public static final String NAME = "FastDrawerView";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public FastDrawerView createViewInstance(ThemedReactContext context) {
    return new FastDrawerView(context);
  }

  @Override
  @ReactProp(name = "drawerPosition")
  public void setDrawerPosition(FastDrawerView view, String position) {
    int gravity = position.equals("left") ? Gravity.LEFT : Gravity.RIGHT;
    view.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, gravity);
  }

  @Override
  @ReactMethod
  public void openDrawer(DrawerLayout view) {
    view.openDrawer(Gravity.LEFT);
  }

  @Override
  @ReactMethod
  public void closeDrawer(DrawerLayout view) {
    view.closeDrawer(Gravity.LEFT);
  }
}
