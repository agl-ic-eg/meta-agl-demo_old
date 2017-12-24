SUMMARY     = "AGL Reference POI application."
DESCRIPTION = "This application provides the function of destination search to AGL.  It uses the API provided by AGL Reference Navigation.  This application uses yelp WebAPI."
HOMEPAGE    = "https://github.com/AGLExport/genivi-navi-yelp-client"
SECTION     = "apps"

LICENSE          = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=947b2d60ca3872e172034438e9801200"

inherit cmake_qt5 pkgconfig
inherit aglwgt

DEPENDS += " qtbase json-c libnaviapi-agl \
             af-binder qlibwindowmanager virtual/libhomescreen \
           "

RDEPENDS_${PN} =  " qtbase \
                  "

SRCREV = "d7afe75ebd4041b1d52f8a5066e38e6e2e5c91b7"
SRC_URI = "git://github.com/AGLExport/genivi-navi-yelp-client.git;branch=agl \
          "

S = "${WORKDIR}/git"

