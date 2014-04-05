package Model;

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
