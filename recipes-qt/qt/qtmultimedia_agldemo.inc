FILESEXTRAPATHS_append := ":${THISDIR}/qtmultimedia"

PACKAGECONFIG_append = " gstreamer"

SRC_URI_append = " \
    file://0001-metadata-image-support-with-the-data-URL-scheme-for-.patch \
    "
