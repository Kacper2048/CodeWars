//Solution by https://github.com/Spion-Spion
/*
In this kata, you will write a function that returns the positions and the values of the "peaks" (or local maxima) of a numeric array.
For example, the array arr = [0, 1, 2, 5, 1, 0] has a peak at position 3 with a value of 5 (since arr[3] equals 5).
The output will be returned as an object of type PeakData which has two members: pos and peaks. Both of these members should be vector<int>s.
If there is no peak in the given array then the output should be a PeakData with an empty vector for both the pos and peaks members.
PeakData is defined in Preloaded as follows:

struct PeakData {
  vector<int> pos, peaks;
};

Example: pickPeaks([3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3]) should return {pos: [3, 7], peaks: [6, 3]} (or equivalent in other languages)

All input arrays will be valid integer arrays (although it could still be empty), so you won't need to validate the input.
The first and last elements of the array will not be considered as peaks (in the context of a mathematical function,
we don't know what is after and before and therefore, we don't know if it is a peak or not).
Also, beware of plateaus !!! [1, 2, 2, 2, 1] has a peak while [1, 2, 2, 2, 3] and [1, 2, 2, 2, 2] do not.
In case of a plateau-peak, please only return the position and value of the beginning of the plateau.
For example: pickPeaks([1, 2, 2, 2, 1]) returns {pos: [1], peaks: [2]} (or equivalent in other languages)

Have fun!

*/

#include <vector>
#include <string>
#include <iostream>
using namespace std;

struct PeakData {
	vector<int> pos, peaks;
};

PeakData pick_peaks(const std::vector<int>& v)
{
	PeakData result;
	int local_max = 0;
	int local_pos = 0;
	bool boolmax = false;

	for (int i = 1; i < v.size(); i++)
	{
		if (v[i] > v[i - 1])
		{
			local_max = v[i];
			local_pos = i;
			boolmax = true;
		}
		else if (v[i] < v[i - 1] && boolmax == true)
		{
			result.pos.push_back(local_pos);
			result.peaks.push_back(local_max);
			boolmax = false;
		}
	}
	return result;
}

int main()
{
	PeakData result;

	std::vector<int> v{ 1, 2, 2, 2, 3 };
	result = pick_peaks(v);

	for (int i = 0; i < result.peaks.size(); i++)
	{
		cout << "pos = " << result.pos[i] << " | peak = " << result.peaks[i] << endl;
	}

	cout << endl;
	std::vector<int> s{ 3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3 };
	result = pick_peaks(s);
	for (int i = 0; i < result.peaks.size(); i++)
	{
		cout << "pos = " << result.pos[i] << " | peak = " << result.peaks[i] << endl;
	}

	cout << endl;
	std::vector<int> y{ 1, 2, 2, 2, 1 };
	result = pick_peaks(y);
	for (int i = 0; i < result.peaks.size(); i++)
	{
		cout << "pos = " << result.pos[i] << " | peak = " << result.peaks[i] << endl;
	}
}