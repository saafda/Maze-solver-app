package MazeSolverProject;

public class Tuple<X, Y> {
    
    private final X x;

    private final Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public boolean compareTo(Tuple<Integer, Integer> tuple) {
        if (this.getX() == tuple.getX() && this.getY() == tuple.getY()) return true;
        else return false;
    }

    public X getX() {
        return this.x;
    }

    public Y getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(i: " + String.valueOf(getX()) + " j: " + String.valueOf(getY() + ")");
    }

    // KILDE: https://stackoverflow.com/questions/2670982/using-pairs-or-2-tuples-in-java

    public static void main(String[] args) {
        Tuple<Integer, Integer> tuple = new Tuple<>(1, 2);
        System.out.println(tuple.toString());
    }
}
