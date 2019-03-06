import java.io.Serializable;
import java.util.ArrayList;

public class RemoteClient implements Serializable, IRemoteClient {
	
	private static RemoteClient client = null;
	
	private RemoteClient() {
		
	}
	
	public static RemoteClient getInstance() {
		if(client == null)
			return new RemoteClient();
		else return client;
	}

	@Override
	public void updateGameBoard(char[][] gameBoard) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePlayerList(ArrayList<String> playerList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStatus(String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showInvitation() {
		// TODO Auto-generated method stub

	}

	@Override
	public String showVote(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showWin() {
		// TODO Auto-generated method stub

	}

}
