package evanq.game.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class IOUtils {

    private IOUtils() {
        // utility class
    }

    /**
     * Close an output stream without throwing an exception.
     *
     * @param out the output stream or null
     */
    public static void closeSilently(Closeable out) {
        if (out != null) {
            try {              
                out.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }

    /**
     * Skip a number of bytes in an input stream.
     *
     * @param in the input stream
     * @param skip the number of bytes to skip
     * @throws EOFException if the end of file has been reached before all bytes
     *             could be skipped
     * @throws IOException if an IO exception occurred while skipping
     */
    public static void skipFully(InputStream in, long skip) throws IOException {
        try {
            while (skip > 0) {
                long skipped = in.skip(skip);
                if (skipped <= 0) {
                    throw new EOFException();
                }
                skip -= skipped;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Skip a number of characters in a reader.
     *
     * @param reader the reader
     * @param skip the number of characters to skip
     * @throws EOFException if the end of file has been reached before all
     *             characters could be skipped
     * @throws IOException if an IO exception occurred while skipping
     */
    public static void skipFully(Reader reader, long skip) throws IOException {
        try {
            while (skip > 0) {
                long skipped = reader.skip(skip);
                if (skipped <= 0) {
                    throw new EOFException();
                }
                skip -= skipped;
            }
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Close an input stream without throwing an exception.
     *
     * @param in the input stream or null
     */
    public static void closeSilently(InputStream in) {
        if (in != null) {
            try {
               
                in.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }

    /**
     * Close a reader without throwing an exception.
     *
     * @param reader the reader or null
     */
    public static void closeSilently(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }

    /**
     * Close a writer without throwing an exception.
     *
     * @param writer the writer or null
     */
    public static void closeSilently(Writer writer) {
        if (writer != null) {
            try {
                writer.flush();
                writer.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }


    /**
     * Create a buffered reader to read from an input stream using the UTF-8
     * format. If the input stream is null, this method returns null. The
     * InputStreamReader that is used here is not exact, that means it may read
     * some additional bytes when buffering.
     *
     * @param in the input stream or null
     * @return the reader
     */
    public static Reader getBufferedReader(InputStream in) {
        return in == null ? null : new BufferedReader(new InputStreamReader(in, CharsetUtil.UTF_8));
    }

    /**
     * Create a reader to read from an input stream using the UTF-8 format. If
     * the input stream is null, this method returns null. The InputStreamReader
     * that is used here is not exact, that means it may read some additional
     * bytes when buffering.
     *
     * @param in the input stream or null
     * @return the reader
     */
    public static Reader getReader(InputStream in) {
        // InputStreamReader may read some more bytes
        return in == null ? null : new BufferedReader(new InputStreamReader(in, CharsetUtil.UTF_8));
    }

    /**
     * Create a buffered writer to write to an output stream using the UTF-8
     * format. If the output stream is null, this method returns null.
     *
     * @param out the output stream or null
     * @return the writer
     */
    public static Writer getBufferedWriter(OutputStream out) {
        return out == null ? null : new BufferedWriter(new OutputStreamWriter(out, CharsetUtil.UTF_8));
    }

    /**
     * Wrap an input stream in a reader. The bytes are converted to characters
     * using the US-ASCII character set.
     *
     * @param in the input stream
     * @return the reader
     */
    public static Reader getAsciiReader(InputStream in) {
        try {
            return in == null ? null : new InputStreamReader(in, "US-ASCII");
        } catch (Exception e) {
        	e.printStackTrace();
        	return null;
        }
    }

 
    /**
     * Create an input stream to read from a string. The string is converted to
     * a byte array using UTF-8 encoding.
     * If the string is null, this method returns null.
     *
     * @param s the string
     * @return the input stream
     */
    public static InputStream getInputStreamFromString(String s) {
        if (s == null) {
            return null;
        }
        return new ByteArrayInputStream(s.getBytes(CharsetUtil.UTF_8));
    }

 
}
