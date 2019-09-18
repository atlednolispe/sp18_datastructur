public class NBody {
    public static int readNumber(String file) {
        In in = new In(file);
        int N = in.readInt();
        return N;
    }

    public static double readRadius(String file) {
        In in = new In(file);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int N = in.readInt();
        double R = in.readDouble();
        Planet[] planets = new Planet[N];
        int index = 0;
        while(index < N) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            // To create an animation, need to add images path to filename
            // String imgFileName = "images/" + in.readString();
            String imgFileName = in.readString();
            planets[index] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            index += 1;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        String starfieldFilePath = "images/starfield.jpg";
        StdDraw.picture(0, 0, starfieldFilePath);
        for (Planet p: planets) {
            p.show();
        }
        StdDraw.show();

        double t = 0;
        while (t < T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            int index = 0;
            for (Planet p: planets) {
                double xForce = p.calcNetForceExertedByX(planets);
                double yForce = p.calcNetForceExertedByY(planets);
                xForces[index] = xForce;
                yForces[index] = yForce;

                index += 1;
            }

            index = 0;
            for (Planet p: planets) {
                p.update(dt, xForces[index], yForces[index]);

                index += 1;
            }

            for (Planet p: planets) {
                p.show();
            }
            StdDraw.show();

            int pauseMilliseconds = 10;
            StdDraw.pause(pauseMilliseconds);

            t += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}