//Solution by https://github.com/Spion-Spion
/*
    -- TASK --
    In this kata you are required to, given a string, replace every letter with its position in the alphabet.
    If anything in the text isn't a letter, ignore it and don't return it.
*/

#include <iostream>
#include <string>

using namespace std;

std::string alphabet_position(const std::string& text)
{
    string s_temp;
    int temp = 0;
    int val = 0;
    for (int i = 0; i < text.length(); i++)
    {
        val = static_cast<int>(text[i]);
        //#first case Big letters
        if (val <= 90 && val >= 65)
        {
            if (s_temp.length() > 0 && i > 0)
            {
                s_temp = s_temp + " ";
            }

            temp = static_cast<int>(text[i]) - 64;
            s_temp = s_temp + to_string(temp);

        }
        //#second case small letters
        else if (val <= 122 && val >= 97)
        {
            if (s_temp.length() > 0 && i > 0)
            {
                s_temp = s_temp + " ";
            }

            temp = static_cast<int>(text[i]) - 96;
            s_temp = s_temp + to_string(temp);
        }
    }
    cout << s_temp << endl;
    return s_temp;
}
int main()
{
    alphabet_position("The sunset sets at twelve o' clock.");// , Equals("20 8 5 19 21 14 19 5 20 19 5 20 19 1 20 20 23 5 12 22 5 15 3 12 15 3 11"));
    alphabet_position("The narwhal bacons at midnight.");//, Equals("20 8 5 14 1 18 23 8 1 12 2 1 3 15 14 19 1 20 13 9 4 14 9 7 8 20"));
    alphabet_position("0123456789");//, Equals(""));//;
    alphabet_position("nN<jKgx1eakek");//, Equals(""));
    alphabet_position("");//, Equals(""));
}
