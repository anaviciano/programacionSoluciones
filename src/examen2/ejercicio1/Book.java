package examen2.ejercicio1;

class Book {
    private final String ISBN;
    private final String name;
    private final String author;
    private int numPages;
    private String genre;
    private Format format;

    public enum Format {
        HARDCOVER, SOFTCOVER, POCKET
    }
    public Book(String ISBN, String name, String author) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.numPages = 0; // By default
        this.genre = "";
        this.format = Format.HARDCOVER; // Default format
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public int getWeight() {
        int weightPerPage = 2;
        if (format == Format.HARDCOVER) {
            weightPerPage = 20;
        } else if (format == Format.POCKET) {
            weightPerPage = 10;
        }
        return (50 + (numPages * weightPerPage));
    }

    @Override
    public String toString() {
        return "Libro: " + name + ", Autor: " + author + ", Peso: " + getWeight() + " g";
    }
}