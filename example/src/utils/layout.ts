import { Dimensions } from 'react-native';

const { width: screenWidth, height: screenHeight } = Dimensions.get('screen');

export type Layout = {
  width?: number;
  height?: number;
  gap?: number;
};

const basicDimensions: Required<Pick<Layout, 'width' | 'height'>> &
  Pick<Layout, 'gap'> = {
  width: 1920,
  height: 1200,
};

export const getResponsiveWidth = (width: number) => {
  return width * screenWidth * (1 / basicDimensions.width);
};

export const getResponsiveHeight = (height: number) => {
  return height * screenHeight * (1 / basicDimensions.height);
};

export const getResponsiveFontSize = (fontSize: number) =>
  (fontSize * screenWidth) / basicDimensions.width;
