class SmallestInfiniteSet {
    Queue<Integer> minHeap;
    Set<Integer> containSet;

    public SmallestInfiniteSet() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            list.add(i);
        }
        minHeap = new PriorityQueue<>(list);
        containSet = new HashSet<>(list);
    }
    
    public int popSmallest() {
        int num = minHeap.poll();
        containSet.remove(num);
        return num;
    }
    
    public void addBack(int num) {
        if (!containSet.contains(num)) {
            minHeap.add(num);
            containSet.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */