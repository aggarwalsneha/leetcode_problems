class UndergroundSystem {
    Map<Integer,Pair<String,Integer>> checkIn;
    Map<String,Pair<Double,Integer>> route;
    
    public UndergroundSystem() {
        checkIn=new HashMap<>();
        route=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id,new Pair<>(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String,Integer> in=checkIn.get(id);
        checkIn.remove(id);
        String routeName=in.getKey()+"_"+stationName;
        int time=t-in.getValue();
        Pair<Double,Integer>r=route.getOrDefault(routeName,new Pair<>(0.0,0));
        route.put(routeName,new Pair<>(r.getKey()+time,r.getValue()+1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeName=startStation+"_"+endStation;
        Pair<Double,Integer>trip=route.get(routeName);
        return trip.getKey()/trip.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */