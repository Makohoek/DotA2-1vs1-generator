package View;

import Controller.MatchupController;
import Model.Matchup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MatchupGeneratorPanel
{
   private JButton _generateButton;
   private JPanel _mainPanel;
   private JPanel _heroesPanel;
   @SuppressWarnings("Unused") // scrollpane is necessary when adding a large amount of random matchups
   private JScrollPane _scrollPane;
   private final ArrayList<JPanel> _addedHeroesList;
   private final MatchupController _controller;

   public MatchupGeneratorPanel(MatchupController controller)
   {
      _heroesPanel.setLayout(new GridLayout(0, 2));
      _addedHeroesList = new ArrayList<JPanel>();

      AddEventsToButtons();
      this._controller = controller;

      setStyle();
   }

   private void setStyle()
   {
      StyleSetter.setBackground(_mainPanel);
      StyleSetter.setBackground(_heroesPanel);
      StyleSetter.setButton(_generateButton);
   }

   public JPanel getMainPanel()
   {
      return _mainPanel;
   }

   private void AddEventsToButtons()
   {
      _generateButton.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent actionEvent)
         {
            buttonExecuted();
         }
      });
   }

   void buttonExecuted()
   {
      for (JPanel addedHeroPanel : _addedHeroesList)
         _heroesPanel.remove(addedHeroPanel);

      _addedHeroesList.clear();

      _controller.notifyButtonPressed();
   }

   public void addMatchup(Matchup matchup)
   {
      JPanel radiantHeroPanel = new HeroPanel(matchup._radiantHero).getPanel();
      JPanel direHeroPanel = new HeroPanel(matchup._direHero).getPanel();

      _heroesPanel.add(radiantHeroPanel);
      _heroesPanel.add(direHeroPanel);

      _addedHeroesList.add(radiantHeroPanel);
      _addedHeroesList.add(direHeroPanel);
   }

}
