import java.util.ArrayList;

public class FordonRegister {
   
    private static ArrayList<Fordon> allaFordon; 

    static{
        allaFordon =  new ArrayList<>();
    }
    
    public static void läggTill(Fordon fordon){
        allaFordon.add(fordon);
        IO.println(fordon + " har laggts till ");
    } 

    public static ArrayList<Fordon> getAllaFordoner() {
        return allaFordon;
    }

    public static ArrayList<Fordon> getAllaTyp(Class<?> fordonsTyp){
        ArrayList<Fordon> allaAvTyp = new ArrayList<Fordon>();
        for (Fordon fordon : allaFordon) {
            if(fordonsTyp.isInstance(fordon)){
                allaAvTyp.add(fordon);
            }
        }
        return allaAvTyp;
    }
}
