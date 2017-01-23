#include <iostream>
#include <stack>
using namespace std;
int main(){
    stack <int> tac;
    char ch[31] = {0};
    int sum=0,temp=0,temp2=0;
    cin >> ch;
    for(int i=0; i<31; i++){
        if(ch[i] == 0) break;
        if(ch[i] == '('){
            tac.push(ch[i]);
        }else if(ch[i] == '['){
            tac.push(ch[i]);
        }else if(ch[i] == ')'){
            if(tac.top() == '('){
                tac.pop();
                tac.push(2);
            }else if(tac.top() != '(' && tac.top() != '[' && tac.top() != ')' && tac.top() != ']'){
                temp = tac.top();
                tac.pop();
                if(tac.top() == '('){
                    tac.pop();
                    tac.push(temp * 2);
                }
            }
        }else if(ch[i] == ']'){
            if(tac.top() == '['){
                tac.pop();
                tac.push(3);
            }else if(tac.top() != '(' && tac.top() != '[' && tac.top() != ')' && tac.top() != ']'){
                temp = tac.top();
                tac.pop();
                if(tac.top() == '['){
                    tac.pop();
                    tac.push(temp * 3);
                }
            }
        }
        while(!tac.empty()){
            if(tac.top() != '(' && tac.top() != '[' && tac.top() != ')' && tac.top() != ']'){
                temp2 += tac.top();
                tac.pop();
            }else{
                if(temp2>0) tac.push(temp2);
                temp2 = 0;
                break;
            }
        }
        if(tac.empty()){
            sum += temp2;
            temp2=0;
        }
    }
    cout << sum;
}
