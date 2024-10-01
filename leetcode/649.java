class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int idx = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                rQueue.add(idx++);
            } else {
                dQueue.add(idx++);
            }
        }
        
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.remove();
            int d = dQueue.remove();
            if (r < d) {
                rQueue.add(idx++);
            } else {
                dQueue.add(idx++);
            }
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}