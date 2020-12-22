require chromium.inc

SRC_URI = "\
    git://github.com/igalia/${PN};branch=@45.agl.jellyfish;protocol=https;rev=${SRCREV_chromium79};name=chromium79 \
    git://github.com/webosose/chromium-v8;branch=@chromium79;destsuffix=git/src/v8;rev=${SRCREV_v8};name=v8 \
    file://0001-GCC-fix-includes-for-gcc-10.patch \
"

# Needed by catapult
DEPENDS += "python-six-native python-beautifulsoup4-native python-lxml-native python-html5lib-native python-webencodings-native"

SRCREV_chromium79 = "c568380f34a275ed5430f3927b1bdee0e14220e0"
SRCREV_v8 = "e876fd0e28bd3bda5815394874183b7e6079d440"

BROWSER_APPLICATION = "chromium79-browser"
BROWSER_APPLICATION_DIR = "/opt/chromium79"
MKSNAPSHOT_PATH = "v8_snapshot/"

GN_ARGS += "use_gtk=false"

# Disable closure_compile
# Else we need HOSTTOOLS += "java"
GN_ARGS += "closure_compile=false"

# When using meta-clang, one can switch to using the lld linker
# by using the ld-is-lld distro feature otherwise use gold linker
GN_ARGS += "${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-lld', 'use_lld=true use_gold=false', 'use_lld=false use_gold=true', d)}"

# Toolchains we will use for the build. We need to point to the toolchain file
# we've created, set the right target architecture and make sure we are not
# using Chromium's toolchain (bundled clang, bundled binutils etc).
GN_ARGS += "\
    host_toolchain=\"//build/toolchain/cros:host\" \
    cros_host_is_clang=false \
    use_custom_libcxx_for_host=false \
    cros_host_ar=\"${BUILD_AR}\" \
    cros_host_cc=\"${BUILD_CC}\" \
    cros_host_cxx=\"${BUILD_CXX}\" \
    cros_host_extra_ldflags=\"${BUILD_LDFLAGS}\" \
    custom_toolchain=\"//build/toolchain/cros:target\" \
    is_clang=false \
    use_custom_libcxx=false \
    target_cpu=\"${@gn_arch_name('${TUNE_ARCH}')}\" \
    cros_target_ar=\"${AR}\" \
    cros_target_cc=\"${CC}\" \
    cros_target_cxx=\"${CXX}\" \
    cros_target_extra_ldflags=\"${LDFLAGS}\" \
    v8_snapshot_toolchain=\"//build/toolchain/cros:v8_snapshot\" \
    cros_v8_snapshot_is_clang=false \
    cros_v8_snapshot_ar=\"${BUILD_AR}\" \
    cros_v8_snapshot_cc=\"${BUILD_CC}\" \
    cros_v8_snapshot_cxx=\"${BUILD_CXX}\" \
    linux_use_bundled_binutils=false \
    gold_path=\"\" \
    v8_enable_embedded_builtins=false \
    use_v8_context_snapshot=false \
"

D = "${OUT_DIR}/${BUILD_TYPE}/image"

