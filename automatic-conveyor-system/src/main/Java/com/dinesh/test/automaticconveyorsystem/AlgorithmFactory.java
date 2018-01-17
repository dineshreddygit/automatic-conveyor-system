package com.dinesh.test.automaticconveyorsystem;

public class AlgorithmFactory {

    public static Algorithm createAlgorithm(){
        return new AlgorithmImpl();
    }
}
