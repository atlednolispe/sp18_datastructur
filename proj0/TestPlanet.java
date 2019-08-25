public class TestPlanet {
    private static void printForce(Planet p1, Planet p2) {
        double netForce = p1.calcForceExertedBy(p2);
        System.out.println("The net force between is: " + netForce);
    }

    private static void checkForce() {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");

        printForce(p1, p2);
    }

    public static void main(String[] args) {
        checkForce();
    }
}