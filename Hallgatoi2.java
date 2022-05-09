/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hallgatoi2;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author serto
 */

/*
Módosítsa ezt a programot úgy, hogy a fájl tartalmát az ablakban
jeleníti meg. (Segítség: használja a JScrollPane osztályt.)
*/

public class Hallgatoi2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Menü menü = new Menü("Fájl kiírás");
    }
}
class Menü extends JFrame implements ActionListener{
    JMenuItem exit;
    JMenuItem open;
    private final JFileChooser fc = new JFileChooser();
    public Menü(String cim){
        setSize(400,150);
        setTitle(cim);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar mb;
        JMenu File;
        setJMenuBar(mb=new JMenuBar());
        mb.add(File=new JMenu("File"));
        mb.add(new JMenu("Help"));
        File.add(open = new JMenuItem("Open"));
        File.addSeparator();
        File.add(exit = new JMenuItem("Exit"));
        setVisible(true);
        open.addActionListener(this);
        exit.addActionListener(this);
    }
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == open){
        fc.showOpenDialog(this);
        try {
            beolvas(fc.getSelectedFile());
            //dispose();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Nincs fájlnév","Fájlhiba",JOptionPane.ERROR_MESSAGE);
        }
    }
    if(e.getSource()==exit){
        System.exit(0);
    }
}
public void beolvas(File file) throws FileNotFoundException{
     String sor;
    DefaultListModel<String> lm = new DefaultListModel<>();
    JList<String> jl = new JList<>(lm);
    JScrollPane scroll = new JScrollPane(jl);
    scroll.setPreferredSize(new Dimension(300, 200));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocation(400,400);
    try (Scanner out = new Scanner(file)) {
        while(out.hasNext()) {
            sor = out.nextLine();
            lm.addElement(sor);
        }
        out.close();
    }
    catch (NullPointerException error){
        System.out.println(error.getMessage());
        JOptionPane.showMessageDialog(null, "Nincs fájlnév","Fájlhiba",JOptionPane.ERROR_MESSAGE);
    }
    catch (IOException error) {
        JOptionPane.showMessageDialog(null, error.getMessage(),"Fájlhiba",JOptionPane.ERROR_MESSAGE);
    }
    finally{
        add(scroll);
        setTitle("File");
        pack();
        setVisible(true);
    } 
}
}
