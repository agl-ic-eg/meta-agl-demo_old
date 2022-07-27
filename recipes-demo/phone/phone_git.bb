SUMMARY     = "Phone application"
DESCRIPTION = "AGL demonstration Phone application"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/phone"
SECTION     = "apps"

LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "qtquickcontrols2 libqtappfw gstreamer1.0"

PV = "1.0+git${SRCPV}"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/phone;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "bfcc2fa194474a7bc317583072b62c977ae0fc14"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig agl-app

AGL_APP_NAME = "Phone"

FILES:${PN} += "${datadir}/sounds/"

RDEPENDS:${PN} += "libqtappfw"
