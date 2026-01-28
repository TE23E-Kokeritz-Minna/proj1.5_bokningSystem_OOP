public abstract class Fartyg {

    // priser olika
    // antal passagerar
    // array med alla passagerar på fartygen

    double pris1;
    double pris2;

    Kund[] kunder;

    Fartyg(double pris1, double pris2, int antalKunder){
        this.pris1 = pris1;
        this.pris2 = pris2;
        kunder = new Kund[antalKunder];
    }

    public Kund[] getKunder() {
        return kunder;
    }

    // stoppa in hela kunden? Tror inte det fungerar
    public double getPris(){
        return pris1;
    }
    
}
