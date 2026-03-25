package dsa.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class Vehicle {
    String licenseNumber;
    VehicleType type;

    Vehicle(String licenseNumber, VehicleType type){
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

}
enum VehicleType {
    BIKE, CAR, TRUCK
}
class ParkingSpot {
    int spotId;
    VehicleType type;
    boolean isOccupied = false;
    Vehicle vehicle;

    ParkingSpot(int spotId,VehicleType type ){
        this.spotId = spotId;
        this.type = type;
    }

    boolean assignVehicle(Vehicle v) {
        if (!isOccupied) {
            this.vehicle = v;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }
}

class Floor {
    int floorNumber;
    List<ParkingSpot> spots;

    Floor(int floorNumber, List<ParkingSpot> spots){
        this.floorNumber = floorNumber;
        this.spots= spots;
    }

    ParkingSpot findAvailableSpot(VehicleType type) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied && spot.type == type) {
                return spot;
            }
        }
        return null;
    }
}

class Ticket {
    String ticketId;
    long entryTime;
    Vehicle vehicle;
    ParkingSpot spot;

    public Ticket(String ticketId, long entryTime, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.spot = spot;
    }
}
class Payment {
    double calculateFee(long entryTime, long exitTime) {
        long duration = (exitTime - entryTime) / (1000 * 60 * 60);
        return duration * 10; // ₹10 per hour
    }
}



interface PricingStrategy {
    double calculate(long hours);
}

class VehicleFactory {
    static Vehicle createVehicle(VehicleType type, String number) {
        // return specific vehicle object
        return null;
    }
}


class ParkingLot {
    List<Floor> floors = new ArrayList<>();

    Ticket parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            System.out.println(floors);
            ParkingSpot spot = floor.findAvailableSpot(vehicle.type);

            if (spot != null) {
                spot.assignVehicle(vehicle);
                System.out.println(spot.isOccupied + "ticket");

                return new Ticket(UUID.randomUUID().toString(),
                        System.currentTimeMillis(),
                        vehicle,
                        spot);
            }
        }
        return null; // full
    }

    double exitVehicle(Ticket ticket) {
        long exitTime = System.currentTimeMillis();
        ticket.spot.removeVehicle();
        return new Payment().calculateFee(ticket.entryTime, exitTime);
    }
    private static ParkingLot instance;

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.floors = new ArrayList<>();
        parkingLot.floors.add(new Floor(1, new ArrayList<>(){{
            add(new ParkingSpot(1,VehicleType.BIKE)
            );
        }}));
        Ticket ticket = parkingLot.parkVehicle(new Vehicle("12",VehicleType.BIKE));
        System.out.println(ticket.entryTime);
        System.out.println(parkingLot.exitVehicle(ticket));

    }

}

