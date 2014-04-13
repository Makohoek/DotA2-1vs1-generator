package View;

import Model.Hero;

import javax.swing.*;

public class HeroPanel
{
   private JLabel _heroNameField;
   private JLabel _heroIcon;
   private JPanel _mainPanel;

   public HeroPanel(Hero hero)
   {
      String heroName = hero.toString();
      String lowerCaseHeroName = heroName.toLowerCase();
      String pathToHeroIcon = "resources/img/"+lowerCaseHeroName+"_full.png";
      ImageIcon heroIcon = new ImageIcon(pathToHeroIcon);

      _heroNameField.setText(heroName);
      _heroIcon.setIcon(heroIcon);

      setStyle();
   }

   private void setStyle()
   {
      StyleSetter.setBackground(_mainPanel);
      StyleSetter.setFont(_heroNameField);
   }

   public JPanel getPanel()
   {
      return _mainPanel;
   }
}
