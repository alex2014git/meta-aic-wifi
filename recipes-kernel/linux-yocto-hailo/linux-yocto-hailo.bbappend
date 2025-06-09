FILESEXTRAPATHS:prepend := "${THISDIR}:"

# 缺省模式 wifi-usb
WIFI_MODE ??= "wifi-usb"

# 根据 WIFI_MODE 决定用哪些 cfg
WIFI_CFG_FILES = "${@'file://cfg/aic8800-wifi.cfg file://cfg/usb-support.cfg' \
    if d.getVar('WIFI_MODE') == 'with-usb' else 'file://cfg/aic8800-wifi.cfg'}"

# 把 cfg 文件加入 SRC_URI
SRC_URI:append = " ${WIFI_CFG_FILES}"

# 可选：如果 kernel 不自动 merge cfg，可以打开下面代码强制 merge
#do_configure:prepend() {
#    for cfg_file in ${WIFI_CFG_FILES}; do
#        fname=$(basename ${@cfg_file.replace('file://', '')})
#        echo "Appending $fname to .config..."
#        cat ${WORKDIR}/cfg/$fname >> ${B}/.config
#    done
#}

