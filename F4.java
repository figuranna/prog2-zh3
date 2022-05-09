/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package f4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/*
Egy keretben jelenítsen meg két szövegmezőt, amelyekbe billentyűzetről megadhatunk számokat.
Készítsünk olyan menüt, amely segítségével összeadjuk, kivonjuk, összeszorozzuk és elosztjuk a
beírt számokat. Az eredményt a „label”-be írjuk ki.
*/  

public class F4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menü m = new Menü();
        m.menü("4. feladat");
    }
}
class Menü extends JFrame implements ActionListener{
    JMenuItem sum;
    JMenuItem min;
    JMenuItem mult;
    JMenuItem div;
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
        File.add(sum = new JMenuItem("Összeadás"));
        File.addSeparator();
        File.add(min = new JMenuItem("Kivonás"));
        File.addSeparator();
        File.add(mult = new JMenuItem("Szorzás"));
        File.addSeparator();
        File.add(div = new JMenuItem("Osztás"));
        
        setVisible(true);
        sum.addActionListener(this);
        min.addActionListener(this);
        mult.addActionListener(this);
        div.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        String a = text.getText();
        String b = text2.getText();
        int ossz, kiv, szor;
        float oszt;
        if (e.getSource() == sum){
            ossz = Integer.parseInt(a) + Integer.parseInt(b);
            
            label.setText("Összeadva: " + ossz);
            //System.out.println(ossz);
        }
        else if(e.getSource()==min){
            kiv = Integer.parseInt(a) - Integer.parseInt(b);
            
            label.setText("Kivonva: " + kiv);
            //System.out.println(kiv);
        }
        else if(e.getSource()==mult){
            szor = Integer.parseInt(a) * Integer.parseInt(b);
            
            label.setText("Szorozva: " + szor);
            //System.out.println(szor);
        }
        else if(e.getSource()==div){
            float c = Integer.parseInt(a);
            float d = Integer.parseInt(b);
            if(c > d){
                oszt = c / d;
                
                label.setText("Osztva: " + oszt);
                //System.out.println(oszt);
            }
            else{
                oszt = d / c;
                
                label.setText("Összeadva: " + oszt);
                //System.out.println(oszt);
            }
            /*oszt = Integer.parseInt(a) / Integer.parseInt(b);
            System.out.println(oszt);*/
        }
}
}   

