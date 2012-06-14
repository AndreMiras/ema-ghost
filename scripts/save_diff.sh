#!/bin/sh
# affiche_param.sh


usage()
{
cat << EOF
usage: $0 "BackupName"

Automate differential system backup on ISOs 

OPTIONS:
   -h      Show this message

Examples:

	Do a differential backup "BackupName.iso" of the / 
		$0  "BackupName"

EOF
}
	dirbackup="/"
	outputdir="/"
	name=$1
	num=$#
	help=false
	
	
	
while [ $# -gt 0 ] ;
	do
		
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


    		
if [ $num -eq 1 ]
then echo mondoarchive -O -i -I \"$dirbackup\" -d \"$outputdir\" -p \"$name\" -s 4g -W -D
fi

if [ $num -lt 1 ]
then usage
fi
	 	
if [ $num -gt 1 ]
then usage					
fi

