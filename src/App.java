void main(){

    System.out.println("Hello, World!");
    
    Buss bussTest = new Buss();

    bussTest.setPlats(0, true);
    bussTest.setPlats(12, true);

    bussTest.skrivUtPlatserTEST();

    BokningSystem.visaPlatser(bussTest);

}
