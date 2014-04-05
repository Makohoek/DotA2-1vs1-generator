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
   private JButton GenerateButton;
   private JPanel mainPanel;
   private JPanel HeroesPanel;
   private JScrollPane scrollPane;
   private final ArrayList<JPanel> addedHeroesList;
   private final MatchupController controller;

   public MatchupGeneratorPanel(MatchupController controller)
   {
      //mainPanel.setBackground(new Color(45, 45, 43));
      HeroesPanel.setLayout(new GridLayout(0, 2));
      addedHeroesList = new ArrayList<JPanel>();

      AddEventsToButtons();
      this.controller = controller;
   }

   public JPanel getMainPanel()
   {
      return mainPanel;
   }

   private void AddEventsToButtons()
   {
      GenerateButton.addActionListener(new ActionListener()
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
      for (JPanel addedHeroPanel : addedHeroesList)
         HeroesPanel.remove(addedHeroPanel);

      addedHeroesList.clear();

      controller.notifyButtonPressed();
   }

   public void addMatchup(Matchup matchup)
   {
      JPanel radiantHeroPanel = new HeroPanel(matchup.radiant).getPanel();
      JPanel direHeroPanel = new HeroPanel(matchup.dire).getPanel();

      HeroesPanel.add(radiantHeroPanel);
      HeroesPanel.add(direHeroPanel);

      addedHeroesList.add(radiantHeroPanel);
      addedHeroesList.add(direHeroPanel);
   }

}
