package tema6;

public class Hero extends Entity {
    public Hero(String n, int h) {
        super(n);
        //this.name = n;
        this.health = h;
        this.damage = 10;
    }
    public Hero(){
        this("default", 100);
    }
    @Override
    public void attack(Entity entity)
    {
        System.out.println("Este ataque es de la clase Hero");
        entity.health -= this.damage;
    }
}
