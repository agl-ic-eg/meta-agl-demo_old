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
    packagegroup-agl-profile-graphical-html5 \
    packagegroup-agl-demo \
    "


RDEPENDS:${PN}:append = " \
    weston-ini-conf-landscape \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip' , '', d)} \
    "

# TODO(jdapena): replace this with HTML5 apps.
AGL_APPS = " \
    html5-dashboard \
    html5-launcher \
    html5-homescreen \
    html5-hvac \
    html5-mediaplayer \
    html5-mixer \
    html5-settings \
    "

# TODO(jdapena): review if we still need the demo-i2c stuff.

# Hook for demo platform configuration
# ATM used for:
# 1) Adding udev configuration and scripts for supporting USB attached
#    I2C devices for RTC and HVAC LED support.
DEMO_UNIT_CONF ?= "demo-i2c-udev-conf"

# Preload only if agl-demo-preload is set
DEMO_PRELOAD = "${@bb.utils.contains("AGL_FEATURES", "agl-demo-preload", "${DEMO_UNIT_CONF}", "",d)}"

RDEPENDS:${PN}:append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip' , '', d)} \
    qtquickcontrols2-agl \
    qtquickcontrols2-agl-style \
    ${AGL_APPS} \
    ${DEMO_PRELOAD} \
    "
