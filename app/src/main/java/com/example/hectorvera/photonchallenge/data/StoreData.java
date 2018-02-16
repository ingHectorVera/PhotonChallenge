package com.example.hectorvera.photonchallenge.data;


public class StoreData {

    private int row, cost;

    public StoreData (int row, int cost) {
        this.row = row;
        this.cost = cost;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
