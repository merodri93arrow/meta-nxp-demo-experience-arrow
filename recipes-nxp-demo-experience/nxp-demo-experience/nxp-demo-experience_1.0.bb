# Copyright 2020, 2021 NXP

SUMMARY = "NXP Demo Experience"
DESCRIPTION = "Launcher for NXP Demo Experience"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}/git"

SRCBRANCH = "imx_5.10.y"


NXP_DEMO_SRC ?= "git://github.com/merodri93arrow/nxp-demo-experience-arrow.git;protocol=https"
NXP_DEMO_LIST_SRC ?= "git://github.com/merodri93arrow/nxp-demo-experience-demos-list-arrow.git;protocol=https"

SRC_URI = " \
    ${NXP_DEMO_SRC};branch=${SRCBRANCH};name=nxp-demo-experience \
    ${NXP_DEMO_LIST_SRC};branch=${SRCBRANCH};destsuffix=demos;name=demos "

SRCREV_FORMAT = "nxp-demo-experience_demos"
SRCREV_nxp-demo-experience = "af4f719ac367917cac613a6c808418726a26bf2d"
SRCREV_demos = "7fdfab118be31a323a0a688e0efd1dcde8f03de9"


inherit qmake5

DEPENDS += " packagegroup-qt5-imx qtquickcontrols2 qtconnectivity qtgraphicaleffects qtsvg"
RDEPENDS_${PN} += " weston bash qtgraphicaleffects-qmlplugins qtquickcontrols-qmlplugins qtsvg-plugins"

do_install() {
    install -d -m 755 ${D}/home/root/.nxp-demo-experience
    cp -r ${WORKDIR}/demos/* ${D}/home/root/.nxp-demo-experience

    install -d -m 755 ${D}${bindir}
    install ${WORKDIR}/build/demoexperience ${D}${bindir}
}

FILES_${PN} += "${bindir}* /home/root/.nxp-demo-experience/* "
