package model;

import java.util.LinkedList;

public class Snake {
    private final LinkedList<Point> body = new LinkedList<>();
    private Direction direction;

    public Snake(Point start, Direction dir) {
        body.add(start);
        this.direction = dir;
    }

    public Point getHead() {
        return body.getFirst();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction d) {
        this.direction = d;
    }

    public boolean isOnBody(Point p) {
        return body.contains(p);
    }

    public boolean isCollidingWithItself() {
        Point head = getHead();
        return body.stream().skip(1).anyMatch(p -> p.equals(head));
    }
}
