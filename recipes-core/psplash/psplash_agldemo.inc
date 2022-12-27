FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://psplash-colors.h"

SPLASH_IMAGES = "file://psplash-poky-img.h;outsuffix=default"

do_configure:append () {
	cp -f ${WORKDIR}/psplash-colors.h ${S}
}

do_install:append () {
	# Always run psplash-start service as agl-driver user since it results
	# having psplash-fifo to be user-permission so that it helps to use it
	# from both user and system sessions.
	sed -i -e '/^\[Service\]/a User=agl-driver' ${D}${systemd_system_unitdir}/psplash-start.service
}
