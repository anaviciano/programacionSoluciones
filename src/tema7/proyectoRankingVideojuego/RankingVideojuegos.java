package tema7.proyectoRankingVideojuego;

import java.io.*;
import java.util.*;

public class RankingVideojuegos {
    private ArrayList<Videojuego> ranking;
    private static final String FICHERO_BINARIO = "resources/ranking.dat";
    private static final String FICHERO_TEXTO = "resources/ranking.txt";
    private static final String FICHERO_ERRORES = "resources/errores.log";

    public RankingVideojuegos() {
        ranking = new ArrayList<>();
    }

    public void anyadirVideojuego(Videojuego videojuego) {
        ranking.add(videojuego);
    }

    public void mostrarRanking() {
        if (ranking.isEmpty()) {
            System.out.println("El ranking está vacío.");
        } else {
            for (Videojuego v : ranking) {
                System.out.println(v);
            }
        }
    }

    public void eliminarVideojuego(String titulo) throws JuegoNoEncontradoException {
        boolean encontrado = false;
        for (Videojuego v : ranking) {
            if (v.getTitulo().equalsIgnoreCase(titulo)) {
                ranking.remove(v);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new JuegoNoEncontradoException("Juego no encontrado: " + titulo);
        }
    }

    public void guardarRanking() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHERO_BINARIO))) {
            out.writeObject(ranking);
        } catch (IOException e) {
            registrarError(e);
        }
    }

    public void cargarRanking() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FICHERO_BINARIO))) {
            ranking = (ArrayList<Videojuego>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            registrarError(e);
        }
    }

    public void exportarRanking() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHERO_TEXTO))) {
            for (Videojuego v : ranking) {
                writer.println(v);
            }
        } catch (IOException e) {
            registrarError(e);
        }
    }

    private void registrarError(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHERO_ERRORES, true))) {
            writer.println(e.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void ordenarPorNota() {
        Collections.sort(ranking, new Comparator<Videojuego>() {
            @Override
            public int compare(Videojuego v1, Videojuego v2) {
                return Integer.compare(v2.getNota(), v1.getNota()); // Orden descendente
            }
        });
    }

    public static void main(String[] args) throws JuegoNoEncontradoException{
        RankingVideojuegos ranking = new RankingVideojuegos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- Ranking de Videojuegos ---");
            System.out.println("1. Añadir videojuego");
            System.out.println("2. Mostrar ranking");
            System.out.println("3. Guardar ranking");
            System.out.println("4. Cargar ranking");
            System.out.println("5. Eliminar videojuego");
            System.out.println("6. Exportar a texto");
            System.out.println("7. Jugar demo");
            System.out.println("8. Ordenar ranking por nota");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de videojuego (1. Físico, 2. Digital): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Plataforma: ");
                    String plataforma = scanner.nextLine();
                    System.out.print("Nota: ");
                    int nota = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    try {
                        if (tipo == 1) {
                            System.out.print("Tienda de compra: ");
                            String tiendaCompra = scanner.nextLine();
                            System.out.print("Estado (nuevo/usado): ");
                            String estado = scanner.nextLine();
                            ranking.anyadirVideojuego(new VideojuegoFisico(titulo, plataforma, nota, tiendaCompra, estado));
                        } else if (tipo == 2) {
                            System.out.print("Tienda online: ");
                            String tiendaOnline = scanner.nextLine();
                            System.out.print("Tamaño en GB: ");
                            double tamanyoGB = scanner.nextDouble();
                            ranking.anyadirVideojuego(new VideojuegoDigital(titulo, plataforma, nota, tiendaOnline, tamanyoGB));
                        }
                    } catch (NotaInvalidaException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, introduce los datos correctamente.");
                        scanner.nextLine(); // Limpiar el buffer
                    }
                    break;
                case 2:
                    ranking.mostrarRanking();
                    break;
                case 3:
                    ranking.guardarRanking();
                    break;
                case 4:
                    ranking.cargarRanking();
                    break;
                case 5:
                    System.out.print("Título del videojuego a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    try {
                        ranking.eliminarVideojuego(tituloEliminar);
                    } catch (JuegoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    ranking.exportarRanking();
                    break;
                case 7:
                    System.out.print("Título del videojuego para jugar demo: ");
                    String tituloDemo = scanner.nextLine();
                    boolean encontrado = false;
                    for (Videojuego v : ranking.ranking) {
                        if (v.getTitulo().equalsIgnoreCase(tituloDemo) && v instanceof IJugable) {
                            ((IJugable) v).jugarDemo();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        throw new JuegoNoEncontradoException("Juego no encontrado o no jugable: " + tituloDemo);
                    }
                    break;
                case 8:
                    ranking.ordenarPorNota();
                    System.out.println("Ranking ordenado por nota.");
                    break;
                // ... (resto de las opciones)

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
