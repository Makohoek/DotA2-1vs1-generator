package Model;

import java.util.ArrayList;

public class HeroDatabase
{
   private final ArrayList<Hero> _heroList;

   public HeroDatabase()
   {
      _heroList = new ArrayList<Hero>();
   }

   public boolean contains(Hero hero)
   {
      for (Hero currentHero : _heroList)
      {
         if (currentHero.equals(hero))
            return true;
      }
      return false;
   }

   @Override
   public String toString()
   {
      return _heroList.toString();
   }

   public void addHero(Hero hero)
   {
      _heroList.add(hero);
   }

   //TODO: unit test with mocks
   public void addHeroesFromGateway(HeroConfigurationGateway heroConfigurationGateway)
   {
      heroConfigurationGateway.open();
      while (heroConfigurationGateway.isFinished() == false)
      {
         addHero(heroConfigurationGateway.nextHero());
      }
      heroConfigurationGateway.close();
   }
}
