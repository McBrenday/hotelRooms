import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class hotelRooms {
    private int hotelArray[][] = new int[7][7];
    private int amount = (int) (Math.random() * 25) + 5;

    public hotelRooms() {
        reset();
        printArray();
        printMostNeighbors();
        
    }
    public void reset() {
        for(int r = 0; r < hotelArray.length; r++) {
            for(int c = 0; c < hotelArray.length; c++) {
                hotelArray[r][c] = 0;
            }
        }
        for(int x = 0; x < amount; x++) {
            int r = (int) (Math.random() * hotelArray.length);
            int c = (int) (Math.random() * hotelArray.length);
            if(hotelArray[r][c] != 1) {
                hotelArray[r][c] = 1;
            }
            else 
                x--;
        }
    }
    public void printArray() {
        for(int r = 0; r < hotelArray.length; r++) {
            for(int c = 0; c < hotelArray.length; c++) {
                System.out.print(hotelArray[r][c]);
            }
            System.out.println();
        }
    }
    public void printMostNeighbors() {
        int row = 0, col = 0, currentCount = 0;
        boolean first = false;
        for(int r = 0; r < hotelArray.length; r++) {
            for(int c = 0; c < hotelArray.length; c++) {

                    if(hotelArray[r][c] == 1) {
                        int cnt = howManyNearby(r, c);
                        if(cnt > currentCount) {
                            row = r; col = c; currentCount = cnt;
                        }
                    }     
            }
        }
        
        System.out.println("row: " +row +" col: " +col +" has the most neighbors ");
    }
    public int howManyNearby(int r, int c) {
        int count = 0;
        if(r-1 >= 0 && hotelArray[r-1][c] == 1)
            count++;
        if( c-1 >= 0 && hotelArray[r][c-1] == 1)
            count++;
        if( c+1 < hotelArray.length && hotelArray[r][c+1] == 1)
            count++;
        if(r+1 < hotelArray.length && hotelArray[r+1][c] == 1 )
            count++; 
        return count;
    }
}