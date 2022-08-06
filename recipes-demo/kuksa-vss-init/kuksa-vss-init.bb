DESCRIPTION = "Initialize the Kuksa VSS data to some constant values"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/kuksa_vss_init.py;beginline=2;endline=20;md5=afe8bd5e80449c5209495644133c16a8"

SRC_URI = "file://kuksa_vss_init.py"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/kuksa_vss_init.py ${D}${sbindir}
}

RDEPENDS:${PN} = "python3"
