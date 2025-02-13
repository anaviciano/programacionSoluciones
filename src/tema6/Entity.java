package tema6;

public class Entity {
    protected String name;
    protected int health;
    protected int damage;

    //Si no tengo este constructor, debo llamar a super() en las clases hijas
    /*
    public Entity() {
        this.name = "Entity";
        this.health = 0;
        this.damage = 0;
    }

 */
    public Entity(String name) {
        this.name = name;
        this.health = 0;
        this.damage = 0;
    }
    public void attack(Entity other) {
        System.out.println("Este ataque es de la clase Entity");
        other.health -= this.damage;
    }
}
