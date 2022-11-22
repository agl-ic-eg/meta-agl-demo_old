FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://native-shell-client.service"

do_install:append() {
    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    install -m0644 ${WORKDIR}/native-shell-client.service ${D}${systemd_user_unitdir}/native-shell-client.service
    ln -s ../native-shell-client.service ${D}${systemd_user_unitdir}/agl-session.target.wants/native-shell-client.service
}

FILES:${PN} += " ${systemd_user_unitdir}"

RCONFLICTS:${PN} = "homescreen"
