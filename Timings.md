# Introduction #

Draft document of Mondo commands, Pulls, Pushes with timings.


# Details #

  * mondoarchive -I /var -d /mnt/nfs took 4 minutes
  * du -sh /var was 1Go
  * The final ISO archive was 400Mo

  * mondoarchive -I / -d /mnt/nfs took x minutes
  * du -sh / was xGo
  * The final ISO archive was xMo

<pre>
root@emabs-pc2:~# time mondoarchive -Oi -E "/dev /media /mnt /proc /tmp" -d /mnt/backups -s 5g -W -p "full"<br>
real    8m12.764s<br>
user    7m42.533s<br>
sys     0m56.928s<br>
root@emabs-pc2:~# ls -lh /mnt/backups/full-1.iso<br>
-rw-r--r-- 1 root root 938M Jun 14 15:27 /mnt/backups/full-1.iso<br>
root@emabs-pc2:~# du -sh /<br>
du: cannot access `/proc/29514/task/29514/fd/3': No such file or directory<br>
du: cannot access `/proc/29514/task/29514/fdinfo/3': No such file or directory<br>
du: cannot access `/proc/29514/fd/3': No such file or directory<br>
du: cannot access `/proc/29514/fdinfo/3': No such file or directory<br>
2.5G    /<br>
root@emabs-pc2:~# time mondoarchive -Oi -E "/dev /media /mnt /proc /tmp" -d /mnt/backups -s 5g -W -p "full-diff" -D<br>
real    6m27.503s<br>
user    5m27.532s<br>
sys     0m14.441s<br>
root@emabs-pc2:~# ls -lh /mnt/backups/full-diff-1.iso<br>
-rw-r--r-- 1 root root 928M Jun 14 15:38 /mnt/backups/full-diff-1.iso<br>
root@emabs-pc2:~# time /home/emabs/ema-ghost/scripts/mondorestore.sh -f /mnt/backups/full-1.iso -d /mnt/backups/full-diff-1.iso -o /tmp/full/<br>
<br>
real    7m45.164s<br>
user    2m39.946s<br>
sys     1m2.052s<br>
root@emabs-pc2:~# du -sh /tmp/full/<br>
2.5G    /tmp/full/<br>
<br>
</pre>