SUMMARY = "Input device output assignment udev configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://91-output.rules"

do_compile[noexec] = "1"

do_install() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/udev/rules.d
        install -m 0644 ${WORKDIR}/91-output.rules ${D}${sysconfdir}/udev/rules.d/
    fi
}

FILES:${PN} += "${systemd_system_unitdir}"

RDEPENDS:${PN} += "udev"
