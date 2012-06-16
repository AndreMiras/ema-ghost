#!/bin/bash
# Automate new client installation (for iso creation)

required_packages="openssh-server nfs-common openjdk-6-jre"
optional_packages="vim screen git"
all_packages="$required_packages $optional_packages"
create_dirs="/mnt/sda4 /root/.ssh/ /home/emabs/.ssh/"

apt-get update
apt-get upgrade -y
apt-get install -y $all_packages

# http://code.google.com/p/ema-ghost/issues/detail?id=17
apt-get install -y --force-yes mondo

for a_dir in $create_dirs
do
    if [[ ! -d $a_dir ]]
    then
        mkdir -p $create_dirs
    fi
done
