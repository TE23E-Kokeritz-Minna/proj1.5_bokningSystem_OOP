public class Tåg extends Fordon {

    Tåg(String ID) {
        super(ID, 195.99, 999.99, 60);
    }

    @Override
    public double getPris(Bokning bokning) {
        if(bokning.getPlatsIndex() < 25) return pris2;
        else return pris1;
    }

    @Override
    public String toString() {
        return "TÅG: " + ID;
    }
}
