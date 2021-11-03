# This layer contains the WIP feature/demo code only
#---------------------------------------------------
BBLAYERS =+ " \
   ${METADIR}/meta-agl-demo \
"

AGL_META_FILESYSTEMS = "${METADIR}/external/meta-openembedded/meta-filesystems"
AGL_META_PYTHON = "${METADIR}/external/meta-openembedded/meta-python"

# OpenEmbedded layer to add support for multiple cloud service provider solutions
#---------------------------------------------------
BBLAYERS =+ " \
   ${METADIR}/external/meta-qt5 \
"

#   ${METADIR}/external/meta-python2 \
#