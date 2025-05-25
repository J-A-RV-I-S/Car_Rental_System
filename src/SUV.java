class SUV extends Car {
    private double basePricePerDay;

    public SUV(String carId, String brand, String model, double basePricePerDay) {
        super(carId, brand, model);
        this.basePricePerDay = basePricePerDay;
    }

    @Override
    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays * 1.10; // 10% surcharge
    }
}
