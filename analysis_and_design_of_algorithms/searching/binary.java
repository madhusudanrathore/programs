public class binary{
    public static void main(String[] args){

        int arr[]={12,56,78,98,236,458,497,2032,5625,9877}, val=458;
        int beg=0, end=arr.length, mid=(beg+end)/2;

        while (beg <= end){
            mid=(beg+end)/2;
            if (arr[mid]==val){
                System.out.println( val +" Found" );
                return;
            }
            else if(arr[mid]<val)
                beg=mid+1;
            else if(arr[mid]>val)
                end=mid-1;
        }
        // if not found
        System.out.println( val + " Not Found" );
    }
}