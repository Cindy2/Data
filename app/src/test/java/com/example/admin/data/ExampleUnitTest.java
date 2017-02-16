package com.example.admin.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        int result = Utils.add(3,5);
        //断言：用来检测实际值与期望值是否一致
        assertEquals(8,result);
        Utils.chuyi(2,1);
    }

}