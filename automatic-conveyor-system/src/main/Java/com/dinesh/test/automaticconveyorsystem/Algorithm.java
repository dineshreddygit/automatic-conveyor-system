package com.dinesh.test.automaticconveyorsystem;

import com.dinesh.test.automaticconveyorsystem.model.Direction;

import java.util.List;

public interface Algorithm {
    public String findShortestPath(String entry,String dest, List<Direction> graphDirection);
}
