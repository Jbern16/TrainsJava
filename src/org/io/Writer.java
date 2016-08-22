package org.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public abstract class Writer {
    public static void writeOutputs(String data) {
        try {
            File outputs = new File("station_output.txt");
            FileOutputStream is = new FileOutputStream(outputs);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            BufferedWriter w = new BufferedWriter(osw);
            w.write(data);
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file station_output.txt");
        }
    }
}
