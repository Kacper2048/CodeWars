
public class Kata {
	
	public static boolean isValid(char[] walk) {
	    // Insert brilliant code here
		int posX = 0;
		int posY = 0;
		
		if(walk.length != 10){
			return false;
		}
		else{
			for( char dir : walk) {
				switch(dir) {
				case 'n':{ posY--; } break;
				case 's':{ posY++; } break;
				case 'w':{ posX--; } break;
				case 'e':{ posX++; } break;
				}
			}	
			if(posY == 0 && posX == 0)
				return true;
		}
		return false;
	  }
	
	public static void doTest(char[] arr, boolean result)
	{
		if(isValid(arr) == result)
		  {
			  System.out.printf("OK\n");
		  }
		  else
		  {
			  System.out.printf("~!ERROR!~\n");
		  }
	}
	
	public static void main(String args[])
	{
	    doTest(new char[] {'n'}, false);
        doTest(new char[] {'n', 's'}, false);
		doTest(new char[] {'n','s','n','s','n','s','n','s','n','s','n','s'}, false);
        doTest(new char[] {'n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w'}, false);
        doTest(new char[] {'n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w'}, false);
		doTest(new char[] {'n','s','n','s','n','s','n','s','n','n'}, false);
	    doTest(new char[] {'e','e','e','w','n','s','n','s','e','w'}, false);
	    doTest(new char[] {'n','e','n','e','n','e','n','e','n','e'}, false);
	    doTest(new char[] {'n','w','n','w','n','w','n','w','n','w'}, false);
	    doTest(new char[] {'s','e','s','e','s','e','s','e','s','e'}, false);
	    doTest(new char[] {'s','w','s','w','s','w','s','w','s','w'}, false);
	    doTest(new char[] {'n','s','n','s','n','s','n','s','n','s'}, true);
        doTest(new char[] {'e','w','e','w','n','s','n','s','e','w'}, true);
        doTest(new char[] {'n','s','e','w','n','s','e','w','n','s'}, true);
	}

	
}
