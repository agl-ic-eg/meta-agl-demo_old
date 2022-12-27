FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://psplash-colors.h"

# drm-backend backport from:
# https://patchwork.yoctoproject.org/project/yocto/cover/20220425075954.10427-1-vasyl.vavrychuk@opensynergy.com/
FILESEXTRAPATHS:prepend := "${THISDIR}/psplash-drm:"
SRC_URI += " \
	file://0000-Fix-duplicated-definition-of-bool.patch \
	file://0001-Trim-trailing-spaces.patch \
	file://0002-Fix-unused-result-warnings.patch \
	file://0003-Remove-unused-save_termios.patch \
	file://0004-Remove-psplash-fb.h-from-psplash.h.patch \
	file://0005-Extract-plot-pixel-from-psplash-fb.patch \
	file://0006-Extract-draw-rect-image-from-psplash-fb.patch \
	file://0007-Extract-draw-font-from-psplash-fb.patch \
	file://0008-psplash.c-Make-psplash_draw_-msg-progress-independen.patch \
	file://0009-Rework-flip-as-function-pointer.patch \
	file://0010-Import-drm-howto-modeset.c-as-psplash-drm.c.patch \
	file://0011-Implement-drm-backend.patch \
	file://0012-Reverse-modeset_list.patch \
	file://0013-psplash-drm.c-Allocate-resources-only-for-the-first-.patch \
	file://0014-psplash-drm.c-Implement-double-buffering.patch \
	"

# Licesnse checksum was changed by above patches
LIC_FILES_CHKSUM = "file://psplash.h;beginline=1;endline=8;md5=db1ed16abf4be6de3d79201093ac4f07"

PACKAGECONFIG[drm] = "--enable-drm,,libdrm"
PSPLASH_ARGS += "${@bb.utils.contains('PACKAGECONFIG', 'drm', '--drm', '', d)}"
# WIP: We have to add psplash-quit service here to support drm transition

SPLASH_IMAGES = "file://psplash-poky-img.h;outsuffix=default"

do_configure:append () {
	cp -f ${WORKDIR}/psplash-colors.h ${S}
}

do_install:append () {
	# Always run psplash-start service as agl-driver user since it results
	# having psplash-fifo to be user-permission so that it helps to use it
	# from both user and system sessions.
	sed -i -e '/^\[Service\]/a User=agl-driver' ${D}${systemd_system_unitdir}/psplash-start.service

	sed -i -e "s!^\(ExecStart=/usr/bin/psplash.*\)!\1 ${PSPLASH_ARGS}!" ${D}${systemd_system_unitdir}/psplash-start.service
}
