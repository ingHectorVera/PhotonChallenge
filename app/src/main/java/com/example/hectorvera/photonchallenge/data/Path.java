package com.example.hectorvera.photonchallenge.data;

import java.util.ArrayList;

public class Path {
    private int cost;
    private ArrayList<Integer> steps;
    private boolean isComplete;

    public Path() {
        cost = 0;
        steps = new ArrayList<>();
        isComplete = false;
    }

    public int getCost() { return this.cost;}

    public void setCost(int cost) {this.cost = cost;}

    public boolean isComplete() {return this.isComplete;}

    public void setComplete(boolean isComplete) { this.isComplete = isComplete;}

    public ArrayList<Integer> getSteps() { return steps; }

    public void setSteps(ArrayList<Integer> steps) { this.steps = steps; }

    public String toString() {
        StringBuilder sSteps = new StringBuilder();
        for (int i = 0; i < steps.size(); i++) {
            sSteps.append(steps.get(i));
            if (i != (steps.size() - 1)) {
                sSteps.append(" ");
            }
        }
        return (isComplete) ? "Yes,":"No," +
                cost + ","+sSteps.toString();
    }
}
