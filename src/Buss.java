import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Buss extends Fordon{

    Buss(String ID){
        super(ID, 149.99, 299.99, 20);
    }

    public double getPris(String personummer){
        LocalDate pnr = LocalDate.parse(personummer, DateTimeFormatter.BASIC_ISO_DATE); 
        if((LocalDate.now().getYear() - pnr.getYear()) > 18) return pris1;
        else return pris2;
    }

    @Override
    public String toString() {
        return "BUSS: " + ID;
    }
    
}
