import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class deposit_money extends JFrame{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField TextfieldCuenta;
    private JTextField TexfieldNombre;
    private JLabel numeroCuentas;
    private JLabel nombre;
    private JTextField textfieldDeposito;
    private JButton depositarButton;
    private JLabel nombreAcceso;
    private JLabel apellidoPAcceso;
    private JLabel apellidoMAcceso;
    private JLabel saldoAcceso;
    private JLabel numeroCAcceso;
    private JLabel fieldDeposito;
    private JButton buttonClear;

    private String Nombre;/**variable que almacenan los datos para comprobar su una cuenta existe y poder habilitar el deposito*/
    private String Ncuenta;/**variable que almacenan los datos para comprobar su una cuenta existe y poder habilitar el deposito*/

    private float SaldoAcceso;
    private float CantidadDeposito; /**variable para el Jtextfield que toma la cantidad a depositar*/





    public deposit_money() {
        setContentPane(contentPane);
        setVisible(true);
        setSize(700,300);

        buttonOK.addActionListener(new botonlistener1());
        buttonCancel.addActionListener(new botonlistener1());
        buttonClear.addActionListener(new botonlistener1());
        depositarButton.addActionListener(new botonlistener1());

        fieldDeposito.setEnabled(false);
        textfieldDeposito.setEnabled(false);
        depositarButton.setEnabled(false);


    }

    public class botonlistener1 implements ActionListener {

        int i=0;
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(buttonOK)) {


                Nombre = TexfieldNombre.getText();
                Ncuenta = TextfieldCuenta.getText();


                for (data d: banco.clientes) {

                    i++;
                    System.out.println(d.toString());

                    if(d.getNombre().equals(Nombre)&&d.getnumeroCuenta().equals(Ncuenta)){


                        SaldoAcceso = d.getSaldo();

                        nombreAcceso.setText(d.getNombre());
                        apellidoPAcceso.setText(d.getApaterno());
                        apellidoMAcceso.setText(d.getAmaterno());
                        //aqui convieto el entero de entero a string
                        saldoAcceso.setText(String.valueOf(d.getSaldo()));

                        numeroCAcceso.setText(d.getnumeroCuenta());

                        fieldDeposito.setEnabled(true);
                        textfieldDeposito.setEnabled(true);
                        depositarButton.setEnabled(true);
                    }




                }

                if(fieldDeposito.isEnabled()==false) {
                    JOptionPane.showMessageDialog(deposit_money.this,"no se encontro ninguna cuenta");
                    i=0;
                }


            }



            else if (e.getSource().equals(buttonCancel)) {
                setVisible(false);
                principal_windows PW2 = new principal_windows();
                PW2.setEnabled(true);

            }

            else if (e.getSource().equals(buttonClear)){

                TexfieldNombre.setText("");
                TextfieldCuenta.setText("");

                nombreAcceso.setText("");
                apellidoPAcceso.setText("");
                apellidoMAcceso.setText("");
                saldoAcceso.setText("");
                numeroCAcceso.setText("");

                fieldDeposito.setEnabled(false);
                textfieldDeposito.setEnabled(false);
                textfieldDeposito.setText("");
                depositarButton.setEnabled(false);
            }

            else if (e.getSource().equals(depositarButton)){

                CantidadDeposito = Float.parseFloat(textfieldDeposito.getText());
                saldoAcceso.setText(String.valueOf(SaldoAcceso + CantidadDeposito));

                for(data dt:banco.clientes){

                    if(dt.getNombre().equals(Nombre)&&dt.getnumeroCuenta().equals(Ncuenta)){
                        dt.setSaldo(dt.getSaldo()+CantidadDeposito);
                        JOptionPane.showMessageDialog(deposit_money.this,"se depositaron $"+CantidadDeposito+" pesos a la cuenta "+dt.getnumeroCuenta());

                        TexfieldNombre.setText("");
                        TextfieldCuenta.setText("");

                        nombreAcceso.setText("");
                        apellidoPAcceso.setText("");
                        apellidoMAcceso.setText("");
                        saldoAcceso.setText("");
                        numeroCAcceso.setText("");

                        fieldDeposito.setEnabled(false);
                        textfieldDeposito.setEnabled(false);
                        textfieldDeposito.setText("");
                        depositarButton.setEnabled(false);
                    }
                }



            }
        }
    }
}

