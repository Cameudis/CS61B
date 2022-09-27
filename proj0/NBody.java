class NBody {
    public static double readRadius(String file_name) {
        In infile = new In(file_name);
        infile.readInt();
        double radius = infile.readDouble();

        return radius;
    }
}