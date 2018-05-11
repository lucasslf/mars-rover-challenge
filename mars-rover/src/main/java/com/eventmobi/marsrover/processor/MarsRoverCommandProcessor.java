/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventmobi.marsrover.processor;

import com.eventmobi.marsrover.domain.Rover;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cy81
 */
public class MarsRoverCommandProcessor {

    static final String PLATEAU_INSTRUCTION = "Plateau";
    static final String LANDING_INSTRUCTION = "Landing";
    static final String INSTRUCTIONS_INSTRUCTION = "Instructions";
    static final char MOVE_ROVER_COMMAND = 'M';
    static final char TURN_RIGHT_ROVER_COMMAND = 'R';
    static final char TURN_LEFT_ROVER_COMMAND = 'L';

    Dimension plateau;

    Map<String, Rover> rovers = new HashMap<>();
    
    List<Rover> orderedRovers = new ArrayList<>();

    public void process(String instructionLine) {

        String[] instruction = instructionLine.split(":");

        if (instruction.length < 2) {
            throw new RuntimeException("Invalid Instruction");
        }

        String command = instruction[0];

        String[] arguments = instruction[1].split(" ");

        processCommand(command, arguments);

    }

    private void processRoverInstructions(Rover r, String roverInstructions) {
        roverInstructions.chars().forEach(c -> {
            switch (c) {
                case MOVE_ROVER_COMMAND:
                    r.move();
                    break;
                case TURN_LEFT_ROVER_COMMAND:
                    r.turnLeft();
                    break;
                case TURN_RIGHT_ROVER_COMMAND:
                    r.turnRight();
                    break;
            }
        });
    }

    private void processCommand(String command, String[] args) {
        if (plateau == null) {
            if (PLATEAU_INSTRUCTION.equals(command)) {
                int width = Integer.parseInt(args[0]) + 1;
                int height = Integer.parseInt(args[1]) + 1;
                plateau = new Dimension(width, height);
            }else{
                throw new RuntimeException("First instruction must be Plateau creation");
            }
        } else {
            String[] commandParts = command.split(" ");
            String cmd = commandParts[1];
            String roverName = commandParts[0];
            switch (cmd) {
                case LANDING_INSTRUCTION:
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[1]);
                    Rover r = new Rover(roverName,x, y, Rover.getHeadingFromCode(args[2]), plateau);
                    rovers.put(roverName, r);
                    orderedRovers.add(r);
                    break;
                case INSTRUCTIONS_INSTRUCTION:
                    processRoverInstructions(rovers.get(roverName), args[0]);
                    break;
                default:
                    throw new RuntimeException("Unknown instruction "+cmd);
            }

        }

    }
    
    public String getState(){
        String result = "";
        result = orderedRovers.stream().map(r -> r.toString()).reduce(result, String::concat);
        return result;
    }
}
