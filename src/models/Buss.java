package models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Buss extends Fordon {

    /* * * * * Konstruktor * * * * */
    public Buss(String ID) {
        super(ID, 149.99, 299.99, 20);
    }

    /* * * * * Getter * * * * */
    @Override
    public double getPris(Bokning bokning) {
        //Parse persnomuret till en LocalDate object
        LocalDate pnr = LocalDate.parse(bokning.getKund().getPersonummer(), DateTimeFormatter.BASIC_ISO_DATE);
        // Om individen är under 18 returnera de billigare priset
        if ((LocalDate.now().getYear() - pnr.getYear()) < 18)
            return pris1;
        else
            return pris2;
    }

    /* * * * * To String * * * * */
    @Override
    public String toString() {
        return "BUSS: " + ID;
    }

}
