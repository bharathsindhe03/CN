
import java.util.*;
 public class leakyBucketal{
public static void main(String[] args) { 
    System.out.println("enter the number of timeintervals"); 
    Scanner sc =new Scanner(System.in);
    int n=sc.nextInt(); 
    int t[]=new int[n];
    System.out.println("enter the timeintervals"); 
    for(int i=0;i<n;i++)
        t[i]=sc.nextInt(); 
    System.out.println("enter i and l"); 
    int i=sc.nextInt();
    int l=sc.nextInt(); 
    int lct=t[0];
    int x=0,y=0;
    for(int j=0;j<n;j++){
        y=x-(t[j]-lct); 
        if(y>l)
            System.out.println("nonconforming packet"+t[j]);
        else
            x=y+i;
        lct=t[j];
        System.out.println("conforming packet"+t[j]);
    }
    }
}