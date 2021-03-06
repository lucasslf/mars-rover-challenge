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

    public static int getHeadingFromCode(String heading) {
        switch (heading) {
            case "N":
                return NORTH;
            case "E":
                return EAST;
            case "S":
                return SOUTH;
            case "W":
                return WEST;
        }
        return 0;
    }

    public Rover(String name, int x, int y, int heading, Plateau plateau) {
        this.name = name;
        this.heading = heading;
        this.x = x;
        this.y = y;
        this.plateau = plateau;
    }

    public void move() {
        int nextX = 0;
        int nextY = 0;
        switch (heading) {
            case NORTH:
                if (y < plateau.getHeight() - 1) {
                    nextX = this.getX();
                    nextY = this.getY() + 1;
                    if (plateau.isValidMove(this, nextX, nextY)) {
                        y++;
                    }
                }
                break;
            case SOUTH:
                if (y > 0) {
                    nextX = this.getX();
                    nextY = this.getY() - 1;
                    if (plateau.isValidMove(this, nextX, nextY)) {
                        y--;
                    }
                }
                break;
            case EAST:
                if (x < plateau.getWidth() - 1) {
                    nextX = this.getX() + 1;
                    nextY = this.getY();
                    if (plateau.isValidMove(this, nextX, nextY)) {
                        x++;
                    }
                }
                break;
            case WEST:
                if (x > 0) {
                    nextX = this.getX() - 1;
                    nextY = this.getY();
                    if (plateau.isValidMove(this, nextX, nextY)) {
                        x--;
                    }
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

    public String getHeadingCode() {
        switch (heading) {
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
        }
        return "";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s:%d %d %s\n", name, x, y, getHeadingCode());
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

    private String name;
    private int heading;
    private int x;
    private int y;
    private Plateau plateau;
}
