SUMMARY     = "HVAC application"
DESCRIPTION = "AGL demonstration HVAC application"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/hvac"
SECTION     = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = " \
    qttools-native \
    qtbase \
    qtdeclarative \
    qtquickcontrols2 \
    libqtappfw \
"

PV = "2.0+git${SRCPV}"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/hvac;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "c173b5b5fbdb9013304ad62e0dc8f8bb9a072e7d"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES:${PN} += "${datadir}/icons/"

RDEPENDS:${PN} += " \
    qtwayland \
    qtbase-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtquickcontrols2-agl-style \
    libqtappfw \
"
