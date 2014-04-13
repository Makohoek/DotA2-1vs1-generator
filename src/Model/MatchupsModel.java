package Model;

import Event.MatchupChangedEvent;
import View.MatchupListenerIface;
import View.MatchupView;

import javax.swing.event.EventListenerList;
import java.util.ArrayList;

public class MatchupsModel
{
   private ArrayList<Matchup> _matchups;
   private final EventListenerList _listenerList;

   public MatchupsModel()
   {
      _listenerList = new EventListenerList();
   }

   public void setMatchups(ArrayList<Matchup> matchups)
   {
      this._matchups = matchups;
      fireMatchupChanged();
   }

   public void addMatchupListener(MatchupView listener)
   {
      _listenerList.add(MatchupListenerIface.class, listener);
   }

   private void fireMatchupChanged()
   {
      MatchupListenerIface[] matchupListeners = _listenerList.getListeners(MatchupListenerIface.class);

      for (MatchupListenerIface listener : matchupListeners)
      {
         listener.matchupsChanged(new MatchupChangedEvent(this, _matchups));
      }
   }


}
