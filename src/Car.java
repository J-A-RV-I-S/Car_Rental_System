abstract class Car {
    private String carId;
    private String brand;
    private String model;
    private boolean isAvailable;

    public Car(String carId, String brand, String model) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.isAvailable = true;
    }

    public String getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isAvailable() { return isAvailable; }
    public void rent() { isAvailable = false; }
    public void returnCar() { isAvailable = true; }

    public abstract double calculatePrice(int rentalDays);
}