DESCRIPTION = "Simulator that generates CAN messages of a driving car"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://simple_can_simulator.py"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/simple_can_simulator.py ${D}${sbindir}
}

RDEPENDS_${PN} = "python3"
