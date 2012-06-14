#!/bin/bash
# Differential archive using mondoarchive 
#
#
#


# directory to mount ISOs to
ISO_MOUNT_DIR="/mnt/iso"

usage()
{
cat << EOF
usage: $0 -f full_archive_file -d destination_file

Create a differential backup from a mondo archive

OPTIONS:
   -h      Show this message
   -f      Path to Full backup ISO
   -d      Path to Differential backup ISO
   -v      Verbose

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


uncompress_afio()
{
    exec_cmd "cd $tmp_directory"
    exec_cmd "afio -i $ISO_MOUNT_DIR/archives/0.afio.bz2"
    for afio_file in `ls $ISO_MOUNT_DIR/archives/*.afio.bz2`
    do
        exec_cmd "afio -i $afio_file"
    done
}

# uncompressing bz2 archives made by mondoarchive
uncompress_bz2()
{
    exec_cmd "cd $tmp_directory"
    find -type f -name '*.z' -exec bunzip2 {} \; 2> /dev/null
    find -type f -name '*.z.out' | while read f; do mv "$f" "${f%.z.out}"; done
}

##copy added or modified files between f1 and f2 in temporary files folder
#get_added_modified()
#{
#    exec_cmd "TODO"
#}
#
##echo deleted files paths between f1 and f2 in temporary deleted.txt
#get_deleted()
#{
#    exec_cmd "TODO"
#}

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
        v)
             verbose=1
             ;;
        ?)
             usage
             exit
             ;;
     esac
done

$tmp_directory = /tmp/$RANDOM.$RANDOM
exec_cmd "mkdir $tmp_directory"
exec_cmd "mkdir $tmp_directory/files"

if [[ -z $iso_full_backup_path ]] || [[ -z $iso_diff_backup_path ]]
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
# mounting full ISO
exec_cmd "mount -o loop,ro $iso_full_backup_path $ISO_MOUNT_DIR"

#diff between full iso and hdd
#copy added or modified files in $tmp_directory/files/
exec_cmd "zcat /mnt/iso/archives/filelist.full.gz |sort > filelist.full"
exec_cmd "grep -v ^/media filelist.full | grep -v ^/mnt | grep -v ^/mondo.* | grep -v ^/proc | grep -v ^/run | grep -v ^/sys | grep -v ^/tmp | grep -v ^/var/tmp | sort > filelist.before"
exec_cmd "find / -path /media -prune -o -path /mnt -prune -o -path /mondo.* -prune -o -path /proc -prune -o -path /run -prune -o -path /sys -prune -o -path /tmp -prune -o -path '/var/tmp' -prune -o -print | sort > filelist.after"
exec_cmd "diff filelist.before filelist.after > filelist.diff"

#compress the whole thing

sleep 1 # workarounds umount: /mnt/iso: device is busy
exec_cmd "umount $ISO_MOUNT_DIR"

exec_cmd "rm -rf $tmp_directory"
