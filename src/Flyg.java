public class Flyg extends Fordon {

    Flyg(String ID) {
        super(ID, 699.99, 90000.0, 54);
    }

    @Override
    public double getPris(Bokning bokning) {

        //TODO FLYTTTA 
        //? BOOLEAN FÖRSTA KLASS? 
        // DET HÄR SKA INTE VARA HÄR FRÅGA NÄR MAN SKAPAR BOKNINGEN ELLER NÅGOT
        while (true) {
            try {
                String svar = IO.readln("Vill du ha första klass? (y/n): ");
                if (svar.toLowerCase().equals("y")) {
                    IO.println("FÖRSTA KLASSS");
                    return pris2;
                } else if (svar.toLowerCase().equals("n"))
                    return pris1;
                else
                    throw new IllegalArgumentException("Måste svara antingen y eller n");
            } catch (Exception e) {
                IO.println("FEL: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "FLYG: " + ID;
    }
}
