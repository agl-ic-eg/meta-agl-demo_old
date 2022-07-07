SUMMARY = "AGL user session"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
    file://org.freedesktop.weston.wayland-terminal.desktop \
    file://weston-terminal.desktop \
"

inherit allarch

do_install() {
    install -d ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/org.freedesktop.weston.wayland-terminal.desktop ${D}${datadir}/applications

    # Enable systemd sandboxing override as a demonstration
    mkdir -p ${D}${sysconfdir}/systemd/system/agl-app@weston-terminal.service.d/
    ln -sf ${sysconfdir}/systemd/sandboxing/no-network.conf ${D}${sysconfdir}/systemd/system/agl-app@weston-terminal.service.d/

    # HACK - install .desktop file for systemd until applaunchd can do enumeration with homescreen names and icons
    install -m 0644 ${WORKDIR}/weston-terminal.desktop ${D}${datadir}/applications/
}

FILES:${PN} = " \
    ${datadir}/applications \
    ${sysconfdir}/systemd/system/agl-app@weston-terminal.service.d \
"

RDEPENDS:${PN} = " \
    weston \
"
