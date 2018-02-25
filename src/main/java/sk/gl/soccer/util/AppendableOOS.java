package sk.gl.soccer.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableOOS extends ObjectOutputStream {
    private static boolean first = true;

    public AppendableOOS(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        if (first) {
            super.writeStreamHeader();
            first = false;
        } else {
            reset();
        }
    }
}
