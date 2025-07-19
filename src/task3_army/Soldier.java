package task3_army;

public abstract class Soldier {
    protected final String name;
    protected final int damage;
    protected final SoldierType type;
    protected final String rank;

    public Soldier(String name, int damage, SoldierType type, String rank) {
        this.name = name;
        this.damage = damage;
        this.type = type;
        this.rank = rank;
    }

    public void displayInfo() {
        System.out.println("Soldier " + this.name + " here." + "Type " + this.type);
    }

    public void makeDamage() {
        System.out.println(this.rank + " " + this.name + " deals " + this.damage + " damage.");
    }
}
