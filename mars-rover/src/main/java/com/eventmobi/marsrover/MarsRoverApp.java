/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventmobi.marsrover;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cy81
 */
public class MarsRoverApp {

    private static final Scanner scanner = new Scanner(System.in);

    static final int NORTH = 0xFFFFFFFE;
    static final int WEST =  0xFFFFFEFF;
    static final int SOUTH = 0xFFFEFFFF;
    static final int EAST = 0xFEFFFFFF;
    
    public static void left(int direction) {
        int result = Integer.rotateLeft(direction, 8);
        switch (result) {
            case NORTH:
                System.out.println("N"+result);
                break;
            case EAST:
                System.out.println("E"+result);
                break;
            case SOUTH:
                System.out.println("S"+result);
                break;
            case WEST:
                System.out.println("W"+result);
                break;
                default:
                System.out.println("DEU MERDA"+result);

        }
    }

    public static void main(String[] args) {
        
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] plateauDimensions = scanner.nextLine().split(" ");
            //TODO: Correct input treatment based on Abdul's e-mail
            if (plateauDimensions.length != 2) {
                throw new RuntimeException("Bad command format");
            }
            int width = Integer.parseInt(plateauDimensions[0]);
            int height = Integer.parseInt(plateauDimensions[1]);
            List<Rover> rovers = new ArrayList<>();
            String commandLine = scanner.nextLine();
            while (!"".equals(commandLine)) {

                String[] instruction = commandLine.split(" ");
                if (instruction.length == 3) {
                    int x = Integer.parseInt(instruction[0]);
                    int y = Integer.parseInt(instruction[1]);
                    if (x > width || y > height || x < 0 || y < 0) {
                        throw new RuntimeException("Bad Rover Position");
                    }
                    Rover r = new Rover(x, y, instruction[2]);

                }
                commandLine = scanner.nextLine();
            }

            //Writes result
            bufferedWriter.write("");

            bufferedWriter.close();

            scanner.close();
        } catch (IOException ex) {
            throw new RuntimeException("There was an unexpected error");
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Bad number input");
        }
    }

    static class Rover {

        String heading;
        int x;
        int y;

        public Rover(int x, int y, String heading) {
            this.heading = heading;
            this.x = x;
            this.y = y;
        }

    }
}
