#ifdef RCT_NEW_ARCH_ENABLED
#import "FastDrawerView.h"

#import <react/renderer/components/RNFastDrawerViewSpec/ComponentDescriptors.h>
#import <react/renderer/components/RNFastDrawerViewSpec/EventEmitters.h>
#import <react/renderer/components/RNFastDrawerViewSpec/Props.h>
#import <react/renderer/components/RNFastDrawerViewSpec/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"
#import "Utils.h"

using namespace facebook::react;

@interface FastDrawerView () <RCTFastDrawerViewViewProtocol>

@end

@implementation FastDrawerView {
    UIView * _view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<FastDrawerViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const FastDrawerViewProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];

    self.contentView = _view;
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<FastDrawerViewProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<FastDrawerViewProps const>(props);

    if (oldViewProps.color != newViewProps.color) {
        NSString * colorToConvert = [[NSString alloc] initWithUTF8String: newViewProps.color.c_str()];
        [_view setBackgroundColor: [Utils hexStringToColor:colorToConvert]];
    }

    [super updateProps:props oldProps:oldProps];
}

Class<RCTComponentViewProtocol> FastDrawerViewCls(void)
{
    return FastDrawerView.class;
}

@end
#endif
