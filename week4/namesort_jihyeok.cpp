#include <iostream>
#include <vector>
#include <string>
#include <tuple>

using namespace std;
int main(){
    vector<tuple<int,int,string>> set1;
    pair<int,int> set2;
    int n =0,age=0;
    string name;
    cin >> n;
    for(int i=0; i<n; i++){
        age = 0;
        cin >> age >> name;
        set1.push_back(tuple<int,int,string>(age,i,name));
    }
    sort(set1.begin(),set1.end());
    for(int i=0; i<set1.size(); i++){
        cout << get<0>(set1[i]) << " " << get<2>(set1[i]) << endl;
    }
}
