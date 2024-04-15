package com.fastdrawer;

import android.view.View;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;

public abstract class FastDrawerViewManagerSpec<T extends View> extends SimpleViewManager<T> {
  public abstract void setColor(T view, @Nullable String value);
}
