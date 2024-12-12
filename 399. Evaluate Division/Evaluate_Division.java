class Evaluate_Division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Pair<String, Double>> dsu = new HashMap<>();
        for(int i=0; i< equations.size(); i++){
            String dvd = equations.get(i).get(0);
            String dvr = equations.get(i).get(1);
            Double val = values[i];
            union(dsu, dvd, dvr, val);
        }

        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            List<String> qur = queries.get(i);
            String dvd = qur.get(0), dvr = qur.get(1);
            if(!dsu.containsKey(dvd) || !dsu.containsKey(dvr))
                res[i] = -1.0;
            else{
                Pair<String, Double> dvdPr = find(dsu, dvd);
                Pair<String, Double> dvrPr = find(dsu, dvr);
                if(dvdPr.getKey() != dvrPr.getKey())
                    res[i] = -1.0;
                else
                    res[i] = dvdPr.getValue()/dvrPr.getValue();

            }
        }
        return res;

    }
    private Pair<String, Double> find(Map<String, Pair<String, Double>> dsu, String node){
        dsu.putIfAbsent(node, new Pair<>(node, 1.0));
        Pair<String, Double> curr = dsu.get(node);
        if(curr.getKey() != node){
            Pair<String, Double> par = find(dsu, curr.getKey());
            dsu.put(node, new Pair<>(par.getKey(), curr.getValue() * par.getValue()));
        }
        return dsu.get(node);
    }

    private void union(Map<String, Pair<String, Double>> dsu, String dvd, String dvr, Double val){
        Pair<String,Double> dvdPair = find(dsu, dvd);
        Pair<String,Double> dvrPair = find(dsu, dvr);
        String dvdGid = dvdPair.getKey();
        String dvrGid = dvrPair.getKey();
        Double dvrValue = dvrPair.getValue();
        Double dvdValue = dvdPair.getValue();
        if(dvdGid != dvrGid){
            dsu.put(dvdGid, new Pair<>(dvrGid, dvrValue * val / dvdValue));
        }

    }






    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
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
