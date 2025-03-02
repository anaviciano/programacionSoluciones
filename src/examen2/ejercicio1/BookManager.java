package examen2.ejercicio1;

import examen2.ejercicio1.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("(1) Añadir libro");
            System.out.println("(2) Mostrar libro (por ISBN)");
            System.out.println("(3) Modificar género (por ISBN)");
            System.out.println("(4) Encontra libros por autor");
            System.out.println("(5) Salir");
            System.out.print("Selecciona una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Remove \n
            switch (choice) {
                case 1:
                    addBook(library);
                    break;
                case 2:
                    showBookInfo(library);
                    break;
                case 3:
                    modifyBookGenre(library);
                    break;
                case 4:
                    findBooksByAuthor(library);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void addBook(ArrayList<Book> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ISBN:");
        String ISBN = scanner.nextLine();
        System.out.print("Nombre:");
        String name = scanner.nextLine();
        System.out.print("Autor:");
        String author = scanner.nextLine();
        Book book = new Book(ISBN, name, author);
        System.out.print("Páginas:");
        book.setNumPages(scanner.nextInt());
        scanner.nextLine(); // Remove \n
        System.out.println("Género:");
        System.out.println("(1) Tapa dura\n(2) Tapa blanda\n(2) De bolsillo\nEnter Format:");
        Book.Format format = Book.Format.HARDCOVER;;
        switch (scanner.nextInt()) {
            case 2:
                format = Book.Format.SOFTCOVER;
                break;
            case 3:
                format = Book.Format.POCKET;
                break;
        }
        book.setFormat(format);
        library.add(book);
    }

    private static void showBookInfo(ArrayList<Book> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ISBN:");
        String ISBN = scanner.nextLine();
        for (Book book : library) {
            if (book.getISBN().equals(ISBN)) {
                System.out.println(book);
            }
        }
    }

    private static void modifyBookGenre(ArrayList<Book> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ISBN:");
        String ISBN = scanner.nextLine();
        for (Book book : library) {
            if (book.getISBN().equals(ISBN)) {
                System.out.print("Nuevo género:");
                String newGenre = scanner.nextLine();
                book.setGenre(newGenre);
            }
        }
    }

    private static void findBooksByAuthor(ArrayList<Book> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Autor:");
        String author = scanner.nextLine();
        boolean found = false;
        for (Book book : library) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("El autor no tiene libros");
        }
    }
}