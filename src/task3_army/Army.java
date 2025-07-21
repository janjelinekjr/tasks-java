package task3_army;

import java.util.List;

public class Army {
    private List<Soldier> soldiers;

    public Army(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public void report() {
        for (Soldier soldier : soldiers) {
            soldier.displayInfo();
        }
    }

    public void flank() {
        for (Soldier soldier : soldiers) {
            if (soldier instanceof Knight) {
                ((Knight) soldier).flank();
            }
        }
    }

    public void fireDefense() {
        for (Soldier soldier : soldiers) {
            if (soldier instanceof Archer) {
                ((Archer) soldier).fireDefense();
            }
        }
    }

    public void shortDistanceAttack() {
        for (Soldier soldier : soldiers) {
            if (soldier instanceof Swordsman) {
                ((Swordsman) soldier).goShortDistanceAttack();
            }
        }
    }
}
