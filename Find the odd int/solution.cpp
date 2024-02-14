//Solution by https://github.com/Spion-Spion
/*
Description:

Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.
Examples

[7] should return 7, because it occurs 1 time (which is odd).
[0] should return 0, because it occurs 1 time (which is odd).
[1,1,2] should return 2, because it occurs 1 time (which is odd).
[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
*/


#include <iostream>
#include <vector>
#include <bitset>

using namespace std;

int findOdd(const std::vector<int>& numbers);

int main()
{
    std::vector<int> vec1 = { 20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5 };
    std::vector<int> vec2 = { 1,1,2,-2,5,2,4,4,-1,-2,5 };
    std::vector<int> vec3 = { 20,1,1,2,2,3,3,5,5,4,20,4,5 };
    std::vector<int> vec4 = { 10 };
    std::vector<int> vec5 = { 1,1,1,1,1,1,10,1,1,1,1 };
    std::vector<int> vec6 = { -3, -4, 2, -4, -2, 2, 2, -4, -3, -4, -2, 2, -2, 2, -4, -2, 2, -4, -4, 2, 2, -3, -2, -2, -4, -4, -3, -2, -4, 2, 2, -2, -2, -2, -3, -3, -3 };

    std::cout << findOdd(vec1) << "\n" << std::endl;
    std::cout << findOdd(vec2) << "\n" << std::endl;
    std::cout << findOdd(vec3) << "\n" << std::endl;
    std::cout << findOdd(vec4) << "\n" << std::endl;
    std::cout << findOdd(vec5) << "\n" << std::endl;
    std::cout << findOdd(vec6) << "\n" << std::endl;
}

/*
int findOdd(const std::vector<int>& numbers) 
{
    std::vector<std::vector<int>> vec2d;
    std::vector<int> vec1d(2);

    if (numbers.size() == 0)
        return 0;

    if (numbers.size() == 1)
        return numbers[0];

    //if size is bigger than 1
    vec1d[0] = numbers[0];
    vec1d[1] = 1;
    vec2d.push_back(vec1d);

    vec1d[0] = vec1d[1] = 0;
    bool flag = false;

    for (int i = 1; i < numbers.size(); i++)
    {
        //check evry one round if it fit in old squad 
        for (int q = 0; q < vec2d.size(); q++)
        {
            //if yes then increment and continue
            if (numbers[i] == vec2d[q][0])
            {
                vec2d[q][1]++;
                flag = true;
                break;
            }
            flag = false;
        }

        if (flag == false)
        {
            vec2d.push_back(vec1d);
            vec2d[vec2d.size() - 1][0] = numbers[i];
            vec2d[vec2d.size() - 1][1] = 1;
        }
    }

    //find vec2d[x][1] = odd
    for (int i = 0; i < vec2d.size(); i++)
    {
        if(vec2d[i][1] % 2) //return 1 then true
        {
            return vec2d[i][0];
        }
    }
    return 0;
}
*/

int findOdd(const std::vector<int>& numbers) {
    int result = 0;
    bitset<8> y;
    bitset<8> x;
    for (auto& num : numbers) {
        y = result;
        x = num;

        cout << "("<<result << ")" << y << " ^ " << "(" << num << ")" << x << " = ";

        result = result ^ num;

        y = result;
        cout << "(" << result << ")" << y << endl;
    }
    return result;
}


