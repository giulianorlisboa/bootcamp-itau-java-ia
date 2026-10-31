package entities;

public class PetWash {

    private static final int MAX_WATER = 30;
    private static final int MAX_SHAMPOO = 10;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet;
    private boolean clean = true;

    public void washPet() {
        if (this.pet == null) {
            System.out.println("Não há nenhum pet para lavar.");
            return;
        }
        if (this.shampoo < 2) {
            System.out.println("Não há shampoo suficiente para lavar o pet. Adicione mais shampoo.");
            return;
        }
        if (this.water < 10) {
            System.out.println("Não há água suficiente para lavar o pet. Adicione mais água.");
            return;
        }
        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está limpo!");
    }

    public void addWater() {
        if (water >= MAX_WATER) {
            System.out.println("O tanque de água está cheio.");
            return;
        }
        System.out.println("Adicionando 2 litros de água ao tanque.");
        this.water = Math.min(water + 2, MAX_WATER);
    }

    public void addShampoo() {
        if (shampoo >= MAX_SHAMPOO) {
            System.out.println("O tanque de shampoo está cheio.");
            return;
        }
        System.out.println("Adicionando 2 litros de shampoo ao tanque.");
        this.shampoo = Math.min(shampoo + 2, MAX_SHAMPOO);
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return this.pet != null;
    }

    public boolean setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("A máquina de lavar está suja. Por favor, limpe-a antes de colocar outro pet.");
            return false;
        }
        if (hasPet()) {
            System.out.println("O pet " + this.pet.getName() + " já está no banho.");
            return false;
        }
        this.pet = pet;
        return true;
    }

    public void removePet() {
        if (!hasPet()) {
            System.out.println("Não há nenhum pet para remover.");
            return;
        }
        System.out.println("O pet " + this.pet.getName() + " foi removido da máquina de lavar.");
        if (this.pet.isClean()) {
            System.out.println("O pet " + this.pet.getName() + " está limpo!");
        } else {
            System.out.println("O pet " + this.pet.getName() + " ainda está sujo. A máquina precisa ser limpa.");
            this.clean = false;
        }
        this.pet = null;
    }

    public void washMachine() {
        if (this.clean) {
            System.out.println("A máquina de lavar já está limpa.");
            return;
        }
        this.water -= 3;
        this.shampoo -= 1;
        this.clean = true;
        System.out.println("A máquina de lavar foi limpa.");
    }

}
