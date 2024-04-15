package com.fastdrawer;

import androidx.annotation.Nullable;

import android.content.Context;
import android.util.AttributeSet;

import androidx.drawerlayout.widget.DrawerLayout;

public class FastDrawerView extends DrawerLayout {

  public FastDrawerView(Context context) {
    super(context);
  }

  public FastDrawerView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public FastDrawerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

}
