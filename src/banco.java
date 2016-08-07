import javax.swing.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
/**
 * Created by rober on 22/05/2016.
 */
public class banco {

    static Scanner leer = new Scanner(System.in);

    public static ArrayList<data> clientes = new ArrayList<>();


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

       try {
           FileInputStream FIS = new FileInputStream("cuentas.txt");
           ObjectInputStream OIS = new ObjectInputStream(FIS);
           clientes = (ArrayList<data>)(OIS.readObject());

       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "problemas al leer el archivo");
       }

        principal_windows Principal_window = new principal_windows();
        Principal_window.setVisible(true);



        //Principal_window.setVisible(true);
        //Principal_window.setResizable(true);

    }
}