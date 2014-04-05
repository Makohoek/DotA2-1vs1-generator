package Model;

import java.util.ArrayList;

public class HeroDatabase
{
   private final ArrayList<String> heroList;

   public HeroDatabase()
   {
      String pathToHeroListFile = "config/HeroDatabase.txt";
      heroList = readHeroListFromFile(pathToHeroListFile);
   }

   public boolean contains(String heroName)
   {
      for (String hero : heroList)
      {
         if (hero.compareToIgnoreCase(heroName) == 0)
            return true;
      }

      return false;
   }

   @Override
   public String toString()
   {
      return heroList.toString();
   }

   private ArrayList<String> readHeroListFromFile(String pathToHeroListFile)
   {
      ArrayList<String> resultList = new ArrayList<String>();
      ConfigReader heroConfigReader = new ConfigReader(pathToHeroListFile);
      heroConfigReader.openConfigFile();

      String currentHero;
      while ((currentHero = heroConfigReader.readLine()) != null)
      {
         resultList.add(currentHero);
      }

      heroConfigReader.closeConfigFile();

      return resultList;
   }


}
