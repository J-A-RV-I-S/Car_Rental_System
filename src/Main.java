public class Main {
    public static void main(String[] args) {
        CarRentalSystem crs = new CarRentalSystem();
        crs.addCar(new Sedan("C001", "Toyota", "Camry", 60.0));
        crs.addCar(new SUV("C002", "Honda", "CR-V", 80.0));
        crs.addCar(new LuxuryCar("C003", "BMW", "M Series", 150.0));
        crs.menu();
    }
}
