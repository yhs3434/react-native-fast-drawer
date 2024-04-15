package com.fastdrawer;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReadableArray;

import java.util.HashMap;
import java.util.Map;

@ReactModule(name = FastDrawerViewManager.NAME)
public class FastDrawerViewManager extends com.fastdrawer.FastDrawerViewManagerSpec {
  public final int COMMAND_OPEN_DRAWER = 1;
  public final int COMMAND_CLOSE_DRAWER = 2;

  public static final String NAME = "FastDrawerView";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public FastDrawerView createViewInstance(ThemedReactContext context) {
    FastDrawerView drawerLayout = new FastDrawerView(context);

    // Main content view
    FrameLayout contentView = new FrameLayout(context);
    contentView.setLayoutParams(new DrawerLayout.LayoutParams(
      DrawerLayout.LayoutParams.MATCH_PARENT,
      DrawerLayout.LayoutParams.MATCH_PARENT
    ));
    contentView.setBackgroundColor(Color.RED);
    TextView textView = new TextView(context);
    textView.setText("Main Content Here");
    textView.setTextColor(Color.BLACK);
    textView.setGravity(Gravity.CENTER);
    contentView.addView(textView);

    // Drawer view
    FrameLayout drawerView = new FrameLayout(context);
    DrawerLayout.LayoutParams drawerParams = new DrawerLayout.LayoutParams(
      300,
      DrawerLayout.LayoutParams.MATCH_PARENT
    );
    drawerParams.gravity = GravityCompat.END;
    drawerView.setLayoutParams(drawerParams);
    drawerView.setBackgroundColor(Color.LTGRAY);
    TextView drawerText = new TextView(context);
    drawerText.setText("Drawer Content Here");
    drawerText.setTextColor(Color.BLACK);
    drawerText.setGravity(Gravity.CENTER);
    drawerView.addView(drawerText);

    drawerLayout.addView(contentView);
    drawerLayout.addView(drawerView);

    return drawerLayout;
  }

  @Override
  @ReactProp(name = "drawerPosition")
  public void setDrawerPosition(FastDrawerView view, String position) {
    int gravity = position.equals("left") ? Gravity.LEFT : Gravity.RIGHT;
    view.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, gravity);
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
