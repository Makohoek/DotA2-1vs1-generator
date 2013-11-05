package Model;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 18/09/13
 * Time: 19:04
 */
public class Matchup
{
   public final Hero radiant;
   public final Hero dire;

   public Matchup(Hero radiant, Hero dire)
   {
      this.radiant = radiant;
      this.dire = dire;
   }

   @Override
   public String toString()
   {
      return radiant+" vs "+dire;
   }

   @Override
   public boolean equals(Object obj)
   {
      if ((obj == null) || (obj.getClass() != this.getClass()))
      {
         return false;
      }

      Matchup otherMatchup = (Matchup)obj;

      return radiant.equals(otherMatchup.radiant) && dire.equals(otherMatchup.dire);
   }
}
