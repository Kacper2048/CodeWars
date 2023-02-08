//Solution by https://github.com/Spion-Spion
/*
Description:

In this kata you have to correctly return who is the "survivor", ie: the last element of a Josephus permutation.
Basically you have to assume that n people are put into a circle and that they are eliminated in steps of k elements,
like this:

josephus_survivor(7,3) => means 7 people in a circle;
one every 3 is eliminated until one remains
[1,2,3,4,5,6,7] - initial sequence
[1,2,4,5,6,7] => 3 is counted out
[1,2,4,5,7] => 6 is counted out
[1,4,5,7] => 2 is counted out
[1,4,5] => 7 is counted out
[1,4] => 5 is counted out
[4] => 1 counted out, 4 is the last element - the survivor!

The above link about the "base" kata description will give you a more thorough insight about the origin of this kind of permutation,
but basically that's all that there is to know to solve this kata.

Notes and tips: using the solution to the other kata to check your function may be helpful,
but as much larger numbers will be used, using an array/list to compute the number of the survivor may be too slow;
you may assume that both n and k will always be >=1.
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

int josephusSurvivor(int n, int k)
{
    vector<int> values;

    for (int i = 0; i < n; i++)
        values.push_back(i + 1);

    int position = (k - 1) % (values.size());

    while (values.size() > 1)
    {
        values.erase(values.begin() + position);
        position = (position + (k - 1)) % (values.size());
    }

    return values[0];
}

int main()
{
    cout << josephusSurvivor(7, 3); //Equals(4));
    cout << "\n" << josephusSurvivor(11, 19);// Equals(10));
    cout << "\n" << josephusSurvivor(1, 300);// Equals(1));
    cout << "\n" << josephusSurvivor(14, 2);// Equals(13));
    cout << "\n" << josephusSurvivor(100, 1);// Equals(100));
    cout << "\n" << josephusSurvivor(40, 3);// , Equals(28));
    cout << "\n" << josephusSurvivor(2, 300);//, Equals(1));
    cout << "\n" << josephusSurvivor(5, 300);//, Equals(1));
    cout << "\n" << josephusSurvivor(7, 300);//, Equals(7));
    cout << "\n" << josephusSurvivor(300, 300);//, Equals(265));

    return 0;
}