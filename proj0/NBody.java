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
            String imgFileName = in.readString();
            planets[index] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            index += 1;
        }
        return planets;
    }
}