void main(){

    System.out.println("Hello, World!");
    
    Buss bussTest = new Buss("MysterieBussen");
    Flyg flygTest = new Flyg("Falcon");
    Tåg tågTest = new Tåg("Thomas");

    bussTest.setPlats(0, true);
    bussTest.setPlats(12, true);

   // Programmet crashar inte av fel index 
    flygTest.setPlats(54, true);
    flygTest.setPlats(30, true);
    flygTest.setPlats(12, true);
    flygTest.setPlats(0, true);
    BokningSystem.visaPlatser(bussTest);
    BokningSystem.visaPlatser(flygTest);
    BokningSystem.visaPlatser(tågTest);
}
