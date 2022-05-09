/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package f3;

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

/*
 Menük segítségével készítsen egy rajzoló programot. Menü segítségével válasszon ki
rajzobjektumokat (vonal, kör, téglalap stb.) amelyek paramétereit a billentyűzetről kérje be. A
rajzolás színét menü segítségével adja meg.
 */
public class F3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menü m = new Menü();
        //m.beker();
        m.menü();
        
        /*Scanner bill = new Scanner (System.in, "ISO8859_2");
        
        int a,b,c,d;
        
        System.out.println("Kérem az 1. koordinátát :");
        a = bill.nextInt();
        System.out.println("Kérem az 2. koordinátát :");
        b = bill.nextInt();
        System.out.println("Kérem az 3. koordinátát :");
        c = bill.nextInt();
        System.out.println("Kérem az 4. koordinátát :");
        d = bill.nextInt();*/
    }
}
class Menü extends JFrame implements ActionListener{
    JMenuItem tegla;
    JMenuItem kor;
    JMenuItem vonal;
    JMenuItem red, yellow, green, blue, pink;
    int a,b,c,d;
    static Color color = Color.BLACK;
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
        JMenu Szin;
        
        setJMenuBar(mb=new JMenuBar());
        mb.add(File = new JMenu("Rajz"));
        mb.add(Szin = new JMenu("Szín"));
        
        File.add(tegla = new JMenuItem("Téglalap"));
        File.addSeparator();
        File.add(kor = new JMenuItem("Kör"));
        File.addSeparator();
        File.add(vonal = new JMenuItem("Vonal"));
        
        Szin.add(red = new JMenuItem("Piros"));
        Szin.addSeparator();
        Szin.add(yellow = new JMenuItem("Sárga"));
        Szin.addSeparator();
        Szin.add(green = new JMenuItem("Zöld"));
        Szin.addSeparator();
        Szin.add(blue = new JMenuItem("Kék"));
        Szin.addSeparator();
        Szin.add(pink = new JMenuItem("Rózsaszín"));
        
        setVisible(true);
        
        tegla.addActionListener(this);
        kor.addActionListener(this);
        vonal.addActionListener(this);
        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        pink.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e){
        //String str= e.getActionCommand();
        Graphics g = getGraphics();
        
        if(e.getSource()==red){
            color = Color.RED;
        }
        else if(e.getSource()==yellow){
            color = Color.YELLOW;
        }
        else if(e.getSource()==green){
            color = Color.GREEN;
        }
        else if(e.getSource()==blue){
            color = Color.BLUE;
        }
        else if(e.getSource()==pink){
            color = Color.PINK;
        }
        else if(e.getSource() == tegla){
            beker();
            this.color = color;
            //color=JColorChooser.showDialog(this, "Az alakzat színe", color);
            g.setColor( color );
            g.fillRect( a, b, c, d ); 
        }
        else if(e.getSource()==kor){
            beker();
            this.color = color;
            //color=JColorChooser.showDialog(this, "Az alakzat színe", color);
            g.setColor( color );
            g.drawOval(a, b, c, d); 
        }
        else if(e.getSource()==vonal){
            beker();
            this.color = color;
            //color=JColorChooser.showDialog(this, "Az alakzat színe", color);
            g.setColor( color );
            g.drawLine(a, b, c, d); 
        }
}
}
/*class Panel extends JPanel{
    
 

    public Panel() {
    }
    
    public void paint(Graphics gr, int a ,int b, int c, int d){
        Scanner bill = new Scanner (System.in, "ISO8859_2");
        
        int a,b,c,d;
        
        System.out.println("Kérem az 1. koordinátát :");
        a = bill.nextInt();
        System.out.println("Kérem az 2. koordinátát :");
        b = bill.nextInt();
        System.out.println("Kérem az 3. koordinátát :");
        c = bill.nextInt();
        System.out.println("Kérem az 4. koordinátát :");
        d = bill.nextInt();
        
            gr.setColor( Color.green ); 
            gr.fillRect( 100, 100, 200, 150 ); 
        
        
            gr.setColor( Color.red ); 
            gr.drawOval(300, 300, 100, 100); 
        
        
            gr.setColor( Color.red ); 
            gr.drawLine(250, 250, 100, 500); 
        
        
    }
}*/