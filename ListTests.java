import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import java.util.*;

public class ListTests {
    public class Checker implements StringChecker{
        public boolean checkString(String s){
            return s.length() > 3;
        }

    }
    @Test
    public void testMethod1(){
        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("hi");
        list.add("what's up");
        list.add("y");
        list.add("aye");
        list.add("am i more than you bargained for yet");

        List<String> filtered = ListExamples.filter(list, new Checker());
        List<String>  expected = new ArrayList<>();
        expected.add("hello");
        expected.add("what's up");
        expected.add("am i more than you bargained for yet");

        assertEquals(3, filtered.size());
        for(int i = 0;  i < filtered.size(); i++){
            assertEquals(expected.get(i), filtered.get(i));
        }
    }

    @Test
    public void testMethod2(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("i");
        list2.add("j");
        list2.add("y");

        list1.add("a");
        list1.add("d");
        list1.add("x");

        List<String> result = ListExamples.merge(list1, list2);

        assertEquals(list1.size() + list2.size(), result.size());

        List<String> expectedSolution = new ArrayList<>();
        expectedSolution.add("a");
        expectedSolution.add("a");
        expectedSolution.add("b");
        expectedSolution.add("c");
        expectedSolution.add("d");
        expectedSolution.add("i");
        expectedSolution.add("j");
        expectedSolution.add("x");
        expectedSolution.add("y");
        

        assertArrayEquals(expectedSolution.toArray(), result.toArray());

        

    }
}
