SUMMARY     = "AGL HTML5 Aquarium Demo"
LICENSE     = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://aquarium/LICENSE;md5=9f0d95e61aa217eacd61ee6833cf411c"
DESKTOP_FILE = "webapps-aquarium.desktop"

require webapp-samples.inc

do_install:append() {
  cp -R --no-dereference --preserve=mode,links ${S}/aquarium/* ${D}${WAM_APPLICATIONS_DIR}/${PN}
}

