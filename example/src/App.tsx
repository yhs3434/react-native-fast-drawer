import * as React from 'react';
import { StyleSheet, View, Text, Button } from 'react-native';
import { FastDrawer, type DrawerMethods } from 'react-native-fast-drawer';

export default function App() {
  const drawerRef = React.useRef<DrawerMethods>(null);

  return (
    <View style={styles.container}>
      <FastDrawer ref={drawerRef} style={styles.box}>
        <View>
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
  box: {
    flex: 1,
  },
});
