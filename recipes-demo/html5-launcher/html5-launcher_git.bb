SUMMARY     = "AGL HTML5 Launcher Application"
HOMEPAGE    = "https://git.automotivelinux.org/apps/html5-launcher/"
SECTION     = "apps"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV      = "1.0+git${SRCPV}"
S       = "${WORKDIR}/git"
B       = "${WORKDIR}/build"

SRC_URI = " \
  git://gerrit.automotivelinux.org/gerrit/apps/html5-launcher;protocol=https;branch=master \
  file://launcher.desktop \
"
SRCREV = "1283e3bddd4655be0d5208fbbcd9535f8f1ff0f6"

inherit pythonnative

DEPENDS = "nodejs-native"

do_compile() {
  cd ${S}
  rm -rf package node_modules package-lock.json
  npm install
  npm run build
}

WAM_APPLICATIONS_DIR="${libdir}/wam_apps"
APPLICATIONS_DIR="${datadir}/applications"

do_install() {
  install -d ${D}${WAM_APPLICATIONS_DIR}/${PN}
  cp -R --no-dereference --preserve=mode,links ${S}/dist/* ${D}${WAM_APPLICATIONS_DIR}/${PN}
  install -d ${D}${APPLICATIONS_DIR}
  install ${WORKDIR}/launcher.desktop ${D}${APPLICATIONS_DIR}
}

FILES:${PN} = " \
  ${WAM_APPLICATIONS_DIR}/${PN} \
  ${APPLICATIONS_DIR} \
"

RCONFLICTS:${PN} = "launcher"
RDEPENDS:${PN} = "applaunchd"
