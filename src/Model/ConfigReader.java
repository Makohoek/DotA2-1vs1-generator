package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ConfigReader
{
   private FileReader fileReader = null;
   private BufferedReader bufferedReader = null;
   private String pathToConfigFile = null;


   public ConfigReader(String pathToConfigFile)
   {
      this.pathToConfigFile = pathToConfigFile;
   }

   public void openConfigFile()
   {
      try
      {
         fileReader = new FileReader(pathToConfigFile);
         bufferedReader = new BufferedReader(fileReader);
      } catch (FileNotFoundException e)
      {
         System.err.println(e.getMessage());
         System.err.println("The path to the configFile ("+pathToConfigFile+") must be invalid");
      }
   }

   public String readLine()
   {
      try
      {
         return(bufferedReader.readLine());
      } catch (IOException e)
      {
         System.err.println(e.getMessage());
         System.err.println("You must call openConfigFile() before any attempt to read the file");
         return null;
      }
   }

   public void closeConfigFile()
   {
      try
      {
         if (bufferedReader != null)
            bufferedReader.close();
         if (fileReader != null)
            fileReader.close();

      } catch (IOException ex)
      {
         ex.printStackTrace();
      }
   }
}
