package entities;

public class Pet {

    private final String name;
    private boolean isClean;

    public Pet(String name) {
        this.name = name;
        this.isClean = false;
    }

    public String getName() {
        return name;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }
}


