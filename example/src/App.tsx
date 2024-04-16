import * as React from 'react';
import { StyleSheet, View, Text, Button } from 'react-native';
import { FastDrawer, type FastDrawerMethods } from 'react-native-fast-drawer';
import { getResponsiveHeight, getResponsiveWidth } from './utils/layout';

export default function App() {
  const drawerRef = React.useRef<FastDrawerMethods>(null);

  return (
    <View style={styles.container}>
      <FastDrawer
        style={styles.drawerLayout}
        ref={drawerRef}
        drawerWidth={600}
        drawerContent={() => (
          <View
            style={{
              width: getResponsiveWidth(600),
              height: getResponsiveHeight(600),
              justifyContent: 'center',
              alignItems: 'center',
              backgroundColor: 'yellow',
              borderWidth: 1,
              padding: 4,
            }}
          >
            <Text>drawer content</Text>
          </View>
        )}
        backdropColor="#00000000"
        enableLock
      >
        <View style={styles.contentContainer}>
          <Text>drawer children</Text>
        </View>
      </FastDrawer>
      <Button
        title="open"
        onPress={() => {
          drawerRef.current?.openDrawer();
        }}
      />
      <Button
        title="close"
        onPress={() => {
          drawerRef.current?.closeDrawer();
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  drawerLayout: {
    flex: 1,
  },
  contentContainer: {
    //
  },
});
