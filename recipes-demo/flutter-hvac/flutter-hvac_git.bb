SUMMARY = "Flutter HVAC"
DESCRIPTION = "A Flutter based IVI Dashboard Application for automotive grade Linux."

HOMEPAGE = "https://gerrit.automotivelinux.org/gerrit/apps/flutter-hvac"

BUGTRACKER = "https://github.com/hritik-chouhan/HVAC_dashboard/issues"

SECTION = "graphics"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://License.md;md5=f712ede8d4f845976061925d1416fc40"


SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/flutter-hvac;protocol=https;branch=${AGL_BRANCH} \
    file://HVAC_config.yaml \
    "

SRCREV = "5559cdb261cfd3e69daa2349906f071dc2491c0d"
S = "${WORKDIR}/git"

inherit agl-app flutter-app

# flutter-app
#############
PUBSPEC_APPNAME = "flutter_hvac"
FLUTTER_APPLICATION_INSTALL_PREFIX = "/flutter"
FLUTTER_BUILD_ARGS = "bundle -v"

# agl-app
#########
AGL_APP_TEMPLATE = "agl-app-flutter"
AGL_APP_ID = "flutter_hvac"
AGL_APP_NAME = "Flutter Hvac"

do_install:append() {
    install -d ${D}${sysconfdir}/xdg/AGL
    install -m 0644 ${WORKDIR}/HVAC_config.yaml ${D}${sysconfdir}/xdg/AGL/
}

FILES:${PN} += "${sysconfdir}/xdg/AGL"
