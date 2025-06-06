SUMMARY = "Packagegroup for AIC8800 WiFi driver and firmware"
DESCRIPTION = "Packagegroup to install AIC8800 driver, firmware and udev rules."
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "aic8800-driver"
