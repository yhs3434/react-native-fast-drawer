import * as React from 'react';
import { StyleSheet, View, Text, Button } from 'react-native';
import { FastDrawer, type FastDrawerMethods } from 'react-native-fast-drawer';

export default function App() {
  const drawerRef = React.useRef<FastDrawerMethods>(null);

  return (
    <View style={styles.container}>
      <FastDrawer
        ref={drawerRef}
        style={styles.drawerLayout}
        drawerWidth={600}
        drawerContent={() => (
          <View style={{ backgroundColor: 'red' }}>
            <Text>drawer content</Text>
          </View>
        )}
        backdropColor="#00000000"
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
