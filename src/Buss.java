import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Buss extends Fordon{

    Buss(){
        super(149.99, 299.99, 20);
    }

    public double getPris(String personummer){
        // kolla att det är ett giltigt personummer via localdate 
        // om det är fortsätt kolla om person är äldre en 18 via localdate.
        LocalDate pnr = LocalDate.parse(personummer, DateTimeFormatter.BASIC_ISO_DATE); // KAN KRASHA 
        if((LocalDate.now().getYear() - pnr.getYear()) > 18) return pris1;
        else return pris2;
    }

    @Override
    public String toString() {
        return "BUSS";
    }
    
}
