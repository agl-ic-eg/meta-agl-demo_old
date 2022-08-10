SUMMARY = "Flutter HVAC"
DESCRIPTION = "A Flutter based IVI Dashboard Application for automotive grade Linux."

HOMEPAGE = "https://github.com/hritik-chouhan/HVAC_dashboard"

BUGTRACKER = "https://github.com/hritik-chouhan/HVAC_dashboard/issues"

SECTION = "graphics"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://License.md;md5=f712ede8d4f845976061925d1416fc40"


SRC_URI = "git://github.com/hritik-chouhan/HVAC_dashboard.git;protocol=https;branch=main"
SRCREV = "0f9b82048e867afde53bd72b4736511dae8d09ff"
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
