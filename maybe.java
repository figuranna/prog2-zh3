/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package help1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.out;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/*
Láncolt listás feladat menüben
 */
public class Help1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Scanner bill = new Scanner (System.in);
        Lista lista = new Lista();
        lista.feltölt(bill); //Rendezett feltöltés
        lista.kiír(); //Kiírás*/
        
        Menü m = new Menü();
        m.menü("Last words of a Shooting Star");
    } 
}
class Menü extends JFrame implements ActionListener{
    Scanner bill = new Scanner (System.in);
    
    JMenuItem nevv;
    JMenuItem del;
    JMenuItem nez;
    JMenuItem ker;
    JMenuItem mod;
    
    class OB_def{
        public Integer azon;
        public String nev;
        public Float fizetes;
    }
    
    LinkedList<OB_def> adatok = new LinkedList<>();
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
        File.add(nevv = new JMenuItem("Új adat felvétele"));
        File.add(nez = new JMenuItem("Adat megtekintése"));
        File.add(ker = new JMenuItem("Adat keresése"));
        File.add(mod = new JMenuItem("Adat módosítása"));
        File.addSeparator();
        
        setVisible(true);
        
        del.addActionListener(this);
        nevv.addActionListener(this);
        nez.addActionListener(this);
        ker.addActionListener(this);
        mod.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == del){
            torles();
        }
        else if(e.getSource()== nevv){
            ujAdat();
        }
        else if(e.getSource()== nez){
            adatKiir();
        }
        else if(e.getSource()== ker){
            keres();
        }
        else if(e.getSource()== mod){
            modosit();
        }
        
    
}
    void torles(){
        for(i=0; i<adatok.size(); i++){
            adatok.clear();
        }
    }
    void ujAdat(){
        int t = 0;
        OB_def OB = new OB_def();
        
        out.printf("Kérem az azonosítót: ");
        OB.azon = bill.nextInt();
        out.printf("Kérem a nevet: ");
        OB.nev = bill.next();
        out.printf("Kérem a fizetést: ");
        OB.fizetes = bill.nextFloat();
        
        for(t=0; t<adatok.size(); t++){
            if(adatok.get(t).azon > OB.azon){
            adatok.add(t, OB);
            break;
            } 
        }
        if( t == adatok.size()){
            adatok.add(OB);
        }
        
        
        JOptionPane.showMessageDialog(null, "Sikeres adatfelvétel.");
    }
    void adatKiir(){
        for(int j = 0; j <adatok.size(); j++){
            out.printf("%10d %20s %10.2f\n",adatok.get(j).azon, adatok.get(j).nev, adatok.get(j).fizetes);
        }
    }
    void keres(){
        int hlp;
        int k;
        int tmp = 0;
        out.printf("Keresett személy azonosítója: ");
        hlp = bill.nextInt();
        
        for(k=0; k<adatok.size(); k++){
            if(adatok.get(k).azon.equals(hlp)){
                 out.printf("%10d %20s %10.2f\n",adatok.get(k).azon, adatok.get(k).nev, adatok.get(k).fizetes);
                 tmp = 1;
            }
            else if(k == (adatok.size()-1) && tmp != 1){
                System.out.println("Nincsen ilyen azonosítójú személy.");
            }
        }
    }
    void modosit() {
        int keres;
        int k;
        int tmp = 0;
        out.printf("Módosítandó személy azonosítója: ");
        keres = bill.nextInt();
        
        for(k=0; k<adatok.size(); k++){
            if(adatok.get(k).azon.equals(keres)){
                out.printf("Kérem a nevet: ");
                adatok.get(k).nev = bill.next();
                out.printf("Kérem a fizetést: ");
                adatok.get(k).fizetes = bill.nextFloat();
                
                JOptionPane.showMessageDialog(null, "Sikeres adatmódosítás.");
            }
            else if(k == (adatok.size()-1) && tmp != 1){
                System.out.println("Nincsen ilyen azonosítójú személy.");
            }
        }
    }
}
