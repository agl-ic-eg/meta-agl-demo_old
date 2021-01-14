SUMMARY     = "Instrument Cluster Receiver application"
DESCRIPTION = "AGL demonstration instrument cluster remote display application"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/agl-cluster-demo-receiver"
SECTION     = "apps"

LICENSE     = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=374fee6a7817f1e1a5a7bfb7b7989553"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-cluster-demo-receiver;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "${AGL_APP_REVISION}"

PV = "1.0+git${SRCPV}"
S  = "${WORKDIR}/git"

# build-time dependencies
DEPENDS += "wayland wayland-native \
	    gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

inherit cmake pkgconfig aglwgt

RDEPENDS_${PN} += " \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-good \
	gstreamer1.0-plugins-bad \
"
