SUMMARY     = "Dashboard application"
DESCRIPTION = "AGL demonstration Dashboard application"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/dashboard"
SECTION     = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = " \
    qttools-native \
    qtquickcontrols2 \
"

PV = "2.0+git${SRCPV}"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/dashboard;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "3fc84a0a674fa532f6aded100cf2beb3d0cf1f83"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES:${PN} += "${datadir}/icons/"

RDEPENDS:${PN} += " \
    qtwayland \
    qtbase-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtquickcontrols2-agl-style \
"
