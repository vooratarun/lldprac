package lld.elevator;
import java.util.*;

enum Direction {
    UP, DOWN
}

enum ElevatorState {
    IDLE, MOVING_UP, MOVING_DOWN
}

class Request {
    int floor;
    Direction direction;

    Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}


class Elevator {
    int id;
    int currentFloor;
    ElevatorState state;

    // Min heap for UP, Max heap for DOWN
    PriorityQueue<Integer> upStops = new PriorityQueue<>();
    PriorityQueue<Integer> downStops = new PriorityQueue<>(Collections.reverseOrder());

    Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.state = ElevatorState.IDLE;
    }

    void addRequest(int floor) {
        if (floor > currentFloor) {
            upStops.offer(floor);
        } else {
            downStops.offer(floor);
        }
    }

    void move() {
        if (!upStops.isEmpty()) {
            state = ElevatorState.MOVING_UP;
            currentFloor = upStops.poll();
        } else if (!downStops.isEmpty()) {
            state = ElevatorState.MOVING_DOWN;
            currentFloor = downStops.poll();
        } else {
            state = ElevatorState.IDLE;
        }
    }

    boolean isIdle() {
        return state == ElevatorState.IDLE;
    }
}


class ElevatorController {
    List<Elevator> elevators;

    ElevatorController(int n) {
        elevators = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            elevators.add(new Elevator(i));
        }
    }

    // Assign best elevator
    Elevator assignElevator(Request request) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.currentFloor - request.floor);

            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }

        best.addRequest(request.floor);
        return best;
    }

    void step() {
        for (Elevator e : elevators) {
            e.move();
            System.out.println("Elevator " + e.id + " at floor " + e.currentFloor + " state: " + e.state);
        }
    }
}

class Main {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(3);

        controller.assignElevator(new Request(5, Direction.UP));
        controller.assignElevator(new Request(2, Direction.DOWN));
        controller.assignElevator(new Request(8, Direction.UP));

        for (int i = 0; i < 5; i++) {
            controller.step();
        }
    }
}