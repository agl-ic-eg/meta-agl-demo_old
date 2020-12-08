SUMMARY     = "Waltham-receiver"
DESCRIPTION = "Waltham-receiver is a demo application for testing out Waltham"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/apps/waltham-receiver.git"
SECTION     = "apps"

LICENSE     = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=374fee6a7817f1e1a5a7bfb7b7989553"

SRC_URI = "gitsm://gerrit.automotivelinux.org/gerrit/apps/waltham-receiver.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "${AGL_APP_REVISION}"

PV = "1.0+git${SRCPV}"
S  = "${WORKDIR}/git"

# build-time dependencies
DEPENDS += "waltham wayland wayland-native \
	    gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

inherit cmake pkgconfig aglwgt

RDEPENDS_${PN} += " \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-good \
	gstreamer1.0-plugins-bad \
	waltham \
"
