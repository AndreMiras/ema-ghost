#!/bin/sh
# affiche_param.sh
#$1 : directory to backup
#$2 : Output directory
#$3 : ISO's name
#$4 : Mode [none = classic save] [-diff = differential save] [-rest = Restore mode] 



dir1=$1
dir2=$2
name=$3
num=$#
restore=false
differential=false

while [ $# -gt 0 ] ;
	do
		if [ $1 = "-diff" ]
		then
			differential=true
		fi
		
		if [ $1 = "-rest" ]
		then
			restore=true
		fi

	  	shift 
	done


if [ $restore = 'true' ]
	then
		 	if [ $num -eq 1 ]
			then echo "mondorestore"
			fi
			
    	 	if [ $num -gt 1 ]
			then echo "Too many args"
			fi

	else if [ $differential = 'true' ]
			then
		 		if [ $num -eq 4 ]
				then echo "mondoarchive -O -i -I \"$dir1\" -d \"$dir2\" -p \"$name\" -s 4g -W -D"
				fi
			
				if [ $num -lt 4 ]
				then echo "Args missing"
				fi
    	 	
    		 	if [ $num -gt 4 ]
				then echo "Too many args"
				fi
    		else
    		 echo "mondoarchive -O -i -I \"$dir1\" -d \"$dir2\" -p \"$name\" -s 4g -W"
     	 fi
fi