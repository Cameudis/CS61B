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
        In in_file = new In(filename);

        int num = in_file.readInt();
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        // draw the background
        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.show();

        // animation
        for (double t = 0.0; t <= T; t += dt) {
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for (int i = 0; i < num; i++) {
                double xForce = 0.0;
                double yForce = 0.0;

                for (int j = 0; j < num; j++) {
                    if (j == i) {
                        continue;
                    } else {
                        xForce += planets[i].calcForceExertedByX(planets[j]);
                        yForce += planets[i].calcForceExertedByY(planets[j]);
                    }
                }

                xForces[i] = xForce;
                yForces[i] = yForce;
            }
            for (int i = 0; i < num; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p: planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        // after the animation end
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
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