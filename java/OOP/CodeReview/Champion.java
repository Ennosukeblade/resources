public abstract class Champion {
    String name;
    int health;
    int attackDamage;
    boolean pickedUpHealthBottle = false;

    public Champion(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public void attack(Champion target) {
        if (target.isDead()) {
            System.out.println("Target " + target.name + " is already defeated.");
            return;
        }
        target.health -= attackDamage;
        System.out.println(name + " attacked " + target.name + " for " + attackDamage + " damage.");
        System.out.println(target.name + "'s health is now " + target.health + ".");
    }

    public abstract void useAbility();

    public abstract void die();

    public boolean isDead() {
        return health <= 0;
    }
}