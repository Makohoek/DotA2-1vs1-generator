package Model;

public class HeroConfigurationGateway extends ConfigurationFileGateway
{
   public HeroConfigurationGateway(String pathToConfigFile)
   {
      super(pathToConfigFile);
   }

   public Hero nextHero()
   {
      String heroName = super.readLine();
      return new Hero(heroName);
   }
}
