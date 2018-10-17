public class linear{
    public static void main(String[] args){

        int arr[]={12,56,78,98,236,458,497,2032,5625,9877}, val=458;

        for (int i=0; i<arr.length; i++){
            if(arr[i]==val){ // if found
                System.out.println( val + " Found" );
                return;
            }
        }
        // if not found
        System.out.println( val + " Not Found" ) ;
    }
}