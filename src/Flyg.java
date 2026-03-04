public class Flyg extends Fordon {

    /* * * * * Konstruktor * * * * */
    Flyg(String ID) {
        super(ID, 699.99, 90000.0, 54);
    }

    /* * * * * Getter * * * * */
    public double getPris(boolean förstaKlass) {
        if (förstaKlass)
            return pris2;
        else
            return pris1;
    }

    /* * * * * To String * * * * */
    @Override
    public String toString() {
        return "FLYG: " + ID;
    }
}
