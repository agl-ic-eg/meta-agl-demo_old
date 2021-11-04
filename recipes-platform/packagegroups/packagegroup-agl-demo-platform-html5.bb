SUMMARY = "The software for DEMO platform of AGL IVI profile"
DESCRIPTION = "A set of packages belong to AGL Demo Platform"

LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-agl-demo-platform-html5 \
    packagegroup-agl-demo-platform-html5-devel \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    packagegroup-agl-image-ivi \
    "

RDEPENDS:${PN} += "\
    packagegroup-hmi-framework \
    packagegroup-agl-profile-graphical-html5 \
    "


RDEPENDS:${PN}:append = " \
    weston-ini-conf \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip' , '', d)} \
    "

# NOTE: Currently no coverage versions for the application widgets,
#       they should be added here when available.
#       Also, the navigation and mixer debug widgets are currently
#       specified explicitly, as there's no simple way to derive their
#       names from the virtual/ RPROVIDES at present.
RDEPENDS:${PN}-devel = " \
    packagegroup-hmi-framework-devel \
    "
