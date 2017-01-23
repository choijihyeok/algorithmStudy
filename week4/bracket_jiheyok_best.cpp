#include <iostream>
#include <stack>
using namespace std;

int b[35] = {0};
char ch[35] = {0};
stack<char> a;

void check(int n){
    int k = a.size();
    if(b[k] == 0) b[k] = 1;
    b[k-1] += b[k] * n;
    a.pop();
    b[k] = 0;
}

int main(){
    cin >> ch;
    for(int i=0; ch[i]; i++){
        if(ch[i] == '(' || ch[i] == '[') a.push(ch[i]);
        else if(ch[i] == ')' && a.top() == '(') check(2);
        else if(ch[i] == ']' && a.top() == '[') check(3);
        else {cout << "0"; return 0;}
    }
    cout << b[0];
    return 0;
}
