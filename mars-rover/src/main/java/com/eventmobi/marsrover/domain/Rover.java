/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventmobi.marsrover.domain;

import java.awt.Dimension;

/**
 *
 * @author cy81
 */
public class Rover {

    public static final int NORTH = 0xFFFFFFFE;
    public static final int WEST = 0xFFFFFEFF;
    public static final int SOUTH = 0xFFFEFFFF;
    public static final int EAST = 0xFEFFFFFF;

    int heading;
    int x;
    int y;
    Dimension plateau;

    public Rover(int x, int y, int heading, Dimension plateau) {
        this.heading = heading;
        this.x = x;
        this.y = y;
        this.plateau = plateau;
    }

    //What happens when moving out of bounds? Just stop or break?
    public void move() {
        switch (heading) {
            case NORTH:
                if (y < plateau.height) {
                    y++;
                }
                break;
            case SOUTH:
                if (y > 0) {
                    y--;
                }
                break;
            case EAST:
                if (x < plateau.width) {
                    x++;
                }
                break;
            case WEST:
                if (x > 0) {
                    x--;
                }
                break;
        }

    }

    public void turnLeft() {
        this.heading = Integer.rotateLeft(this.heading, 8);
    }

    public void turnRight() {
        this.heading = Integer.rotateRight(this.heading, 8);
    }

    public int getHeading() {
        return heading;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
