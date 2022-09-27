public class Planet {
    // instance varibles
    public double xxPos;   // position
    public double yyPos;
    public double xxVel;   // velocity
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    // constructor
    public Planet(double xP, double yP, double xV,
        double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    // calculates the distance between two Bodys
    public double calcDistance(Planet b) {
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;

        return Math.sqrt(dx*dx + dy*dy);
    }

    // calculates the force exerted on this body by the given body
    public double calcForceExertedBy(Planet b) {
        double r = this.calcDistance(b);
        return (G * this.mass * b.mass) / (r * r);
    }

    // use calcForceExertedBy() to calculate force exerted in the X direction
    public double calcForceExertedByX(Planet b) {
        double totalForce = this.calcForceExertedBy(b);
        double r = this.calcDistance(b);

        return totalForce * (b.xxPos - this.xxPos) / r;
    }
    // use calcForceExertedBy() to calculate force exerted in the Y direction
    public double calcForceExertedByY(Planet b) {
        double totalForce = this.calcForceExertedBy(b);
        double r = this.calcDistance(b);

        return totalForce * (b.yyPos - this.yyPos) / r;
    }


    // use calcForceExertedBy() to calculate force exerted in the X direction
    public double calcNetForceExertedByX(Planet[] planets) {
        double totalForceX = 0.0;
        for (Planet p: planets) {
            if (this.equals(p)) {
				continue;	
			}
            double f = this.calcForceExertedBy(p);
            double r = this.calcDistance(p);
            totalForceX += f * (p.xxPos - this.xxPos) / r;
        }

        return totalForceX;
    }
    // use calcForceExertedBy() to calculate force exerted in the Y direction
    public double calcNetForceExertedByY(Planet[] planets) {
        double totalForceY = 0.0;
        for (Planet p: planets) {
            if (this.equals(p)) {
				continue;	
			}
            double f = this.calcForceExertedBy(p);
            double r = this.calcDistance(p);
            totalForceY += f * (p.yyPos - this.yyPos) / r;
        }

        return totalForceY;
    }


    // update Velocity and Position according to dt, fx and fy
    public void update(double dt, double fX, double fY){
        xxVel = xxVel + fX / mass * dt;
        yyVel = yyVel + fY / mass * dt;

        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }

    // draw the planet
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
        StdDraw.show();
    }
}