DESCRIPTION = "AGL Demo Platform image currently contains a simple HMI and \
demos."

require agl-image-ivi.bb


LICENSE = "MIT"

# add packages for demo platform (include demo apps) here
IMAGE_INSTALL:append = " \
    packagegroup-agl-demo-platform \
    "

