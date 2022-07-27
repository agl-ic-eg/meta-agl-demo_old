require agl-image-ivi.bb

DESCRIPTION = "AGL Flutter based Demo Platform image"

# add packages for demo platform (include demo apps) here
IMAGE_INSTALL:append = " \
    packagegroup-agl-demo-platform-flutter \
"

