package Model;

import java.util.ArrayList;
import java.util.Random;

public class RandomMatchupPicker
{
   private final MatchupDatabase matchupDatabase;

   public RandomMatchupPicker(MatchupDatabase heroMatchupDatabase)
   {
      this.matchupDatabase = heroMatchupDatabase;
   }

   public ArrayList<Matchup> pickRandomMatches(int numberOfRandomMatches)
   {
      if (numberOfRandomMatches < 1 || numberOfRandomMatches > matchupDatabase.size())
      {
         System.err.println("the HeroMatchupDatabase is empty or the number of matches asked is too big");
      }

      ArrayList<Integer> randomIndexes = new ArrayList<Integer>();
      for (int i = 0; i < numberOfRandomMatches; i++)
      {
         Integer randomIndex = getUnusedMatchupIndex(randomIndexes);
         randomIndexes.add(randomIndex);
      }

      ArrayList<Matchup> randomMatches = new ArrayList<Matchup>();
      for(Integer index: randomIndexes)
      {
         Matchup selectedMatchup = matchupDatabase.get(index);
         randomMatches.add(selectedMatchup);
      }

      return randomMatches;
   }

   private Integer getUnusedMatchupIndex(ArrayList<Integer> indexsOfDatabase)
   {
      Random r = new Random();

      Integer randomIndexInteger;
      int indexLimit = matchupDatabase.size();
      do
      {
         randomIndexInteger = r.nextInt(indexLimit);
      } while (indexsOfDatabase.contains(randomIndexInteger));

      return randomIndexInteger;
   }
}
