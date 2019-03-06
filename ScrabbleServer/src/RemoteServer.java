import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteServer extends UnicastRemoteObject implements IRemoteServer {
	
	private boolean gameState;
	private List<Player> playerList = new ArrayList<Player>();
	private List<Player> waitplayerList = new ArrayList<Player>();
	private char[][] gameBoard;
	private int voteCount;

	protected RemoteServer() throws RemoteException {
		
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String login(String username, IRemoteClient client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean startGame(IRemoteClient client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean joinGame(IRemoteClient client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void nextTurn(String word, IRemoteClient client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitGame(String username, IRemoteClient client) {
		// TODO Auto-generated method stub

	}

	@Override
	public String vote(IRemoteClient client) {
		// TODO Auto-generated method stub
		return null;
	}

}
