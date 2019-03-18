import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //given
        String text = "my name is Hamlet";
        String expected = "my name is Leon";
        String find = "HAMLET";
        //when
        String actual = hamletParser.replacementString(find,"Leon", text);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeonAllCaps() {
        //given
        String text = "my name is Hamlet";
        String expected = "my name is Leon";
        String find = "hamlet";
        //when
        String actual = hamletParser.replacementString(find,"Leon", text);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        String text = "my name is Horatio";
        String expected = "my name is Tariq";
        String find = "Horatio";
        //when
        String actual = hamletParser.replacementString(find,"Tariq", text);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariqAllCaps() {
        //given
        String text = "my name is HORATIO";
        String expected = "my name is Tariq";
        String find = "Horatio";
        //when
        String actual = hamletParser.replacementString(find,"Tariq", text);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //given
        String text = "my name is Horatio";
        String find = "Horatio";
        //when
        Boolean result = hamletParser.findString(find, text);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFindHoratioAllCaps() {
        //given
        String text = "my name is HORATIO the one and only";
        String find = "Horatio";
        //when
        Boolean result = hamletParser.findString(find, text);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFindHoratioNoSpace() {
        //given
        String text = "my name is the one and onlyhoratio";
        String find = "Horatio";
        //when
        Boolean result = hamletParser.findString(find, text);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFindHoratioWhenNotThere(){
        //given
        String text = "my name is the Hamlet the great";
        String find = "Horatio";
        //when
        Boolean result = hamletParser.findString(find, text);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testFindHamlet() {
        //given
        String text = "my name is Hamlet";
        String find = "Hamlet";
        //when
        Boolean result = hamletParser.findString(find, text);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFindHamletAllCaps() {
        //given
        String text = "HAMLET is my name";
        String find = "Hamlet";
        //when
        Boolean result = hamletParser.findString(find, text);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFindHamletNoSpace() {
        //given
        String text = "my name is the one and onlyHAMLET";
        String find = "Hamlet";
        //when
        Boolean result = hamletParser.findString(find, text);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFindHamletWhenNotThere(){
        //given
        String text = "my name is the one and onlyhoratio";
        String find = "Hamlet";
        //when
        Boolean result = hamletParser.findString(find, text);
        //then
        Assert.assertFalse(result);
    }
}