#!/usr/bin/env python
"""
Runs pyuic4 on all .ui found in the local directory
"""

import os
from os import listdir
from subprocess import call
from os.path import isfile, join

# onlyfiles = [ f for f in listdir(mypath) if isfile(join(mypath,f)) ]
mypath = "."
for f in listdir(mypath):
    full_obj_path = join(mypath, f)
    if isfile(full_obj_path) and f.endswith(".ui"):
        # replaces the .ui with .py
        full_module_path = full_obj_path[:-2] + "py"
        cmd_line = ["pyuic4", "-x", full_obj_path, "-o", full_module_path]
        print(cmd_line)
        call(cmd_line)
