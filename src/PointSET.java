import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class PointSET {
    private TreeSet<Point2D> points;

    public PointSET() {
        points = new TreeSet<Point2D>();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    public void insert(Point2D p) {
        checkNull(p);
        if (!points.contains(p)) {
            points.add(p);
        }
    }

    public boolean contains(Point2D p) {
        checkNull(p);
        return points.contains(p);
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);

        for (Point2D p : points)
            StdDraw.point(p.x(), p.y());

        StdDraw.show(0);
    }

    public Iterable<Point2D> range(RectHV rect) {
        checkNull(rect);

        List<Point2D> solution = new ArrayList<>();
        for (Point2D point : points) {
            if (rect.contains(point)) {
                solution.add(point);
            }
        }
        return solution;
    }

    public Point2D nearest(Point2D p) {
        checkNull(p);

        Point2D nearestPoint = null;
        for (Point2D point : points) {
            if (nearestPoint == null || point.distanceTo(p) < nearestPoint.distanceTo(p)) {
                nearestPoint = point;
            }
        }
        return nearestPoint;
    }

    private void checkNull(Object obj) {
        if (obj == null) throw new NullPointerException();
    }
}
