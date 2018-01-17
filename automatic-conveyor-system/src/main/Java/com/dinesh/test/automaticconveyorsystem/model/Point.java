package com.dinesh.test.automaticconveyorsystem.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Point implements Comparable<Point>{
    private final String name;
    private int time =Integer.MAX_VALUE;
    private Point prevPoint = null;
    private final Map<Point, Integer> neighbours = new HashMap<>();

    public Point(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrevPoint(Point prevPoint) {
        this.prevPoint = prevPoint;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Point getPrevPoint() {
        return prevPoint;
    }

    public Map<Point, Integer> getNeighbours() {
        return neighbours;
    }

    public int compareTo(Point other)
    {
        if (time == other.time)
            return name.compareTo(other.name);

        return Integer.compare(time, other.time);
    }

    public List<Point> getShortestPathTo()
    {
        List<Point> path = new ArrayList();
        path.add(this);
        Point point=this.getPrevPoint();
        while (point!=null && !path.contains(point)) {
            path.add(point);
            point=point.getPrevPoint();
        }

        Collections.reverse(path);
        return path;
    }

    @Override
    public String toString(){
        return this.name+":"+this.time;
    }
}
