
import java.rmi.Remote;
import java.util.ArrayList;

public interface IRemoteClient extends Remote {

	void updateGameBoard(char[][] gameBoard);

	void updatePlayerList(ArrayList<String> playerList);

	void updateStatus(String state);

	// void showUserName(String userame);

	void showInvitation();

	String showVote(String word);

	void showWin();

}
