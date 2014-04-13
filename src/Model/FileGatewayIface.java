package Model;

public interface FileGatewayIface
{
   public void open();
   public String readLine();
   public boolean isFinished();
   public void close();
}
