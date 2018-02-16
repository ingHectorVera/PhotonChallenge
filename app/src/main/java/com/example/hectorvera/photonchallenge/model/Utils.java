package com.example.hectorvera.photonchallenge.model;

import android.util.Log;

import com.example.hectorvera.photonchallenge.Library;


public class Utils {
    private static final String TAG = "DEBUG_Utils ";
    public static int[][] convertStringToIntArray(String matix) {
        String[] rows = matix.split(Library.RETURN_LINE_DELIM);
        int numRows = rows.length;
        int numColumns = rows[Library.FIRST_ARRAY_ELEMENT].split(Library.SPACE_DELIM).length;
        Log.d(TAG, "convertStringToIntArray - numRows: "+ numRows + " numColumns: " + numColumns);
        int [][] iMatrix = new int[numRows][numColumns];
        for (int i = 0; i<numRows; i++) {
            String [] sColumn = rows[i].split(Library.SPACE_DELIM);
            for (int j=0; j < sColumn.length; j++){
                iMatrix[i][j] = Integer.parseInt(sColumn[j]);
                Log.d(TAG, "convertStringToIntArray - element i: "+i+" j: " +j+" : "+ iMatrix[i][j]);
            }
        }
        return  iMatrix;
    }

    public static String printIntArray(int [][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                builder.append(matrix[i][j]);
                if (j == (matrix[i].length -1)) {
                    builder.append("\n");
                } else {
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }

}
