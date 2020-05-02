import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * @author Heena Hussain
 *
 */
public class Client
{
	public static void main(String[] args)
	{
		/*
			Creates a stream socket and connects it to the specified port number on the named host.
		 */
		try (Socket clientSocket = new Socket("localhost", 8001)) //try with resource
		{
			DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream()); //outgoing

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				String input = bufferedReader.readLine();
				dataOutputStream.writeUTF(input);

				if("exit".equals(input.toLowerCase())) break;
			}
		} catch (IOException ex)
		{
			System.out.println("Exception while sending data to Server: " + ex.getMessage());
		}
//		finally
//		{
//			close client socket connection  - if try with resource is not used
//		}
	}
}
