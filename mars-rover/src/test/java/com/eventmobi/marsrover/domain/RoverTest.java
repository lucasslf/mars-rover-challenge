/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventmobi.marsrover.domain;

import java.awt.Dimension;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cy81
 */
public class RoverTest {

    @Test
    public void roverShouldTurnLeft() {
        Dimension plateau = new Dimension(30, 30);
        Rover roverNorth = new Rover("roverNorth",0, 0, Rover.NORTH, plateau);
        Rover roverEast = new Rover("roverEast",0, 0, Rover.EAST, plateau);
        Rover roverSouth = new Rover("roverSouth",0, 0, Rover.SOUTH, plateau);
        Rover roverWest = new Rover("roverWest",0, 0, Rover.WEST, plateau);
        roverNorth.turnLeft();
        roverEast.turnLeft();
        roverSouth.turnLeft();
        roverWest.turnLeft();
        Assert.assertTrue("Rover facing North didn't turn left correctly", roverNorth.getHeading() == Rover.WEST);
        Assert.assertTrue("Rover facing South didn't turn left correctly", roverSouth.getHeading() == Rover.EAST);
        Assert.assertTrue("Rover facing West didn't turn left correctly", roverWest.getHeading() == Rover.SOUTH);
        Assert.assertTrue("Rover facing East didn't turn left correctly", roverEast.getHeading() == Rover.NORTH);

    }

    @Test
    public void roverShouldTurnRight() {
        Dimension plateau = new Dimension(30, 30);
        Rover roverNorth = new Rover("roverNorth",0, 0, Rover.NORTH, plateau);
        Rover roverEast = new Rover("roverEast",0, 0, Rover.EAST, plateau);
        Rover roverSouth = new Rover("roverSouth",0, 0, Rover.SOUTH, plateau);
        Rover roverWest = new Rover("roverWest",0, 0, Rover.WEST, plateau);
        roverNorth.turnRight();
        roverEast.turnRight();
        roverSouth.turnRight();
        roverWest.turnRight();
        Assert.assertTrue("Rover facing North didn't turn right correctly", roverNorth.getHeading() == Rover.EAST);
        Assert.assertTrue("Rover facing South didn't turn right correctly", roverSouth.getHeading() == Rover.WEST);
        Assert.assertTrue("Rover facing West didn't turn right correctly", roverWest.getHeading() == Rover.NORTH);
        Assert.assertTrue("Rover facing East didn't turn right correctly", roverEast.getHeading() == Rover.SOUTH);

    }
    @Test
    public void roverFacingNorthShouldMoveNorth() {
        Dimension plateau = new Dimension(30, 30);
        //x=0 , y=0
        Rover rover = new Rover("Rover1",0, 0, Rover.NORTH, plateau);
        
        //y = y+1
        rover.move();
        Assert.assertTrue("Rover facing North didn't move correctly", rover.getY() == 1);

    }
    @Test
    public void roverFacingSouthShouldMoveSouth() {
        Dimension plateau = new Dimension(30, 30);
        //x=4 , y=4
        Rover rover = new Rover("Rover1",4, 4, Rover.SOUTH, plateau);
        
        //y = y-1
        rover.move();
        Assert.assertTrue("Rover facing South didn't move correctly", rover.getY() == 3);
    }
    @Test
    public void roverFacingEastShouldMoveEast() {
        Dimension plateau = new Dimension(30, 30);
        //x=4 , y=4
        Rover rover = new Rover("Rover1",4, 4, Rover.EAST, plateau);
        
        //x= x+1
        rover.move();
        Assert.assertTrue("Rover facing East didn't move correctly", rover.getX() == 5);
    }
    @Test
    public void roverFacingWestShouldMoveWest() {
        Dimension plateau = new Dimension(30, 30);
        //x=4 , y=4
        Rover rover = new Rover("Rover1",4, 4, Rover.WEST, plateau);
        
        //x = x-1
        rover.move();
        Assert.assertTrue("Rover facing South didn't move correctly", rover.getX() == 3);
    }

}
