class Sedan extends Car {
    private double basePricePerDay;

    public Sedan(String carId, String brand, String model, double basePricePerDay) {
        super(carId, brand, model);
        this.basePricePerDay = basePricePerDay;
    }

    @Override
    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }
}
