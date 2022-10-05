SUMMARY = "Flutter Dashboard"
DESCRIPTION = "A Flutter based IVI Dashboard Application for automotive grade Linux."

HOMEPAGE = "https://gerrit.automotivelinux.org/gerrit/apps/flutter-dashboard"

BUGTRACKER = "https://github.com/hritik-chouhan/dashboard_for_recipe/issues"

SECTION = "graphics"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://License.md;md5=f712ede8d4f845976061925d1416fc40"


SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/flutter-dashboard;protocol=https;branch=${AGL_BRANCH} \
    file://dashboard_config.yaml \
    "

SRCREV = "10945b8056eb2b228c156918a3505882a49a79b8"
S = "${WORKDIR}/git"


inherit agl-app flutter-app

# flutter-app
#############
PUBSPEC_APPNAME = "dashboard_app"
FLUTTER_APPLICATION_INSTALL_PREFIX = "/flutter"
FLUTTER_BUILD_ARGS = "bundle -v"

# agl-app
#########
AGL_APP_TEMPLATE = "agl-app-flutter"
AGL_APP_ID = "dashboard_app"
AGL_APP_NAME = "Flutter Dashboard"



do_install:append() {
    install -d ${D}${sysconfdir}/xdg/AGL
    install -m 0644 ${WORKDIR}/dashboard_config.yaml ${D}${sysconfdir}/xdg/AGL/


    
}

FILES:${PN} += "${sysconfdir}/xdg/AGL"

