package Event;

import Model.Matchup;

import java.util.ArrayList;
import java.util.EventObject;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 19/09/13
 * Time: 14:08
 */
public class MatchupChangedEvent extends EventObject
{
   public final ArrayList<Matchup> newMatchups;

   public MatchupChangedEvent(Object source, ArrayList<Matchup> newMatchups)
   {
      super(source);
      this.newMatchups = newMatchups;
   }


}
