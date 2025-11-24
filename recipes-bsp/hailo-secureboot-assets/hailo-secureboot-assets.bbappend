FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# 使用本地文件替换
CUSTOMER_CERT = "customer_certificate.bin"
#CUSTOMER_CERT = "development_customer_cert_chain.bin"
CUSTOMER_KEY = "customer_keypair.pem"

# 清理原始下载条目（彻底）
SRC_URI = " \
    file://${CUSTOMER_CERT} \
    file://${CUSTOMER_KEY} \
    ${BASE_URI}/LICENSE;name=lic \
"

# 保留 LICENSE 校验
#SRC_URI[lic.sha256sum] = "ca96445e6e33ae0a82170ea847b0925c864492f0cbb6342d42c54fd647133608"
#LIC_FILES_CHKSUM = "file://../LICENSE;md5=263ee034adc02556d59ab1ebdaea2cda"

# 自定义部署逻辑
#do_deploy:override() {
#    install -m 644 -D ${WORKDIR}/${CUSTOMER_CERT} ${DEPLOYDIR}/customer_certificate.bin
#    install -m 600 -D ${WORKDIR}/${CUSTOMER_KEY} ${DEPLOYDIR}/customer.key
#
#    # 可选：生成 crt
#    openssl req -batch -new -x509 -key ${DEPLOYDIR}/customer.key -out ${DEPLOYDIR}/customer.crt
#}

