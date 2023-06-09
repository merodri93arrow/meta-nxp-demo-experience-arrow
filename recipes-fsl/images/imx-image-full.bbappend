# Copyright 2021 NXP

ROOTFS_POSTPROCESS_COMMAND_append_mx8 = "install_demo; "
ROOTFS_POSTPROCESS_COMMAND_append_mx7ulp = "install_demo; "

install_demo() {
    if ! grep -q "icon=/home/root/.nxp-demo-experience/icon/icon_demo_launcher.png" ${IMAGE_ROOTFS}${sysconfdir}/xdg/weston/weston.ini
    then
       printf "\n[launcher]\nicon=/home/root/.nxp-demo-experience/icon/icon_demo_launcher.png\npath=/usr/bin/demoexperience\n\n[launcher]\nicon=/usr/share/weston/terminal.png\npath=/usr/bin/weston-terminal" >> ${IMAGE_ROOTFS}${sysconfdir}/xdg/weston/weston.ini
    fi
    if ! grep -q "HOME=/home/root/" ${IMAGE_ROOTFS}${sysconfdir}/default/weston
    then
        printf "\nHOME=/home/root/\nQT_QPA_PLATFORM=wayland" >> ${IMAGE_ROOTFS}${sysconfdir}/default/weston
    fi
}
