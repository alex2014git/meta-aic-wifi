FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto-hailo:"

SRC_URI += "file://aic8800-wifi.cfg"

KERNEL_FEATURES:append = " cfg/aic8800-wifi.cfg"
