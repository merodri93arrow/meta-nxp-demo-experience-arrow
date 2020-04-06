# Copyright 2020 NXP

SUMMARY = "NXP Demo Experience"
DESCRIPTION = "Launcher for NXP Demo Experience"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://source.codeaurora.org/external/imxsupport/nxp-demo-experience;branch=v2.0"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit qmake5

DEPENDS += "qtbase qtquickcontrols2 qtconnectivity"
RDEPENDS_${PN} += "nxp-demos-experience-demos-list weston"

do_install() {
    install -d -m 755 ${D}${bindir}
    install ${WORKDIR}/build/demoexperience ${D}${bindir}
}

FILES_${PN} += "${bindir}*"