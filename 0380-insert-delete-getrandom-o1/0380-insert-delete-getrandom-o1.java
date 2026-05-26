class RandomizedSet {
    Map<Integer, Integer> randomMap;
    List<Integer> randomList;
    Random randNo ;

    public RandomizedSet() {
        randomMap = new HashMap();
        randomList = new ArrayList();
        randNo = new Random();    
    }
    
    public boolean insert(int val) {
        if(randomMap.containsKey(val))
            return false;
        randomMap.put(val, randomList.size());
        randomList.add(randomList.size(), val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!randomMap.containsKey(val))
            return false;
        
        int lastElem = randomList.get(randomList.size()-1);
        int idx = randomMap.get(val);
        randomList.set(idx, lastElem);
        randomMap.put(lastElem, idx);
        randomMap.remove(val);
        randomList.remove(randomList.size()-1);
        return true;
    }
    
    public int getRandom() {
        return randomList.get(randNo.nextInt(randomList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */