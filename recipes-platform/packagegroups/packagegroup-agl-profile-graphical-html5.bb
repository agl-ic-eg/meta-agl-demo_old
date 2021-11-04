SUMMARY = "AGL web runtime profile"
DESCRIPTION = "The full set of packages required for AGL web runtime"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-profile-graphical-html5 \
    profile-graphical-html5 \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    packagegroup-agl-profile-graphical \
"

RDEPENDS:${PN} += "\
    wam \
    "

RDEPENDS:profile-graphical-html5 = "${PN}"
