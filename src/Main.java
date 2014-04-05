import Controller.MatchupController;
import Model.MatchupsModel;

public class Main
{
   public static void main(String args[])
   {
      MatchupsModel model = new MatchupsModel();
      MatchupController controller = new MatchupController(model);
   }

}
