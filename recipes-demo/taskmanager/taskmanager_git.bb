SUMMARY     = "Task Manager application"
DESCRIPTION = "AGL demonstration task visualization and management application"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/taskmanager"
SECTION     = "apps"

LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/taskmanager;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "${AGL_APP_REVISION}"

PV = "1.0+git${SRCPV}"
S  = "${WORKDIR}/git"

# build-time dependencies
DEPENDS += "qtquickcontrols2 \
            qtwebsockets \
            qtcharts \
            libqtappfw \
            libhomescreen \
"

inherit qmake5 aglwgt

RDEPENDS_${PN} += "agl-service-taskmanager libqtappfw"
