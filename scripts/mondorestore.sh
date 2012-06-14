#!/bin/bash
# Automate system restorations from Mondo ISOs
# TODO:
#	- add support for splits e.g. mondorescue-[0-9].iso
#


# directory to mount ISOs to
ISO_MOUNT_DIR="/mnt/iso"

usage()
{
cat << EOF
usage: $0 -f isofile -o outdir [-h] [-d] [-v]

Automate system restoration from Mondo ISOs (both full and differential)

OPTIONS:
   -h      Show this message
   -f      Path to Full backup ISO
   -d      Path to Differential backup ISO
   -o      Output directory
   -v      Verbose

Examples:
1)
    Assuming mondoarchive was ran as such:
    mondoarchive -Oi -I "/etc" -d /mnt/backups -s 1g -W
    mondoarchive -Oi -I "/etc" -d /mnt/backups -s 1g -W -D -p "diff"
    Applying mondorescue-1.iso full backup and diff-1.iso in the root ("/") directory:
    $0 -f /mnt/backups/mondorescue-1.iso -d /mnt/backups/diff-1.iso -o /

2)
    Assuming mondoarchive was ran as such:
    mondoarchive -Oi -E "/dev /media /mnt /proc /tmp" -d /mnt/backups -s 5g -W -p "gentoo"
    Applying gentoo-1.iso full backup in / directory:
    $0 -f /mnt/backups/gentoo-1.iso -o /
EOF
}


exec_cmd()
{
    if [[ ! -z $verbose ]]
    then
        echo "Running: $1"
    fi
    # TODO: is that the right way to do it?
    $1
    if [ $? != 0 ]
    then
        echo "!! Error while running: $1 !!"
        echo "Try rerunning the script in verbose (-v) mode."
        echo ""
        exit 1
    fi
}


TEST=
SERVER=
PASSWD=
VERBOSE=
while getopts “hf:d:o:v” OPTION
do
     case $OPTION in
         h)
             usage
             exit
             ;;
         f)
             # path to full backup ISO
             iso_full_backup_path=$OPTARG
             ;;
         d)
             # path to differential backup ISO
             iso_diff_backup_path=$OPTARG
             ;;
         o)
             # backup output directory
             output_directory=$OPTARG
             ;;
         v)
             verbose=1
             ;;
         ?)
             usage
             exit
             ;;
     esac
done

if [[ -z $iso_full_backup_path ]] || [[ -z $output_directory ]]
then
     usage
     exit 1
fi

if [[ ! -d $ISO_MOUNT_DIR ]]
then
    exec_cmd "mkdir $ISO_MOUNT_DIR"
fi

# unmounting just in case something else was mounted on it
if grep -qs "$ISO_MOUNT_DIR" /proc/mounts
then
    exec_cmd "umount $ISO_MOUNT_DIR"
fi
# backing up full ISO
exec_cmd "mount -o loop,ro $iso_full_backup_path $ISO_MOUNT_DIR"
exec_cmd "cd $output_directory"
exec_cmd "afio -i $ISO_MOUNT_DIR/archives/0.afio.bz2"
for afio_file in `ls $ISO_MOUNT_DIR/archives/*.afio.bz2`
do
    exec_cmd "afio -i $afio_file"
done

# uncompressing bz2 archives made by mondoarchive
find -type f -name '*.z' -exec bunzip2 {} \; 2> /dev/null
find -type f -name '*.z.out' | while read f; do mv "$f" "${f%.z.out}"; done

sleep 1 # workarounds umount: /mnt/iso: device is busy
exec_cmd "umount $ISO_MOUNT_DIR"

# backing up diff ISO
if [[ ! -z $iso_diff_backup_path ]]
then
    exec_cmd "mount -o loop,ro $iso_diff_backup_path $ISO_MOUNT_DIR"
    exec_cmd "cd $output_directory"
    exec_cmd "afio -i $ISO_MOUNT_DIR/archives/0.afio.bz2"
    sleep 1 # workarounds umount: /mnt/iso: device is busy
    exec_cmd "umount $ISO_MOUNT_DIR"
fi
