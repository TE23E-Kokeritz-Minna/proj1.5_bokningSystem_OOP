import java.util.ArrayList;

public class FordonRegister {

    // Registret
    private static ArrayList<Fordon> allaFordon;

    // skapar Listan i ett static block
    static {
        allaFordon = new ArrayList<>();
    }

    // Metod för att lägga till Fordon
    public static void läggTill(Fordon fordon) {
        allaFordon.add(fordon);
        IO.println(fordon + " har laggts till ");
    }

    /* * * * * Getters * * * * */
    public static ArrayList<Fordon> getAllaFordoner() {
        return allaFordon;
    }

    public static ArrayList<Fordon> getAllaTyp(Class<?> fordonsTyp) {
        ArrayList<Fordon> allaAvTyp = new ArrayList<Fordon>();
        for (Fordon fordon : allaFordon) {
            if (fordonsTyp.isInstance(fordon)) {
                allaAvTyp.add(fordon);
            }
        }
        return allaAvTyp;
    }
}
