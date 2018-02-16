package com.example.hectorvera.photonchallenge.model;

import com.example.hectorvera.photonchallenge.Library;
import com.example.hectorvera.photonchallenge.data.Path;

import java.util.ArrayList;

public class PathSeeker {
    private static final String TAG = "DEBUG_PATH_SEEKER";
    //private static ArrayList<Path> paths = new ArrayList<>();

    public static String seekPath(int [][] matrix) {
        int rows = matrix.length;
        int columns = matrix[Library.FIRST_ARRAY_ELEMENT].length;
        Path lowestPath = null;
        for ( int i = 0; i < rows; i++) {
            Path tempPath = walkPath(matrix, rows, columns, i);
            if (lowestPath == null || (lowestPath.getCost() > tempPath.getCost())) {
                lowestPath = tempPath;
            }
        }
        return lowestPath.toString();
    }

    private static Path walkPath(int [][] matrix, int rows, int columns,  int column) {
        Path currentPath = new Path();
        return null;
    }
}
