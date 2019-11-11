class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i : stones) {
            pq.add(i);
        }
                
        while(pq.size() >= 2) {
            int x1 = pq.poll();
            int x2 = pq.poll();
            
            if (x1 > x2) {
                pq.add(x1 - x2);
            }
        }
        if (pq.size() == 1) return pq.peek();
        else return 0;
    }
}