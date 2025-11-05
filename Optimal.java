/*
15
3
6 7 8 9 6 7 1 6 7 8 9 1 7 9 6
*/

import java.util.*;

public class temp
{
    public static void main(String []arg)
    {
        Scanner sobj = new Scanner(System.in);
        
        System.out.print("Enter the number of pages: ");
        int n = sobj.nextInt();

        System.out.print("Enter the frame size: ");
        int frame = sobj.nextInt();

        System.out.println("Enter the pages: ");
        
        int []pages = new int[n];
        for(int i = 0; i<n; i++)
        {
            pages[i] = sobj.nextInt();
        }

        List<Integer> arr = new ArrayList<>();
        int fault = 0;

        for(int i = 0; i<n; i++)
        {
            int x = pages[i];
            if(!arr.contains(x))
            {
                if(arr.size() == frame)
                {
                    List<Integer> frames = new ArrayList<>();
                    for(int j = 0; j<frame; j++)
                    {
                        frames.add(arr.get(j));
                    }

                    for(int k=i; k<n; k++)
                    {
                        if(frames.size() == 1)
                            break;

                        if(frames.contains(pages[k]))
                            frames.remove(Integer.valueOf(pages[k]));                            
                    }

                    arr.remove(Integer.valueOf(frames.get(0)));
                }

                arr.add(x);
                
                fault++;
            }
        }

        System.out.println("Total number of page faults: " + fault);

    }
}