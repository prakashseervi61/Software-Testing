import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class TestNG {
    @Test(priority = 1)
        public void L(){
            System.out.println("Hello");
        }
    @Test(priority = 0)
        public void M(){
            String a = "a";
            String b = "b";
            Assert.assertEquals(a,b);
        }
}
