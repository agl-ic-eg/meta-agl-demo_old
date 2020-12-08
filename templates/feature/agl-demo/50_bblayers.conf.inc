# This layer contains the WIP feature/demo code only
#---------------------------------------------------
BBLAYERS =+ " \
   ${METADIR}/meta-agl-demo \
"

# OpenEmbedded layer to add support for multiple cloud service provider solutions
#---------------------------------------------------
BBLAYERS =+ " \
   ${METADIR}/external/meta-iot-cloud \
   ${METADIR}/external/meta-qt5 \
   ${METADIR}/external/meta-openembedded/meta-filesystems \
   ${METADIR}/external/meta-python2 \
"
