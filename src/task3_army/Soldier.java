package task3_army;

public abstract class Soldier {
    protected final String name;
    protected final int damage;
    protected final SoldierType type;

    public Soldier(String name, int damage, SoldierType type) {
        this.name = name;
        this.damage = damage;
        this.type = type;
    }

    public void displayInfo() {
        System.out.println("Soldier " + this.name + " here." + "Type " + this.type);
    }

    public String makeDamage() {
        return this.name + " deals " + this.damage + " damage.";
    }
}
