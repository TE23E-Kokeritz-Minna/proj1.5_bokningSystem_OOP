import java.util.ArrayList;

public class BokningsRegister {
    private  ArrayList<Bokning> allaBokningar; 

    BokningsRegister(){
        allaBokningar =  new ArrayList<Bokning>();
    }
    
    public void läggTill(Bokning bokning){
        allaBokningar.add(bokning);
        IO.println(bokning + " har laggts till ");
    } 

    public ArrayList<Bokning> getAllaBokninger() {
        return allaBokningar;
    }
}
