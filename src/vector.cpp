#include <iostream>
#include <string>
#include <vector>


using namespace std;

class Vector{
    private:
        int age;
    public:
        Vector();
        Vector(int);
};
Vector::Vector(){
    cout<<"vector constructor"<<endl;
}
Vector::Vector(int i){
    cout<<"vector constructor "<<i<<endl;
}

int main(){
    string str1="haha";
    string str2="heihei";
    string str=str1+str2;
    Vector v;
    Vector v1(1);
    Vector *vp = new Vector();
    vector<int> t;
    
    if(vp !=NULL){
        cout<<"error"<<endl;
    }
    
    return 0;
}
