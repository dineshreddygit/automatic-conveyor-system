
package com.dinesh.test.automaticconveyorsystem;

import com.dinesh.test.automaticconveyorsystem.model.GraphMap;
import com.dinesh.test.automaticconveyorsystem.model.GraphMapException;
import com.dinesh.test.automaticconveyorsystem.model.Direction;
import com.dinesh.test.automaticconveyorsystem.model.point;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AlgorithmImpl implements Algorithm {

    private final static String SINGLE_WHITE_SPACE=" ";

    Map<String, GraphMap> visitedMap=new ConcurrentHashMap<>();

    @Override
    public String findShortestPath(String entryGate, String destGate, List<Direction> directions) {
        GraphMap GraphMap;
        if(visitedMap.containsKey(entryGate)){
            GraphMap = visitedMap.get(entryGate);
        }else {
            GraphMap = new GraphMap(directions);
            GraphMap.point(entryGate);
            visitedMap.put(entryGate,GraphMap);
        }

        List<Point> shortestPath= GraphMap.getShortestPath(destGate);
        return generatePathLine(shortestPath);
    }

    private String generatePathLine(List<Point> path){
        StringBuffer line = new StringBuffer();

        for(Point point:path){
            line.append(point.getName()).append(SINGLE_WHITE_SPACE);
        }
        line.append(": ").append(path.get(path.size()-1).getTime());
        return line.toString();
    }

}
