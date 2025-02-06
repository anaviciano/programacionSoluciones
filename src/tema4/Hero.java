package tema4;

public class Hero {
    public static final int POTION_HP = 10;
    public static final int REST_HP = 50;
    public static final int EXPERIENCE_BY_ATTACK = 10;
    public static final int LEVEL_UP_EXPERIENCE = 50;
    private int MAX_HEALTH = 100;

    private String name;
    private int level;
    private int health;
    private int experience;
    private int attack;
    private int defense;

    public Hero(String name, int attack, int defense) {
        this.name = name;
        this.level = 0;
        this.health = MAX_HEALTH;
        this.experience = 0;
        this.attack = attack;
        this.defense = defense;
    }

    public Hero(String name, int attack, int defense, int health) {
        this.name = name;
        this.level = 0;
        this.health = health;
        this.experience = 0;
        this.attack = attack;
        this.defense = defense;
        MAX_HEALTH = health;
    }

    public void drinkPotion() {
        setHealth(health + POTION_HP);
    }

    public void rest() {
        setHealth(health + REST_HP);
    }

    public void attack(Hero otherHero) {
        int damage = Math.max(1, attack - otherHero.defense);
        otherHero.receiveDamage(damage);
        experience += EXPERIENCE_BY_ATTACK;
        levelUp();
    }

    private void levelUp() {
        if (experience >= LEVEL_UP_EXPERIENCE) {
            setLevel(level + 1);
            setHealth(getHealth() + 5);
            setAttack(attack + 1);
            setDefense(defense + 1);
            setExperience(0);
        }
    }

    private void receiveDamage(int damage) {
        setHealth(Math.max(0, health - damage));
    }

    public String toString() {
        return String.format("%s (level %d) %d/%d HP %d XP %d ATK %d DEF", name, level, health, MAX_HEALTH, experience, attack, defense);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        if (health >= 0 && health <= MAX_HEALTH) {
            this.health = health;
        }
    }

    public int getExperience() {
        return experience;
    }

    private void setExperience(int experience) {
        if (experience >= 0) {
            this.experience = experience;
        }
    }

    public int getAttack() {
        return attack;
    }

    private void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }
}

