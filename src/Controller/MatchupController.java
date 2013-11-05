package Controller;

import Model.Matchup;
import Model.MatchupDatabase;
import Model.MatchupsModel;
import Model.RandomMatchupPicker;
import View.MatchupView;

import java.util.ArrayList;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 19/09/13
 * Time: 16:40
 */
public class MatchupController
{
   private final MatchupView view;
   private final MatchupsModel model;
   private static final int numberOfRandomMatches = 3;
   private RandomMatchupPicker randomMatchupPicker;


   public MatchupController(MatchupsModel model)
   {
      this.model = model;

      view = new MatchupView(this);

      addListenersToModel();

      buildRandomMatchupPicker();
   }

   private void addListenersToModel()
   {
      model.addMatchupListener(view);
   }

   private void buildRandomMatchupPicker()
   {
      MatchupDatabase heroMatchupDatabase = new MatchupDatabase();
      heroMatchupDatabase.ReadFromConfigurationFile();
      randomMatchupPicker = new RandomMatchupPicker(heroMatchupDatabase);
   }

   public void notifyButtonPressed()
   {
      ArrayList<Matchup> randomMatchups = randomMatchupPicker.pickRandomMatches(numberOfRandomMatches);
      model.setMatchups(randomMatchups);
   }
}
