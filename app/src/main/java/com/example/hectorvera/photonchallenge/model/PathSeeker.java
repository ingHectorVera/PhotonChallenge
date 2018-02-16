package com.example.hectorvera.photonchallenge.model;

import com.example.hectorvera.photonchallenge.Library;
import com.example.hectorvera.photonchallenge.data.Path;
import com.example.hectorvera.photonchallenge.data.StoreData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PathSeeker {
    private static final String TAG = "DEBUG_PATH_SEEKER";
    //private static ArrayList<Path> paths = new ArrayList<>();

    public static String seekPath(int [][] matrix) {
        int rows = matrix.length;
        int columns = matrix[Library.FIRST_ARRAY_ELEMENT].length;
        Path lowestPath = null;
        for ( int i = 0; i < rows; i++) {
            Path currentPath = new Path();
            Path tempPath = walkPath(matrix, rows, columns, i, Library.FIRST_ARRAY_ELEMENT, currentPath);
            if (lowestPath == null || (lowestPath.getCost() > tempPath.getCost())) {
                lowestPath = tempPath;
            }
        }
        return lowestPath.toString();
    }

    private static Path walkPath(int [][] matrix, int rows, int columns,  int row, int column, Path currentPath) {
        if (currentPath.getCost() > Library.MAX_COST || column == columns) {
            if (column == columns) {
                currentPath.setComplete(true);
            }
            return currentPath;
        } else {
            int nextRow = 0;
            int prevRow = 0;
            int nRow = 0;
            int nextColumn = column + 1;
            currentPath.setCost(currentPath.getCost() + matrix[row][column]);
            currentPath.addStep(row + 1);
            if (row == Library.FIRST_ARRAY_ELEMENT) {
                nRow = row + 1;
                if (matrix[row][nextColumn] < matrix[nRow][nextColumn]) {
                    nextRow = row;
                } else {
                    nextRow = nRow;
                }
            } else {
                if (row == (rows - 1)) {
                    prevRow = row - 1;
                    nRow = Library.FIRST_ARRAY_ELEMENT;
                } else {
                    prevRow = row -1;
                    nRow = row + 1;
                }
                ArrayList<StoreData> costsData = new ArrayList<>();
                costsData.add(new StoreData(prevRow, matrix[column][prevRow]));
                costsData.add(new StoreData(row, matrix[column][row]));
                costsData.add(new StoreData(nRow, matrix[column][nRow]));
                int cost = 0;
                for (int i =0; i < costsData.size(); i++) {
                    if (i ==0) {
                        cost = costsData.get(i).getCost();
                        nextRow = costsData.get(i).getRow();
                    } else {
                        if (cost > costsData.get(i).getCost()) {
                            cost = costsData.get(i).getCost();
                            nextRow = costsData.get(i).getRow();
                        }
                    }
                }
            }
            return walkPath(matrix,rows,columns,nextRow, nextColumn, currentPath );
        }
    }
}
