
public class Calculator {
    public int add(int a, int b) {
        DataManager dataManager = new DataManager();
        dataManager.saveData("Resultado: " + (a + b));
        return a + b;
    }
}