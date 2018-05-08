
public class Planet {
    public double xxPos;       // Its current x position
    public double yyPos;       // Its current y position
    public double xxVel;       // Its current velocity in the x direction
    public double yyVel;       // Its current velocity in the y direction
    public double mass;        // Its mass
    public String imgFileName; // The name of the file that corresponds to the image that depicts the planet 

    static final double G = 6.67e-11;

    // two Planet constructors that can initialize an instance of the Planet class
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    //  calculates the distance between two Planets
    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        return r;
    }

    // takes in a planet, and returns a double describing the force exerted on this planet by the given planet.
    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        double f = G * this.mass * p.mass / (r * r);
        return f;
    }

    // these two methods describe the force exerted in the X and Y directions, respectively
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double r = calcDistance(p);
        double f = calcForceExertedBy(p);
        double fX = f * dx / r;
        return fX;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double r = calcDistance(p);
        double f = calcForceExertedBy(p);
        double fY = f * dy / r;
        return fY;
    }

    // take in an array of Planets and calculate the net X and net Y force exerted by all planets in that array upon the current Planet.
    public double calcNetForceExertedByX(Planet[] planets) {
        double netFx = 0;
        for (Planet p: planets) {
            // Running test again, but with array that contains the target planet.
            if (this.xxPos == p.xxPos && this.yyPos == p.yyPos) {
                continue;
            } else {
                netFx += calcForceExertedByX(p);
            }
        }
        return netFx;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double netFy = 0;
        for (Planet p: planets) {
            // Running test again, but with array that contains the target planet.
            if (this.xxPos == p.xxPos && this.yyPos == p.yyPos) {
                continue;
            } else {
                netFy += calcForceExertedByY(p);
            }
        }
        return netFy;
    }

    // a method that determines how much the forces exerted on the planet will cause that planet to accelerate, and the resulting change in the planet’s velocity and position in a small period of time dt
    // For example, samh.update(0.005, 10, 3) would adjust the velocity and position if an x-force of 10 Newtons and a y-force of 3 Newtons were applied for 0.005 seconds
    public Planet update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;
        this.xxPos = this.xxPos + dt * xxVel;
        this.yyPos = this.yyPos + dt * yyVel;
        return this;
    }

    // uses the StdDraw API mentioned above to draw the Planet’s image at the Planet’s position. The draw method should return nothing and take in no parameters.
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }

}