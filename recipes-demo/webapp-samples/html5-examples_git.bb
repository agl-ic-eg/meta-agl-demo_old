SUMMARY     = "AGL HTML5 Examples"
LICENSE     = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ea5dd8751060d9f04d2748030c547ed"
DESKTOP_FILE = "webapps-examples.desktop"

require webapp-samples.inc

do_install:append() {
  cp -R --no-dereference --preserve=mode,links ${S}/examples/* ${D}${WAM_APPLICATIONS_DIR}/${PN}
}

