SUMMARY = "AGL user session"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit allarch agl-app

AGL_APP_ID = "org.freedesktop.weston.wayland-terminal"
AGL_APP_EXEC = "weston-terminal"
AGL_APP_NAME = "Weston Terminal"

do_install() {
    # Enable systemd sandboxing override as a demonstration
    install -d ${D}${systemd_system_unitdir}/agl-app@${AGL_APP_ID}.service.d/
    ln -sf ${systemd_system_unitdir}/sandboxing/no-network.conf ${D}${systemd_system_unitdir}/agl-app@${AGL_APP_ID}.service.d/
}

FILES:${PN} = " \
    ${sysconfdir}/systemd/system/agl-app@${AGL_APP_ID}.service.d \
"

RDEPENDS:${PN} = "weston"
