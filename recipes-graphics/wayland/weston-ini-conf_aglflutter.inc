do_compile:append() {
    # Put all of our cfg files together for a default portrait
    # orientation configuration
    rm -f ${WORKDIR}/weston.ini.flutter
    for F in ${WESTON_FRAGMENTS}; do
        cat ${WORKDIR}/${F}.cfg >> ${WORKDIR}/weston.ini.flutter
	if grep -q '\[output\]' ${WORKDIR}/${F}.cfg; then
            echo "activation-area=1080x1600+0,160" >> ${WORKDIR}/weston.ini.flutter
        fi
        echo >> ${WORKDIR}/weston.ini.flutter
    done
    sed -i -e '$ d' ${WORKDIR}/weston.ini.flutter
}

do_install:append() {
    install -m 0644 ${WORKDIR}/weston.ini.flutter ${D}${weston_ini_dir}/
}

PACKAGE_BEFORE_PN += "${PN}-flutter"

FILES:${PN}-flutter = "${weston_ini_dir}/weston.ini.flutter"

RPROVIDES:${PN}-flutter = "weston-ini"
RCONFLICTS:${PN}-flutter = "${PN}"
ALTERNATIVE:${PN}-flutter = "weston.ini"
ALTERNATIVE_TARGET_${PN}-flutter = "${weston_ini_dir}/weston.ini.flutter"
