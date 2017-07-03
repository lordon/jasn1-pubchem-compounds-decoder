package de.uni_leipzig.dbs.jasn1.pubchem.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/**
 * Some methods in the jASN1 dependency expect a greedy input stream. This makes
 * {@link GZIPInputStream} greedy.
 */
public class PubchemGzipInputStream extends GZIPInputStream {

  public PubchemGzipInputStream(final InputStream is) throws IOException {
    super(is);

  }

  public PubchemGzipInputStream(final InputStream is, final int bufSize) throws IOException {
    super(is, bufSize);
  }

  /**
   * <pre>
   * This blocks until len bytes are read or EOF occurrs.
   * </pre>
   *
   * {@inheritDoc}
   */
  @Override
  public int read(final byte[] b, int off, int len) throws IOException {
    int sumBytesRead = 0;
    do {
      int bytesRead = super.read(b, off, len);
      if (bytesRead == -1) {
        throw new EOFException("Unexpected end of input stream.");
      }

      len -= bytesRead;
      sumBytesRead += bytesRead;
      off += bytesRead;
    } while (len > 0);

    return sumBytesRead;

  }
}
