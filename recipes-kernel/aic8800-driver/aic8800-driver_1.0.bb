DESCRIPTION = "AIC8800 Wi-Fi kernel driver, firmware and udev rule"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=1a94e00dcd8ed71a00ecabc292c6cc5b"

SRC_URI = "file://driver/ \
           file://fw/ \
           file://aic.rules"

S = "${WORKDIR}/driver"

inherit module

do_install() {
    # Install kernel modules
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 ${S}/aic_load_fw/*.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/
    install -m 0644 ${S}/aic8800_fdrv/*.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/

    # Install firmware
    install -d ${D}/lib/firmware/aic8800D80
    cp -r ${WORKDIR}/fw/aic8800D80/* ${D}/lib/firmware/aic8800D80/

    # Install udev rule
    install -d ${D}/etc/udev/rules.d
    install -m 0644 ${WORKDIR}/aic.rules ${D}/etc/udev/rules.d/
}

FILES:${PN} += " \
    ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra \
    /lib/firmware/aic8800D80 \
    /etc/udev/rules.d/aic.rules \
"

INSANE_SKIP:${PN} += "installed-vs-shipped"
