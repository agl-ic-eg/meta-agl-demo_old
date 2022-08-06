SUMMARY = "Baseline Flutter Image for Release"

LICENSE = "MIT"


require recipes-platform/images/agl-image-weston.inc

# generic
IMAGE_INSTALL:append = "\
    agl-compositor \
    agl-compositor-init \
    packagegroup-agl-profile-graphical \
    packagegroup-agl-ivi-services \
    "

# flutter
IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    \
    flutter-cluster-dashboard-runtimerelease \
    flutter-cluster-dashboard-runtimerelease-init \
    flutter-auto-runtimerelease \
    "

CLANGSDK = "1"
