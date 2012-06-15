#!/bin/bash
# affiche_param.sh
#$1 : directory to backup
#$2 : Output directory
#$3 : ISO's name
#$4 : Mode [none = classic save] [-d = differential save] 

usage()
{
cat << EOF
usage: $0 BackupDir outdir BackupName [-d]

Automate system backup on ISOs (both full and differential)

OPTIONS:
   -h      Show this message
   -d      Do a differential backup

Examples:
1)
	Do a full backup "BackupHome.iso" of "/home" in the directory "/backup" 
		$0 "/home" "/backup" "BackupHome"
2)
	Do a diff backup "BackupHome.iso" of "/home" in the directory "/backup" 
		$0 "/home" "/backup" "BackupHome" -d

EOF
}

	dir1=$1
	dir2=$2
	name=$3
	num=$#
	differential=false
	partition=/mnt/sda4
    help=false



while [ $# -gt 0 ] ;
	do
		if [ $1 = "-d" ]
		then
			differential=true
		fi

		if [ $1 = "h" ]
		then
			help=true
		fi

		if [ $1 = "?" ]
		then
			help=true
		fi
	  	shift 
	done


if [ $differential = 'true' ]
then
#	if [ $num -eq 4 ]
#	then
#		if [ ! -d /mnt/share ]
#		then mkdir /mnt/share
#		fi
#		mount -t nfs $nfs_server /mnt/share
#		mondoarchive -O -i -I $dir1 -d $dir2 -p $name -s 4g -W -D
#	fi
#
#	if [ $num -lt 4 ]
#	then usage
#	fi
#
#  	if [ $num -gt 4 ]
#	then usage
#	fi
    echo 'moved to mondodiff.sh'
else

  	if [ $num -eq 3 ]
	then
		if [ ! -d /mnt/share ]
                then mkdir /mnt/share
                fi
                mondoarchive -O -i -I $partition/$dir1 -d $dir2 -p $name -s 4g -W
	fi

	if [ $num -lt 3 ]
	then usage
	fi

	if [ $num -gt 3 ]
	then usage
	fi
fi

