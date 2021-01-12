# Base image
require agl-image-ivi.inc

# Pull in speech framework bits
IMAGE_FEATURES += "agl-speech-framework"

# Pull in Alexa voiceagent if configured
IMAGE_FEATURES += "${@bb.utils.filter("AGL_FEATURES", "agl-voiceagent-alexa", d)}"
