SUMMARY = "GLib Connman interface library"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "systemd glib-2.0"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/connman-glib;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "d2377cec23dca4b8caab2208767bc23de32ae807"

S = "${WORKDIR}/git"

# PV needs to be modified with SRCPV to work AUTOREV correctly
PV = "1.0+git${SRCPV}"

inherit meson pkgconfig
