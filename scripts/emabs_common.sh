#!/bin/bash

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
