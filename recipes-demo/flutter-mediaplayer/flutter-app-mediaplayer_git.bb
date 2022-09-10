SUMMARY = "Flutter MediaPlayer app for IVI"
DESCRIPTION = "A Flutter based IVI Dashboard Application for automotive grade Linux"

HOMEPAGE = "https://github.com/hritik-chouhan/musicplayer"

BUGTRACKER = "https://github.com/hritik-chouhan/musicplayer/issues"

SECTION = "graphics"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://License.md;md5=f712ede8d4f845976061925d1416fc40"


SRC_URI = "git://github.com/hritik-chouhan/musicplayer.git;protocol=https;branch=main"
SRCREV = "45f9425552ec08a8706953c41aa25b0fc1a6fb57"
S = "${WORKDIR}/git"

inherit agl-app flutter-app

# flutter-app
#############
PUBSPEC_APPNAME = "musicplayer"
FLUTTER_APPLICATION_INSTALL_PREFIX = "/flutter"
FLUTTER_BUILD_ARGS = "bundle -v"

# agl-app
#########
AGL_APP_TEMPLATE = "agl-app-flutter"
AGL_APP_ID = "musicplayer"
AGL_APP_NAME = "Flutter MediaPlayer"
