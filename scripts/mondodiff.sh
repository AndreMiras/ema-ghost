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
usage: $0 -f full_archive_file -d destination_path_file -n iso_filename [-v] [-h]

Create a differential backup from a mondo archive

OPTIONS:
   -h      Show this message
   -f      Path to Full backup ISO
   -d      Path to Differential backup ISO
   -n      Prefix of the generated diff ISO
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


#uncompress_afio()
#{
#    exec_cmd "cd $tmp_directory"
#    exec_cmd "afio -i $ISO_MOUNT_DIR/archives/0.afio.bz2"
#    for afio_file in `ls $ISO_MOUNT_DIR/archives/*.afio.bz2`
#    do
#        exec_cmd "afio -i $afio_file"
#    done
#}

## uncompressing bz2 archives made by mondoarchive
#uncompress_bz2()
#{
#    exec_cmd "cd $tmp_directory"
#    find -type f -name '*.z' -exec bunzip2 {} \; 2> /dev/null
#    find -type f -name '*.z.out' | while read f; do mv "$f" "${f%.z.out}"; done
#}

while getopts “h:f:d:n:v” OPTION
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
        n)
            #name of the diff iso
            iso_diff_name=$OPTARG
            ;;
        ?)
             usage
             exit
             ;;
     esac
done

tmp_directory="/tmp/mondo$RANDOM"
exec_cmd "mkdir $tmp_directory"
#for the time you will realize mondo is useless for what you want to do
#exec_cmd "mkdir $tmp_directory/files"
exec_cmd "cd $tmp_directory"

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
#get list of full backup files
# exec_cmd "zcat $ISO_MOUNT_DIR/archives/filelist.full.gz | sort > filelist.full"
# zcat $ISO_MOUNT_DIR/archives/filelist.full.gz | sort > filelist.full
zcat $ISO_MOUNT_DIR/archives/filelist.full.gz | sort > filelist.full
# exit
#exclude useless directories
grep -v ^/media filelist.full | grep -v ^/mnt | grep -v ^/mondo.* | grep -v ^/proc | grep -v ^/run | grep -v ^/sys | grep -v ^/tmp | grep -v ^/var/tmp | sort > filelist.before
#get list of actual system files
find / -path /media -prune -o -path /mnt -prune -o -path /mondo.* -prune -o -path /proc -prune -o -path /run -prune -o -path /sys -prune -o -path /tmp -prune -o -path '/var/tmp' -prune -o -print | sort > filelist.after
#get list of deleted files
comm -23 filelist.before filelist.after > deleted.diff
#copy the list into the right place
mv deleted.diff /home/emabs/ema-ghost/deleted.diff

mondoarchive -Oi -E "/media /mnt /mondo.* /proc /run /sys /tmp /var/tmp" -d $iso_diff_backup_path -s 5g -W -D -p $iso_diff_name

sleep 1 # workarounds umount: /mnt/iso: device is busy
exec_cmd "umount $ISO_MOUNT_DIR"

exec_cmd "rm -rf $tmp_directory"
