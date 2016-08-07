import javax.swing.*;
import java.awt.event.*;

public class withdrawal_money extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField WDretiroTextField1;
    public JLabel field1;
    public JLabel WDnombreField;
    public JLabel WDapellidoPField;
    public JLabel WDapellidoMField;
    public JLabel WDsaldoField;
    public JLabel WDcuentaField;
    public float Cantidadretiro;
    public int bandera;

    public withdrawal_money() {
        setContentPane(contentPane);
        setVisible(true);
        setSize(400,300);

        buttonOK.addActionListener(new botonlistenr());
        buttonCancel.addActionListener(new botonlistenr());
    }

    public class botonlistenr implements ActionListener{



        public void actionPerformed(ActionEvent e) {

            if(e.getSource().equals(buttonOK)){

                for(data WD:banco.clientes){

                    Cantidadretiro = Float.parseFloat(WDretiroTextField1.getText());

                    if(WD.getNombre().equals(WDnombreField.getText())&&WD.getnumeroCuenta().equals(WDcuentaField.getText())){
                        WD.setSaldo(WD.getSaldo()-Cantidadretiro);
                        JOptionPane.showMessageDialog(withdrawal_money.this,"se retiraron $"+Cantidadretiro+" pesos de la cuenta "+WDcuentaField.getText());
                    }
                }
                setVisible(false);
            }

            else if (e.getSource().equals(buttonCancel)){
                setVisible(false);
                principal_windows pw= new principal_windows();
                pw.setEnabled(true);
            }
        }
    }
}

