package com.fastdrawer;

import android.view.View;

import androidx.annotation.Nullable;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.FastDrawerViewManagerDelegate;
import com.facebook.react.viewmanagers.FastDrawerViewManagerInterface;

public abstract class FastDrawerViewManagerSpec<T extends View> extends SimpleViewManager<T> implements FastDrawerViewManagerInterface<T> {
  private final ViewManagerDelegate<T> mDelegate;

  public FastDrawerViewManagerSpec() {
    mDelegate = new FastDrawerViewManagerDelegate(this);
  }

  @Nullable
  @Override
  protected ViewManagerDelegate<T> getDelegate() {
    return mDelegate;
  }
}
