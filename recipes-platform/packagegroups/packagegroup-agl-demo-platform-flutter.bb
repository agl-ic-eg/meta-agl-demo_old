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
    packagegroup-hmi-framework \
    packagegroup-agl-demo \
    "

AGL_APPS = " \
    hvac \
    dashboard \
    flutter-dashboard \
    flutter-hvac \
    flutter-nav \
    flutter-mediaplayer \
    "

RDEPENDS:${PN}:append = " \
    flutter-auto-runtimerelease \
    launcher \
    qtquickcontrols2-agl \
    qtquickcontrols2-agl-style \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip mpc' , '', d)} \
    ${AGL_APPS} \
    psplash-portrait-config \
    "
