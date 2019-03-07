package firstt;

import org.apache.log4j.Logger;

public class Second  implements First, Third
{
public static void main(String[] args) 
{
	Second s=new Second();
    s.get();
    s.set();
    Logger log = Logger.getLogger("Second");
	log.info("hello world");
	
}

@Override
public void get() {
	System.out.println("hi");
	
}

@Override
public void set() {
	// TODO Auto-generated method stub
	
}



}





/*AnonymousClass a=new AnonymousClass()
{
	    public void set()
	      {		
		    System.out.println("hello");
        }
};*/
