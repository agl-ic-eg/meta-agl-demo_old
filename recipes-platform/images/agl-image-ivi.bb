SUMMARY = "A basic system of AGL distribution of IVI profile"

DESCRIPTION = "Basic image for baseline of AGL Distribution for IVI profile."

require recipes-platform/images/agl-image-minimal.inc

IMAGE_INSTALL:append = "\
    packagegroup-agl-image-ivi \
    packagegroup-agl-ivi-services \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pipewire', 'packagegroup-pipewire', '', d)} \
    can-utils \
    iproute2 \
    "

IMAGE_FEATURES += "splash package-management ssh-server-dropbear"


LICENSE = "MIT"

