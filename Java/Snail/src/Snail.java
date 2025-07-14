import java.util.ArrayList;

public class Snail {
	
	static public void SnailTest1() {
        int[][] array
                = {	{1,   2,  3,  4},
	                {5,   6,  7,  8},
	                {9,  10, 11, 12},
	                {13, 14, 15, 16}
	                };
        
        int[] r = {1, 2, 3, 4,8, 12, 16,15, 14,13,9,5,6,7,11,10};
        test(array, r);
    }
	
	static public void test(int[][] arr, int[] exp)
	{
		int ans[] = snail(arr);
		
		if ( exp.equals(ans))
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("Not OK");
			System.out.println();
			for(int el : ans)
			{
				System.out.print(el + ", ");
			}
			System.out.println();
			for(int el : exp)
			{
				System.out.print(el + ", ");
			}
			System.out.println();
			System.out.println();
			
		}
	}
	
	public static int[] snail(int[][] array) {
		
	     ArrayList<Integer> list = new ArrayList<Integer>();
	     
	     if (array.length == 0 || array[0].length == 0) {
	         return new int[0];
	     }
	     
	     
	     int dir = 1; // 0= left 1 = rigth 2=down 3=up
	     int steps = 0;
	     int posX = 0;
	     int posY = 0;
	     
	     int leftBound = 0;
	     int rigthBound = array[0].length-1;
	     int upBound = 1;
	     int downBound = array.length-1;
	     
	     
	     
		 while(steps < array.length*array.length)
		 {
			 steps++;
			 list.add(array[posY][posX]);
			 
			 switch(dir)
			 {
			 case 1: { //rigth
				 
				 if( posX < rigthBound )
				 {
					 posX++;
				 }
				 else
				 {
					 dir = 2;
					 rigthBound--;
					 posY++;
				 }
				 
			 } break;
			 case 0: { //left
				 if( posX > leftBound )
				 {
					 posX--;
				 }else
				 {
					 dir = 3;
					 leftBound++;
					 posY--;
				 }
				 
				 
			 } break;
			 case 2: { //down
				 
				 if( posY < downBound )
				 {
					 posY++;
				 }else
				 {
					 dir = 0;
					 downBound--;
					 posX--;
				 }
				 
			 } break;
			 case 3: { //up
				 
				 if( posY > upBound )
				 {
					 posY--;
				 }else
				 {
					 dir = 1;
					 upBound++;
					 posX++;
				 }
				 
			 } break;
			 }
		 }
		 
		 int[] result = new int[list.size()];
		 for (int i = 0; i < list.size(); i++) {
		     result[i] = list.get(i);
		 }
		 return result;
	   }
	
	static public void main(String args[])
	{
		SnailTest1();
	}
}
