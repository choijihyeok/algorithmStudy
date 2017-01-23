#include <iostream>
#include <vector>
using namespace std;
vector <char> v[1000];
int cnt =0;

void search(char a,int type){
    int cnt = 0;
    if(a == '.') return;
    if(type == 0) cout << a;
    search(v[a].at(cnt),type);
    if(type == 1) cout << a;
    cnt++;
    search(v[a].at(cnt),type);
    if(type == 2) cout << a;
    return ;
}

int main(){
    char a,b,c,start = '\0';
    int n = 0,ch=0;
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> a >> b >> c;
        if(ch == 0) start = a;
        ch = 1;
        v[a].push_back(b);
        v[a].push_back(c);
    }
    search(start,0);
    cout << endl;
    search(start,1);
    cout << endl;
    search(start,2);
    cout << endl;
    return 0;
}
