package Model;

import Event.MatchupChangedEvent;
import View.MatchupListenerIface;
import View.MatchupView;

import javax.swing.event.EventListenerList;
import java.util.ArrayList;

public class MatchupsModel
{
   private ArrayList<Matchup> matchups;
   private final EventListenerList listenerList;

   public MatchupsModel()
   {
      listenerList = new EventListenerList();
   }

   public void setMatchups(ArrayList<Matchup> matchups)
   {
      this.matchups = matchups;
      fireMatchupChanged();
   }

   public void addMatchupListener(MatchupView listener)
   {
      listenerList.add(MatchupListenerIface.class, listener);
   }

   private void fireMatchupChanged()
   {
      MatchupListenerIface[] matchupListeners = listenerList.getListeners(MatchupListenerIface.class);

      for (MatchupListenerIface listener : matchupListeners)
      {
         listener.matchupsChanged(new MatchupChangedEvent(this, matchups));
      }
   }




}
