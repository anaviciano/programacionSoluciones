package tema4;

public class HeroMain {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Superman", 100, 10);
        Hero hero2 = new Hero("Batman", 100, 10);
        System.out.println(hero1);
        System.out.println(hero2);

        while (hero1.getHealth() > 0 && hero2.getHealth() > 0) {
            hero1.attack(hero2);
            hero2.attack(hero1);
            System.out.println(hero1);
            System.out.println(hero2);
        }
    }
}