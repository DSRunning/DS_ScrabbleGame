package remo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteClientImpl extends UnicastRemoteObject implements IRemoteClient {

	private static final long serialVersionUID = -7678315360549642977L;

	protected RemoteClientImpl() throws RemoteException {
	}

	@Override
	public void showName(String userName) throws RemoteException {
		System.out.println("New player: " + userName);
	}

}
