package model;

import java.util.LinkedList;

public class Snake {
    private final LinkedList<Point> body = new LinkedList<>();
    private  Direction direction;

    public Snake(Point start, Direction dir){
        body.add(start);
        this.direction = dir;
    }


    public void setDirection(Direction d) {
        this.direction = d;
    }

    public boolean isOnBody(Point p) {
        return body.contains(p);
    }
}
