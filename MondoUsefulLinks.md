#Commentaires et liens utiles sur Mondo Archive ou Mondo Rescue

# Commentaires #




# Liens #

  * http://www.mondorescue.org/docs.shtml
  * http://syslinux.zytor.com/pxe.php
  * http://c-net.fr/info/?doc=Mondo_Rescue,_la_sauvegarde_sous_Linux
  * https://help.ubuntu.com/community/MondoMindi #installer mondo
  * [Differential Backup With Mondo](http://bryan-murdock.blogspot.fr/2007/02/differential-backup-with-mondo_15.html)


# Installing Mondo #
<pre>
wget ftp://ftp.mondorescue.org/ubuntu/`lsb_release -r|awk '{print $2}'`/mondorescue.sources.list<br>
sudo sh -c "cat mondorescue.sources.list >> /etc/apt/sources.list"<br>
sudo apt-get update<br>
sudo apt-get install mondo<br>
</pre>