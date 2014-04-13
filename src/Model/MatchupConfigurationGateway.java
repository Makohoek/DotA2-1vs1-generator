package Model;

public class MatchupConfigurationGateway extends ConfigurationFileGateway
{
   public MatchupConfigurationGateway(String pathToConfigFile)
   {
      super(pathToConfigFile);
   }

   public Matchup getNextMatchup()
   {
      String radiantHeroName;
      String direHeroName;

      String matchupString = super.readLine();
      if (matchupString == null)
         return null;

      String[] heroes = matchupString.split(",");
      radiantHeroName = heroes[0];
      direHeroName = heroes[1];

      return new Matchup(new Hero(radiantHeroName), new Hero(direHeroName));
   }
}
