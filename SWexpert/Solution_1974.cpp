#include<iostream>
using namespace std;

int map[9][9];

int chk_g(){
    int num[10];
    for (int i = 0; i < 9; i++)
    {
        for (int j = 1; j <= 9; j++)
        {
            num[j] = 0;
        }

        for (int k = 0; k < 9; k++)
        {
            int temp = map[i][k];
            if(!num[temp])
            {
                num[temp] = 1;
            }
            else{
                return 0; //false
            }
        }
    }
    return 1; //true    
}

int chk_s(){
    int num[10];
    for (int i = 0; i < 9; i++)
    {
        for (int j = 1; j <= 9; j++)
        {
            num[j] = 0;
        }

        for (int k = 0; k < 9; k++)
        {
            int temp = map[k][i];
            if(!num[temp])
            {
                num[temp] = 1;
            }
            else{
                return 0; //false
            }
        }
    }
    return 1; //true    
}

int chk_l(){
    int num[10];
    for (int i = 0; i < 9; i+=3)
    {
        for (int k = 0; k < 9; k+=3)
        {
            for (int j = 1; j <= 9; j++)
            {
                num[j] = 0;
            }
            for (int h = 0; h < 3; h++)
            {
                for (int r = 0; r < 3; r++)
                {
                    int temp = map[i+h][k+r];
                    if(!num[temp])
                    {
                        num[temp] = 1;
                    }
                    else{
                        return 0; //false
                    }
                }
            }
        }
    }
    return 1; //true    
}


int main(){
    int t;
    cin >> t;
    for (int test = 1; test <= t; test++)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                cin>>map[i][j];
            }
            
        }

        if(chk_g()&&chk_s()&&chk_l())
        {
            cout<<"#"<<test<<" "<<1<<"\n";
        }
        else{
            cout<<"#"<<test<<" "<<0<<"\n";
        }
    }
    
}