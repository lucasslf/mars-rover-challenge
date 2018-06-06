/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventmobi.marsrover.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cy81
 */
public class PlateauTest {

    @Test
    public void shouldNotAllowCollisionOnLanding() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover("Rover1", 1, 1, Rover.NORTH, plateau);
        Rover rover2 = new Rover("Rover2", 1, 1, Rover.NORTH, plateau);

        plateau.addRover(rover1);
        plateau.addRover(rover2);
        Assert.assertTrue("Plateau allowed collision on landing", plateau.getRover("Rover2") == null);

    }

    @Test
    public void shouldVerifyValidMove() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover("Rover1", 1, 1, Rover.NORTH, plateau);
        Rover rover2 = new Rover("Rover2", 1, 0, Rover.NORTH, plateau);
        plateau.addRover(rover1);
        plateau.addRover(rover2);
        Assert.assertFalse("Plateau allowed invalid move",plateau.isValidMove(rover2, 1, 1));
    }
}
