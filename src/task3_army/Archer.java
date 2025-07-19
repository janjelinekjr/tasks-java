package task3_army;

public class Archer extends Soldier {
    public Archer(String name, int damage) {
        super(name, damage, SoldierType.DEFENSIVE, "Archer");
    }

    public void fireDefense() {
        System.out.println(super.rank + " " + super.name + " in fire defense.");
        super.makeDamage();
    }
}
