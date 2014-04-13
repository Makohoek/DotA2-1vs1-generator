package Controller;

import Model.*;
import View.MatchupView;

import java.util.ArrayList;

public class MatchupController
{
   private final MatchupView _view;
   private final MatchupsModel _model;
   private static final int _numberOfRandomMatches = 3;
   private RandomMatchupPicker _randomMatchupPicker;


   public MatchupController(MatchupsModel model)
   {
      this._model = model;
      _view = new MatchupView(this);
      addListenersToModel();
      buildRandomMatchupPicker();
   }

   private void addListenersToModel()
   {
      _model.addMatchupListener(_view);
   }

   private void buildRandomMatchupPicker()
   {
      HeroDatabase heroDatabase = new HeroDatabase();
      heroDatabase.addHeroesFromGateway(new HeroConfigurationGateway("config/HeroDatabase.txt"));
      MatchupDatabase matchupDatabase = new MatchupDatabase(heroDatabase);
      matchupDatabase.AddMatchupsFromGateway(new MatchupConfigurationGateway("config/MatchupDatabase.txt"));
      _randomMatchupPicker = new RandomMatchupPicker(matchupDatabase);
   }

   public void notifyButtonPressed()
   {
      ArrayList<Matchup> randomMatchups = _randomMatchupPicker.pickRandomMatches(_numberOfRandomMatches);
      _model.setMatchups(randomMatchups);
   }
}
