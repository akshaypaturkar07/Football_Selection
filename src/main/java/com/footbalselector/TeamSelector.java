package com.footbalselector;

import java.util.*;
import java.util.stream.Collectors;


public class TeamSelector {
    private static final int minGoalsScored = 30;
    private static final int minGoalsDefended = 50;
    private static final double minHeight = 5.8;
    private static final int maxWeight = 80;

    public static void main(String[] args) {
        selectTeam(PlayerDetails.getPlayers()).forEach(a -> System.out.println(a));
    }

    private static List<List<String>> selectTeam(List<PlayerDetails> input) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> tempMap = new HashMap<>();
        for (PlayerDetails playerDetails : input) {
            List<String> list = new ArrayList<>();
            if (playerDetails.getWeight() > maxWeight) continue;
            if (playerDetails.getHeight() < minHeight) continue;
            if (playerDetails.getMinGoalDefended() > minGoalsDefended) {
                if (!tempMap.containsKey("DEFENDER")) {
                    list.add(playerDetails.getName() + " SELECT DEFENDER");
                    tempMap.put("DEFENDER", list);
                } else {
                    List<String> tempList = tempMap.get("DEFENDER");
                    tempList.add(playerDetails.getName() + " SELECT DEFENDER");
                    tempMap.put("DEFENDER", tempList);
                }
            } else if (playerDetails.getMinGoalScored() > minGoalsScored) {
                if (!tempMap.containsKey("STRIKER")) {
                    list.add(playerDetails.getName() + " SELECT STRIKER");
                    tempMap.put("STRIKER", list);

                } else {
                    List<String> tempList = tempMap.get("STRIKER");
                    tempList.add(playerDetails.getName() + " SELECT STRIKER");
                    tempMap.put("STRIKER", tempList);
                }
            } else {
                if (!tempMap.containsKey("NA")) {
                    list.add(playerDetails.getName() + " NA");
                    tempMap.put("NA", list);
                } else {
                    List<String> tempList = tempMap.get("NA");
                    tempList.add(playerDetails.getName() + " NA");
                    tempMap.put("NA", tempList);
                }
            }
        }

        if (tempMap.get("STRIKER").size() > tempMap.get("DEFENDER").size()) {
            int size = tempMap.get("STRIKER").size() - tempMap.get("DEFENDER").size();
            modifyMap(tempMap, "STRIKER", size);
            result.add(new ArrayList(tempMap.values()));
            return result;
        } else if (tempMap.get("STRIKER").size() < tempMap.get("DEFENDER").size()) {
            int size = tempMap.get("DEFENDER").size() - tempMap.get("STRIKER").size();
            modifyMap(tempMap, "DEFENDER", size);
            result.add(new ArrayList(tempMap.values()));
            return result;
        } else {
            result.add(new ArrayList(tempMap.values()));
            return result;

        }


    }


    private static Map<String, List<String>> modifyMap(Map<String, List<String>> map, String profile, int size) {
        int start = 0;
        List<String> list = new ArrayList<>();
        while (start < size) {
            String str = map.get(profile).get(start).replace("SELECT " + profile, "NA");
            map.get(profile).remove(start);
            map.get("NA").add(str);
            start++;

        }
        return map;
    }
}
