SUMMARY = "Extra software and configuration for cluster demo with AGL IVI profile demo platform"

LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-agl-demo-cluster-support \
"

RDEPENDS:${PN} += "\
    tbtnavi \
    kuksa-val-agl-demo-cluster \
"
