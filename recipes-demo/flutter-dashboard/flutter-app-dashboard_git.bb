SUMMARY = "Flutter Dashboard"
DESCRIPTION = "A Flutter based IVI Dashboard Application for automotive grade Linux."

HOMEPAGE = "https://github.com/hritik-chouhan/dashboard_for_recipe"

BUGTRACKER = "https://github.com/hritik-chouhan/dashboard_for_recipe/issues"

SECTION = "graphics"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://License.md;md5=f712ede8d4f845976061925d1416fc40"


SRC_URI = "git://github.com/hritik-chouhan/dashboard_for_recipe.git;protocol=https;branch=main"
SRCREV = "c3234da907ff46fb113f308b5ab257089fdcab4f"
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
