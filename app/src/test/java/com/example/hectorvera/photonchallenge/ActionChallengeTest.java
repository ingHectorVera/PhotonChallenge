package com.example.hectorvera.photonchallenge;

import com.example.hectorvera.photonchallenge.model.PathSeeker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ActionChallengeTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void Test1() throws Exception {
        assertEquals(Library.RESULT_1, PathSeeker.seekPath(Library.TEST_1));
    }

    @Test
    public void Test2() throws Exception {
        assertEquals(Library.RESULT_2, PathSeeker.seekPath(Library.TEST_2));
    }

    @Test
    public void Test3() throws Exception {
        assertEquals(Library.RESULT_3, PathSeeker.seekPath(Library.TEST_3));
    }
}