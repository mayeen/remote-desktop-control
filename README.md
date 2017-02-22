# remote-desktop-control
This project is made using JAVA soket programming. This program allows any computer to control other PCs remotely.  
Using the Robot class, all necessary functionality has been met. functionality of robot class is given below
mouseMove - Moves the mouse pointer to a set of specified absolute screen coordinates given in pixels
mousePress - Presses one of the buttons on the mouse
mouseRelease - Releases one of the buttons on the mouse
keyPress - Presses a specified key on the keyboard
keyRelease - Releases specified key on the keyboard
createScreenCapture - Takes a screenshot  
REMOTE SERVER:
This is the server part which waits for clients connections and per each connected client, a new frame appears showing the current client screen. When you move the mouse over the frame, this results in moving the mouse at the client side. The same happens when you right/left click mouse button or type a key while the frame is in focus.
REMOTE CLIENT:
This the client side, its core function is sending a screen shot of the client's desktop every predefined amount of time. Also it receives server commands such as "move the mouse command", then executes the command at the client's PC.  
