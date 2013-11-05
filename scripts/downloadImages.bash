#!/bin/bash
#
# simple script to download every hero icon from the dota cdn

wget http://www.dota2.com/heroes/ -O dota2heroList.html

cat dota2heroList.html | grep -o '"http://cdn.dota2.com/apps/dota2/images/heroes/[a-z_]*\_sb.png"' > tmp
cat tmp | sed s/\"// | sed s/\"// | sed s/_sb/_full/ > tmp2
wget -i tmp2
cat tmp | sed s/\"// | sed s/\"// | sed s/.*heroes\// | sed s/_sb.*// | sed s/\\/// > HeroDatabase.txt

rm tmp tmp2 
mkdir img
mv *.png img/

