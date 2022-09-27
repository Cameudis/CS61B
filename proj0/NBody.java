class NBody {
    public static void main(String args[]) {
        // read data
        if (args.length < 3) {
            System.out.println("Command line arguments < 3!");
            return;
        }

        double T, dt;
        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);

        String filename;
        filename = args[2];

        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        // draw the background
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.show();

        // draw the planet
        planets[0].draw();
    }

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