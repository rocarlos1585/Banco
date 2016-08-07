import java.io.Serializable;

/**
 * Created by rober on 25/05/2016.
 */
public  class data implements Serializable{

    private  String nombre;
    private String ApellidoP;
    private  String ApellidoM;
    private  float saldo;
    private String numeroCuenta;
    private  char [] NIP;


    public String toString(){
        return  " "+nombre +" "+ApellidoP+" "+ApellidoM+" "+saldo+" "+numeroCuenta;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public  String getApaterno(){
        return ApellidoP;
    }

    public void setApaterno(String ApellidoP){
        this.ApellidoP = ApellidoP;
    }

    public  String getAmaterno(){
        return ApellidoM;
    }

    public void setAmaterno(String ApellidoM){
        this.ApellidoM = ApellidoM;
    }

    public  float getSaldo(){
        return saldo;
    }

    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public  String getnumeroCuenta(){return numeroCuenta;}

    public void setnumCuenta(String numeroCuentas){this.numeroCuenta = numeroCuentas;}

    public  char[] getNIP(){
        return NIP;
    }

    public void setNIP(char[] NIP){
        this.NIP = NIP;
    }

}
