package com.dinesh.test.automaticconveyorsystem.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class GraphMap {
   
    private final Map<String, Point> graphMap;
    public GraphMap(List<Direction> direction) {

        graphMap = new HashMap<>(direction.size());

      
        for (Direction e : direction) {
            if (!graphMap.containsKey(e.getSource().getName())) graphMap.put(e.getSource().getName(), new Point(e.getSource().getName()));
            if (!graphMap.containsKey(e.getDestination().getName())) graphMap.put(e.getDestination().getName(), new Point(e.getDestination().getName()));
        }

        for (Direction e : direction) {
            graphMap.get(e.getSource().getName()).getNeighbours().put(graphMap.get(e.getDestination().getName()), e.getTime());
        }
    }

    public void point(String startName) {
        if (!graphMap.containsKey(startName)) {
            throw new PointGraphMapException("This pointGraphMap does not contain the starting Point named:"+startName);
        }
        final Point source = graphMap.get(startName);
        NavigableSet<Point> queue = new TreeSet<>();

        
        for (Point v : graphMap.values()) {
            v.setPrevPoint( v == source ? source : null);
            v.setTime(v == source ? 0 : Integer.MAX_VALUE);
            queue.add(v);
        }

        point(queue);
    }

    public List<Point> getShortestPath(String endName){
        if (!graphMap.containsKey(endName)) {
            throw new PointGraphMapException("Graph doesn't contain end point : "+endName);
        }

        return graphMap.get(endName).getShortestPathTo();
    }

    private void point(final NavigableSet<Point> que) {
        Point source, neighbour;
        while (!que.isEmpty()) {

            source = que.pollFirst();
            if (source.getTime() == Integer.MAX_VALUE) break;

          
            for (Map.Entry<Point, Integer> a : source.getNeighbours().entrySet()) {
                neighbour = a.getKey();

                final int alternateTime = source.getTime() + a.getValue();
                if (alternateTime < neighbour.getTime()) { 
                    que.remove(neighbour);
                    neighbour.setTime(alternateTime);
                    neighbour.setPrevPoint(source);
                    que.add(neighbour);
                }
            }
        }
    }
}
