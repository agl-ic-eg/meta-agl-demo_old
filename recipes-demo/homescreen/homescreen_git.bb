SUMMARY     = "Home Screen application"
DESCRIPTION = "AGL demonstration Home Screen application"
HOMEPAGE    = "http://docs.automotivelinux.org"
LICENSE     = "Apache-2.0"
SECTION     = "apps"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"
#LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = " \
    qtbase \
    qtdeclarative \
    qtquickcontrols2 \
    wayland-native \
    wayland \
    qtwayland \
    qtwayland-native \
    agl-compositor \
    json-c \
    qtwebsockets \
"

PV      = "1.0+git${SRCPV}"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/homescreen;protocol=https;nobranch=1"
SRCREV  = "09b5eb1b42910e84612a37a0fb44629c73eee3e7"

S       = "${WORKDIR}/git"

inherit qmake5 systemd pkgconfig

PATH:prepend = "${STAGING_DIR_NATIVE}${OE_QMAKE_PATH_QT_BINS}:"

OE_QMAKE_CXXFLAGS:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', '' , '-DQT_NO_DEBUG_OUTPUT', d)}"


do_install:append() {

    install -d ${D}/${bindir}
    install -m 0644 ${B}/homescreen/HomeScreen ${D}/${bindir}/homescreen

}