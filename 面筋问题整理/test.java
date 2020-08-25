private void quickSortThreeWay(int []nums){
    quickSortThreeWay(nums,0,nums.length-1);
}

private void quickSortThreeWay(int []nums,int start,int end){
    if(start>=end)
        return;
    
    int L = start;
    int R = end;
    int i = L+1;
    int temp = nums[start];
    while(i<=R){
        if(nums[i]>temp){
            swap(nums,i,R);
            R++;
        }
        else if(nums[i]<temp){
            swap(nums,i,L);
            L++;
        }
        else{
            i++;
        }

    }
    quickSortThreeWay(nums,start,L-1);
    quickSortThreeWay(nums,start,R+1);


}