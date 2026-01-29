public abstract class Fordon {

    // priser olika
    // antal passagerar
    //  // array med alla passagerar på fartygen

    //Array med platser sträng: XX taget annars 1-antalplatser BokningSystemet ser till att uppdatera listan.

    double pris1;
    double pris2;

    int antalPlatser;

    ///Kund[] kunder;

    Fordon(double pris1, double pris2, int antalKunder){
        this.pris1 = pris1;
        this.pris2 = pris2;
        //kunder = new Kund[antalKunder];
        antalPlatser = antalKunder;
    }


    // THINGS WILL GET WEIRID 
/*     public void läggTillIKunder(Kund kund, int index){
        kunder[index] = kund;
    }
 */
    // stoppa in hela kunden? Tror inte det fungerar
    public double getPris(){
        return pris1;
    }

    @Override
    public abstract String toString();
}
