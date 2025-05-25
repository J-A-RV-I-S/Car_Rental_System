import java.util.*;

class CarRentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available.");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        rentals.removeIf(r -> r.getCar().equals(car));
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    Customer customer = new Customer("CUST" + (customers.size() + 1), name);
                    addCustomer(customer);

                    System.out.println("Available Cars:");
                    for (Car c : cars) {
                        if (c.isAvailable()) {
                            System.out.println(c.getCarId() + " - " + c.getBrand() + " " + c.getModel());
                        }
                    }

                    System.out.print("Enter car ID: ");
                    String carId = scanner.nextLine();
                    System.out.print("Rental days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Car selected = null;
                    for (Car c : cars) {
                        if (c.getCarId().equals(carId) && c.isAvailable()) {
                            selected = c;
                            break;
                        }
                    }

                    if (selected != null) {
                        System.out.printf("Total Price: $%.2f%n", selected.calculatePrice(days));
                        System.out.print("Confirm rental (Y/N): ");
                        if (scanner.nextLine().equalsIgnoreCase("Y")) {
                            rentCar(selected, customer, days);
                            System.out.println("Car rented successfully.");
                        } else {
                            System.out.println("Rental cancelled.");
                        }
                    } else {
                        System.out.println("Car not available or invalid ID.");
                    }
                    break;

                case 2:
                    System.out.print("Enter car ID to return: ");
                    String id = scanner.nextLine();
                    Car toReturn = null;
                    for (Car c : cars) {
                        if (c.getCarId().equals(id) && !c.isAvailable()) {
                            toReturn = c;
                            break;
                        }
                    }

                    if (toReturn != null) {
                        returnCar(toReturn);
                        System.out.println("Car returned.");
                    } else {
                        System.out.println("Invalid or not rented.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Car Rental System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                    break;
            }
        }
    }
}
