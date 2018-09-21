package remo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteServer extends Remote {
	public String login(IRemoteClient client, String userName) throws RemoteException;
}
