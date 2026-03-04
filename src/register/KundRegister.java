package register;
import java.util.ArrayList;

import models.Kund;

public class KundRegister {
    // Registret
    static private ArrayList<Kund> allaKunder;

    // skapar Listan i ett static block
    static {
        allaKunder = new ArrayList<>();
    }

    // Metod för att lägga till Kunder
    static public void läggTill(Kund kund) {
        allaKunder.add(kund);
        IO.println(kund + " har laggts till ");
    }

    /* * * * * Getters * * * * */
    static public ArrayList<Kund> getAllaKunder() {
        return allaKunder;
    }
}
