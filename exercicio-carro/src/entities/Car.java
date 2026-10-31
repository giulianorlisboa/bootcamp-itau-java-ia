package entities;

public class Car {

    private String model;
    private String name;
    private boolean isStarted;
    private int velocity;
    private String gear;

    public Car(String model, String name) {
        this.model = model;
        this.name = name;
        this.isStarted = false;
        this.velocity = 0;
        this.gear = "neutral";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void start() {
        if (isStarted) {
            System.out.println("Car is already started.");
        } else {
            isStarted = true;
            System.out.println("Car starting...");
            System.out.println("Vrooom! The car is now started.");
        }
    }

    public void stop() {
        if (!isStarted) {
            System.out.println("Car is already stopped.");
        } else if (velocity > 0) {
            System.out.println("Brake the car completely before turning it off.");
        } else {
            isStarted = false;
            gear = "neutral";
            System.out.println("Car stopped.");
        }
    }

    public void accelerate() {
        if (!isStarted) {
            System.out.println("Start the car first before accelerating.");
        } else if (gear.equals("neutral")) {
            System.out.println("You can't accelerate in neutral gear. Change to a gear first.");
        } else {
            velocity += 5;
            System.out.println("Accelerating... Current velocity: " + velocity + " km/h");

        }
    }

    public void brake() {
        if (!isStarted) {
            System.out.println("This car is already stopped.");
        } else {
            if (velocity > 0) {
                velocity -= 5;
                System.out.println("Braking... Current velocity: " + velocity + " km/h");
            } else {
                System.out.println("The car is already stopped.");
            }
        }
    }

    private static final String[] GEARS = {"neutral", "first", "second", "third", "fourth", "fifth", "sixth"};

    private int gearForSpeed() {
        if (velocity <= 20)  return 1; // first (inclui 0, para o carro poder sair do lugar)
        if (velocity <= 40)  return 2;
        if (velocity <= 60)  return 3;
        if (velocity <= 80)  return 4;
        if (velocity <= 100) return 5;
        return 6;
    }

    public void changeGear() {
        if (!isStarted) {
            System.out.println("Start the car first before changing gear.");
            return;
        }

        int current = java.util.Arrays.asList(GEARS).indexOf(gear);
        int target = gearForSpeed();

        if (target > current) {
            gear = GEARS[current + 1];
            System.out.println("Shifting up. The car is in " + gear + " gear.");
        } else if (target < current) {
            gear = GEARS[current - 1];
            System.out.println("Shifting down. The car is in " + gear + " gear.");
        } else {
            System.out.println("The car is already in the right gear (" + gear + ").");
        }
    }

    public void displaySpeed() {
        System.out.println("Current speed: " + velocity + " km/h");
        System.out.println("Current gear: " + gear);
    }

    public void turnLeft() {
        if (!isStarted) {
            System.out.println("Start the car first before turning left.");
        } else {
            System.out.println("Turning left...");
        }
    }

    public void turnRight() {
        if (!isStarted) {
            System.out.println("Start the car first before turning right.");
        } else {
            System.out.println("Turning right...");
        }
    }
}
