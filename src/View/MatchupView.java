package View;

import Controller.MatchupController;
import Event.MatchupChangedEvent;
import Model.Matchup;

import javax.swing.*;
import java.util.ArrayList;

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
