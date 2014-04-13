package Model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Test_Hero
{
   @Test
   public void shouldHaveSameNameIfHeroEquals() throws Exception
   {
      Hero heroA = new Hero("a");
      Hero heroB = new Hero("a");

      if (heroA.equals(heroB))
      {
         Assert.assertEquals(heroA._name, heroB._name);
      }
   }

   @Test
   public void shouldHaveDifferentNamesIfHeroesAreDifferent() throws Exception
   {
      Hero heroA = new Hero("a");
      Hero heroB = new Hero("b");

      if (heroA.equals(heroB) == false)
      {
         Assert.assertEquals(false, heroA._name.equalsIgnoreCase(heroB._name));
      }
   }

   @Test
   public void toStringShouldReturnName() throws Exception
   {
      Hero hero = new Hero("someFantasyName");
      Assert.assertEquals(hero._name, hero.toString());
   }
}
