#!/bin/bash

if grep -qs "/mnt/share/" /proc/mounts
then
    umount /mnt/share
fi

java -jar /usr/local/bin/EmaBSClient.jar
