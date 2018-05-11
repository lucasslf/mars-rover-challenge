/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventmobi.marsrover;

import com.eventmobi.marsrover.processor.MarsRoverCommandProcessor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author cy81
 */
public class MarsRoverApp {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            MarsRoverCommandProcessor commandProcessor = new MarsRoverCommandProcessor();
            for (String instructionLine = reader.readLine(); !"".equals(instructionLine); instructionLine = reader.readLine()) {
                commandProcessor.process(instructionLine);
            }
            System.out.println(commandProcessor.getState());
        } catch (IOException ex) {
            throw new RuntimeException("Unexpected Error");
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Bad number input");
        }
    }

}
