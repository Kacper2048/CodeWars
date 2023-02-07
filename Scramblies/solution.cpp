//Solution by https://github.com/Spion-Spion
/*
Description:

Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

Notes:

    Only lower case letters will be used (a-z). No punctuation or digits will be included.
    Performance needs to be considered.

Examples

scramble('rkqodlw', 'world') ==> True
scramble('cedewaraaossoqqyt', 'codewars') ==> True
scramble('katas', 'steak') ==> False

*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool scramble(const std::string& s1, const std::string& s2)
{
    vector<int> letters(26, 0);
    for (int i = 0; i < s1.length(); i++)
    {
        letters[static_cast<int>(s1[i]) - 97]++;
    }

    for (int i = 0; i < s2.length(); i++)
    {
        if (letters[static_cast<int>(s2[i]) - 97] > 0)
        {
            letters[static_cast<int>(s2[i]) - 97]--;
        }
        else
        {
            return false;
        }
    }
    return true;
}

int main()
{
    cout << scramble("rkqodlw", "world") << endl;
    cout << scramble("cedewaraaossoqqyt", "codewars") << endl;
    cout << scramble("katas", "steak") << endl;
    cout << scramble("scriptjavx", "javascript") << endl;
    cout << scramble("scriptingjava", "javascript") << endl;
    cout << scramble("scriptsjava", "javascript") << endl;
    cout << scramble("javscripts", "javascript") << endl;
    cout << scramble("aabbcamaomsccdd", "commas") << endl;
    cout << scramble("commas", "commas") << endl;
    cout << scramble("sammoc", "commas") << endl;

    return 0;
}