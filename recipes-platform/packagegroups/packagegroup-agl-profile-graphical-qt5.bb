SUMMARY = "The middlewares for AGL IVI profile"
DESCRIPTION = "The set of packages required for AGL Distribution"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-profile-graphical-qt5 \
    profile-graphical-qt5 \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    packagegroup-agl-profile-graphical \
"

RDEPENDS:${PN} += "\
    "

RDEPENDS:profile-graphical-qt5 = "${PN}"
