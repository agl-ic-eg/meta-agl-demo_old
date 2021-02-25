FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://geoclue.conf.agl"

PACKAGECONFIG = "nmea lib"

do_install_append() {
    install -D -m 0644 ${WORKDIR}/geoclue.conf.agl ${D}${sysconfdir}/geoclue/geoclue.conf
}
