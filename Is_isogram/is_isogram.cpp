//Solution by https://github.com/Spion-Spion
/*
An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines whether a string that contains only letters is an isogram. Assume the empty string is an isogram. Ignore letter case.

Example: (Input --> Output)

"Dermatoglyphics" --> true "aba" --> false "moOse" --> false (ignore letter case)

isIsogram "Dermatoglyphics" = true
isIsogram "moose" = false
isIsogram "aba" = false
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;
bool is_isogram(std::string str) 
{
    vector<char> alfa(26);
    int temp = 0;
    //chane all string characters to lowercase 
    for (int i = 0; i < str.length(); i++)
    {
        str[i] = tolower(str[i]);
        temp = static_cast<int>(str[i]) - 97;

        alfa[temp]++;

        if (alfa[temp] >= 2)
        {
            return false;
        }
    }

    return true;
}

int main()
{
    cout << is_isogram("Hello World") << endl;
    cout << is_isogram("HeJka") << endl;
    cout << is_isogram("Dermatoglyphics") << endl;
    cout << is_isogram("Dwight") << endl;
    cout << is_isogram("moose") << endl;
    cout << is_isogram("abba") << endl;
}
