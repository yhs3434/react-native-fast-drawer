import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { FastDrawerView } from 'react-native-fast-drawer';

export default function App() {
  return (
    <View style={styles.container}>
      <FastDrawerView style={styles.box} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 200,
    height: 200,
    backgroundColor: 'red',
  },
});
