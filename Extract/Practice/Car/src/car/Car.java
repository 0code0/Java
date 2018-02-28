package car;

public class Car {
    
    int maxSpeed = 100 ;
    int minSpeed = 0;
    
    double weights = 4093.0;
    double maxFuel = 16.0;
    double CurrentFuel = 8;
    
    boolean isTheCarOn = false;
    char Condition = 'A';
    
    
    public void PrintVaribale(){
        System.out.println(maxSpeed);
        System.out.println(minSpeed);
        System.out.println(weights);
        System.out.println(isTheCarOn);
        System.out.println(Condition);
        
        
    }
    public void WreckCar(){
    
        Condition = 'C';
    }
    
    
    public static void main(String[] args) {

        Car familyCar = new Car();
        familyCar.PrintVaribale();
        Car Alix = familyCar;
        familyCar.WreckCar();
        Alix.PrintVaribale();
        
    }
    
}
