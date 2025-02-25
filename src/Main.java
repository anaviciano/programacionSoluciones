package tema6;

public class Main {
    public static void main(String[] args) {

        Hero hero = new Hero("John", 100);
        Enemy enemy = new Enemy(100, 100);
        hero.attack(enemy);
        enemy.attack(hero);
    }
}