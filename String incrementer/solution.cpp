//Solution by https://github.com/Spion-Spion
/*
Description:

Your job is to write a function which increments a string, to create a new string.

    If the string already ends with a number, the number should be incremented by 1.
    If the string does not end with a number. the number 1 should be appended to the new string.

Examples:

foo -> foo1

foobar23 -> foobar24

foo0042 -> foo0043

foo9 -> foo10

foo099 -> foo100

Attention: If the number has leading zeros the amount of digits should be considered.
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

std::string incrementString(const std::string& str)
{
    string temp;
    string temp_string;

    int value = 0;
    int q = 0;

    if (str.length() == 0)
    {
        temp = "1";
        return temp;
    }

    int i = str.length() - 1;

    while (static_cast<int>(str[i]) <= 58 && static_cast<int>(str[i]) >= 48)
    {
        temp.insert(temp.begin(), str[i]);
        i--;
    }

    for (int w = 0; w < i + 1; w++) //string
    {
        temp_string.push_back(str[w]);
    }

    q = temp.length();

    while (temp[0] == '0')
    {
        temp.erase(temp.begin());
    }

    if (temp.length() == 0)
    {
        temp.push_back('0');
    }

    value = stoi(temp);
    temp = to_string(++value);

    while (temp.length() < q)
    {
        temp.insert(temp.begin(), '0');
    }

    return temp_string + temp;
}

int main()
{
    incrementString("foobar000");
    incrementString("foo");
    incrementString("foobar001");
    incrementString("foobar99");
    incrementString("foobar099");
    incrementString("");

    return 0;
}