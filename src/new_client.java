import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class new_client extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nombreTextField;
    private JTextField APtextField2;
    private JTextField AMtextField3;
    private JTextField SaldotextField4;
    private JTextField numeroCuentas;
    private JPasswordField NIPpasswordField1;
    private JButton GuardarBTN;
    private JButton CancelarBTN;
    private int bandera=0;

    Scanner leer = new Scanner(System.in);

    public new_client() {
        setContentPane(contentPane);
        setVisible(true);
        //setModal(true);
        setSize(400,300);

        //agrego los listeners a los botones del dialog
        GuardarBTN.addActionListener(new botonlistener());
        CancelarBTN.addActionListener(new botonlistener());

    }

    public class botonlistener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if(e.getSource().equals(GuardarBTN)){


                data dt = new data();

                dt.setNombre(nombreTextField.getText());
                dt.setApaterno(APtextField2.getText());
                dt.setAmaterno(AMtextField3.getText());
                dt.setSaldo(Float.parseFloat(SaldotextField4.getText()));
                dt.setnumCuenta(numeroCuentas.getText());
                //dt.setNIP(Integer.parseInt(NIPpasswordField1.setEchoChar())); /**Nota: despues de cambiar el char al int tengo que cambiarlo a un to String*/
                for(data VD: banco.clientes){

                    if(nombreTextField.getText().equals(VD.getNombre())){
                        JOptionPane.showMessageDialog(new_client.this, "esta cuenta ya ha sido creada");
                        bandera=1;
                    }

                }
                if(bandera==0){
                    banco.clientes.add(dt);
                    setVisible(false);
                }
                else if(bandera ==1) {
                    setVisible(false);
                }
            }

            else if(e.getSource().equals(CancelarBTN)) {
                setVisible(false);
                principal_windows pw= new principal_windows();
                pw.setEnabled(true);
            }
        }
    }

}
