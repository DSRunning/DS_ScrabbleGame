# HappyProgramming
The second assignment of Distributed System in UM.




COMP90015 Distributed Systems
Assignment 2
Distributed Scrabble Game 




Team: Running
Fan Yang, Haoying Zhu, Xian Dong, Xinhao Zhang
Tutor: Alisha Aneja
 
1.	Introduction
This assignment is aiming for build a distributed scrabble game system. The game should happen on a 20x20 grid with multiple players, every player will take turns to place a character in the grid, the player will get marks when the characters aligned as a word.
This system should have basic functions as follows:
	A GUI for gameboard in every client.
	Reliable connection and communication between game server and clients.
	Players login, start game, invite other players, join game and exit game.
	Voting system when a player highlights a word for getting marks.
The system should have a good consistency, all game status ought to be synchronized in all clients at all time. Also, the design should also consider all the possible exceptions and deal with every situation.

2.	Game Architecture
The game is based on a client-server system. 
In the server side, a port number can be input to bind an RMI connection so that the client can connect to the server though this port. Besides, when clients connect to server, a table containing clients’ user name and state is shown, and a console part will display the operations of clients.
As for the function of server, clients should be able to start a game, join a game started by others and exit game. They are all implemented by invoking remote RMI methods. When a client invoke a startgame() method, the sever will check the status of the game; if the game has already been started by others, the client will receive “false” to indicate the situation. If the game has not been started, this client will be removed from the waiting player list and inserted into the player list. Meanwhile, the other players in the waiting player list will receive an invitation message after server call the remote RMI method of client. Then, these clients can choose whether join the game or not, and their selection will be sent to server. After all the clients, except those who exit in this stage, in waiting player list answer, the game starts with clients who say “Yes” and the inviter.
The function of voting is quite similar to starting game. When clients want to gain score, they should firstly notify server. Then server call the method in remote RMI to show the voting message to others. If all the clients approve that the word can be passed, the current player will get the score; otherwise, an unapproved message will be shown on the UI. All the communications above are implemented by RMI and the message is in a String form which can be read in both client and server side.
Finally, clients can exit the game in all time. If they exit before the game is started by others, the server removes it from waiting player list and notifies others. If they exit during the invitation stage, the server does the same thing above as well as the decrement of total invitation number of players so that the server would not be stuck. If players exit during the gaming stage — playing or voting — the game will be ended immediately, and all the clients will receive the result of the game. After that, all clients will exit the game. However, if the Spectators exit, the game would not be ended, and they just leave, and the server will update their user information and send it to other clients.
 
3.	Protocols and Messaging
The communication model which is implemented in the distributed scrabble game system is the Remote Method Invocation (RMI). For the server side, it creates a registry with the defined IP address and port number. Consequently, it binds the remote object (Scrabble Server Class in this system) with the registry. On the other hand, the client side uses port number and IP address to search the registry and acquires the remote object proxy. The exchange protocol between the client and the server is the request-reply protocol. Every time the client applies the proxy to request some results, the server will reply them and send a return value each time. In this game system, the server does not only reply the client who sends the request, it will return the values to all the connected clients, because during the game, all the players should be synchronised. The game board, player list, player score, vote message and winner message will be presented to all players and the invitation message will be shown to all users who login the system. 
4.	Class Design
To achieve the communication between each other, there are two interfaces in both the client and the server. 
	The IRemoteClient interface is implemented in the client, and it was also used in the server to invoke remote object of client to broadcast the game status.
	The IRemoteServer is the interface implemented in the server, and client needs to remotely invoke the methods in server by using this interface. The function of this interface is to achieve action such as join game or start a vote, etc.
For the server, The RemoteServer is implemented IRemoteServer and deal with all the incoming transmission, marking, and voting for the game.
Also, we designed a GUI (The MainWindow class) for the server, which can display the player list and their status.
The UpdateTableThread is created for handling update the player information in the GUI for multiple clients at the same time.
 
The client used Model-View-Controller architecture.
	The ReceiveViewController which implemented IRemoteClient is the controller to receive messages from the server and proceed them to the UI. 
	The ClientWindow is the UI that players will interact with, it contains the 20*20 grid for the game, a player list to display the realtime status, and multiple buttons for voting or different functions. And this class is also working as the View in this structure.
	The SendOperationController is the class that invoke the remote server object and sending information the server. When player wants to play/quit a game or start a vote when they want to get the marks, different methods in this class will be used.
 
5.	Critical Analysis
Pros:
5.1.1.	Broadcast design is adopted for update all client GUI. Once a client made a move, the server will broadcast the action to all clients. This design ensures the synchronization between all clients without frequently requesting the server.
5.1.2.	The MVC architecture in client has low coupling feature, easy to implement and modify the functions of the GUI.
Cons:
5.2.1.	The multithread design in server needs to handle multiple clients, but the system memory has its limit. If many clients play the game for a long time and keep sending messages to the server, the server will reach it’s limit eventually.
5.2.2.	The UI of clients are good but not quite attractive.
5.2.3.	The scalability cannot be controlled by programmer due to usage of RMI, which may lead to delay when the game is processing.
6.	Contributions
	Fan Yang: 
  Server GUI
 	Server backend include start and exit game, invite player
 	System integration
	Haoying Zhu: 
  Client GUI
 	Client backend Model-View-Controller implementation
 	System integration
	Xian Dong: 
 	Sever backend include handling player login, next turn and voting system
 	Report writing and UML drawing
	Xinhao Zhang: 
 Client-Server communication and messaging, RMI implementation
 	Report writing
