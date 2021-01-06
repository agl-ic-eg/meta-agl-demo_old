IMAGE_FEATURES =+ "debug-tweaks"

DISTRO_FEATURES_append = " automount "

# convenience
IMAGE_INSTALL_append = " screen mc "

# Extend agl-voiceagent-alexa image feature with local alexa-viewer
# package.
FEATURE_PACKAGES_agl-voiceagent-alexa_append = " alexa-viewer"

# enable the layer
AGL_FEATURES_append = " agldemo"

# Set preferred provider for low-can device mapping configuration
PREFERRED_RPROVIDER_virtual/low-can-dev-mapping ?= "${@bb.utils.contains('DISTRO_FEATURES', 'AGLCI', 'dev-mapping-ci', 'dev-mapping', d)}"

# voice api inclusion
PREFERRED_RPROVIDER_virtual/voice-high-config = "default-voice-high-config"
FEATURE_PACKAGES_agl-speech-framework = "packagegroup-agl-speech-services"
IMAGE_FEATURES += "agl-speech-framework"
