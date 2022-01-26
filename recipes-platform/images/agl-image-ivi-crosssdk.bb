require recipes-platform/images/agl-image-minimal-crosssdk.inc

require recipes-platform/images/agl-image-minimal.inc

IMAGE_INSTALL:append = "\
    packagegroup-agl-image-ivi \
    packagegroup-agl-ivi-services \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pipewire', 'packagegroup-pipewire', '', d)} \
    can-utils \
    iproute2 \
    "

IMAGE_FEATURES += "splash package-management ssh-server-openssh"

inherit populate_sdk

# Task do_populate_sdk and do_rootfs can't be exec simultaneously.
# Both exec "createrepo" on the same directory, and so one of them
# can failed (randomly).
addtask do_populate_sdk after do_rootfs
