package Model;

import java.util.ArrayList;
import java.util.Random;

public class RandomMatchupPicker
{
   private final MatchupDatabase _matchupDatabase;

   public RandomMatchupPicker(MatchupDatabase heroMatchupDatabase)
   {
      this._matchupDatabase = heroMatchupDatabase;
   }

   public ArrayList<Matchup> pickRandomMatches(int numberOfRandomMatches)
   {
      assert (numberOfRandomMatches > 0);
      assert (numberOfRandomMatches <= _matchupDatabase.size());

      ArrayList<Integer> randomIndexes = new ArrayList<Integer>();
      for (int i = 0; i < numberOfRandomMatches; i++)
      {
         Integer randomIndex = getUnusedMatchupIndex(randomIndexes);
         randomIndexes.add(randomIndex);
      }

      ArrayList<Matchup> randomMatches = new ArrayList<Matchup>();
      for (Integer index : randomIndexes)
      {
         Matchup selectedMatchup = _matchupDatabase.get(index);
         randomMatches.add(selectedMatchup);
      }

      return randomMatches;
   }

   private Integer getUnusedMatchupIndex(ArrayList<Integer> indexsOfDatabase)
   {
      Random r = new Random();

      Integer randomIndexInteger;
      int indexLimit = _matchupDatabase.size();
      do
      {
         randomIndexInteger = r.nextInt(indexLimit);
      } while (indexsOfDatabase.contains(randomIndexInteger));

      return randomIndexInteger;
   }
}
