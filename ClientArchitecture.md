# Composants du client emabs #

## Required Packages ##
  * openssh-server
  * mondo
  * nfs-common
  * openjdk-6-jre

## Optional Packages ##
  * vim
  * screen

## Files ##
/etc/ssh/sshd\_config
UseDNS no
[pour automatiser la connexion client/server avec des clés](Voir.md)

/etc/apt/sources.list

## Folders ##
  * /mnt/share/ => pour monter le serveur nfs
  * /usr/local/bin/ => emabs scripts and binaries
  * /mnt/sda4 => /dev/sda4 (other Linux systems)

## Scripts ##
  * /usr/local/bin/sc\_restore (-s 192.168.1.1:/share/ -f /isos/gentoo-1.iso) => mondo restore
  * /usr/local/bin/sc\_diff\_restore (-s 192.168.1.1:/share/ -f iso\_file -d iso\_diff\_file) => besoin d'un restore diff ? TODO: atomiser
  * /usr/local/bin/sc\_save\_diff  (-f path\_to\_full\_backup -d destination\_folder -n diff\_iso\_name) => mondo save diff
  * /usr/local/bin/sc\_save (@iso\_output\_path) => besoin d'un save complet ?
  * /usr/local/bin/EmaBSClient.jar => application cliente emabs (java) (java -jar /usr/local/bin/EmaBSClient.jar)