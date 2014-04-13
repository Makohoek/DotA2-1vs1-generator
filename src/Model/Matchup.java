package Model;

public class Matchup
{
   public final Hero _radiantHero;
   public final Hero _direHero;

   public Matchup(Hero radiantHero, Hero direHero)
   {
      this._radiantHero = radiantHero;
      this._direHero = direHero;
   }

   @Override
   public String toString()
   {
      return _radiantHero + " vs " + _direHero;
   }

   @Override
   public boolean equals(Object obj)
   {
      if ((obj == null) || (obj.getClass() != this.getClass()))
      {
         return false;
      }

      Matchup otherMatchup = (Matchup) obj;
      boolean equals = _radiantHero.equals(otherMatchup._radiantHero) && _direHero.equals(otherMatchup._direHero);
      boolean invertedEquals = _radiantHero.equals(otherMatchup._direHero) && _direHero.equals(otherMatchup._radiantHero);

      return equals || invertedEquals;
   }
}
