class Evaluate_Division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++ ){
            List<String> eq = equations.get(i);
            String dvd = eq.get(0), dvr = eq.get(1);
            double val = values[i];
            graph.putIfAbsent(dvd, new HashMap<>());
            graph.get(dvd).put(dvr, val);
            graph.putIfAbsent(dvr, new HashMap<>());
            graph.get(dvr).put(dvd, 1/val);
        }

        double[] result = new double[queries.size()];

        for(int i=0; i<queries.size(); i++){
            List<String> query = queries.get(i);
            String dvd = query.get(0), dvr = query.get(1);
            if(!graph.containsKey(dvd) || !graph.containsKey(dvr))
                result[i] = -1.0;
            else if(dvd == dvr)
                result[i] = 1;
            else{
                Set<String> visited = new HashSet<>();
                result[i] = bt(graph, dvd, dvr, 1, visited);
            }

        }
        return result;

    }

    private double bt(Map<String, Map<String, Double>> graph, String curr, String tar, double prod, Set<String> visited){
        visited.add(curr);
        double res = -1.0;
        Map<String, Double> nbrs = graph.get(curr);
        if(nbrs.containsKey(tar))
            res = prod * nbrs.get(tar);
        else{
            for(Map.Entry<String, Double> nbr : nbrs.entrySet()){
                String next = nbr.getKey();
                if(visited.contains(next))
                    continue;
                else{
                    res = bt(graph, next, tar, prod*nbr.getValue(), visited);
                    if(res != -1.0)
                        break;
                }
            }
        }
        visited.remove(curr);

        return res;
    }
}
