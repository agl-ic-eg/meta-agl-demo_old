SUMMARY = "A basic system of AGL distribution of IVI profile"

DESCRIPTION = "Basic image for baseline of AGL Distribution for IVI profile."

LICENSE = "MIT"

require recipes-platform/images/agl-image-weston.inc

IMAGE_INSTALL:append = "\
    packagegroup-agl-image-ivi \
    packagegroup-agl-ivi-services \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pipewire', 'packagegroup-pipewire', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pipewire', 'wireplumber-config-agl wireplumber-policy-config-agl', '', d)} \
    can-utils \
    iproute2 \
    "

IMAGE_FEATURES += "splash package-management ssh-server-openssh"

# NOTE: In hardknott or later this can be replaced by adding "weston"
#       to IMAGE_FEATURES.
SYSTEMD_DEFAULT_TARGET = "graphical.target"


