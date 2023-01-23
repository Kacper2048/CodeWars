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

    for (int i = 0; i < len; i = i + 2)
    {
        vec.push_back(s.substr(i, 2));
    }

    if (len % 2)
    {
        vec[vec.size() - 1].push_back('_');
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