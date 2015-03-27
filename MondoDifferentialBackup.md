# Introduction #

The differential backup is a delta of the last full backup, so that you can delete all of the differential backups except for the last one.

nb:
We won't back up the following directories :
  * /proc
  * /dev
  * /tmp
  * /media

Useful links:
  * http://steveyoung.wordpress.com/2007/02/02/mondo-differential-backup/
  * http://bryan-murdock.blogspot.fr/2007/02/differential-backup-with-mondo_15.html



# Full backup #
mkdir -p /media/backups/```date +%F```

mondoarchive -Oi -E "/dev /proc /media /tmp /mnt" -d /media/backups/```date +%F``` -s 4g


Arguments:
  * -O Backup the system
  * -i Make an ISO
  * -g GUI (non-cron-friendly)
  * -E Exclude path(s) from backup
  * -d Backup device|dir

# Differential backup #

mkdir -p /media/backups/```date +%F```

mondoarchive -Oi -E "/dev /proc /media /tmp /mnt" -d /media/backups/```date +%F``` -s 4g -D -W -p "diff"


Arguments:
  * -D Make  a  differential  backup
  * -W Don't  make  your  backup  self-booting
  * -p ISO base name


---------------Functionnal scenario-------------

  * mondoarchive  -O -i -I "/etc" -d "/var/cache/mondo/mondouser" -s 4g -W
Don't put "/" in the end of the directory
  * touch /etc/test.txt
  * mondoarchive  -O -i -I "/etc" -d "/var/cache/mondo/mondouser" -p "differentialbackup" -s 4g -W -D
  * mondorestore //let the gui work for you