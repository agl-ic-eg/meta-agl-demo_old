SUMMARY     = "Navigation application."
DESCRIPTION = "AGL demonstration Navigation application based on QtLocation widget."
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/ondemandnavi"
SECTION     = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "qtquickcontrols2 qtlocation libqtappfw"

PV = "2.0+git${SRCPV}"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/ondemandnavi;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "1593664d2f17ab563c7ad81215696b1ac6a3bd7b"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES:${PN} += "${datadir}/icons/"

RDEPENDS:${PN} += " \
    qtlocation \
    flite \
    libqtappfw \
    openjtalk \
    gstreamer1.0 \
    ondemandnavi-config \
"
