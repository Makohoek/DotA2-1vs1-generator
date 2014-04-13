package View;

import javax.swing.*;
import java.awt.*;

public class StyleSetter
{
   public static void setBackground(JPanel panel)
   {
      panel.setBackground(new Color(45, 45, 43));

   }
   public static void setFont(JLabel label)
   {
      label.setFont(new Font("Georgia", Font.BOLD, 20));
      label.setForeground(new Color(156, 54, 39));
   }
   public static void setButton(JButton button)
   {
      button.setFont(new Font("Georgia", Font.BOLD, 14));
      button.setForeground(new Color(156, 54, 39));
   }
}
