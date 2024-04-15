import React from 'react';
import { View, type StyleProp, type ViewStyle } from 'react-native';
import type { SharedValue } from 'react-native-reanimated';

export type Layout = { width: number; height: number };

export type DrawerProps = React.PropsWithChildren<{
  open: boolean;
  onOpen: () => void;
  onClose: () => void;
  onGestureStart?: () => void;
  onGestureCancel?: () => void;
  onGestureEnd?: () => void;
  onTransitionStart?: (closing: boolean) => void;
  onTransitionEnd?: (closing: boolean) => void;
  renderDrawerContent: () => React.ReactNode;
  layout?: Layout;
  drawerPosition?: 'left' | 'right';
  drawerType?: 'front' | 'back' | 'slide' | 'permanent';
  drawerStyle?: StyleProp<ViewStyle>;
  overlayStyle?: StyleProp<ViewStyle>;
  overlayAccessibilityLabel?: string;
  keyboardDismissMode?: 'none' | 'on-drag';
  hideStatusBarOnOpen?: boolean;
  statusBarAnimation?: 'slide' | 'fade' | 'none';
  swipeEnabled?: boolean;
  swipeEdgeWidth?: number;
  swipeMinDistance?: number;
  swipeMinVelocity?: number;
  style?: StyleProp<ViewStyle>;
}>;

export type OverlayProps = React.ComponentProps<typeof View> & {
  open: boolean;
  progress: SharedValue<number>;
  onPress: () => void;
  accessibilityLabel?: string;
};
