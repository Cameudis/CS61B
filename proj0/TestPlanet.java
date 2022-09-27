class TestPlanet {
    public static void main(String[] args) {
        Planet p1 = new Planet(0, 0, 0, 0, 100, "NONE");
        Planet p2 = new Planet(1, 0, 0, 0, 100, "NONE");

        System.out.println("p2->p1: " + p1.calcForceExertedByX(p2) + ", " + p1.calcForceExertedByY(p2));
        System.out.println("Total: " + p1.calcForceExertedBy(p2));
    }
}