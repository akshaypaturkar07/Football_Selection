package com.footbalselector;

import java.util.ArrayList;
import java.util.List;

public class PlayerDetails {
    private String name;
    private double height;
    private int weight;
    private int minGoalScored;

    public PlayerDetails(String name, double height, int weight, int minGoalScored, int minGoalDefended) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.minGoalScored = minGoalScored;
        this.minGoalDefended = minGoalDefended;
    }

    public static List<PlayerDetails> getPlayers() {
        List<PlayerDetails> playerDetails = new ArrayList<>();
        playerDetails.add(new PlayerDetails("avis", 6.0, 65, 35, 4));
        playerDetails.add(new PlayerDetails("tema", 6.2, 67, 0, 70));
        playerDetails.add(new PlayerDetails("ulispa", 7.0, 56, 80, 7));
        playerDetails.add(new PlayerDetails("rikey", 6.3, 67, 5, 80));
        playerDetails.add(new PlayerDetails("steven", 7.0, 56, 80, 7));
        playerDetails.add(new PlayerDetails("sprite", 6.3, 67, 50, 80));
        return playerDetails;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMinGoalScored() {
        return minGoalScored;
    }

    public void setMinGoalScored(int minGoalScored) {
        this.minGoalScored = minGoalScored;
    }

    public int getMinGoalDefended() {
        return minGoalDefended;
    }

    public void setMinGoalDefended(int minGoalDefended) {
        this.minGoalDefended = minGoalDefended;
    }

    private int minGoalDefended;

    @Override
    public String toString() {
        return "com.footbalselector.PlayerDetails{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", minGoalScored=" + minGoalScored +
                ", minGoalDefended=" + minGoalDefended +
                '}';
    }
}
