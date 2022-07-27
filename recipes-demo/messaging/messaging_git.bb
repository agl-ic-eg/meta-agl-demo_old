SUMMARY     = "Messaging application"
DESCRIPTION = "AGL demonstration Messaging application"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/messaging"
SECTION     = "apps"

LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "qtquickcontrols2 libqtappfw"

PV = "1.0+git${SRCPV}"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/messaging;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "e58b0382de8e665d64b8e3486022a6bcb0572823"

S  = "${WORKDIR}/git"

inherit qmake5 pkgconfig agl-app

AGL_APP_NAME = "Messaging"

RDEPENDS:${PN} += "libqtappfw"
