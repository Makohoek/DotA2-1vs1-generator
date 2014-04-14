#!/usr/bin/python2.7

from __future__ import print_function

import urllib2
import re

class HeroDownloader(object):
    def __init__(self, heroPage):
        self.baseLink = heroPage

    def parseHeroLinks(self):
        stream = urllib2.urlopen(self.baseLink)
        htmlPage = stream.read()
        self._heroLinks = re.findall('http://cdn.dota2.com/apps/dota2/images/heroes/[a-z_]*\_sb.png', htmlPage)
        self._replaceWithFullResolutionLinks()

    def _replaceWithFullResolutionLinks(self):
        self._fullImageUrls = map(self._changeSuffixFullResolution, self._heroLinks)

    def _changeSuffixFullResolution(self, lowResolutionUrl):
        return re.sub('_sb', '_full', lowResolutionUrl)

    def getHeroNames(self):
        return map(self._extractHeroName, self._heroLinks)

    def _extractHeroName(self, imageUrl):
        withoutPrefix = re.sub('.*/heroes/', '', imageUrl)
        heroName = re.sub('_sb.png', '', withoutPrefix)
        heroName = re.sub('_full.png', '', heroName)
        return heroName

    #def createHeroDatabase(self): #FIXME: WIP here
    #    newDatabase = open('HeroDatabase.txt', 'w')
    #    print(self.getHeroNames(), file=newDatabase)
    #    newDatabase.close()

    def downloadAllHeroPortraits(self):
        map (self._saveHeroPortraitToDisc, self._fullImageUrls)

    def _saveHeroPortraitToDisc(self, imageUrl):
        heroName = self._extractHeroName(imageUrl)
        pathToFile = 'img/'+heroName+'.png'
        self._saveUrlToFile(imageUrl, pathToFile)

    def _saveUrlToFile(self, url, filePath):
        fileStream = urllib2.urlopen(url)
        newFile = open(filePath, 'w')
        newFile.write(fileStream.read())
        newFile.close()

downloader = HeroDownloader('http://www.dota2.com/heroes/')
downloader.parseHeroLinks()

heroNames = downloader.getHeroNames()
print('%s' % heroNames)
print('Currently found %s heroes' % len(heroNames))

print('Started downloading all portraits ...')
downloader.downloadAllHeroPortraits()
print('Done downloading all portraits')

#downloader.createHeroDatabase()
