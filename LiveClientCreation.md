# Introduction #

TODO


# Details #

exclude following directories TODO
think about including the /mnt/ directory which contains the /mnt/sda4

# Doing the backup #
mondoarchive -Oi -E "/dev /proc /media /tmp" -d "/media/backups/" -s 4g

TODO:
  * rm ~/.netrc ~/.config
  * Add stuffs