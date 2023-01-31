//Solution by https://github.com/Spion-Spion
/*
Description:
Task

You are at position [0, 0] in maze NxN and you can only move in one of the four cardinal directions (i.e. North, East, South, West). Return true if you can reach position [N-1, N-1] or false otherwise.

    Empty positions are marked ..
    Walls are marked W.
    Start and exit positions are empty in all test cases.
*/

#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

struct pos
{
    int row;
    int col;
};

bool path_finder(string maze) //BFS algorithm
{
    if (maze.length() == 0)
    {
        return false;
    }

    string temp;
    vector<string> D2; //2D maps of characters

    for (int i = 0; i <= maze.length(); i++)
    {
        if (maze[i] == '\n' || maze[i] == '\0')
        {
            D2.push_back(temp);
            temp.clear();
            continue;
        }
        temp = temp + maze[i];
    }

    int n = D2.size();
    pos position;
    queue<pos> queue_pos;

    int rrow = 0;
    int ccol = 0;
    int choosen = 0;

    //start with 0,0
    position = { 0,0 };
    queue_pos.push(position);
    D2[0][0] = 'v'; //v as visitied

    while (!queue_pos.empty()) 
    {
        for (int b = 0; b <= 1; b++)
        {
            for (int q = -1; q <= 1; q += 2)
            {
                rrow = queue_pos.front().row;
                ccol = queue_pos.front().col;

                (b == 0) ? (ccol = ccol + q) : (rrow = rrow + q);
                (b == 0) ? choosen = ccol : choosen = rrow;

                if (choosen >= 0 && choosen < n && D2[rrow][ccol] == '.')
                {
                    //add to queue and change value to 'v'
                    position = { rrow,ccol };
                    queue_pos.push(position);
                    D2[rrow][ccol] = 'v';

                    if (rrow == n - 1 && ccol == n - 1)
                    {
                        return true;
                    }
                }
            }
        }
        queue_pos.pop(); //delete visited
    }
    return false;
}


int main()
{
    cout << path_finder(".W.\n.W.\n...") << endl;
    /*
      Maze:
        .W.
        .W.
        W..
    */

    cout << path_finder(".W.\n.W.\nW..") << endl;
    /*
      Maze:
        ......
        ......
        ......
        ......
        ......
        ......
    */
    cout << path_finder("......\n......\n......\n......\n......\n......") << endl;
    /*
      Maze:
        ......
        ......
        ......
        ......
        .....W
        ....W.
    */
    cout << path_finder("......\n......\n......\n......\n.....W\n....W.") << endl;
}
