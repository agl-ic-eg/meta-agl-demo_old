SUMMARY     = "AGL cloud proxy service"
DESCRIPTION = "AGL cloud proxy service build with recipe method"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/apps/agl-service-cloudproxy"
SECTION     = "apps"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=133bb7bd14f18c4f134e819619b3f09a"

inherit cmake aglwgt pkgconfig

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-cloudproxy;protocol=https"

SRCREV = "0cecffd4565b52bd8d200f6bc9f4144f244a6515"

PV      = "1.0+git${SRCPV}"
S       = "${WORKDIR}/git/"

DEPENDS = "azure-iot-sdk-c glib-2.0"

RDEPENDS_${PN} += "azure-iot-sdk-c azure-c-shared-utility"

#azure include files
CXXFLAGS_prepend += "-I${STAGING_INCDIR}/azureiot"

BBCLASSEXTEND = "native nativesdk"
