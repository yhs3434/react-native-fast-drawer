import React from 'react';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import type { ViewProps, HostComponent } from 'react-native';

interface FastDrawerProps extends ViewProps {
  children?: React.ReactNode;
  drawerPosition?: 'left' | 'right';
  drawerWidth?: number;
  drawerContent: () => React.ReactNode;
  backdropColor?: string;
  enableLock?: boolean;
}

export interface FastDrawerMethods {
  openDrawer: (ref?: React.ElementRef<HostComponent<FastDrawerProps>>) => void;
  closeDrawer: (ref?: React.ElementRef<HostComponent<FastDrawerProps>>) => void;
}

const FastDrawerViewComponent =
  codegenNativeComponent<FastDrawerProps>('FastDrawerView');

const Commands = codegenNativeCommands<FastDrawerMethods>({
  supportedCommands: ['openDrawer', 'closeDrawer'],
});

const FastDrawer = React.forwardRef<FastDrawerMethods, FastDrawerProps>(
  ({ children, drawerContent, ...restProps }, ref) => {
    const drawerRef = React.useRef<any>(null);

    React.useImperativeHandle(ref, () => ({
      openDrawer: () => {
        if (drawerRef.current) {
          Commands.openDrawer(drawerRef.current);
        }
      },
      closeDrawer: () => {
        if (drawerRef.current) {
          Commands.closeDrawer(drawerRef.current);
        }
      },
    }));

    return (
      <FastDrawerViewComponent
        ref={drawerRef}
        drawerContent={() => drawerContent()}
        {...restProps}
      >
        {children}
        {drawerContent()}
      </FastDrawerViewComponent>
    );
  }
);

export default FastDrawer;
