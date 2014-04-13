package Event;

import Model.Matchup;

import java.util.ArrayList;
import java.util.EventObject;

public class MatchupChangedEvent extends EventObject
{
   public final ArrayList<Matchup> _newMatchups;

   public MatchupChangedEvent(Object source, ArrayList<Matchup> newMatchups)
   {
      super(source);
      this._newMatchups = newMatchups;
   }


}
