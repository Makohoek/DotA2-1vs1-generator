package Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_Matchup
{
   private Matchup _matchup;
   private Matchup _invertedMatchup;

   @Before
   public void SetUp()
   {
      _matchup = new Matchup(new Hero("hero1"), new Hero("hero2"));
      _invertedMatchup = new Matchup(new Hero("hero2"), new Hero("hero1"));
   }
   @Test
   public void shouldReturnTrueIfMatchupEquals()
   {
      boolean comparison = _matchup.equals(_matchup);
      Assert.assertEquals(true, comparison);
   }
   @Test
   public void shouldTrueIfMatchupEqualsNoOrder()
   {
      boolean comparison = _matchup.equals(_invertedMatchup);
      Assert.assertEquals(true, comparison);
   }
   @Test
   public void shouldTrueFalseIfMatchupIsDifferent()
   {
      Matchup differentMatchup = new Matchup(new Hero("otherName"), new Hero("hero2"));
      boolean comparison = _matchup.equals(differentMatchup);
      Assert.assertEquals(false, comparison);
   }
}
