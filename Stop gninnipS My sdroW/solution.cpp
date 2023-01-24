//Solution by https://github.com/Spion-Spion
/*
Write a function that takes in a string of one or more words, and returns the same string,
but with all five or more letter words reversed (Just like the name of this Kata). 
Strings passed in will consist of only letters and spaces.
Spaces will be included only when more than one word is present.

Examples:

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"
*/

#include <vector>
#include <string>
#include <iostream>

using namespace std;

std::string spinWords(const std::string& str)
{
	string temp;
	string tempx;
	string new_string;
	int len = str.length();
	int temp_len;
	int start = 0;
	int end = 0;

	for (int i = 1; i <= len; i++)
	{
		if (str[i] == ' ' || str[i] == '\0')
		{
			end = i;
			temp = str.substr(start, end - start);
			temp_len = temp.length();
			if (temp_len >= 5)
			{
				tempx = temp;

				for (int i = 0; i < temp_len; i++)
				{
					temp[temp_len - 1 - i] = tempx[i];
				}
			}

			new_string = new_string + temp;

			if (i < len)
			{
				new_string = new_string + ' ';
			}

			start = i + 1;
		}
	}

	return new_string;
}


int main()
{
	cout << spinWords("gnitseretni am azzip dluoc ylniaM are sotamoT sdnik ylniaM are they azzip used I") << endl;

}