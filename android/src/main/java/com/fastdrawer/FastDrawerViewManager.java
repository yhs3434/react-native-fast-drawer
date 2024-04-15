package com.fastdrawer;

import android.graphics.Color;

import androidx.annotation.Nullable;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@ReactModule(name = FastDrawerViewManager.NAME)
public class FastDrawerViewManager extends FastDrawerViewManagerSpec<FastDrawerView> {

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
  @ReactProp(name = "color")
  public void setColor(FastDrawerView view, @Nullable String color) {
    view.setBackgroundColor(Color.parseColor(color));
  }
}
