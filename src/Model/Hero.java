package Model;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 18/09/13
 * Time: 19:04
 */
public class Hero
{
   private final String name;

   public Hero(String heroName)
   {
      HeroDatabase heroDatabase = new HeroDatabase();
      if (heroDatabase.contains(heroName))
         name = heroName;
      else
         name = "Invalid Model.Hero";
   }

   @Override
   public String toString()
   {
      return name;
   }

   @Override
   public boolean equals(Object obj)
   {
      if ((obj == null) || (obj.getClass() != this.getClass()))
      {
         return false;
      }
      Hero other = (Hero) obj;

      return name.compareTo(other.name) == 0;
   }
}
