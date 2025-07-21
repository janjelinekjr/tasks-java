package task3_army;

import task3_army.interfaces.Defense;

public class Archer extends Soldier implements Defense {
    public Archer(String name, int damage) {
        super(name, damage, SoldierType.DEFENSIVE);
    }

    public void fireDefense() {
        System.out.println("Archer " + " " + super.name + " in fire defense.");
        super.makeDamage();
    }

    @Override
    public void makeDefense() {
        System.out.println("Archer " + super.makeDamage());
    }
}
