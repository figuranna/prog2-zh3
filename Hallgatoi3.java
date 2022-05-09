/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hallgatoi3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author serto
 */

/*
készítsen programot, amely segítségével egy dinamikus tömbbe olvas
be számokat. Menüpontok: „adatbázis törlése”, „új adat felvitel”, „összeg kiszámítása”,
„átlagszámítás”.
*/

public class Hallgatoi3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Menü m = new Menü();
        m.menü("Last words of a Shooting Star");
        System.out.println();
    }
}
class Menü extends JFrame implements ActionListener{
    JMenuItem nevv;
    JMenuItem del;
    JMenuItem sum;
    JMenuItem avg;
    Integer[] tomb = new Integer[10];
    int i = 0;
    private final JFileChooser fc = new JFileChooser();
    
    public void menü(String cim){
        setSize(400,150);
        setTitle(cim);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar mb;
        JMenu File;
        setJMenuBar(mb=new JMenuBar());
        mb.add(File=new JMenu("Fájl"));
        mb.add(new JMenu("Súgó"));
        File.add(del = new JMenuItem("Adatbázis törlése"));
        File.addSeparator();
        File.add(nevv = new JMenuItem("Új adat felvétele"));
        File.addSeparator();
        File.add(sum = new JMenuItem("Összeg számítása"));
        File.addSeparator();
        File.add(avg = new JMenuItem("Átlagszámítás"));
        
        setVisible(true);
        
        del.addActionListener(this);
        nevv.addActionListener(this);
        sum.addActionListener(this);
        avg.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == del){
            torles();
        }
        else if(e.getSource()== nevv){
            ujAdat();
        }
        else if(e.getSource()== sum){
            osszeg();
        }
        else if(e.getSource()== avg){
            atlag();
        }
}
    void torles(){
        for(int k = 0; k<10; k++){
            tomb[k] = null;
            i = 0;
            System.out.println(tomb[k]);
            System.out.println(i);
        }
    }
    void ujAdat(){
    String data = JOptionPane.showInputDialog("Új adat felvétele");
    Integer dt = Integer.parseInt(data);
            tomb[i] = dt;
            i++;
            JOptionPane.showMessageDialog(null, "Sikeres adatfelvétel.");
    }

    void osszeg(){ 
        int tmp = 0;
        for(int j = 0; j < i; j++){
            tmp += tomb[j];
        }
       
        JOptionPane.showMessageDialog(null, "Összeg: " + tmp);

    }
    void atlag(){
        float tmp = 0, awg = 0;
        for(int j = 0; j < i; j++){
            tmp += tomb[j];
            awg = tmp / i;
        }
        JOptionPane.showMessageDialog(null, "Átlag: " + awg);
    }
}

