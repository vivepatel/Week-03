import org.junit.Test;
import stringbuffer.concatenatestrings.ConcatenateStrings;
import stringbuilder.removeduplicates.RemoveDuplicates;
import stringbuilder.reversestring.ReverseString;

import static org.junit.Assert.assertEquals;

public class test {

    @Test
    public void TestReverse(){
        assertEquals(ReverseString.Reverse(new StringBuilder("QWERTY")),"YTREWQ");
    }

    @Test
    public void TestRemoveDuplicates(){
        assertEquals(RemoveDuplicates.removeDuplicates(new StringBuilder("Deepansh")),"Depansh");
    }

    @Test
    public void TestConcat(){
        assertEquals(ConcatenateStrings.Concat(new String[]{"abc","def","ghi","jkl","mno"}), "abcdefghijklmno");
    }
}
