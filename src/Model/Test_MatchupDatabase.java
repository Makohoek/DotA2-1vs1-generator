package Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_MatchupDatabase
{
   private static final String _RADIANT_HERO_NAME = "Thor";
   private static final String _DIRE_HERO_NAME = "Loki";
   HeroDatabase _heroDatabase;
   MatchupDatabase _matchupDatabase;
   @Before
   public void SetUp() throws Exception
   {
      _heroDatabase = new HeroDatabase();
      _heroDatabase.addHero(new Hero(_RADIANT_HERO_NAME));
      _heroDatabase.addHero(new Hero(_DIRE_HERO_NAME));
      _matchupDatabase = new MatchupDatabase(_heroDatabase);
   }
   @Test
   public void AddShouldReturnTrueWhenMatchupSuccessfullyAdded() throws Exception
   {
      boolean firstAdd = _matchupDatabase.addMatchup(new Matchup(new Hero(_RADIANT_HERO_NAME), new Hero(_DIRE_HERO_NAME)));
      Assert.assertEquals(true, firstAdd);
   }
   @Test
   public void AddShouldReturnFalseWhenMatchupAlreadyExists() throws Exception
   {
      boolean couldAddFirstMatchup = _matchupDatabase.addMatchup(new Matchup(new Hero(_RADIANT_HERO_NAME), new Hero(_DIRE_HERO_NAME)));
      Assert.assertEquals(true, couldAddFirstMatchup);

      boolean couldAddSecondMatchup = _matchupDatabase.addMatchup(new Matchup(new Hero(_RADIANT_HERO_NAME), new Hero(_DIRE_HERO_NAME)));
      Assert.assertEquals(false, couldAddSecondMatchup);

      boolean couldAddThirdMatchup = _matchupDatabase.addMatchup(new Matchup(new Hero(_DIRE_HERO_NAME), new Hero(_RADIANT_HERO_NAME)));
      Assert.assertEquals(false, couldAddThirdMatchup);
   }

   @Test(expected = AssertionError.class)
   public void AddShouldAssertFailWhenAddingUnknownHeroMatchup() throws Exception
   {
      Hero unknownHero = new Hero("Papyrusse");
      boolean containedInDatabase = _heroDatabase.contains(unknownHero);
      Assert.assertEquals(false, containedInDatabase);

      _matchupDatabase.addMatchup(new Matchup(unknownHero, new Hero(_DIRE_HERO_NAME)));
   }
}
