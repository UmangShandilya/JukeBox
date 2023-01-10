package FilePathGetter;

import DataAccess.GetFilePath;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetFilePathTest
{
    @Test
    public void givenValidTrackNameReturnFilePath()
    {
       assertEquals("D:\\IT Studio\\NIIT\\Problem Solving and Computational Thinking using Java\\Java Practice Sets\\Month - August\\12th Aug - 19th Aug 2022\\jap_c7_s1_java_programming_project\\JukeBox\\src\\main\\resources\\Songs\\Lamhe.wav", GetFilePath.getFilePath("Lamhe"));
    }

    @Test
    public void givenInValidTrackNameReturnFilePath()
    {
        assertEquals("",GetFilePath.getFilePath("Lamhee"));
    }
}