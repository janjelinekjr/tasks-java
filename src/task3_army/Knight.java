package task3_army;

import task3_army.interfaces.Attack;

public class Knight extends Soldier implements Attack {
    public Knight(String name, int damage) {
        super(name, damage, SoldierType.OFFENSIVE);
    }

    public void flank() {
        System.out.println("Knight " + " " + super.name + " is flanking.");
    }

    @Override
    public void makeAttack() {
        System.out.println("Knight " + super.makeDamage());
    }
}
