import java.rmi.Naming;

public class ScrabbleClient {

	private static IRemoteServer remoteServer;

	public static void main(String[] args) {

		try {

			IRemoteClient remoteclient = new ReceiveViewController();
			IRemoteClient client = RemoteClient.getInstance();
			remoteServer = (IRemoteServer) Naming.lookup("rmi://192.168.0.2:3000/RemoteServer");

			System.out.println("Connection Successful.");


		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
