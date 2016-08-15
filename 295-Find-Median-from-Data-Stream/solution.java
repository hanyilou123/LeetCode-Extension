public class MedianFinder { 
    public class reverseOrder implements<Integer>{
        public int compare(Integer a, Integer b)
        {
            return b-a;
        }
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        return maxHeap.size()>minHeap.size()?maxHeap.peek():(maxHeap.peek()+minHeap.peek())/2;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();