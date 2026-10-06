class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> nums;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        // get the index value mapped to the val
        // assume {0:0, 1:1, 2:2} val = 0 -> 0:0
        int index = map.get(val);
        // get the value of the last element in nums
        // assume [0,1,2] -> we get 2
        int last = nums.get(nums.size() - 1);
        // update the index of last to the index of val
        // assume: {2:2} --> {2:0}: {0:0, 1:1: 2:0}
        map.put(last, index);
        // update the value at index in nums to last (2)
        // assume: [0,1,2] -> [2,1,2]
        nums.set(index, last);
        // remove val from the map
        // assume: {1:1:, 2:0}
        map.remove(val);
        // remove the last element to remove the dup
        // assume: [2,1,2] ---> [2,1]
        nums.remove(nums.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */