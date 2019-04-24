package lib.internalApi.environment;

public class Point {
    int x;
    int y;

    @org.jetbrains.annotations.Contract(value = "null -> false", pure = true)
    public boolean equals(Object o) {
        Point c = (Point) o;
        return c.x == x && c.y == y;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point add(Point b) {
        return new Point(this.x + b.x, this.y + b.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}