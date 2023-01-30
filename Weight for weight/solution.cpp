//Solution by https://github.com/Spion-Spion
/*
Description:

My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month a list with 
the weights of members is published and each month he is the last on the list which means he is the heaviest.

I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.

For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.

Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?
Example:

"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:

"100 180 90 56 65 74 68 86 99"

When two numbers have the same "weight", let us class them as if they were strings (alphabetical ordering) and not numbers:
180 is before 90 since, having the same "weight" (9), it comes before as a string.

All numbers in the list are positive numbers and the list can be empty.
Notes

    it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace between two consecutive numbers
    For C: The result is freed.
*/
#include <iostream>
#include <vector>
#include <string>
#include <math.h>
#include <algorithm>

using namespace std;

class WeightSort
{
public:
    static std::string orderWeight(const std::string& strng);

};

std::string WeightSort::orderWeight(const std::string& strng)
{
    vector<int> sum;
    vector<string> s_var;
    string s_val;
    int temp = 0;

    //get string and sum of digit
    for (int i = 0; i <= strng.length(); i++)
    {
        if ((strng[i] == ' ' || strng[i] == '\0') && s_val.length() > 0)
        {
            sum.push_back(0);
            s_var.push_back(s_val);

            for (int x = 0; x < s_val.length(); x++)
            {
                temp = temp + (s_val[x] - '0');
            }
            sum[sum.size() - 1] = temp;

            s_val.clear();
            temp = 0;
        }
        else
        {
            s_val = s_val + strng[i];
        }
    }

    //bubblesort
    for (int i = 0; i < sum.size(); i++)
    {
        for (int x = 1; x < sum.size() - i; x++)
        {
            if (sum[x - 1] > sum[x])
            {
                swap(s_var[x - 1], s_var[x]);
                swap(sum[x - 1], sum[x]);
            }
            else if (sum[x - 1] == sum[x])
            {
                if (s_var[x - 1].compare(s_var[x]) > 0)
                {
                    swap(s_var[x - 1], s_var[x]);
                    swap(sum[x - 1], sum[x]);
                }
            }

        }
    }

    s_val.clear();

    for (int i = 0; i < s_var.size(); i++)
    {
        s_val = s_val + s_var[i];
        if (i < s_var.size() - 1)
        {
            s_val = s_val + ' ';
        }
    }

    return s_val;
}


int main()
{
    WeightSort a;

    cout << a.orderWeight("103 123 4444 99 2000") << endl;
    cout << a.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123") << endl;
    cout << a.orderWeight("") << endl;
    cout << a.orderWeight("103 123 4444 99 2000 ") << endl;
}
