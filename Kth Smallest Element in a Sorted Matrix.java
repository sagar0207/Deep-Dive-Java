class ArrayContainer implements Comparable<ArrayContainer> {
	    int[] arr;
	    int index;
 
	    public ArrayContainer(int[] arr, int index) {
		    this.arr = arr;
		    this.index = index;
	    }
 
	    @Override
	    public int compareTo(ArrayContainer o) {
		    return this.arr[this.index] - o.arr[o.index];
	    }
    }
class Solution {
 
    public static int[] mergeKSortedArray(int[][] arr) {
		//PriorityQueue is heap in Java 
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int total=0;
 
		//add arrays to heap
		for (int i = 0; i < arr.length; i++) {
			queue.add(new ArrayContainer(arr[i], 0));
			total = total + arr[i].length;
		}
 
		int m=0;
		int result[] = new int[total];
 
		//while heap is not empty
		while(!queue.isEmpty()){
			ArrayContainer ac = queue.poll();
			result[m++]=ac.arr[ac.index];
 
			if(ac.index < ac.arr.length-1){
				queue.add(new ArrayContainer(ac.arr, ac.index+1));
			}
		}
 
		return result;
	}
    
    public int kthSmallest(int[][] matrix, int k) {
    
        int[] res = mergeKSortedArray(matrix);
        
        for(int i = 0; i<res.length; i++)
        {
            if(i == k-1)
                return res[i];
        }
        return -99;
    }    
}
