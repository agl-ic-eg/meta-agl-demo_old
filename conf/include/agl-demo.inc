IMAGE_FEATURES =+ "debug-tweaks"

DISTRO_FEATURES_append = " automount "

# convenience
IMAGE_INSTALL_append = " screen mc "

# Extend agl-voiceagent-alexa image feature with local alexa-viewer
# package.
FEATURE_PACKAGES_agl-voiceagent-alexa_append = " alexa-viewer"

# enable the layer
AGL_FEATURES_append = " agldemo"
