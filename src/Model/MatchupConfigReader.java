package Model;

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
