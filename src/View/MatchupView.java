package View;

import Controller.MatchupController;
import Model.Matchup;
import Event.MatchupChangedEvent;
import Model.MatchupsModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 19/09/13
 * Time: 14:21
 */
public class MatchupView implements MatchupListenerIface
{
   private final JFrame frame;
   private final MatchupGeneratorPanel matchupGeneratorPanel;

   public MatchupView(MatchupController matchupController)
   {
      frame = new JFrame("Dota2 1vs1 generator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      matchupGeneratorPanel = new MatchupGeneratorPanel(matchupController);

      frame.getContentPane().add(matchupGeneratorPanel.getMainPanel());

      frame.pack();
      frame.setVisible(true);
   }

   @Override
   public void matchupsChanged(MatchupChangedEvent event)
   {
      ArrayList<Matchup> newMatchups = event.newMatchups;

      for (Matchup newMatchup : newMatchups)
      {
         System.out.println(newMatchup);
         matchupGeneratorPanel.addMatchup(newMatchup);
      }

      frame.pack();
      frame.setBounds(frame.getBounds());
   }
}
