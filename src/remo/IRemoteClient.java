package remo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteClient extends Remote{
	public void showName(String userName) throws RemoteException;
}
