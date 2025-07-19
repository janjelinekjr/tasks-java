package task3_army;

public class Knight extends Soldier {
    public Knight(String name, int damage) {
        super(name, damage, SoldierType.OFFENSIVE, "Knight");
    }

    public void flank() {
        System.out.println(super.rank + " " + super.name + " is flanking.");
    }
}
