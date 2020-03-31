package com.excel;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {
        try {
            new ExcelWriteTest().writeWithoutHead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
