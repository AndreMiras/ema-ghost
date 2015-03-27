_Notes et documentation sur la préparation du système d'exploitation client EmaBS_

# Introduction #

Cette page présente les instructions à suivre pour préparer le système EmaBS à mettre en production sur les clients.


# Details #

**Installation d'un light ubuntu 12.04**

**Installation de Mondo**
> Voici la liste des commandes a taper pour installer MondoRescue
  * _wget [ftp://ftp.mondorescue.org/ubuntu/`lsb_release](ftp://ftp.mondorescue.org/ubuntu/`lsb_release) -r|awk '{print $2}'`/mondorescue.sources.list_
  * _sudo sh -c "cat mondorescue.sources.list >> /etc/apt/sources.list"_
  * _sudo apt-get update_
  * _sudo apt-get install mondo_

**Configuration de Mondo**
  * Editer le fichier de configureation mindi.conf afin de pouvoir utiliser des images bootables.

**Installation de Openssh-Server**
  * _sudo apt-get install openssh-server_