package firstt;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Fourth
{
@Test
public void run()
{
	Logger log=Logger.getLogger("Fouth");
	log.info("hello world");
	log.warn("warning");
	log.error("erroring");
	
}
}
