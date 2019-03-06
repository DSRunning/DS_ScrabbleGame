
import java.rmi.Remote;

public interface IRemoteServer extends Remote {

	String login(String username, IRemoteClient client);

	boolean startGame(IRemoteClient client);

	boolean joinGame(IRemoteClient client);

	void nextTurn(String word, IRemoteClient client);
	
	String vote(IRemoteClient client);

	void exitGame(String username, IRemoteClient client);

}