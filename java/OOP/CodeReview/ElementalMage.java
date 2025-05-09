public class ElementalMage extends Champion implements IHealthBottleBearer, IManaBottleBearer {

    int mana = 100;
    private boolean pickedUpManaBottle = false;
    private boolean pickedUpHealthBottle = false;

    public ElementalMage(String name) {
        super(name, 80, 10);
        this.mana = 100;
    }

    @Override
    public void attack(Champion target) {
        super.attack(target);
    }

    @Override
    public void useAbility() {
        System.out.println("ElementalMage " + name + " is preparing to cast a Fireball.");
    }

    @Override
    public void die() {
        System.out.println("ElementalMage " + name + " has been defeated.");
    }

    public void castFireball(Champion target) {
        if (mana >= 30) {
            int damage = attackDamage * 3;
            target.health -= damage;
            mana -= 30;
            System.out.println(
                    "ElementalMage " + name + " casts Fireball on " + target.name + " for " + damage + " damage!");
            System.out.println(name + "'s mana is now " + mana + ".");
        } else {
            System.out.println("Not enough mana to cast Fireball!");
        }
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
            System.out.println("ElementalMage " + name
                    + " used a health bottle and recovered 20 health. Health is now: " + this.health);
        } else {
            System.out.println("ElementalMage " + name + " does not have a health bottle.");
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

    @Override
    public void pickUpManaBottle() {
        this.pickedUpManaBottle = true;
    }

    @Override
    public void useManaBottle() {
        if (pickedUpManaBottle) {
            this.mana += 40;
            pickedUpManaBottle = false;
            System.out.println(
                    "ElementalMage " + name + " used a mana bottle and recovered 40 mana. Mana is now: " + this.mana);
        } else {
            System.out.println("ElementalMage " + name + " does not have a mana bottle.");
        }
    }

    @Override
    public boolean isPickedUpManaBottle() {
        return pickedUpManaBottle;
    }

    @Override
    public void setPickedUpManaBottle(boolean value) {
        this.pickedUpManaBottle = value;
    }
}
