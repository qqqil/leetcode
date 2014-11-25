#include <iostream>
#include <stack>

using namespace std;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

*/
class MinStack {
public:
    
    void push(int x) {
        list.push_front(x);
        if(*itr_min > x || itr_min == NULL){
            itr_min = list.begin();
        }
    }

    void pop() {
        if(itr_min == list.begin()){
            for(list<int>::iterator itr;itr 1= list.end();itr++){
                if(itr == list.begin()){
                    itr_min = NULL;
                    continue;
                }
                if(itr_min == NULL){
                    itr_min = itr;
                }else if(*itr_min > *itr){
                   itr_min = itr; 
                }
            }
        }
        list.pop_front(x);
    }

    int top() {
        return list.front();
    }

    int getMin() {
        return *itr_min;
    }
private:
   list<int> list = new list();
   list<int>::iterator itr_min=list.begin();
};
int main(){

    cout<<"min stack"<<endl;

    return 0;
}
