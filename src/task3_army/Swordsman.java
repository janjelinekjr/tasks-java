package task3_army;

public class Swordsman extends Soldier {
    public Swordsman(String name, int damage) {
        super(name, damage, SoldierType.ADAPTABLE, "Swordsman");
    }

    public void goShortDistanceAttack() {
        System.out.println(super.rank + " " + super.name + " is in short distance attack.");
        super.makeDamage();
    }
}
