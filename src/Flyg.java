public class Flyg extends Fordon {

    // TODO DEN SKA INTE VARA HÄR 

    Flyg(String ID, boolean förstaKlass) {
        super(ID, 699.99, 90000.0, 54);
    }

    public double getPris(boolean förstaKlass) {
        if(förstaKlass) return pris2;
        else return pris1;        
    }

    @Override
    public String toString() {
        return "FLYG: " + ID;
    }
}
