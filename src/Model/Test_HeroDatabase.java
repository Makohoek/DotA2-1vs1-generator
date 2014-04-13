package Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_HeroDatabase
{
   private HeroDatabase _database;

   @Before
   public void SetUp() throws Exception
   {
      _database = new HeroDatabase();
   }

   @Test
   public void shouldReturnTrueIfHeroIsContained() throws Exception
   {
      Hero hero = new Hero("pudge");
      _database.addHero(hero);
      boolean isContained = _database.contains(hero);
      Assert.assertEquals(true, isContained);
   }

   @Test
   public void shouldReturnFalseIfEmptyDatabase() throws Exception
   {
      Hero hero = new Hero("pudge");
      boolean isContained = _database.contains(hero);
      Assert.assertEquals(false, isContained);
   }
}
