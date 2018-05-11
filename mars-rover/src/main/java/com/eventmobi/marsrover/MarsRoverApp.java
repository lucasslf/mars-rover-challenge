/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventmobi.marsrover;

import java.io.Console;
import java.util.Arrays;

/**
 *
 * @author cy81
 */
public class MarsRoverApp {



    static final String PLATEAU_INSTRUCTION = "Plateau";
    static final String LANDING_INSTRUCTION = "Landing";
    static final String MOVE_ROVER_COMMAND = "M";
    static final String TURN_RIGHT_ROVER_COMMAND = "R";
    static final String TURN_LEFT_ROVER_COMMAND = "L";

   
    public static void handle(String instructionLine) {
        System.out.println(instructionLine);
        String[] instruction = instructionLine.split(":");
        if(instruction.length < 2){
            throw new RuntimeException("Invalid Instruction");
        }
        String command = instruction[0];
        
        String[] arguments = Arrays.copyOfRange(instruction, 1, instruction.length - 1);
        String[] compositeCommand = command.split(" ");
        if (compositeCommand.length == 1) {

        } else {
        }
    }

    public static void main(String[] args) {

        
        try {
            Console c = System.console();
            /*
             if (plateauDimensions.length != 2) {
             throw new RuntimeException("Bad command format");
             }
             int width = Integer.parseInt(plateauDimensions[0]);
             int height = Integer.parseInt(plateauDimensions[1]);
             */

            for (String instructionLine = c.readLine(); !"".equals(instructionLine);instructionLine = c.readLine()) {

                handle(instructionLine);
                /*
                 if (instruction.length == 3) {
                 int x = Integer.parseInt(instruction[0]);
                 int y = Integer.parseInt(instruction[1]);
                 if (x > width || y > height || x < 0 || y < 0) {
                 throw new RuntimeException("Bad Rover Position");
                 }
                 Rover r = new Rover(x, y, instruction[2]);

                 }*/
            }

        } catch (NumberFormatException ex) {
            throw new RuntimeException("Bad number input");
        }
    }

}
