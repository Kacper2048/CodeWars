//Solution by https://github.com/Spion-Spion
/*
* Description:

The rgb function is incomplete. Complete it so that passing in RGB decimal values will
result in a hexadecimal representation being returned.
Valid decimal values for RGB are 0 - 255. Any values that fall out of
that range must be rounded to the closest valid value.

Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.

The following are examples of expected output values:

rgb(255, 255, 255) # returns FFFFFF
rgb(255, 255, 300) # returns FFFFFF
rgb(0,0,0) # returns 000000
rgb(148, 0, 211) # returns 9400D3
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

class RGBToHex
{
public:
    static std::string rgb(int r, int g, int b);
};

string RGBToHex::rgb(int r, int g, int b)
{
    int tab[3]{ r,g,b };
    vector<int> value(6, 0);
    string result;
    int index = 0;

    for (int i = 1; i < 4; i++)
    {
        if (tab[i - 1] < 0)
            tab[i - 1] = 0;

        if (tab[i - 1] > 255)
            tab[i - 1] = 255;

        for (int q = 0; q < 2; q++)
        {
            value[i * 2 - 1 - q] = tab[index] & 15;
            tab[index] = tab[index] >> 4;
        }
        index++;
    }

    for (int i = 0; i < 6; i++)
    {
        if (value[i] >= 10)
            result.push_back(static_cast<char>(value[i] - 10 + 'A'));
        else
            result.push_back(static_cast<char>(value[i] + '0'));
    }
    return result;
}

int main()
{
    RGBToHex x;

    cout << "\n" << x.rgb(0, 0, 0);//, Equals("000000"));
    cout << "\n" << x.rgb(1, 2, 3);//, Equals("010203"));
    cout << "\n" << x.rgb(255, 255, 255);//, Equals("FFFFFF"));
    cout << "\n" << x.rgb(254, 253, 252);//, Equals("FEFDFC"));
    cout << "\n" << x.rgb(-20, 275, 125);//, Equals("00FF7D"));

    return 0;
}