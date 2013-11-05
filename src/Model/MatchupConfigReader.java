package Model;

import java.io.IOException;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 30/09/13
 * Time: 17:42
 */
public class MatchupConfigReader extends ConfigReader
{
   private String radiantHeroName;
   private String direHeroName;

   public MatchupConfigReader(String pathToConfigFile)
   {
      super(pathToConfigFile);
   }

   @Override
   public String readLine()
   {
      String matchupString = super.readLine();
      if (matchupString == null)
         return null;

      String[] heroes = matchupString.split(",");
      radiantHeroName = heroes[0];
      direHeroName = heroes[1];
      return matchupString;
   }

   public String getCurrentRadiantHeroName()
   {
      return radiantHeroName;
   }

   public String getCurrentDireHeroName()
   {
      return direHeroName;
   }
}
