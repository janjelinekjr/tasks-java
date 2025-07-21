package task3_army;

import task3_army.interfaces.Attack;
import task3_army.interfaces.Defense;

public class Swordsman extends Soldier implements Defense, Attack {
    public Swordsman(String name, int damage) {
        super(name, damage, SoldierType.ADAPTABLE);
    }

    public void goShortDistanceAttack() {
        System.out.println("Swordsman " + " " + super.name + " is in short distance attack.");
        System.out.println("Swordsman " + super.makeDamage());
    }

    @Override
    public void makeAttack() {
        System.out.println("Swordsman " + super.makeDamage());
    }

    @Override
    public void makeDefense() {
        System.out.println("Swordsman " + super.makeDamage());
    }
}
