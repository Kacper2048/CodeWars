//Solution by https://github.com/Spion-Spion
/*
Complete the solution so that it returns true if the first argument(string) passed in ends with the 2nd argument (also a string).

Examples:
solution('abc', 'bc') // returns true
solution('abc', 'd') // returns false
*/

#include <iostream>
#include <string>

using namespace std;

bool solution(std::string const& str, std::string const& ending)
{
    if (str.length() >= ending.length())
    {
        for (int i = str.size() - ending.size(); i < str.size(); i++)
        {
            if (str[i] != ending[i - (str.size() - ending.size())])
            {
                return false;
            }
        }
    }
    else
    {
        return false;
    }
    return true;
}

int main()
{
    cout << solution("abcde", "cde") << endl;
    cout << solution("abcde", "abc") << endl;
    cout << solution("abc", "") << endl;
}
