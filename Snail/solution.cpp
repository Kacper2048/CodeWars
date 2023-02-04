//Solution by https://github.com/Spion-Spion
/*
Description:
Snail Sort

Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]

For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]

This image will illustrate things more clearly:
https://www.haan.lu/files/2513/8347/2456/snail.png

NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array in a clockwise snailshell pattern.

NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].

*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> snail(const vector<vector<int>>& snail_map)
{
    vector<int> temp;

    if (snail_map[0].size() == 0)
    {
        return vector<int>();
    }
    else if (snail_map[0].size() == 1)
    {
        temp.push_back(snail_map[0][0]);
        return temp;
    }

    int dir = 0; //0-right, 1-down, 2-left, 3-up
    int x = 0;
    int y = 0;

    int len = snail_map.size();

    while (len > 0)
    {
        switch (dir)
        {
        case 0:
        {
            for (int i = 0; i < len; i++)
            {
                temp.push_back(snail_map[y][x]);

                x++;
            }
            x--;
            y++;
            dir++;
            len--;

            break;
        }

        case 1:
        {
            for (int i = 0; i < len; i++)
            {
                temp.push_back(snail_map[y][x]);
                y++;
            }
            y--;
            x--;
            dir++;

            break;
        }

        case 2:
        {
            for (int i = 0; i < len; i++)
            {
                temp.push_back(snail_map[y][x]);
                x--;
            }
            x++;
            y--;
            dir++;
            len--;

            break;
        }

        case 3:
        {
            for (int i = 0; i < len; i++)
            {
                temp.push_back(snail_map[y][x]);
                y--;
            }
            y++;
            x++;

            dir = 0;
            break;
        }
        }
    }

    return temp;
}

int main()
{
    std::vector<std::vector<int>> v;
    std::vector<int> expected;

    v = { {} };
    expected = snail(v);
    for (int y = 0; y < expected.size(); y++)
    {
        cout << expected[y] << "\t";
    }
    cout << endl;

    v = { {1} };
    cout << v.size() << endl;
    expected = snail(v);
    for (int y = 0; y < expected.size(); y++)
    {
        cout << expected[y] << "\t";
    }
    cout << endl;

    v = { {1,2}, {4,3} };
    //expected = {1,2,3,4};
    expected = snail(v);


    for (int y = 0; y < expected.size(); y++)
    {
        cout << expected[y] << "\t";
    }
    cout << endl;


    v = { {1,2,3}, {8,9,4}, {7,6,5} };
    //expected ={1, 2, 3, 4, 5, 6, 7, 8, 9};
    expected = snail(v);

    for (int y = 0; y < expected.size(); y++)
    {
        cout << expected[y] << "\t";
    }
    cout << endl;


    v = { {1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7} };
    //expected = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    expected = snail(v);

    for (int y = 0; y < expected.size(); y++)
    {
        cout << expected[y] << "\t";
    }
    cout << endl;


    return 0;
}