import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kund {
    // Namn personummer fartyg och plats
    // Getter and setters 
    // Static ArrayList alla kunder 


    private String namn; 
    private String personummer; //ÅÅÅÅMMDD
    private Bokning fartyg; //FLEXIBELT 
    private int platsIndex;

    Kund(){
        namn = "okänt";
        personummer = "00000000";
        fartyg = null;
        platsIndex = 0;
        
        // lägg till i kundregister? 
    }
}
