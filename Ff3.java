/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ff3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JColorChooser;
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
public class Ff3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menü m = new Menü();
        m.menü();

    }
}
class Menü extends JFrame implements ActionListener{
    JMenuItem tegla;
    JMenuItem kor;
    JMenuItem vonal;
    int a,b,c,d;
    static Color color;
    private final JFileChooser fc = new JFileChooser();    
    
    public Menü() {
        menü();
    }
    public void beker(){
        Scanner bill = new Scanner (System.in, "ISO8859_2");
        
        System.out.println("Kérem az 1. koordinátát :");
        a = bill.nextInt();
        System.out.println("Kérem az 2. koordinátát :");
        b = bill.nextInt();
        System.out.println("Kérem az 3. koordinátát :");
        c = bill.nextInt();
        System.out.println("Kérem az 4. koordinátát :");
        d = bill.nextInt();
    }
    public void menü(){
        
        
        setSize(500,500);
        setTitle("3. feladat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar mb;
        JMenu File;
        
        setJMenuBar(mb=new JMenuBar());
        mb.add(File = new JMenu("Rajz"));
        
        File.add(tegla = new JMenuItem("Téglalap"));
        File.addSeparator();
        File.add(kor = new JMenuItem("Kör"));
        File.addSeparator();
        File.add(vonal = new JMenuItem("Vonal"));
        
        
        setVisible(true);
        
        tegla.addActionListener(this);
        kor.addActionListener(this);
        vonal.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e){
        //String str= e.getActionCommand();
        Graphics g = getGraphics();
        
        if(e.getSource() == tegla){
            beker();
            color=JColorChooser.showDialog(this, "Az alakzat színe", color);
            g.setColor( color );
            g.fillRect( a, b, c, d ); 
        }
        else if(e.getSource()==kor){
            beker();
            color=JColorChooser.showDialog(this, "Az alakzat színe", color);
            g.setColor( color );
            g.drawOval(a, b, c, d); 
        }
        else if(e.getSource()==vonal){
            beker();
            color=JColorChooser.showDialog(this, "Az alakzat színe", color);
            g.setColor( color );
            g.drawLine(a, b, c, d); 
        }
}
}