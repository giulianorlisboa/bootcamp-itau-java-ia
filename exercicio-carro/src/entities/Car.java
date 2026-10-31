package entities;

public class Car {

    private static final String[] GEARS = {"neutral", "first", "second", "third", "fourth", "fifth", "sixth"};
    private static final int[] MIN_SPEED = {0, 0, 21, 41, 61, 81, 101};
    private static final int[] MAX_SPEED = {0, 20, 40, 60, 80, 100, 120};

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
        } else if (velocity > 0 || !gear.equals("neutral")) {
            System.out.println("Stop the car and put it in neutral before turning it off.");
        } else {
            isStarted = false;
            System.out.println("Car stopped.");
        }
    }

    public void accelerate() {
        int g = gearIndex();
        if (!isStarted) {
            System.out.println("Start the car first before accelerating.");
        } else if (g == 0) {
            System.out.println("You can't accelerate in neutral gear. Change to a gear first.");
        } else if (velocity >= MAX_SPEED[g]) {
            System.out.println(g == 6 ? "Maximum speed reached." : "Max speed for this gear. Shift up.");
        } else {
            velocity += 10;
            System.out.println("Accelerating... Current velocity: " + velocity + " km/h");
        }
    }


    public void brake() {
        int g = gearIndex();
        if (!isStarted) {
            System.out.println("Start the car first.");
        } else if (velocity == 0) {
            System.out.println("The car is already stopped.");
        } else if (velocity - 1 < MIN_SPEED[g]) {
            System.out.println("Min speed for this gear. Shift down.");
        } else {
            velocity -= 10;
            System.out.println("Braking... Current velocity: " + velocity + " km/h");
        }
    }

    private int gearIndex() {
        return java.util.Arrays.asList(GEARS).indexOf(gear);
    }

    public void changeGear() {
        if (!isStarted) {
            System.out.println("Start the car first before changing gear.");
            return;
        }
        int g = gearIndex();
        if (g < 6 && velocity >= MAX_SPEED[g]) {
            gear = GEARS[g + 1];
            System.out.println("Shifting up. The car is in " + gear + " gear.");
        } else if (g > 0 && velocity <= MIN_SPEED[g]) {
            gear = GEARS[g - 1];
            System.out.println("Shifting down. The car is in " + gear + " gear.");
        } else {
            System.out.println("You can't change gear at " + velocity + " km/h.");
        }
    }

    public void carStatus() {
        System.out.println("Car model: " + model);
        System.out.println("Car name: " + name);
        System.out.println("Car is " + (isStarted ? "started" : "stopped"));
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
