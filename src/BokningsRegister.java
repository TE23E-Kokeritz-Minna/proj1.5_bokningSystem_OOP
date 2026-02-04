import java.util.ArrayList;

public class BokningsRegister {
    private static ArrayList<Bokning> allaBokningar;

    static {
        allaBokningar = new ArrayList<Bokning>();
    }

    public static void läggTill(Bokning bokning) {
        allaBokningar.add(bokning);
        IO.println(bokning + " har laggts till ");
    }

    public static ArrayList<Bokning> getAllaBokninger() {
        return allaBokningar;
    }
}
