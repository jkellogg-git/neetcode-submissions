class Solution {
    public int lastStoneWeight(int[] stones) {
        // setup a new priority queue - max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // loop through stones and offer to the heap - building the heap is O(n) 
        for (int s : stones) {
            maxHeap.offer(s);
        }
        // loop through the heap while its size is greater than 1 
        //(we'll be polling the top two)
        while (maxHeap.size() > 1) {
            int firstLargest = maxHeap.poll();
            int secondLargest = maxHeap.poll();
            // check if the largest isn't equal to the second largest, if not add first minus second to the heap
            if (firstLargest != secondLargest) {
                // this means that first was heavier than second
                // we add whatever remains of the first stone
                maxHeap.offer(firstLargest - secondLargest);
            }
        }
        // ensure there's at least one value, we need to return zero at the least 
        maxHeap.offer(0);
        return maxHeap.peek();
    }
}
