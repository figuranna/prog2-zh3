/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hallgatoi1;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author serto
 */

/*
Pull down menü segítségével adjon meg színeket, amellyel egy keret
háttérszínét a menüben megadott színekre változtatja. Legalább 5 szín közül lehessen
választani.
*/

public class Hallgatoi1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Menü m = new Menü();
        m.menü("Your Best American Girl");
    }
}
class Menü extends JFrame implements ActionListener{
    JMenuItem exit;
    JMenuItem open;
    JMenuItem help;
    JMenuItem red, yellow, green, blue, pink;
    private final JFileChooser fc = new JFileChooser();
    
    public void menü(String cim){
        setSize(400,150);
        setTitle(cim);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar mb;
        JMenu File, Color, Help;
        
        setJMenuBar(mb=new JMenuBar());
        mb.add(File=new JMenu("File"));
        mb.add(Color=new JMenu("Color"));
        mb.add(Help = new JMenu("Help"));
        
        File.add(open = new JMenuItem("Open"));
        File.addSeparator();
        File.add(exit = new JMenuItem("Exit"));
        
        Color.add(red = new JMenuItem("Red"));
        Color.addSeparator();
        Color.add(yellow = new JMenuItem("Yellow"));
        Color.addSeparator();
        Color.add(green = new JMenuItem("Green"));
        Color.addSeparator();
        Color.add(blue = new JMenuItem("Blue"));
        Color.addSeparator();
        Color.add(pink = new JMenuItem("Pink"));
        
        Help.add(help = new JMenuItem("Help"));
        
        setVisible(true);
        open.addActionListener(this);
        exit.addActionListener(this);
        
        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        pink.addActionListener(this);
        help.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open){
            fc.showOpenDialog(this);
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }
        
        if (e.getSource() == red){
            this.getContentPane().setBackground(Color.RED); 
        }
        else if(e.getSource()==yellow){
            this.getContentPane().setBackground(Color.YELLOW); 
        }
        else if(e.getSource()==green){
            this.getContentPane().setBackground(Color.GREEN); 
        }
        else if(e.getSource()==blue){
            this.getContentPane().setBackground(Color.BLUE); 
        }
        else if(e.getSource()==pink){
            this.getContentPane().setBackground(Color.PINK); 
        }
        
        if (e.getSource() == help){
            try {
             String  urlString = "https://www.youtube.com/watch?v=u_hDHm9MD0I";
                try {
                    Desktop.getDesktop().browse(new URL(urlString).toURI());
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Menü.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }
}
}
