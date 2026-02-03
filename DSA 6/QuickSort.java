public class QuickSort{
    public static void quicksort(int []arr,int l,int r){
        if(l<r){
            int pi=prevent(arr,l,r);
            quicksort(arr,l,pi-1);
            quicksort(arr,pi+1,r);
        }
    }
    public static void prevent(int []arr,int l,int r){
        int pi=arr[l];
        int low=l+1;
        int high=arr.length-1;
        while(low<high){
            while(low<=high && pi>arr[low]){
                low++;
            }
            while(low<=high && pi>arr[high]){
                high++;
            }
            if(low<high>){
                int temp=arr(low);
                arr[low]=arr[high];
                arr[high]=temp;
            }

        }
arr[l] = arr[high];
arr[high]=pi;
pi=arr[l];

    }
    public static void main(String args[]){
        int []arr={4,6,8,3,5,7,9,12,45,2};
        quicksort(arr,0,arr.length-1);
        for(int i:arr)
            {
            System.out.println(i+" ");
        }
    }
}