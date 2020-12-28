package com.cherish.practicalpractice.debugging;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class BreakPointActivityTest {
    //************** call the class you want to test ***********
    BreakPointActivity breakPointActivity;


    //******* create an instance of the class
    @Before
    public  void  setUp(){
        breakPointActivity = new BreakPointActivity();
    }

    //***************Test addition/ test for addition ********

    @Test
    public  void  testAddition(){
      int result =  breakPointActivity.addNumber(2, 5);
      assertThat(result, is(equalTo(7)));
    }

    @Test
    public void  addNegativeNumber(){
        int actual = breakPointActivity.addNumber(-2, -3);
        assertThat("equal", actual, is(equalTo(-5)));
    }

    @Test
    public  void  subtractNumber(){
        int result = breakPointActivity.subtractNumber(20,2);
        assertThat(result, is(equalTo(18)));
    }

    @Test
    public  void  subtractWithNegative(){
        int result = breakPointActivity.subtractNumber(-1, -2);
        assertThat(result, is(equalTo(1)));
    }

    @Test
    public void multiplyNumber(){
        int result = breakPointActivity.multiplyNumber(2,2);
        assertThat(result, is(equalTo(4)));
    }

    @Test
    public void  multiplyNumberWithZero(){
        int result = breakPointActivity.multiplyNumber(3, 0);
        assertThat(result, is(equalTo(0)));

    }

    @Test
    public void  divideNumber(){
        int result = breakPointActivity.divideNumber(6,2);
        assertThat(result, is(equalTo(3)));
    }

    @Test(expected = ArithmeticException.class)
    public void  divideNumberWithZero(){
        int result = breakPointActivity.divideNumber(5, 0);
        assertThat(result, is(equalTo(5)));
    }






}