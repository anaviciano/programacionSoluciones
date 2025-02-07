package tema5;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Uso excepciones");

        PersonaPF p = new PersonaPF("Juan", 20);


        //1era opción
        System.out.println(p.getEdad());
        p.setEdad(-1);
        System.out.println(p.getEdad());
        p.setEdad(32);
        System.out.println(p.getEdad());



        /*
        //2nda opción
        try {
            System.out.println("Uso excepciones");
            PersonaPF p = new PersonaPF("Juan", 20);
            PersonaPF p1 = new PersonaPF("ana", -1);

            System.out.println(p.getEdad());
            p.setEdad(-1);
            System.out.println(p.getEdad());
            p.setEdad(32);
            System.out.println(p.getEdad());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

         */
/*
        //3era opción
        try {
            System.out.println(p.getEdad());
            p.setEdad(-1); // Esto lanzará una excepción
        } catch (Exception e) {
            System.out.println("Error al establecer la edad: " + e.getMessage());
        }

        try {
            System.out.println(p.getEdad());
            p.setEdad(32); // Esto no lanzará una excepción
            System.out.println(p.getEdad());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al establecer la edad: " + e.getMessage());
        }

 */
    }

}
