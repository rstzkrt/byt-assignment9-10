public class Vehicle {
    private int vehicleId;
    private int seats;
    private String route;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, int seats, String route) {
        this.vehicleId = vehicleId;
        this.seats = seats;
        this.route = route;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void blockDoors(){
        System.out.println("Doors are blocking!");
    }
}
