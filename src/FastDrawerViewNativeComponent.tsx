import React from 'react';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import type { ViewProps } from 'react-native';
import { UIManager, findNodeHandle } from 'react-native';

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
  ({ children, ...restProps }, ref) => {
    const drawerRef = React.useRef<any>(null);

    React.useImperativeHandle(ref, () => ({
      openDrawer: () => {
        const nodeHandle = findNodeHandle(drawerRef.current);
        if (nodeHandle) {
          UIManager.dispatchViewManagerCommand(
            nodeHandle,
            UIManager.getViewManagerConfig('FastDrawerView')?.Commands
              ?.openDrawer ?? 1,
            []
          );
        }
      },
      closeDrawer: () => {
        const nodeHandle = findNodeHandle(drawerRef.current);
        if (nodeHandle) {
          UIManager.dispatchViewManagerCommand(
            nodeHandle,
            UIManager.getViewManagerConfig('FastDrawerView')?.Commands
              ?.closeDrawer ?? 2,
            []
          );
        }
      },
    }));

    return (
      <FastDrawerViewComponent ref={drawerRef} {...restProps}>
        {children}
      </FastDrawerViewComponent>
    );
  }
);

export default FastDrawer;
