CONFIG_AIC_LOADFW_SUPPORT := m
CONFIG_AIC8800_WLAN_SUPPORT := m

obj-$(CONFIG_AIC_LOADFW_SUPPORT)    += aic_load_fw/
obj-$(CONFIG_AIC8800_WLAN_SUPPORT) += aic8800_fdrv/

########## config option ##########
export CONFIG_USE_FW_REQUEST = n
export CONFIG_PREALLOC_RX_SKB = n
export CONFIG_PREALLOC_TXQ = y
###################################

# Use variables from Yocto or fallback default
KERNEL_SRC ?= $(if $(KDIR),$(KDIR),/lib/modules/$(shell uname -r)/build)

PWD   := $(shell pwd)

all: modules

modules:
	@echo "==> Building AIC8800 driver with:"
	@echo "    KERNEL_SRC = $(KERNEL_SRC)"
	@echo "    ARCH = $(ARCH)"
	@echo "    CROSS_COMPILE = $(CROSS_COMPILE)"
	$(MAKE) -C $(KERNEL_SRC) M=$(PWD) ARCH=$(ARCH) CROSS_COMPILE=$(CROSS_COMPILE) modules

clean:
	$(MAKE) -C aic_load_fw clean
	$(MAKE) -C aic8800_fdrv clean
	rm -rf modules.order Module.symvers .modules.order.cmd .Module.symvers.cmd .tmp_versions/
