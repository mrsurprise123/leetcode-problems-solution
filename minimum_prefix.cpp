#include<iostream>
using namespace::std;
int *minimum_prefix(int A[], int left, int right){
    int *x = new int[2];
    if(left == right){
        x[0] = A[left];
        x[1] = left;
        return x;
    }

    int center = (left+right)/2;
    x = minimum_prefix(A, left, center);
    int k = center+1; int rightsum = 0; int minsum = 0; int leftsum = 0;
    for(int i = center+1; i <= right; i++){
        rightsum += A[i];
        if(rightsum < minsum){
            minsum = rightsum;
            k = i;
        }
    }

    if(minsum >= 0){
        return x;
    }
    else{
        for(int i = left; i <= center; i++){
            leftsum += A[i];
        }
    }

    int *x1 = new int[2];
    x1[0] = leftsum + minsum;
    x1[1] = k;

    return (x[0] < x1[0])?x:x1;
}

int main(){
    int arry[12] = {4,2,6,-3,-5,-7,-8,-3,4,6,-10,-1};
    int *x = minimum_prefix(arry,0,11);
    cout<<x[0]<<endl;
    cout<<x[1]<<endl;
}