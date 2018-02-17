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
            Path tempPath = walkPath(matrix, rows, columns, i, Library.FIRST_ARRAY_ELEMENT, 0, currentPath);
            if (lowestPath == null || (lowestPath.getCost() > tempPath.getCost())) {
                lowestPath = tempPath;
            }
        }
        return lowestPath.toString();
    }

    private static Path walkPath(int [][] matrix, int rows, int columns,  int row, int column, int cost, Path currentPath) {
        if ((currentPath.getCost() + cost) >= Library.MAX_COST ) {
            currentPath.setComplete(false);
            return currentPath;
        } else if (column == (columns - 1)) {
            currentPath.addStep(column + 1);
            currentPath.setCost(currentPath.getCost() + cost);
            currentPath.setComplete(true);
            return currentPath;
        } else {
            if ((column == Library.FIRST_ARRAY_ELEMENT) ) {
                currentPath.setCost(matrix[Library.FIRST_ARRAY_ELEMENT][Library.FIRST_ARRAY_ELEMENT]);
            } else {
                currentPath.setCost(currentPath.getCost() + cost);
            }
            currentPath.addStep(row + 1);
            int nextColumn = column + 1;
            int nRow = 0;
            int nCost = 0;
            if (row == Library.FIRST_ARRAY_ELEMENT) {
                int nextRow = row + 1;
                if (matrix[row][nextColumn] <= matrix[nextRow][nextColumn]) {
                    nRow = row;
                    nCost = matrix[row][nextColumn];
                } else if (matrix[row][nextColumn] > matrix[nextRow][nextColumn]) {
                    nRow = nextRow;
                    nCost = matrix[nextRow][nextColumn];
                }
            } else if (row == (rows -1)) {
                ArrayList<StoreData> data = new ArrayList<>();
                int prevRow = row - 1;
                int nextRow = Library.FIRST_ARRAY_ELEMENT;
                data.add(new StoreData(prevRow, matrix[prevRow][nextColumn]));
                data.add(new StoreData(row, matrix[row][nextColumn]));
                data.add(new StoreData(nextRow, matrix[nextRow][nextColumn]));
                int tempCost = 0;
                for (int i = 0; i<data.size(); i++) {
                    if (i == 0) {
                        tempCost = data.get(i).getCost();
                        nRow = data.get(i).getRow();
                    } else {
                        if (tempCost > data.get(i).getCost()) {
                            tempCost = data.get(i).getCost();
                            nRow = data.get(i).getRow();
                        }
                    }
                }
            } else {
                ArrayList<StoreData> data = new ArrayList<>();
                int prevRow = row - 1;
                int nextRow = row + 1;
                data.add(new StoreData(prevRow, matrix[prevRow][nextColumn]));
                data.add(new StoreData(row, matrix[row][nextColumn]));
                data.add(new StoreData(nextRow, matrix[nextRow][nextColumn]));
                int tempCost = 0;
                for (int i = 0; i<data.size(); i++) {
                    if (i == 0) {
                        tempCost = data.get(i).getCost();
                        nRow = data.get(i).getRow();
                    } else {
                        if (tempCost > data.get(i).getCost()) {
                            tempCost = data.get(i).getCost();
                            nRow = data.get(i).getRow();
                        }
                    }
                }
            }
            return walkPath(matrix, rows, columns, nRow, nextColumn, nCost, currentPath);
        }
    }
}
