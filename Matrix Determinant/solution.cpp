//Solution by https://github.com/Spion-Spion
/*
Write a function that accepts a square matrix (N x N 2D array) and returns the determinant of the matrix.
How to take the determinant of a matrix -- it is simplest to start with the smallest cases:

A 1x1 matrix |a| has determinant a.
A 2x2 matrix [ [a, b], [c, d] ] or
|a  b|
|c  d|

has determinant: a*d - b*c.

The determinant of an n x n sized matrix is calculated by reducing the problem to the calculation of the determinants of n matrices ofn-1 x n-1 size.
For the 3x3 case, [ [a, b, c], [d, e, f], [g, h, i] ] or

|a b c|
|d e f|
|g h i|

the determinant is: a * det(a_minor) - b * det(b_minor) + c * det(c_minor) where det(a_minor) refers to taking the determinant of the 2x2 matrix created by crossing out the row and column in which the element a occurs:

|- - -|
|- e f|
|- h i|

Note the alternation of signs.

The determinant of larger matrices are calculated analogously, e.g. if M is a 4x4 matrix with first row [a, b, c, d], then:
det(M) = a * det(a_minor) - b * det(b_minor) + c * det(c_minor) - d * det(d_minor)


*/

#include <vector>
#include <string>
#include <iostream>
using namespace std;

long long determinant(vector< vector<long long> > m)
{
	long long val = 0;
	long long temp = 0;

	vector < vector<long long>> newone;
	vector<long long> newrow;

	switch (m.size())
	{
	case 1: {return m[0][0]; break;  }

	case 2: {return ((m[0][0] * m[1][1]) - (m[1][0] * m[0][1])); break; }

	default:
	{
		for (int i = 0; i < m.size(); i++) //the change of the temp matrix every interation
		{
			newone.clear();
			newrow.clear();

			for (int y = 1; y < m.size(); y++)//creating tempoprary matrix
			{
				for (int x = 0; x < m.size(); x++)
				{
					if (i != x)
					{
						newrow.push_back(m[y][x]);
					}
				}
				newone.push_back(newrow);
				newrow.clear();
			}

			temp = ((i + 1) % 2 == 1) ? temp = m[0][i] : temp = (-1) * m[0][i]; //a sign will be added for negative numbers

			val = val + temp * determinant(newone);
		}
		return val;
	}
	}
}


int main()
{
	//my own test and test from the site

	vector< vector<long long> > vec;
	vector<long long> X{ 3,2 };
	vector<long long> Y{ 1,4 };
	vector<long long> Z{ 1,4 };

	vec.push_back(X);
	vec.push_back(Y);
	cout << determinant(vec) << endl;

	cout << endl;
	//
	vec.clear();
	X.clear();
	Y.clear();
	Z.clear();

	X = { 4, 2, 2 };
	Y = { 12, 5, 12 };
	Z = { 1, 1, 1 };

	vec.push_back(X);
	vec.push_back(Y);
	vec.push_back(Z);
	cout << determinant(vec) << endl;
	cout << endl;

	//test form site
	vec.clear();
	X.clear();
	Y.clear();
	Z.clear();

	X = { 1, 3 };
	Y = { 2, 5 };

	vec.push_back(X);
	vec.push_back(Y);
	cout << determinant(vec) << endl;
	cout << endl;

	//test form site
	vec.clear();
	X.clear();
	Y.clear();
	Z.clear();

	X = { 2, 5, 3 };
	Y = { 1, -2, -1 };
	Z = { 1, 3, 4 };

	vec.push_back(X);
	vec.push_back(Y);
	vec.push_back(Z);
	cout << determinant(vec) << endl;
	cout << endl;
}