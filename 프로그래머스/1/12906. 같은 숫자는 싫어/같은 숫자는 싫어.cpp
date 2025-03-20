#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int saveNum;
    for(int i = 0;i<arr.size();i++)
    {
        if( i == 0)
        { 
            saveNum = arr[i];
            answer.push_back(arr[i]);
        }
        else
        {
            if(saveNum == arr[i])continue;
            
            saveNum = arr[i];
            answer.push_back(arr[i]);
            
        }
        
        
    
    }
    
    
    
    return answer;
}