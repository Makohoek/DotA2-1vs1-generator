package Event;

import Model.Matchup;

import java.util.ArrayList;
import java.util.EventObject;

public class MatchupChangedEvent extends EventObject
{
   public final ArrayList<Matchup> newMatchups;

   public MatchupChangedEvent(Object source, ArrayList<Matchup> newMatchups)
   {
      super(source);
      this.newMatchups = newMatchups;
   }


}
