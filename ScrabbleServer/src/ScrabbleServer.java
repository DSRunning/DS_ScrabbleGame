import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ScrabbleServer {
	
	public static void main(String[] args) {
		
		IRemoteServer remoteServer = null;
		Registry registry = null;

		try {
			
			// Register the port
			registry = LocateRegistry.createRegistry(3000);
			// registry = LocateRegistry.getRegistry();
			
			remoteServer = new RemoteServer(); 
			
	        // Register the address
	        // Naming.rebind("rmi://192.168.0.2:3000/RemoteServer", remoteScrabble);
			registry.rebind("rmi://192.168.0.2:3000/RemoteServer", remoteServer);
	        System.out.println("Server Start.");
	        
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}

}
