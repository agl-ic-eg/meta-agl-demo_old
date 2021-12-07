SUMMARY = "The software for DEMO platform of AGL IVI profile"
DESCRIPTION = "A set of packages belong to AGL Demo Platform"

LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-agl-demo-platform \
    packagegroup-agl-demo-platform-devel \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    packagegroup-agl-image-ivi \
    "

RDEPENDS:${PN} += "\
    packagegroup-agl-profile-graphical-qt5 \
    packagegroup-hmi-framework \
    packagegroup-agl-demo \
    "


DEMO_UNIT_CONF ?= ""
# Hook for demo platform configuration
# ATM used for:
# 1) Adding udev configuration and scripts for supporting USB attached
#    I2C devices for RTC and HVAC LED support.
DEMO_UNIT_CONF += " demo-i2c-udev-conf "

# Preload only if agl-demo-preload is set
DEMO_PRELOAD = "${@bb.utils.contains("AGL_FEATURES", "agl-demo-preload", " ${DEMO_UNIT_CONF} poiapp-api-key", "",d)}"

RDEPENDS:${PN}:append = " \
    launcher \
    qtquickcontrols2-agl \
    qtquickcontrols2-agl-style \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip' , '', d)} \
    ${DEMO_PRELOAD} \
    "

# NOTE: Currently no coverage versions for the application widgets,
#       they should be added here when available.
#       Also, the navigation and mixer debug widgets are currently
#       specified explicitly, as there's no simple way to derive their
#       names from the virtual/ RPROVIDES at present.
RDEPENDS:${PN}-devel = " \
    packagegroup-hmi-framework-devel \
    "
