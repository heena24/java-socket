import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author Heena Hussain
 *
 */
public class Server
{
	public static void main(String[] args)
	{
		/*
			Creates a server socket, bound to the specified port
		 */
		try (ServerSocket serverSocket = new ServerSocket(8001)) //try with resource
		{
			/*
				Listens for a connection to be made to this socket and accepts it.
				The method blocks until a connection is made.
			 */
			Socket socket = serverSocket.accept();
			System.out.println("Connected to client");

			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); //incoming stream

			while(true)
			{
				String output = dataInputStream.readUTF();
				System.out.println("SERVER: " + output);

				if("exit".equals(output.toLowerCase())) break;
			}

		} catch (IOException ex)
		{
			System.out.println("Exception while getting data from client: " + ex.getMessage());
		}
//		finally
//		{
//			close server socket connection - if try with resource is not used
//		}
	}
}
