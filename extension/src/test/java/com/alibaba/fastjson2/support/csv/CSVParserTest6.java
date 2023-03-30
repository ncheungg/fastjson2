package com.alibaba.fastjson2.support.csv;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVParserTest6 {

    @Test
    public void testInvalidFile() throws IOException {
        File file = new File("asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf.txt");
        int count = CSVParser.rowCount(file);

        assertEquals(-1, count);
    }

}
