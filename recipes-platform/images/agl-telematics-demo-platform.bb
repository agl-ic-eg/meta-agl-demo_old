DESCRIPTION = "AGL Telematics Demo Platform image."

LICENSE = "MIT"

require recipes-platform/images/agl-image-boot.inc

inherit features_check

REQUIRED_DISTRO_FEATURES = "3g"

IMAGE_INSTALL:append = " \
    packagegroup-agl-telematics-demo-platform \
"
