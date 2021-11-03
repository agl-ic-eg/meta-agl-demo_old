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
    packagegroup-agl-appfw-html5 \
"

RDEPENDS:${PN} += "\
    "

RDEPENDS:profile-graphical-html5 = "${PN}"
