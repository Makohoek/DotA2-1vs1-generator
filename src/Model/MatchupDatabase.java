package Model;

import java.util.ArrayList;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 18/09/13
 * Time: 19:05
 */
public class MatchupDatabase
{
   private final ArrayList<Matchup> database;

   public MatchupDatabase()
   {
      database = new ArrayList<Matchup>();
   }

   public void ReadFromConfigurationFile()
   {
      String pathToMatchupDatabase = ("config/MatchupDatabase.txt");
      MatchupConfigReader matchupConfigReader = new MatchupConfigReader(pathToMatchupDatabase);
      matchupConfigReader.openConfigFile();
      HeroDatabase heroDatabase = new HeroDatabase();

      while (matchupConfigReader.readLine() != null)
      {
         AddMatchupToDatabase(matchupConfigReader, heroDatabase);
      }

      matchupConfigReader.closeConfigFile();
   }

   private void AddMatchupToDatabase(MatchupConfigReader matchupConfigReader, HeroDatabase heroDatabase)
   {
      String radiantHeroName = matchupConfigReader.getCurrentRadiantHeroName();
      String direHeroName = matchupConfigReader.getCurrentDireHeroName();

      if (!(heroDatabase.contains(radiantHeroName) && heroDatabase.contains(direHeroName)))
      {
        System.err.println("The hero database does not contains a hero from the specified matchup("+radiantHeroName+","+direHeroName+")");
      }

      Hero radiantHero = new Hero(radiantHeroName);
      Hero direHero = new Hero(direHeroName);
      Matchup newMatchup = new Matchup(radiantHero, direHero);
      Matchup mirroredNewMatchup = new Matchup(direHero, radiantHero);

      if (contains(newMatchup) || contains(mirroredNewMatchup))
      {
         System.err.println("The matchup database already contains this matchup("+radiantHeroName+","+direHeroName+")");
      }
      else
      {
         database.add(newMatchup);
      }
   }

   public int size()
   {
      return database.size();
   }

   public Matchup get(int index)
   {
      return database.get(index);
   }

   private boolean contains(Matchup other)
   {
      for (Matchup matchup: database)
      {
         if (matchup.equals(other))
            return true;
      }
      return false;
   }
}
