void main(){

    System.out.println("Hello, World!");
    
    Buss bussTest = new Buss("MysterieBussen");
    Flyg flygTest = new Flyg("Falcon");
    Flyg flygTest2 = new Flyg("Athena");
    Tåg tågTest = new Tåg("Thomas");

    Kund k1 = new Kund("Jim", "19530201");
    Kund k2 = new Kund("Elsa", "20231203");
    Kund k3 = new Kund("Zoey", "20050505");
    Kund k4 = new Kund("Karina", "15681230");

    Bokning bok1 = new Bokning(k1, bussTest, 3);
    Bokning bok2 = new Bokning(k4, flygTest, 0);
    Bokning bok3 = new Bokning(k2, bussTest, 5);
    Bokning bok4 = new Bokning(k3, flygTest2, 13);

    bussTest.setPlats(0, true);
    bussTest.setPlats(12, true);

   // Programmet crashar inte av fel index 
    flygTest.setPlats(54, true);
    flygTest.setPlats(30, true);
    flygTest.setPlats(12, true);
    flygTest.setPlats(0, true);
    //BokningSystem.visaPlatser(bussTest);
    //BokningSystem.visaPlatser(flygTest);
    //BokningSystem.visaPlatser(tågTest);

    BokningSystem.Meny();
    
}
