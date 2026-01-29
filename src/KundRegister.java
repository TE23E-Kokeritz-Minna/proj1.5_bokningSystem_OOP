import java.util.ArrayList;

public class KundRegister {
    // inkluderar alla kunder kanske metoder för att hitta dem
    private  ArrayList<Kund> allaKunder; // inte best practice

    KundRegister(){
        allaKunder =  new ArrayList<>();
    }
    
    public void läggTill(Kund kund){
        allaKunder.add(kund);
        IO.println(kund + " har laggts till ");
    } 

    public ArrayList<Kund> getAllaKunder() {
        return allaKunder;
    }
}


