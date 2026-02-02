import java.util.ArrayList;

public class FordonRegister {
   

    private  ArrayList<Fordon> allaFordon; 

    FordonRegister(){
        allaFordon =  new ArrayList<>();
    }
    
    public void läggTill(Fordon fordon){
        allaFordon.add(fordon);
        IO.println(fordon + " har laggts till ");
    } 

    public ArrayList<Fordon> getAllaFordoner() {
        return allaFordon;
    }
}
