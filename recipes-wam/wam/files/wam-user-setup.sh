#!/bin/sh

uid="$1"
bdir=/run/user
udir="$bdir/$uid"
hdir="/home/$uid"

dodir() {
	local x smackset="$1"
	shift
	for x; do
		test -e "$x" || mkdir -m 700 "$x"
		chmod 700 "$x"
		chown "$uid:$uid" "$x"
		chsmack $smackset "$x"
	done
}

dodir '-t -a User::Home' "$hdir/wamdata"

# Initialize lockfile, without this apps will be blocked by SMACK
touch "$udir/wamsocket.lock"
chmod 660 "$udir/wamsocket.lock"
chown "$uid:$uid" "$udir/wamsocket.lock"
chsmack -a User::App-Shared "$udir/wamsocket.lock"
