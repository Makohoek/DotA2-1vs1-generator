package View;

import Event.MatchupChangedEvent;

import java.util.EventListener;

public interface MatchupListenerIface extends EventListener
{
   public void matchupsChanged(MatchupChangedEvent event);
}
