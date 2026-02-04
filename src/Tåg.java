public class Tåg extends Fordon{
    Tåg(String ID){
        super(ID, 195.99, 999.99, 100);
    }

    //TODO BASED on position in Tåg 
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
    @Override
    public String toString() {
        return "TÅG: " +ID;
    }
}
