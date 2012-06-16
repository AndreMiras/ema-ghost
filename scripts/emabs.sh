#!/bin/bash

if grep -qs "/mnt/share/" /proc/mounts
then
    umount /mnt/share
fi

mount -t nfs 192.168.6.1:/partage "/mnt/share/"

java -jar /usr/local/bin/EmaBSClient.jar
