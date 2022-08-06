SUMMARY = "Baseline Flutter Image for Release"

LICENSE = "MIT"


require recipes-platform/images/agl-image-weston.inc

# generic
IMAGE_INSTALL:append = "\
    agl-compositor \
    agl-compositor-init \
    packagegroup-agl-profile-graphical \
    \
    kuksa-val \
    kuksa-val-agl \
    kuksa-dbc-feeder \
    \
    kuksa-vss-init \
    simple-can-simulator \
    "

# flutter
IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    \
    flutter-cluster-dashboard-runtimerelease \
    flutter-auto-runtimerelease \
    "

CLANGSDK = "1"
