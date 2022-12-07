AGL_FEATURES:append = " agl-demo-preload"

# Demo uses AGL reference hardware, which is CAN FD
CANBUS_NETWORK_CONFIG = "${@bb.utils.contains('AGL_FEATURES', 'agl-refhw-h3', 'canbus-can-fd.network', 'canbus-can.network', d)}"
