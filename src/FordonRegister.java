public class FordonRegister {
    // lista på alla fordon 

    private  ArrayList<Fordon> allaFordon; // inte best practice

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
