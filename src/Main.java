import Controller.MatchupController;
import Model.MatchupsModel;
import View.MatchupView;

/**
 * Mattijs Korpershoek
 * <mattijs.korpershoek@gmail.com>
 * Date: 18/09/13
 * Time: 19:05
 */
public class Main
{
   public static void main(String args[])
   {
      MatchupsModel model = new MatchupsModel();
      MatchupController controller = new MatchupController(model);
   }

}
