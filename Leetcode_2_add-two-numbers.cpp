#include<iostream>
#include<vector>
#include <unordered_map>
using std::unordered_map;
using namespace::std;

struct ListNode {
    int val;
     ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

//recursion funcation solution
class Solution1 {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(l1 == NULL && l2 == NULL){
            return NULL;
        }
        else if(l1 == NULL && l2 != NULL){
            ListNode *s = new ListNode(l2->val);
            s->next = l2->next;
            return s;
        }
        else if(l1 != NULL && l2 == NULL){
            ListNode *s = new ListNode(l1->val);
            s->next = l1->next;
            return s;
        }
        else{
            if((l1->val + l2->val) >= 10){

                ListNode *s = new ListNode(l1->val + l2->val);
                s->next = addTwoNumbers(l1->next, l2->next);
                Jinwei(s);
                return s;
            }
            else{
                int y = l1->val + l2->val;
                ListNode *s = new ListNode(0);
                s->val = y;
                s->next = addTwoNumbers(l1->next, l2->next);
                return s;
            }
        }
    }

    void Jinwei(ListNode* l1){
        if(l1 == NULL){
            return;
        }
        else if(l1->val >= 10){
            if(l1->next == NULL){
                ListNode *e = new ListNode(0);
                l1->next = e;
                e->val += l1->val/10;
                l1->val %= 10;
                Jinwei(e);
                return;
            }
            else{
                l1->next->val += l1->val/10;
                l1->val %= 10;
                Jinwei(l1->next);
                return;
            }
        }
        else{
            return;
        }
    }
};

//Elementary Math Solution
class Solution1 {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *Head = new ListNode(0);
        ListNode *p = l1; ListNode *q = l2, *currentNode = Head;
        int carry = 0;

        while(p != NULL && q != NULL){
            int x = (p == NULL)?0:p->val;
            int y = (q == NULL)?0:q->val;
            int sum = carry + x + y;
            carry = sum/10;

            currentNode->next = new ListNode(sum%10);
            currentNode = currentNode->next;
            if (p != NULL){
                p = p->next;
            }
            if (q != NULL){
                q = q->next;
            }
        }
        if (carry > 0) {
            currentNode->next = new ListNode(carry);
        }
        return Head->next;
    }
}

