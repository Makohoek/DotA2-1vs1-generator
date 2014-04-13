package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

abstract class ConfigurationFileGateway implements FileGatewayIface
{
   private FileReader _fileReader = null;
   private BufferedReader _bufferedReader = null;
   private String _pathToConfigFile = null;

   public ConfigurationFileGateway(String pathToConfigFile)
   {
      _pathToConfigFile = pathToConfigFile;
   }

   public void open()
   {
      try
      {
         _fileReader = new FileReader(_pathToConfigFile);
         _bufferedReader = new BufferedReader(_fileReader);
      } catch (FileNotFoundException e)
      {
         System.err.println(e.getMessage());
         System.err.println("The path to the configFile (" + _pathToConfigFile + ") must be invalid");
      }
   }

   public String readLine()
   {
      try
      {
         return (_bufferedReader.readLine());
      } catch (IOException e)
      {
         System.err.println(e.getMessage());
         System.err.println("You must call open() before any attempt to read the file");
         return null;
      }
   }

   public boolean isFinished()
   {
      try
      {
         int readAheadLimit = 128;
         _bufferedReader.mark(readAheadLimit);
         if (_bufferedReader.readLine() == null)
         {
            return true;
         }
         _bufferedReader.reset();
         return false;

      } catch (IOException e)
      {
         System.err.println(e.getMessage());
         return true;
      }
   }

   public void close()
   {
      try
      {
         if (_bufferedReader != null)
            _bufferedReader.close();
         if (_fileReader != null)
            _fileReader.close();

      } catch (IOException ex)
      {
         ex.printStackTrace();
      }
   }
}
