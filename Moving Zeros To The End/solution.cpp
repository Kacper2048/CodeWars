//Solution by https://github.com/Spion-Spion
/*
Write an algorithm that takes an array and moves all of the zeros to the end, 
preserving the order of the other elements.

move_zeros({1, 0, 1, 2, 0, 1, 3}) // returns {1, 1, 2, 1, 3, 0, 0}
*/

#include <vector>
#include <string>
#include <iostream>

using namespace std;

std::vector<int> move_zeroes(const std::vector<int>& input)
{
	vector<int> copy = input;
	int x = 0;

	for (int i = 0; i < copy.size() - x;)
	{
		if (copy[i] == 0)
		{
			copy.erase(copy.begin() + i);
			copy.push_back(0);
			x++;
		}
		else
		{
			i++;
		}
	}

	return copy;
}

int main()
{
	vector<int> vec;
	vec.push_back(1);
	vec.push_back(2);
	vec.push_back(3);
	vec.push_back(0);
	vec.push_back(5);
	vec.push_back(0);
	vec.push_back(5);
	vec.push_back(0);
	vec.push_back(5);

	for (int i = 0; i < vec.size(); i++)
	{
		cout << vec[i] << endl;
	}

	vec = move_zeroes(vec);
	cout << endl;

	for (int i = 0; i < vec.size(); i++)
	{
		cout << vec[i] << endl;
	}
}