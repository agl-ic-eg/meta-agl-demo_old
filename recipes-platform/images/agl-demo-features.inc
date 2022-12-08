FEATURE_PACKAGES_agl-demo-preload = "packagegroup-agl-demo-preload"
FEATURE_PACKAGES_agl-demo-cluster-support = "packagegroup-agl-demo-cluster-support"

IMAGE_FEATURES += "${@bb.utils.filter("AGL_FEATURES", "agl-demo-preload agl-demo-cluster-support", d)}"
