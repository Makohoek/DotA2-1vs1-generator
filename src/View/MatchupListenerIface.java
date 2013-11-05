package View;

import Event.MatchupChangedEvent;

import java.util.EventListener;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 19/09/13
 * Time: 14:35
 */
public interface MatchupListenerIface extends EventListener
{
   public void matchupsChanged(MatchupChangedEvent event);
}
