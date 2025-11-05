import java.util.*;

public class MRU
{
    public static void main(String []arg)
    {
        Scanner sobj = new Scanner(System.in);
        
        System.out.print("Enter the number of pages: ");
        int n = sobj.nextInt();

        System.out.print("Enter the frame size: ");
        int frame = sobj.nextInt();

        System.out.println("Enter the pages: ");

        List<Integer> arr = new ArrayList<>();

        int fault = 0;

        for(int i = 0; i<n; i++)
        {
            int x = sobj.nextInt();
            if(arr.contains(x) == false)
            {
                if(arr.size() == frame)
                {
                    arr.remove(arr.get(frame-1));
                }

                arr.add(x);
                fault++;
            }
            else
            {
                System.out.println(Integer.valueOf(x));
                System.out.println(x);
                arr.remove(Integer.valueOf(x));
                arr.add(x);
            }

            for(int j = 0; j<arr.size(); j++)
            {
                System.out.print(arr.get(j) + "\t");
            }
            System.out.println();
        }

        System.out.println("Total number of page faults: " + fault);

    }
}