SUMMARY = "The software for Flutter Demo platform of AGL IVI profile"
DESCRIPTION = "A set of packages for AGL Flutter Demo Platform"

LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-agl-demo-platform-flutter \
    "

RDEPENDS:${PN} += "\
    packagegroup-agl-image-ivi \
    packagegroup-agl-profile-graphical-qt5 \
    packagegroup-agl-demo \
    "

AGL_FLUTTER_RUNTIME ?= "runtimerelease"

AGL_APPS = " \
    settings \
    mediaplayer \
    ondemandnavi \
    flutter-dashboard-${AGL_FLUTTER_RUNTIME} \
    flutter-hvac-${AGL_FLUTTER_RUNTIME} \
    flutter-mediaplayer-${AGL_FLUTTER_RUNTIME} \
    flutter-nav-${AGL_FLUTTER_RUNTIME} \
    "

RDEPENDS:${PN}:append = " \
    agl-compositor \
    flutter-auto-${AGL_FLUTTER_RUNTIME} \
    flutter-homescreen-${AGL_FLUTTER_RUNTIME} \
    qtquickcontrols2-agl \
    qtquickcontrols2-agl-style \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip mpc' , '', d)} \
    ${AGL_APPS} \
    psplash-portrait-config \
    "
