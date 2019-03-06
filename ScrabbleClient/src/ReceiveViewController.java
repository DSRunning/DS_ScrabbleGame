
import java.util.ArrayList;

public class ReceiveViewController implements IRemoteClient {
	
	GameBoard gameBoard;
	
	public ReceiveViewController() {
		gameBoard = new GameBoard();
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
	public void updateStatus(String state) {
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
