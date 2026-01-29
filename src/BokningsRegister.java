public class BokningsRegister {
    // LISTA på alla bokningar
    private  ArrayList<Bokning> allaBokningar; // inte best practice

    BokningRegister(){
        allaBokningar =  new ArrayList<>();
    }
    
    public void läggTill(Bokning bokning){
        allaBokningar.add(bokning);
        IO.println(bokning + " har laggts till ");
    } 

    public ArrayList<Bokning> getAllaBokninger() {
        return allaBokningar;
    }
}
