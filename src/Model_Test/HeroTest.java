package Model_Test;

import Model.Hero;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Model.HeroDatabase;

public class HeroTest
{
   @Before
   public void setUp() throws Exception
   {
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void shouldHaveInvalidNameIfNotInHeroDatabase() throws Exception
   {
      final String expectedInvalidName = "Invalid Model.Hero";
      final String unknownHeroName = "superman";

      HeroDatabase database = new HeroDatabase();
      Assert.assertEquals(false, database.contains(unknownHeroName));

      Hero impossibleHero = new Hero(unknownHeroName);
      Assert.assertEquals(expectedInvalidName, impossibleHero.toString());
   }

   @Test
   public void testEquals() throws Exception
   {

   }
}
