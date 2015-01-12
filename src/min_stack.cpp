#include <iostream>
#include <list>
#include <stack>
#include <stdio.h>

using namespace std;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

*/
struct Node{
	int val;
	Node *next;
}
class MinStack {
public:
    void push(int x) {
    }

    void pop() {
    }

    int top() {
        return ls.front();
    }

    int getMin() {
        return *itr_min;
    }
private:
   list<int> ls;
   list<int>::iterator itr_min;
};
int main(){
    cout<<"min stack"<<endl;
    MinStack ms;
    for(int i=0;i<10;i++){
        ms.push(i);
    }
    cout<<ms.getMin()<<endl;

    return 0;
}
