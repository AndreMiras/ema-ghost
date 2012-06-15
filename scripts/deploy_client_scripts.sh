#!/bin/bash
#
DEST_DIR="/usr/local/bin"
SCRIPTS_SUBFOLDER="scripts"
SCRIPTS_TO_DEPLOY="archive.sh install_client.sh sc_diff_restore sc_save deploy_client_scripts.sh mondorestore.sh sc_restore sc_save_diff"
JAVA_SUBFOLDER="java"
JAVA_TO_DEPLOY="TODO.jar"

usage()
{
cat << EOF
usage: $0 -g git_project_dir

Automate system restoration from Mondo ISOs (both full and differential)

OPTIONS:
   -h      Show this message
   -g      Git project dir to get the scripts from
   -v      Verbose

Examples:
1)
    Assuming you cloned your git repository in ~/ema-bs
    $0 -g ~/ema-bs
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


while getopts "hg:v" OPTION
do
     case $OPTION in
         h)
             usage
             exit
             ;;
         g)
             git_project_dir=$OPTARG
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

if [[ -z $git_project_dir ]]
then
     usage
     exit 1
fi

scripts_full_path="$git_project_dir/$SCRIPTS_SUBFOLDER/"
for script in $SCRIPTS_TO_DEPLOY
do
    exec_cmd "cp $scripts_full_path/$script $DEST_DIR"
done
