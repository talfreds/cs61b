/** NBody is a class that will actually run your simulation. This class will have NO constructor. The goal of this class is to simulate a universe specified in one of the data files. */

public class NBody {

    // Given a file name, it should return a double corresponding to the radius of the universe in that file
    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);

        int n = in.readInt();
        double r = in.readDouble();
        
        return r;
    }

    // Given a file name, it should return an array of Planets corresponding to the planets in the file
    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);

        int n = in.readInt();
        double r = in.readDouble();

        Planet[] planets = new Planet[n];

        for (int i = 0; i < n; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();

            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }

        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int n = planets.length;

        // set the scale so that it matches the radius of the universe
        StdDraw.setScale(-radius, radius);    

        // draw the image starfield.jpg as the background
        String background = "images/starfield.jpg";
        StdDraw.picture(0, 0, background);

        // audio not working.
        String audio = "audio/2001.mid";
        StdAudio.play(audio);

        // Drawing All of the Planets
        for (Planet p: planets) {
            p.draw();
        }

        // graphics technique to prevent flickering in the animation
        StdDraw.enableDoubleBuffering();   
        
        int time = 0;
        while (time < T) {
            // Create an xForces array and yForces array.
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            
            // Calculate the net x and y forces for each planet, storing these in the xForces and yForces arrays respectively.
            for (int i = 0; i < n; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            // Call update on each of the planets. This will update each planet’s position, velocity, and acceleration.
            for (int i = 0; i < n; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // Draw the background image. Draw all of the planets.
            StdDraw.picture(0, 0, background);
            for (Planet p: planets) {
                p.draw();
            }

            // Show the offscreen buffer
            StdDraw.show();

            // Pause the animation for 10 milliseconds
			StdDraw.pause(10);

            // Increase your time variable by dt
            T += dt;
        }

        // When the simulation is over, i.e. when you’ve reached time T, you should print out the final state of the universe in the same format as the input
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}