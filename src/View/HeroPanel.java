package View;

import Model.Hero;

import javax.swing.*;

public class HeroPanel
{
   private JLabel HeroNameField;
   private JLabel HeroIcon;
   private JPanel mainPanel;

   public HeroPanel(Hero hero)
   {
      String heroName = hero.toString();
      String lowerCaseHeroName = heroName.toLowerCase();
      String pathToHeroIcon = "resources/img/"+lowerCaseHeroName+"_full.png";
      ImageIcon heroIcon = new ImageIcon(pathToHeroIcon);

      HeroNameField.setText(heroName);
      HeroIcon.setIcon(heroIcon);

      //mainPanel.setBackground(new Color(45, 45, 43));
   }

   public JPanel getPanel()
   {
      return mainPanel;
   }
}
