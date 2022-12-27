SUMMARY     = "Systemd unit override for psplash portrait mode for the AGL Demonstrator"
LICENSE     = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd allarch

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install[depends] = "psplash:do_populate_sysroot"

do_install() {
    # Install override
    psplash_service="${STAGING_DIR_TARGET}/${systemd_system_unitdir}/psplash-start.service"
    if [ ! -f "$psplash_service" ]; then
        echo "ERROR: psplash service unit file not found: $psplash_service" >&2
        exit 1
    fi
    install -d ${D}${systemd_system_unitdir}/psplash-start.service.d
    psplash_portrait_conf="${D}${systemd_system_unitdir}/psplash-start.service.d/psplash-portrait.conf"
    echo "[Service]" > "$psplash_portrait_conf"
    echo "ExecStart=" >> "$psplash_portrait_conf"
    sed -ne 's!^\(ExecStart=/usr/bin/psplash.*\)!\1 --angle 90!p' "$psplash_service" >> "$psplash_portrait_conf"
}

FILES:${PN} += "${systemd_system_unitdir}"

RDEPENDS:${PN} += "psplash"
