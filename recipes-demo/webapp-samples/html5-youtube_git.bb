SUMMARY     = "AGL HTML5 Youtube"
LICENSE     = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ea5dd8751060d9f04d2748030c547ed"
DESKTOP_FILE = "webapps-youtube.desktop"

require webapp-samples.inc

do_install:append() {
  cp -R --no-dereference --preserve=mode,links ${S}/youtube/* ${D}${WAM_APPLICATIONS_DIR}/${PN}
}

