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
		 		if [ $num -eq 4 ]
				then mondoarchive -O -i -d $dir2 -p $name -s 4g -W -D
				fi
			
				if [ $num -lt 4 ]
				then usage
				fi
    	 	
    		 	if [ $num -gt 4 ]
				then usage					
				fi
    		else
    		
    			if [ $num -eq 3 ]
				then mondoarchive -O -i -d $dir2 -p $name -s 4g -W
				fi
			
				if [ $num -lt 3 ]
				then usage
				fi
    	 	
    		 	if [ $num -gt 3 ]
				then usage					
				fi
fi

