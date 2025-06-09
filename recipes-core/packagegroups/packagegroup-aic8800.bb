SUMMARY = "Packagegroup for AIC8800 WiFi driver and firmware"
DESCRIPTION = "Packagegroup to install AIC8800 driver, firmware, udev rules, wpa_supplicant and trigger kernel rebuild."

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    aic8800-driver \
    wpa-supplicant \
"
