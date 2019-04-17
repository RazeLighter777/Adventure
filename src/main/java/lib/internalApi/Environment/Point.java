package lib.internalApi.Environment;

public class Point {
    int x;
    int y;

    @org.jetbrains.annotations.Contract(value = "null -> false", pure = true)
    public boolean equals(Object o) {
        Point c = (Point) o;
        return c.x == x && c.y == y;
    }

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return Integer.parseInt("" + x + "0" + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}