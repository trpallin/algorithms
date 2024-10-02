class Solution {
    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double product, Set<String> visited) {
        visited.add(current);
        if (current.equals(target)) {
            return product;
        }
        Map<String, Double> adjacents = graph.get(current);
        for (Map.Entry<String, Double> entry : adjacents.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();

            if (!visited.contains(key)) {
                double result = dfs(graph, key, target, product * value, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, value);

            graph.putIfAbsent(b, new HashMap<>());
            graph.get(b).put(a, 1 / value);
        }

        double[] results = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);

            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                results[i] = -1.0;
            } else if (c.equals(d)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();

                results[i] = dfs(graph, c, d, 1.0, visited);
            }
        }

        return results;
    }
}