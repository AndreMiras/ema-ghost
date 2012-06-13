#!/bin/sh
# affiche_param.sh
#$1 : directory to backup
#$2 : Output directory
#$3 : ISO's name 



dir1=$1
dir2=$2
name=$3
var="$*"
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
 	 echo "mondorestore"
else if [ $differential = 'true' ]
		then 
    	 echo "mondoarchive -O -i -I \"$dir1\" -d \"$dir2\" -p \"$name\" -s 4g -W -D"
    	else
    	 echo "mondoarchive -O -i -I \"$dir1\" -d \"$dir2\" -p \"$name\" -s 4g -W"
     fi
fi