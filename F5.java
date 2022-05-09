/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package f5;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/*
 Egy keretben jelenítsen meg két szövegmezőt, a billentyűzetről írjon beléjük tetszőleges számokat.
Menü segítségével hasonlítsa össze a két számot (kisebb, nagyobb, egyenlő menüpontok). A
választott menüpontnak megfelelő eredményt egy Message box-ban, szövegesen írja ki.
 */
public class F5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menü m = new Menü();
        m.menü("5. feladat");
    }
}
class Menü extends JFrame implements ActionListener{
    JMenuItem nagy;
    JMenuItem kis;
    JMenuItem egynl;
    JTextField text = new JTextField(10);
    JTextField text2 = new JTextField(10);
    JLabel label = new JLabel("");
    //JButton button = new JButton("Ok");
    
    private final JFileChooser fc = new JFileChooser();
    
    public void menü(String cim){
        setSize(400,150);
        setTitle(cim);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar mb;
        JMenu File;
        setJMenuBar(mb=new JMenuBar());
        setLayout(new FlowLayout());
        add(text);
        add(text2);
        add(label);
        //add(button);
        mb.add(File=new JMenu("Műveletek"));
        File.add(nagy = new JMenuItem("Nagyobb"));
        File.addSeparator();
        File.add(kis = new JMenuItem("Kisebb"));
        File.addSeparator();
        File.add(egynl = new JMenuItem("Egyenlő"));
        
        setVisible(true);
        nagy.addActionListener(this);
        kis.addActionListener(this);
        egynl.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        String a = text.getText();
        String b = text2.getText();
        if (e.getSource() == nagy){
            
            if(Integer.parseInt(a) > Integer.parseInt(b)){
                JOptionPane.showMessageDialog(null, a + " nagyobb, mint " + b + ".");
            }
            else{
                JOptionPane.showMessageDialog(null, b + " nagyobb, mint " + a + ".");
                //label.setText(b + " nagyobb, mint " + a + ".");
            }
        }
        else if(e.getSource()==kis){
            
            if(Integer.parseInt(a) < Integer.parseInt(b)){
                
                JOptionPane.showMessageDialog(null, a + " kisebb, mint " + b + ".");
                //label.setText(a + " kisebb, mint " + b + ".");
            }
            else{
                JOptionPane.showMessageDialog(null, b + " kisebb, mint " + a + ".");
                //label.setText(b + " kisebb, mint " + a + ".");
            }
        }
        else if(e.getSource()==egynl){
            
            if(Integer.parseInt(a) == Integer.parseInt(b)){
                JOptionPane.showMessageDialog(null, a + " egyenlő " + b + "-s számmal.");
                //label.setText(a + " egyenlő " + b + "-s számmal.");
            }
            else{
                JOptionPane.showMessageDialog(null, a + " nem egyenlő " + b + "-s számmal.");
                //label.setText(a + " nem egyenlő " + b + "-s számmal.");
            }
        }
}
}   