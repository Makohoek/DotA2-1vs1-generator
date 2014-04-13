package Model;

public class Hero
{
   protected final String _name;

   public Hero(String heroName)
   {
      _name = heroName;
   }

   @Override
   public String toString()
   {
      return _name;
   }

   @Override
   public boolean equals(Object obj)
   {
      if ((obj == null) || (obj.getClass() != this.getClass()))
      {
         return false;
      }
      Hero other = (Hero) obj;

      return _name.compareTo(other._name) == 0;
   }
}
