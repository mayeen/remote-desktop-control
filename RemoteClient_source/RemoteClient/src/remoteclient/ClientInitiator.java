
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package remoteclient;
/**
 *
 * @author Mayeen
 */

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


 
 // This class is responsible for connecting to the server
 //and starting ScreenSpyer and ServerDelegate classes
 
public class ClientInitiator {

    Socket socket = null;

    public static void main(String[] args){
        String ip = JOptionPane.showInputDialog("Please enter server IP");  //for the pop up box at first
        String port = JOptionPane.showInputDialog("Please enter server port"); //same as above
        new ClientInitiator().initialize(ip, Integer.parseInt(port));
    }

    public void initialize(String ip, int port ){

        Robot robot = null; //Used to capture the screen
        Rectangle rectangle = null; //Used to represent screen dimensions

        try {
            System.out.println("Connecting to server ..........");
            socket = new Socket(ip, port);
            System.out.println("Connection Established.");

            //Get default screen device
            GraphicsEnvironment gEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gDev=gEnv.getDefaultScreenDevice();  //you will need the graphics environment for graphics device

            //Get screen dimensions
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();  //taking the screensize
            rectangle = new Rectangle(dim); //formating it in rectangle formate 

            //Prepare Robot object
            robot = new Robot(gDev);

            //draw client gui
            drawGUI();
            //ScreenSpyer sends screenshots of the client screen
            new ScreenSpyer(socket,robot,rectangle);
            //ServerDelegate recieves server commands and execute them
            new ServerDelegate(socket,robot);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (AWTException ex) {
                ex.printStackTrace();
        }
    }

    private void drawGUI() {
        JFrame frame = new JFrame("Remote Admin");          //terminate frame on the client side. can stop the application
        JButton button= new JButton("Terminate");       //from the client side
        
        frame.setBounds(100,100,150,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        button.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
      );
      frame.setVisible(true);
    }
}
