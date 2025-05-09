public class BladeMaster extends Champion implements IHealthBottleBearer {
    boolean rage = false;
    int rageTurns = 0;
    private boolean pickedUpHealthBottle = false;

    public BladeMaster(String name) {
        super(name, 100, 20);
        this.rage = false;
        this.rageTurns = 0;
    }

    @Override
    public void attack(Champion target) {
        if (target.isDead()) {
            System.out.println("Target " + target.name + " is already defeated.");
            return;
        }

        int damage = attackDamage;
        if (rage) {
            damage *= 2;
        }

        target.health -= damage;
        System.out.println(name + " attacked " + target.name + " for " + damage + " damage.");
        System.out.println(target.name + "'s health is now " + target.health + ".");

        rageTurns--;
        if (rageTurns == 0) {
            rage = false;
            System.out.println("BladeMaster " + name + "'s rage has faded.");
        }
    }

    @Override
    public void useAbility() {
        if (!rage) {
            rage = true;
            rageTurns = 2;
            System.out.println("BladeMaster " + name + " has entered rage mode!");
        }
    }

    @Override
    public void die() {
        System.out.println("BladeMaster " + name + " has fallen in battle.");
    }

    @Override
    public void pickUpHealthBottle() {
        this.pickedUpHealthBottle = true;
    }

    @Override
    public void useHealthBottle() {
        if (pickedUpHealthBottle) {
            this.health += 20;
            pickedUpHealthBottle = false;
            System.out.println("BladeMaster " + name + " used a health bottle and recovered 20 health. Health is now: "
                    + this.health);
        } else {
            System.out.println("BladeMaster " + name + " does not have a health bottle.");
        }
    }

    @Override
    public boolean isPickedUpHealthBottle() {
        return pickedUpHealthBottle;
    }

    @Override
    public void setPickedUpHealthBottle(boolean value) {
        this.pickedUpHealthBottle = value;
    }
}
