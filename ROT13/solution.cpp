//Solution by https://github.com/Spion-Spion
/*
ROT13 is a simple letter substitution cipher that replaces a letter with the letter 13 letters after it in the alphabet. 
ROT13 is an example of the Caesar cipher.

Create a function that takes a string and returns the string ciphered with Rot13. 
If there are numbers or special characters included in the string, they should be returned as they are. 
Only letters from the latin/english alphabet should be shifted, like in the original Rot13 "implementation".
*/

#include <vector>
#include <string>
#include <iostream>
using namespace std;

string rot13(string msg)
{
	int shift = 13;
	//uppercase in ascii range <65 - 90>
	//lowercase in ascii rance <97 - 122>
	int val;
	int cipher_val;

	for (int i = 0; i < msg.length(); i++)
	{
		cipher_val = val = static_cast<int>(msg[i]);

		if (val >= 60 && val <= 90) //uppercase
		{
			cipher_val = val + shift;
			if (cipher_val > 90)
			{
				cipher_val = cipher_val - 26;
			}
		}
		else if (val >= 97 && val <= 122) //lowercase
		{
			cipher_val = val + shift;
			if (cipher_val > 122)
			{
				cipher_val = cipher_val - 26;
			}
		}
		msg[i] = static_cast<char>(cipher_val);
	}

	return msg;
}

int main()
{
	cout << rot13("Ala") << endl;
	cout << rot13("Test") << endl;
}