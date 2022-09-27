class NBody {
    public static double readRadius(String file_name) {
        In infile = new In(file_name);
        infile.readInt();
        double radius = infile.readDouble();

        return radius;
    }

    public static Planet[] readPlanets(String file_name) {
        In in_file = new In(file_name);
        int n = in_file.readInt();
        in_file.readDouble();   // throw radius

        Planet[] planets = new Planet[n];
        for (int i = 0; i < n; i++) {
            double xpos, ypos, xvel, yvel, m;
            xpos = in_file.readDouble();
            ypos = in_file.readDouble();
            xvel = in_file.readDouble();
            yvel = in_file.readDouble();
            m    = in_file.readDouble();
            String pname = in_file.readString();
            planets[i] = new Planet(xpos, ypos, xvel, yvel, m, pname);
        }

        return planets;
    }
}