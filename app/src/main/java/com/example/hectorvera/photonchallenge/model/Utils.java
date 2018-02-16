package com.example.hectorvera.photonchallenge.model;

public class Utils {

    public static int[][] convertStringToIntArray(String matix) {

        return  null;
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
