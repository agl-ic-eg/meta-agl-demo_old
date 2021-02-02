SUMMARY = "WAM"
AUTHOR = "Jani Hautakangas <jani.hautakangas@lge.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit cmake

DEPENDS = "glib-2.0 jsoncpp boost chromium79 libhomescreen"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_INSTALL_PREFIX=${prefix} \
    -DPLATFORM_NAME=${@'${DISTRO}'.upper().replace('-', '_')} \
    -DCHROMIUM_SRC_DIR=${STAGING_INCDIR}/chromium79"

PR="r0"

PROVIDES += "virtual/webruntime"
RPROVIDES_${PN} += "virtual/webruntime"

# Disable some of securit_flags
# Disable D_FORTIFY_SOURCE=2 and -fstack-protector-strong
# Refer conf/distro/include/security_flags.inc in meta-webos/conf/distro/include/webos.inc
lcl_maybe_fortify = ""
SECURITY_STACK_PROTECTOR = ""

SRC_URI = "\
    git://github.com/igalia/${BPN}.git;branch=@43.agl.jellyfish;protocol=https \
    file://WebAppMgr@.service \
    file://WebAppMgr.env \
    file://wam-user-setup.sh \
    file://wam-user-setup@.service \
    file://trunc-webapp-roles.patch \
"
S = "${WORKDIR}/git"
SRCREV = "8a1ec2f3e474199a689ae71a12ba70a230770c0d"

do_install_append() {
    install -d ${D}${sysconfdir}/wam
    install -v -m 644 ${S}/files/launch/security_policy.conf ${D}${sysconfdir}/wam/security_policy.conf
    install -d ${D}${systemd_system_unitdir}
    install -v -m 644 ${WORKDIR}/WebAppMgr@.service ${D}${systemd_system_unitdir}/WebAppMgr@.service
    install -d ${D}${sysconfdir}/default/
    install -v -m 644 ${WORKDIR}/WebAppMgr.env ${D}${sysconfdir}/default/WebAppMgr.env
    ln -snf WebAppMgr ${D}${bindir}/web-runtime
    install -d ${D}${systemd_system_unitdir}/afm-user-session@.target.wants
    ln -sf ../WebAppMgr@.service ${D}${systemd_system_unitdir}/afm-user-session@.target.wants/
    install -d ${D}${libexecdir}/wam/
    install -v -m 755 ${WORKDIR}/wam-user-setup.sh ${D}${libexecdir}/wam/wam-user-setup.sh
    install -v -m 644 ${WORKDIR}/wam-user-setup@.service ${D}${systemd_system_unitdir}/wam-user-setup@.service
    install -d ${D}${systemd_system_unitdir}/user-runtime-dir@.service.wants/
    ln -sf ../wam-user-setup@.service ${D}${systemd_system_unitdir}/user-runtime-dir@.service.wants/
}

FILES_${PN} += "${sysconfdir}/init ${sysconfdir}/wam ${libdir}/webappmanager/plugins/*.so ${systemd_system_unitdir}"

CXXFLAGS_append_agl-devel = " -DAGL_DEVEL"

do_install_append_agl-devel() {
    # Enable remote inspector and dev mode
    install -d ${D}${localstatedir}/agl-devel/preferences
    touch ${D}${localstatedir}/agl-devel/preferences/debug_system_apps
    touch ${D}${localstatedir}/agl-devel/preferences/devmode_enabled
}
