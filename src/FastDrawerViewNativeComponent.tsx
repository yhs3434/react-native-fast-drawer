import React from 'react';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import type { ViewProps } from 'react-native';

interface NativeProps extends ViewProps {
  drawerPosition?: 'left' | 'right';
  children: React.ReactNode;
}

const FastDrawerViewComponent =
  codegenNativeComponent<NativeProps>('FastDrawerView');

export default function FastDrawer({ children, ...restProps }: NativeProps) {
  return (
    <FastDrawerViewComponent {...restProps}>{children}</FastDrawerViewComponent>
  );
}
