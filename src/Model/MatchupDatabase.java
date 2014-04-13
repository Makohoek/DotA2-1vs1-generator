package Model;

import java.util.ArrayList;

public class MatchupDatabase
{
   private final ArrayList<Matchup> _matchupDatabase;
   private HeroDatabase _heroDatabase;

   public MatchupDatabase(HeroDatabase heroDatabase)
   {
      _heroDatabase = heroDatabase;
      _matchupDatabase = new ArrayList<Matchup>();
   }

   public void AddMatchupsFromGateway(MatchupConfigurationGateway matchupConfigReader)
   {
      matchupConfigReader.open();
      while (matchupConfigReader.isFinished() == false)
      {
         Matchup currentMatchup = matchupConfigReader.getNextMatchup();
         addMatchup(currentMatchup);
      }
      matchupConfigReader.close();
   }

   public int size()
   {
      return _matchupDatabase.size();
   }

   public Matchup get(int index)
   {
      return _matchupDatabase.get(index);
   }

   protected boolean addMatchup(Matchup matchup)
   {
      assert (_heroDatabase.contains(matchup._radiantHero));
      assert (_heroDatabase.contains(matchup._direHero));

      if (contains(matchup))
      {
         System.err.println("Could not add the matchup:" + matchup);
         return false;
      } else
      {
         _matchupDatabase.add(matchup);
         return true;
      }
   }

   private boolean contains(Matchup other)
   {
      for (Matchup matchup : _matchupDatabase)
      {
         if (matchup.equals(other))
            return true;
      }
      return false;
   }
}
