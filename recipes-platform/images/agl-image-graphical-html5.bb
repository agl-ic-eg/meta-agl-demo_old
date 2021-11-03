SUMMARY = "An image containing all packages required to run web applications"

require recipes-platform/images/agl-image-minimal.inc

IMAGE_FEATURES += "splash"

IMAGE_FEATURES += "${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'ssh-server-dropbear' , '', d)}"

inherit features_check

REQUIRED_DISTRO_FEATURES = "wayland"


LICENSE = "MIT"

IMAGE_INSTALL:append = "\
    packagegroup-agl-profile-graphical-html5 \
    "

