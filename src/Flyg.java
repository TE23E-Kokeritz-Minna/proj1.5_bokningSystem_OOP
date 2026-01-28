public class Flyg extends Fartyg {

    Flyg() {
        super(699.99, 90000, 50);
    }

    @Override
    public double getPris() {
        while (true) {
            try {
                String svar = IO.readln("Vill du ha första klass? (y/n)");
                if (svar == "y" ) return pris2;
                else if (svar == "n") return pris1;
                else throw new IllegalArgumentException("Måste svara antingen y eller n");
            } catch (Exception e) {
                IO.println("FEL: " + e.getMessage());
            }
        }
    }
}
