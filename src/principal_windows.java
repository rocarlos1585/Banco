import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.io.*;


/**
 * Created by rober on 22/05/2016.
 */
public class principal_windows extends JFrame {

    JLabel label1;
    private JPanel ContentPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton btnGarray;



    public principal_windows(){

        super("Banco");
        setContentPane(ContentPane);
        setVisible(true);
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon BG =new ImageIcon("background.png");

        button1.addActionListener(new botonlistener());
        button2.addActionListener(new botonlistener());
        button3.addActionListener(new botonlistener());
        btnGarray.addActionListener(new botonlistener());

    }


    //inicio la clase que va a tomar el evento del listener
    public class botonlistener implements ActionListener {


        //delcaro el metodo encargado de ejecutar el listener dentro de cada uno de los botones
        public void actionPerformed(ActionEvent e) {

            if(e.getSource().equals(button1)){
                new_client alta = new new_client();


            }

            else if(e.getSource().equals(button2)){
                deposit_money deposito = new deposit_money();
                setEnabled(false);
            }

            else if(e.getSource().equals(button3)){
                JTextField usuario = new JTextField();
                JTextField contrasena = new JTextField();
                Object [] mensaje={
                        "usuario:",usuario,
                        "contraseña",contrasena
                };

                int opcion = JOptionPane.showConfirmDialog(null, mensaje, "login", JOptionPane.OK_CANCEL_OPTION);
                int i=0;

                if(opcion==JOptionPane.OK_OPTION){

                    for (data rt:banco.clientes){

                        i++;
                        System.out.println(rt.toString());

                        if(rt.getNombre().equals(usuario.getText())&&rt.getnumeroCuenta().equals(contrasena.getText())){
                            withdrawal_money wm = new withdrawal_money();

                            wm.WDnombreField.setText(rt.getNombre());
                            wm.WDapellidoPField.setText(rt.getApaterno());
                            wm.WDapellidoMField.setText(rt.getAmaterno());
                            wm.WDsaldoField.setText(String.valueOf(rt.getSaldo()));
                            wm.WDcuentaField.setText(rt.getnumeroCuenta());
                        }

                        setEnabled(false);

                        /**NOTA: mejorar la condicion para que aparezca este mensaje*/
                    }
                }
            }

            else if (e.getSource().equals(btnGarray)){
                try{
                    FileOutputStream FOS = new FileOutputStream("cuentas.txt");
                    ObjectOutputStream OOS = new ObjectOutputStream(FOS);
                    OOS.writeObject(banco.clientes);
                    OOS.flush();
                    JOptionPane.showMessageDialog(principal_windows.this,"el array se guardo exitosamente");
                }catch(Exception e1){
                    JOptionPane.showMessageDialog(principal_windows.this,"el array no se pudo guardar");

                }
            }
        }
    }
}
