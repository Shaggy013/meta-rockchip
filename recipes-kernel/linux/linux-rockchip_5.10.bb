# Copyright (C) 2021, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require linux-rockchip.inc

inherit freeze-rev local-git

# SRCREV = "72de5a560a44fb81549f1da325a1b3e323a7aaf7"
SRC_URI = " \
	git://${TOPDIR}/../kernel-5.10;protocol=file;usehead=1 \
	file://${THISDIR}/files/cgroups.cfg \
"

SRCREV_pn-linux-rockchip = "${AUTOREV}"
KBRANCH = "HEAD"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_VERSION_SANITY_SKIP = "1"
LINUX_VERSION ?= "5.10"

SRC_URI:append = " ${@bb.utils.contains('IMAGE_FSTYPES', 'ext4', \
		   'file://${THISDIR}/files/ext4.cfg', \
		   '', \
		   d)}"
