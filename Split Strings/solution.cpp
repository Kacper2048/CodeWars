//Solution by https://github.com/Spion-Spion
/*
Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').

Examples:

* 'abc' =>  ['ab', 'c_']
* 'abcdef' => ['ab', 'cd', 'ef']
*/
#include <iostream>
#include <string>
#include <vector>

using namespace std;

std::vector<std::string> solution(const std::string& s)
{
    vector<string> vec;
    string temp;
    int len = s.length();

    if (len % 2)
    {
        for (int i = 0; i < len-1; i = i + 2)
        {
            temp.clear();
            temp.push_back(s[i]);
            temp.push_back(s[i + 1]);
            vec.push_back(temp);
        }

        temp.clear();
        temp.push_back(s[len - 1]);
        temp.push_back('_');
        vec.push_back(temp);
    }
    else
    {
        for (int i = 0; i < len; i = i + 2)
        {
            temp.clear();
            temp.push_back(s[i]);
            temp.push_back(s[i + 1]);
            vec.push_back(temp);
        }
    }

    return vec; 
}

int main()
{
    vector<string> temp = solution("abcde");
    for (int i = 0; i < temp.size(); i++)
    {
        cout << temp[i] << " ";
    }
    cout << endl;

    temp = solution("LovePizza");
    for (int i = 0; i < temp.size(); i++)
    {
        cout << temp[i] << " ";
    }
    cout << endl;

    temp = solution("HelloWorld");
    for (int i = 0; i < temp.size(); i++)
    {
        cout << temp[i] << " ";
    }
    cout << endl;

}