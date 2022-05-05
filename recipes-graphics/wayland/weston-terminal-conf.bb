SUMMARY = "AGL user session"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
    file://org.freedesktop.weston.wayland-terminal.desktop \
"

inherit allarch

do_install() {
    install -d ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/org.freedesktop.weston.wayland-terminal.desktop ${D}${datadir}/applications
}

FILES:${PN} = "${datadir}/applications"

RDEPENDS:${PN} = " \
    weston \
"
