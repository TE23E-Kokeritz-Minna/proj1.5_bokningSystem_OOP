import java.util.ArrayList;

public class BokningsRegister {
    
    // Registret
    private static ArrayList<Bokning> allaBokningar;

    // skapar Listan i ett static block
    static {
        allaBokningar = new ArrayList<Bokning>();
    }

    // Metod för att lägga till bokningar 
    public static void läggTill(Bokning bokning) {
        allaBokningar.add(bokning);
        IO.println(bokning + " har laggts till ");
    }

    /* * * * * Getters * * * * */
    public static ArrayList<Bokning> getAllaBokninger() {
        return allaBokningar;
    }
}
