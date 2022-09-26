class Planet {
    // instance varibles
    public double xxPos;   // position
    public double yyPos;
    public double xxVel;   // velocity
    public double yyVel;
    public double mass;
    public String imgFileName;

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

    public double calcDistance(Planet b) {
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;

        return Math.sqrt(dx*dx + dy*dy);
    }

}