package View;

import Controller.MatchupController;
import Event.MatchupChangedEvent;
import Model.Matchup;

import javax.swing.*;
import java.util.ArrayList;

public class MatchupView implements MatchupListenerIface
{
   private final JFrame _frame;
   private final MatchupGeneratorPanel _matchupGeneratorPanel;

   public MatchupView(MatchupController matchupController)
   {
      _frame = new JFrame("DotaDuel");
      _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      _matchupGeneratorPanel = new MatchupGeneratorPanel(matchupController);

      _frame.getContentPane().add(_matchupGeneratorPanel.getMainPanel());

      _frame.pack();
      _frame.setVisible(true);
   }

   @Override
   public void matchupsChanged(MatchupChangedEvent event)
   {
      ArrayList<Matchup> newMatchups = event._newMatchups;

      for (Matchup newMatchup : newMatchups)
      {
         System.out.println(newMatchup);
         _matchupGeneratorPanel.addMatchup(newMatchup);
      }

      _frame.pack();
      _frame.setBounds(_frame.getBounds());
   }
}
