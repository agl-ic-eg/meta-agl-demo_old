# This layer contains the WIP feature/demo code only
#---------------------------------------------------
BBLAYERS =+ " \
   ${METADIR}/meta-agl-demo \
"

AGL_META_FILESYSTEMS = "${METADIR}/external/meta-openembedded/meta-filesystems"

# OpenEmbedded layer to add support for multiple cloud service provider solutions
#---------------------------------------------------
BBLAYERS =+ " \
   ${METADIR}/external/meta-iot-cloud \
   ${METADIR}/external/meta-qt5 \
   ${METADIR}/external/meta-python2 \
"
