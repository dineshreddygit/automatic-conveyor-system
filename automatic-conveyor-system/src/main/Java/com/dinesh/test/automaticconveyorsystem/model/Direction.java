package com.dinesh.test.automaticconveyorsystem.model;

public class Direction {
    private final Point source;
    private final Point destination;
    private final int time;

    public Direction(Point source, Point destination, int time) {
        this.source = source;
        this.destination = destination;
        this.time = time;
    }

    public Direction(String sourceName, String destinationName, Integer time) {
        this.source = new Point(sourceName);
        this.destination = new Point(destinationName);
        this.time = time;
    }

    public Point getSource() {
        return source;
    }

    public Point getDestination() {
        return destination;
    }

    public int getTime() {
        return time;
    }
}
