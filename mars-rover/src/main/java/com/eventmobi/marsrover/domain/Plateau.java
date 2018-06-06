/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventmobi.marsrover.domain;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cy81
 */
public class Plateau {

    public Plateau(Dimension dimension) {
        this.dimension = dimension;
    }

    public Plateau(int width, int height) {
        this.dimension = new Dimension(width, height);
    }

    public Rover getRover(String name) {
        return rovers.get(name);
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void addRover(Rover newRover) {
        
        long collisions = orderedRovers.stream().filter(r -> r.getX() == newRover.getX() && r.getY() == newRover.getY()).count();
        if(collisions == 0){        
            rovers.put(newRover.getName(), newRover);
            orderedRovers.add(newRover);
        }
    }

    public int getWidth() {
        return dimension.width;
    }

    public int getHeight() {
        return dimension.height;
    }

    public boolean isValidMove(Rover movingRover,int x, int y){
        long collisions = orderedRovers.stream().filter(r -> r.getX() == x && r.getY() == y).count();
        return collisions == 0;
    }
    
    public String getState(){
        String result = "";
        result = orderedRovers.stream().map(r -> r.toString()).reduce(result, String::concat);
        return result;
    }
    private Map<String, Rover> rovers = new HashMap<>();

    private List<Rover> orderedRovers = new ArrayList<>();

    private Dimension dimension;
}
