#include <cstdio>

int main()
{
    int test_case;
    int T;
    int tmp;
 
    int su; // 직원의 수
    int arr[300000][2] = { 0, }; // 그릇
    int count; // 몇번 올랐는가 카운팅
    //int brr[10] = { 0, };
 
    //setbuf(stdout, NULL);
    scanf("%d", &T);
 
    for (test_case = 1; test_case <= T; ++test_case)
    {
        scanf("%d", &su); // 직원의 수 적기
        scanf("%d", &arr[0][0]); // 다슬이의 연봉
        count=0;
 
        for (int i = 1; i <= su; i++) // 직원들의 연봉과 상관의 번호
        {
            scanf("%d %d", &arr[i][0], &arr[i][1]); // 연봉 상사
 
            tmp = i;
            while(1)
            {
                if (arr[tmp][0] > arr[arr[tmp][1]][0]) // 만약 들어온 아이가 상사보다 연봉이 높다면
                {
                    arr[arr[tmp][1]][0] = arr[tmp][0]; // 바꾸고
                    count++; // 카운팅 해줘
                }
                else	break;
                if (arr[tmp][1] == 0)	break;
 
                tmp = arr[tmp][1];
            } 
        }
        //brr[test_case - 1] = count;
        printf("#%d %d\n",test_case, count);
    }
 
 
   /* for (test_case = 1; test_case <= T; ++test_case)
    {
        printf("#%d %d\n", test_case, brr[test_case - 1]);
    }*/
 
    return 0; //정상종료시 반드시 0을 리턴해야 합니다.
}