import React from 'react';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import type { ViewProps } from 'react-native';

interface NativeProps extends ViewProps {
  drawerPosition?: 'left' | 'right';
  children?: React.ReactNode;
}

export interface DrawerMethods {
  openDrawer: () => void;
  closeDrawer: () => void;
}

const FastDrawerViewComponent =
  codegenNativeComponent<NativeProps>('FastDrawerView');

const FastDrawer = React.forwardRef<DrawerMethods, NativeProps>(
  ({ ...restProps }, ref) => {
    const drawerRef = React.useRef(null);

    React.useImperativeHandle(ref, () => ({
      openDrawer: () => {
        console.log('Open Drawer');
      },
      closeDrawer: () => {
        console.log('Close Drawer');
      },
    }));

    return <FastDrawerViewComponent ref={drawerRef} {...restProps} />;
  }
);

export default FastDrawer;
