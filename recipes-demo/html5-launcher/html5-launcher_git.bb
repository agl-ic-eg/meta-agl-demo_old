SUMMARY     = "AGL HTML5 HVAC Application"
HOMEPAGE    = "https://git.automotivelinux.org/apps/html5-launcher/"
SECTION     = "apps"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV      = "1.0+git${SRCPV}"
S       = "${WORKDIR}/git"
B       = "${WORKDIR}/build"

SRC_URI = " \
  git://gerrit.automotivelinux.org/gerrit/apps/html5-launcher;protocol=https;branch=${AGL_BRANCH} \
  file://launcher.service \
"
SRCREV = "${AGL_APP_REVISION}"

DEPENDS = "nodejs-native"

do_compile() {
  bldcmd=${S}/autobuild/agl/autobuild
  cd ${S}
  $bldcmd build
}

WAM_APPLICATIONS_DIR="${libdir}/wam_apps"

do_install() {
  install -d ${D}${WAM_APPLICATIONS_DIR}/${PN}
  cp -R --no-dereference --preserve=mode,links ${S}/dist/* ${D}${WAM_APPLICATIONS_DIR}/${PN}
  install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
  install -m0644 ${WORKDIR}/launcher.service ${D}${systemd_user_unitdir}/launcher.service
  ln -s ../launcher.service ${D}${systemd_user_unitdir}/agl-session.target.wants/launcher.service
}

FILES_${PN} = " \
  ${WAM_APPLICATIONS_DIR}/${PN} \
  ${systemd_user_unitdir} \
"

RCONFLICTS_${PN} = "launcher"
