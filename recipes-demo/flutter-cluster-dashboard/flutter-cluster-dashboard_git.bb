SUMMARY = "Flutter Instrument Cluster "
DESCRIPTION = "An instrument cluster app written in dart for the flutter runtime"
AUTHOR = "Aakash Solanki"
HOMEPAGE = "https://github.com/aakash-s45/ic"

SECTION = "graphics"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0c52b0e4b5f0dbf57ea7d44bebb2e29d"

SRC_URI = "git://github.com/aakash-s45/ic;protocol=https;branch=master \
    file://flutter-cluster-dashboard.service \
    file://flutter_cluster_dashboard_on_bg-debug.json \
    file://flutter_cluster_dashboard_on_bg-profile.json \
    file://flutter_cluster_dashboard_on_bg-release.json \
"

PV = "1.0+git${SRCPV}"
SRCREV = "798851a33bb614fb1e5473a8046e63cd9b9026f4"

S = "${WORKDIR}/git"

PUBSPEC_APPNAME = "flutter_cluster_dashboard"

FLUTTER_APPLICATION_INSTALL_PREFIX = "/flutter"

inherit flutter-app

APP_CONFIG = "flutter_cluster_dashboard_on_bg-release.json"
APP_CONFIG:class-runtimedebug = "flutter_cluster_dashboard_on_bg-debug.json"
APP_CONFIG:class-runtimeprofile = "flutter_cluster_dashboard_on_bg-profile.json"


do_install:append() {
    install -D -m 0644 ${WORKDIR}/flutter-cluster-dashboard.service ${D}${systemd_user_unitdir}/flutter-cluster-dashboard.service
    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    ln -s ../flutter-cluster-dashboard.service ${D}${systemd_user_unitdir}/agl-session.target.wants/flutter-cluster-dashboard.service

    install -D -m 0644 ${WORKDIR}/${APP_CONFIG} ${D}${datadir}/flutter/default.json
}


FILES:${PN} += "${datadir} ${systemd_user_unitdir}"
