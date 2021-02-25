# Mask out recipes with older versions than those available in
# meta-oe and meta-python
BBMASK += "meta-iot-cloud/recipes-support/cjson/cjson_1.7.10.bb"
BBMASK += "meta-iot-cloud/recipes-devtools/python/python3-httplib2_0.11.3.bb"
BBMASK += "meta-iot-cloud/recipes-devtools/python/python3-xmltodict_0.11.0.bb"
