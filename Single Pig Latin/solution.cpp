//Solution by https://github.com/Spion-Spion
/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
Examples

pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !
*/

#include <vector>
#include <string>
#include <iostream>
using namespace std;

std::string pig_it(std::string str)
{
	string temp;
	string newone;
	char tempx;

	for (int i = 0; i <= str.length(); i++)
	{
		if (str[i] == ' ' || str[i] == '\0')
		{
			if (temp.length() >= 1 && isalpha(temp[0]))
			{
				tempx = temp[0];
				temp.erase(0, 1);
				temp.push_back(tempx);

				temp = temp + "ay";
			}
			newone = newone + temp;

			if (str[i] == ' ')
			{
				newone.push_back(' ');
			}

			temp.clear();
		}
		else
		{
			temp.push_back(str[i]);
		}
	}
	return newone;
}


int main()
{
	cout << pig_it("Pig latin is cool") << endl;
	cout << pig_it("Hello world !") << endl;

}