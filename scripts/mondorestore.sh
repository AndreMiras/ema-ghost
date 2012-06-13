#!/bin/bash
# mondorestore.sh automates system restoration from Mondo
# ISOs (both full and differential)
# TODO:
#	- test if dir exists or create it
#	- command line arguments
#
# Notes:
# mondoarchive -Oi -I "/etc" -d /tmp/mondo -s 4g -W
# mondoarchive -Oi -I "/etc" -d /tmp/mondo -s 4g -W -D -p "diff"

ISO_MOUNT_DIR="/mnt/iso" # const

iso_full_backup_path="/tmp/mondo/mondorescue-1.iso" # param
iso_diff_backup_path="/tmp/mondo/diff-1.iso" # param
output_directory="/tmp" # param, currently sets for testing purpose

# umount $ISO_MOUNT_DIR
mount -o loop $iso_full_backup_path $ISO_MOUNT_DIR
cd $output_directory
afio -i $ISO_MOUNT_DIR/archives/0.afio.bz2

umount $ISO_MOUNT_DIR
mount -o loop $iso_diff_backup_path $ISO_MOUNT_DIR
cd $output_directory
afio -i $ISO_MOUNT_DIR/archives/0.afio.bz2

umount $ISO_MOUNT_DIR
