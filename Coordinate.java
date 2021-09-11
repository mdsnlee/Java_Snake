

class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //same name, but java's smart enough to pick in the one with the correct params

    public Coordinate(Coordinate c) {
        this.x = c.getX();
        this.y = c.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Object obj) {

        if (!(obj instanceof Coordinate)) {
            return false;
        }

        Coordinate other = (Coordinate) obj;
        return (this.getX() == other.getX() && this.getY() == other.getY());
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
