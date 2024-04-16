package com.fastdrawer;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.views.view.ReactViewGroup;

import java.util.HashMap;
import java.util.Map;

@ReactModule(name = FastDrawerViewManager.NAME)
public class FastDrawerViewManager extends com.fastdrawer.FastDrawerViewManagerSpec {
  public final int COMMAND_OPEN_DRAWER = 1;
  public final int COMMAND_CLOSE_DRAWER = 2;

  public static final String NAME = "FastDrawerView";

  private FrameLayout contentView;
  private FrameLayout drawerView;

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public FastDrawerView createViewInstance(ThemedReactContext context) {
    FastDrawerView drawerLayout = new FastDrawerView(context);

    // Main content view
    contentView = new FrameLayout(context);
    contentView.setLayoutParams(new DrawerLayout.LayoutParams(
      DrawerLayout.LayoutParams.MATCH_PARENT,
      DrawerLayout.LayoutParams.MATCH_PARENT
    ));

    // Drawer view
    drawerView = new FrameLayout(context);
    drawerView.setBackgroundColor(Color.TRANSPARENT);

    drawerLayout.addView(contentView);
    drawerLayout.addView(drawerView);

    return drawerLayout;
  }

  @Override
  public void addView(FastDrawerView parent, View child, int index) {
    switch (index) {
      case 0:
        contentView.addView(child);
        break;
      case 1:
        drawerView.addView(child);
        break;
    }
  }

  @Override
  @ReactProp(name = "drawerPosition")
  public void setDrawerPosition(FastDrawerView view, String position) {
    int gravity = position.equals("left") ? Gravity.LEFT : Gravity.RIGHT;
    view.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, gravity);
  }

  @Override
  @ReactProp(name = "drawerWidth")
  public void setDrawerWidth(FastDrawerView view, @Nullable Integer drawerWidth) {
    if (drawerWidth != null) {
      DrawerLayout.LayoutParams drawerParams = new DrawerLayout.LayoutParams(
        drawerWidth,
        DrawerLayout.LayoutParams.MATCH_PARENT
      );
      drawerParams.gravity = GravityCompat.END;
      drawerView.setLayoutParams(drawerParams);

      view.removeAllViews();
      view.addView(contentView);
      view.addView(drawerView);
    }
  }

  @Override
  @ReactProp(name = "backdropColor")
  public void setBackdropColor(FastDrawerView view, @Nullable String color) {
    view.setScrimColor(Color.parseColor(color));
  }

  @Override
  @ReactProp(name = "enableLock")
  public void setDrawerLockMode(FastDrawerView view, Boolean isLock) {
    if (isLock == true) {
      view.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
    } else {
      view.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }
  }

  @Override
  public void openDrawer(DrawerLayout view) {
     view.openDrawer(Gravity.RIGHT);
  }

  @Override
  public void closeDrawer(DrawerLayout view) {
     view.closeDrawer(Gravity.RIGHT);
  }

  public void receiveCommand(@NonNull FastDrawerView root, String commandId, @Nullable ReadableArray args) {
    switch (commandId) {
      case "openDrawer":
        this.openDrawer(root);
        break;
      case "closeDrawer":
        this.closeDrawer(root);
        break;
    }
  }
}
