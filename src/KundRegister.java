import java.util.ArrayList;

public class KundRegister {
    static private  ArrayList<Kund> allaKunder; 
    
    KundRegister(){
        allaKunder =  new ArrayList<>();
    }
    
    static public void läggTill(Kund kund){
        allaKunder.add(kund);
        IO.println(kund + " har laggts till ");
    } 

    public ArrayList<Kund> getAllaKunder() {
        return allaKunder;
    }
}


