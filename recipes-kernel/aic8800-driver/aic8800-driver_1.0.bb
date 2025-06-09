DESCRIPTION = "AIC8800 Wi-Fi kernel driver, firmware and udev rule"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=1a94e00dcd8ed71a00ecabc292c6cc5b"

inherit module

KERNEL_MODULE_AUTOLOAD += "aic_load_fw aic8800_fdrv"

SRC_URI = "file://driver/ \
           file://fw/ \
           file://aic.rules"

S = "${WORKDIR}/driver"

# 重点改这里：用 do_install:append()
do_install:append() {
    install -d ${D}/lib/firmware/aic8800D80
    cp -r ${WORKDIR}/fw/aic8800D80/* ${D}/lib/firmware/aic8800D80/

    install -d ${D}/etc/udev/rules.d
    install -m 0644 ${WORKDIR}/aic.rules ${D}/etc/udev/rules.d/
}

FILES:${PN} += " \
    /lib/firmware/aic8800D80 \
    /etc/udev/rules.d/aic.rules \
"

INSANE_SKIP:${PN} += "installed-vs-shipped"
