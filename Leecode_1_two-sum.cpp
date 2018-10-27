#include<iostream>
#include<vector>
#include <unordered_map>
using std::unordered_map;
using namespace::std;


//solution1, O(n**2)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target){
        vector<int>::iterator t1;
        vector<int>::iterator t2;
        vector<int> solution(2,0);

        for(t1 = nums.begin(); t1 != nums.end()-1; t1++){
            for(t2 = t1 + 1; t2 != nums.end(); t2++){
                if( (*t1 + *t2) == target){
                    solution[0] = t1 - nums.begin();
                    solution[1] = t2 - nums.begin();
                    return solution;
                }
            }
        }
        return solution;
    }
};


//solution2 two-pass hash table O(n)


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> um;
    int n = nums.size();
    int i;
    vector<int> res(2);
    for (i = 0; i < n; ++i) {
        if (um.find(target - nums[i]) != um.end()) {
            res[0] = um[target - nums[i]];
            res[1] = i;
            break;
        }
        else {
            um[nums[i]] = i;
        }
        }
        um.clear();
        return res;
    }
};
