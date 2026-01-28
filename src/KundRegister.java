import java.util.ArrayList;

public class KundRegister {
    // inkluderar alla kunder kanske metoder för att hitta dem
    private static ArrayList<Kund> allaKunder; // inte best practice

    static{
        allaKunder =  new ArrayList<>();
    }
    
    public static void läggTill(Kund kund){
        allaKunder.add(kund);
        IO.println(kund + " har laggts till ");
    } 

}


