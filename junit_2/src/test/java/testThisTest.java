import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testThisTest {
    @Test
    public void getNameAtIndexTest() {
        System.out.println("getNameAtIndex Test");
        testThis tester = new testThis();

        assertEquals("Tony",tester.getNameAtIndex(2));
        assertEquals("Mike",tester.getNameAtIndex(0));

        tester.addEntryToArray("Jared");
        assertEquals("Jared",tester.getNameAtIndex(3));

        System.out.println("getNames= "+tester.getNames());
    }

}
