package models;
public class Tåg extends Fordon {

    /* * * * * Konstruktor * * * * */
    public Tåg(String ID) {
        super(ID, 195.99, 999.99, 60);
    }

    /* * * * * Getter * * * * */
    @Override
    public double getPris(Bokning bokning) {
        if (bokning.getPlatsIndex() < 25) // avgränsningen mellan billigt och dyr bokning
            return pris2;
        else
            return pris1;
    }

    /* * * * * To String * * * * */
    @Override
    public String toString() {
        return "TÅG: " + ID;
    }
}
