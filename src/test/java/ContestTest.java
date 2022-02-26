import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContestTest {

    @Test
    public void shouldReturnSameiFLengthIsTwo(){
        Contest contest = new Contest();
        int[] test = new int[]{1,2};
        int[] actual = contest.sortEvenOdd(test);
        assertEquals(test,actual);
    }


}