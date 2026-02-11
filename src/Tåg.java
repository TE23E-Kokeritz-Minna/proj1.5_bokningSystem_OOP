public class Tåg extends Fordon {
    //TODO DEN SKA INTE VARA HÄR 
    private boolean förstaKlass;

    Tåg(String ID, boolean förstaKlass) {
        super(ID, 195.99, 999.99, 100);
        this.förstaKlass = förstaKlass;
    }

    // TODO BASED on position in Tåg
    @Override
    public double getPris(Bokning bokning) {

        // TODO FIXA
        if(förstaKlass) return pris2;
        else return pris1;
      /*   while (true) {
            try {
                String svar = IO.readln("Vill du ha första klass? (y/n): ");
                if (svar.equals("y"))
                    return pris2;
                else if (svar.equals("n"))
                    return pris1;
                else
                    throw new IllegalArgumentException("Måste svara antingen y eller n");
            } catch (Exception e) {
                IO.println("FEL: " + e.getMessage());
            }
        } */
    }

    @Override
    public String toString() {
        return "TÅG: " + ID;
    }
}
