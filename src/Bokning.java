public class Bokning {

    /* * * * * VARIBALER * * * * */
    private Kund kund;
    private int platsIndex;
    private Fordon fordon;
    private double pris;

    // för Tåg och Buss
    // Eftersom det är garanterat att en Kund Fordon och platsIndex är giltiga när
    // de en ny bokning skapas finns ingen anledning att kontrollera här också
    Bokning(Kund kund, Fordon fordon, int platsIndex) {
        this.kund = kund;
        this.fordon = fordon;
        this.platsIndex = platsIndex;
        if (fordon instanceof Buss || fordon instanceof Tåg)
            pris = fordon.getPris(this);
        else
            throw new IllegalArgumentException("Ogilitg bokning");
        BokningsRegister.läggTill(this);
    }

    // för alla Fordon
    Bokning(Kund kund, Fordon fordon, int platsIndex, boolean förstaKlass) {
        this.kund = kund;
        this.fordon = fordon;
        this.platsIndex = platsIndex;
        switch (fordon) {
            case Flyg f -> pris = f.getPris(förstaKlass);
            case Buss b -> pris = b.getPris(this);
            case Tåg t -> pris = t.getPris(this);
            default -> throw new IllegalArgumentException("Ogilitg bokning");
        }

        BokningsRegister.läggTill(this);
    }

    /* * * * * Getters * * * * */

    public Kund getKund() {
        return kund;
    }

    public Fordon getFordon() {
        return fordon;
    }

    public int getPlatsIndex() {
        return platsIndex;
    }

    public double getPris() {
        return pris;
    }

    /* * * * * To String  * * * * */
    @Override
    public String toString() {
        return kund + " " + fordon + " (" + (platsIndex + 1) + ")";
    }

}
