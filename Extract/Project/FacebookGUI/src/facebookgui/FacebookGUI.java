
package facebookgui;

/**
 *
 * @author jaswinder
 */
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class FacebookGUI extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
    
    
        new FacebookGUI();
    
    
    }
    
    public FacebookGUI(){
    
//        this.setSize(400,400);
//      this.setLocationRelativeTo(null);
//        
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        
//        Dimension dm = tk.getScreenSize();
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setTitle("facebookgui");
//        
//        JPanel thepanel = new JPanel();
//        JLabel thelable = new JLabel("Welcome to facebook gui");
//        
//        
//        
//      //  thelable.setText("new text"); // replace jlable text
//        thelable.setToolTipText("hover on text");
//        
//        JButton button = new JButton("Enter");
//        
//        JTextArea textarea = new JTextArea();
//        
//        textarea.setText("text area ");
//        textarea.setColumns(10);
//        textarea.setRows(20);
//        
//        thepanel.add(textarea);
//        thepanel.add(button);
//        thepanel.add(thelable);
//        
//        this.add(thepanel);
//        this.setVisible(true);
        
        
        
        Home home = new Home();
        home.setVisible(true);
        home.setLocationRelativeTo(null);
    } 
    
}
