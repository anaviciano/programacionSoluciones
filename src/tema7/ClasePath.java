package tema7;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ClasePath {

    public static void main(String[] args) {

        //STARTSWITH, ENDSWITH
        // create object of Path
        Path path = Paths.get("/Users/anavicianofabregat/intelliJ-workspace/programacionSoluciones");

        // create a string object
        String passedPath = "/Users";

        // call startsWith() to check path object
        // starts with passedPath or not
        boolean check = path.startsWith(passedPath);
        boolean check2 = path.endsWith("programacionSoluciones");

        // print result
        System.out.println("Path starts with \""
                + passedPath + "\" :"
                + check);
        System.out.println("Path ends with \""
                + "programacionSoluciones" + "\" :"
                + check2);

        //GETPARENT
        Path parentPath = path.getParent();
        System.out.println("Parent Path: "
                + parentPath);

        //GETROOT
        // call getRoot() to get root path
        Path root = path.getRoot();

        // print Root Path
        System.out.println("Root Path: "+ root);

        //ITERATOR
        // Creating an iterator
        Iterator<Path> elements= path.iterator();

        // Displaying the values
        System.out.println("The iterator values are: ");
        while (elements.hasNext()) {
            System.out.println(elements.next());
        }

        //TOABSOLUTEPATH
        // call toAbsolutePath() to get absolute path
        Path absPath = path.toAbsolutePath();

        // print absolute path
        System.out.println("Absolute Path: "+ absPath);
    }
}
