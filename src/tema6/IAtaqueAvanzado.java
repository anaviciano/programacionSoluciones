package tema6;

public interface IAtaqueAvanzado {
    void lanzar();
    int[] coste(); // Devuelve un array con el coste en maná y esfuerzo físico
    int[] danoInfligido(); // Devuelve un array con el daño mágico y físico
}
