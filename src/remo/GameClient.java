package remo;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GameClient {

	public static void main(String[] args) {
		try {
			Context namingContext = new InitialContext();
			IRemoteServer rmObj = (IRemoteServer) namingContext.lookup("rmi://localhost:8888/RMObj");
			IRemoteClient mytClient = new RemoteClientImpl();
			System.out.println(rmObj.login(mytClient, args[0]));
			System.out.println("others");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
