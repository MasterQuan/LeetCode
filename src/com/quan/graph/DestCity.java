package com.quan.graph;

import java.util.*;

public class DestCity {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Boolean> graph = new HashMap<String, Boolean>();
        for (List<String> path : paths) {
            graph.put(path.get(0), true);
            if (!graph.containsKey(path.get(1))){
                graph.put(path.get(1), false);
            }
        }

        String dest = null;
        for (Map.Entry<String, Boolean> entry : graph.entrySet()) {
            if (!entry.getValue()){
                dest = entry.getKey();break;
            }
        }
        return dest;
    }

    public String destCity2(List<List<String>> paths) {
        Set<String> starts = new HashSet<>();
        Set<String> dests = new HashSet<>();
        for (List<String> path:paths) {
            starts.add(path.get(0));
            dests.add(path.get(1));
        }
        dests.removeAll(starts);
        String dest = null;
        for (String d : dests) {
            dest = d;
            break;
        }
        return dest;
    }
}
