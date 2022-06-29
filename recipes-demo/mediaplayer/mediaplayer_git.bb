SUMMARY     = "Media Player application"
DESCRIPTION = "AGL demonstration Media Player application"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/mediaplayer"
SECTION     = "apps"

LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "qtquickcontrols2 libqtappfw"

PV = "2.0+git${SRCPV}"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/mediaplayer;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "d53efa6bca224f2c6bec8e7b14b1dff7f12a2d03"

S  = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES:${PN} += "${datadir}/icons/"

RDEPENDS:${PN} += "libqtappfw mpd"
