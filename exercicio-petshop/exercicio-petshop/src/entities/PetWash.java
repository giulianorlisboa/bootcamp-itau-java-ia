package entities;

public class PetWash {

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
        if (water >= 30) {
            System.out.println("O tanque de água está cheio.");
            return;
        }
        System.out.println("Adicionando 2 litros de água ao tanque.");
        this.water += 2;
    }

    public void addShampoo() {
        if (shampoo >= 10) {
            System.out.println("O tanque de shampoo está cheio.");
            return;
        }
        System.out.println("Adicionando 2 litros de shampoo ao tanque.");
        this.shampoo += 2;
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

    public void setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("A máquina de lavar está suja. Por favor, limpe-a antes de colocar outro pet.");
            return;
        }
        if (hasPet()) {
            System.out.println("O pet " + this.pet.getName() + " já está no banho.");
            return;
        }
        this.pet = pet;
    }

    public void removePet() {
        if (!hasPet()) {
            System.out.println("Não há nenhum pet para remover.");
            return;
        }
        System.out.println("O pet " + this.pet.getName() + " foi removido da máquina de lavar.");
        if (this.pet.isClean()) {
            System.out.println("O pet " + this.pet.getName() + " está limpo!");
            this.clean = false;
        } else {
            System.out.println("O pet " + this.pet.getName() + " ainda está sujo.");
        }
        this.pet = null;
    }

    public void washMachine() {
        if (this.clean) {
            System.out.println("A máquina de lavar já está limpa.");
            return;
        }
        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("A máquina de lavar foi limpa.");
    }

}
