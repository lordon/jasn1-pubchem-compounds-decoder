/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uni_leipzig.dbs.jasn1.pubchem.util.PCAtomsFilter;
import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.BerInteger;

/**
 * Atom Information (in Parallel Arrays)
 */
public class PCAtoms implements Serializable {

  private PCAtomsFilter pcAtomsFilter = null;

  private static final long serialVersionUID = 1L;

  /**
   * Atom Identifiers (vector)
   */
  public static class Aid implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<BerInteger> seqOf = null;

    public Aid() {
      seqOf = new ArrayList<>();
    }

    public Aid(final byte[] code) {
      this.code = code;
    }

    public List<BerInteger> getBerInteger() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, true);
    }

    public int decode(final InputStream is, final boolean withTag) throws IOException {
      int codeLength = 0;
      int subCodeLength = 0;
      BerTag berTag = new BerTag();
      if (withTag) {
        codeLength += tag.decodeAndCheck(is);
      }

      BerLength length = new BerLength();
      codeLength += length.decode(is);
      int totalLength = length.val;

      if (length.val == -1) {
        while (true) {
          subCodeLength += berTag.decode(is);

          if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
            int nextByte = is.read();
            if (nextByte != 0) {
              if (nextByte == -1) {
                throw new EOFException("Unexpected end of input stream.");
              }
              throw new IOException("Decoded sequence has wrong end of contents octets");
            }
            codeLength += subCodeLength + 1;
            return codeLength;
          }

          BerInteger element = new BerInteger();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      throw new IOException("Unexpected end of sequence, length tag: " + totalLength
          + " But only indefinite length tag supported");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<BerInteger> it = seqOf.iterator();
        if (it.hasNext()) {
          sb.append(it.next());
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            sb.append(it.next());
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }

    public byte[] getCode() {
      return code;
    }

    public void setCode(final byte[] code) {
      this.code = code;
    }

    public List<BerInteger> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<BerInteger> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  /**
   * Atomic Numbers (vector)
   */
  public static class Element implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCElement> seqOf = null;

    public Element() {
      seqOf = new ArrayList<>();
    }

    public Element(final byte[] code) {
      this.code = code;
    }

    public List<PCElement> getPCElement() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, true);
    }

    public int decode(final InputStream is, final boolean withTag) throws IOException {
      int codeLength = 0;
      int subCodeLength = 0;
      BerTag berTag = new BerTag();
      if (withTag) {
        codeLength += tag.decodeAndCheck(is);
      }

      BerLength length = new BerLength();
      codeLength += length.decode(is);
      int totalLength = length.val;

      if (length.val == -1) {
        while (true) {
          subCodeLength += berTag.decode(is);

          if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
            int nextByte = is.read();
            if (nextByte != 0) {
              if (nextByte == -1) {
                throw new EOFException("Unexpected end of input stream.");
              }
              throw new IOException("Decoded sequence has wrong end of contents octets");
            }
            codeLength += subCodeLength + 1;
            return codeLength;
          }

          PCElement element = new PCElement();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      throw new IOException("Unexpected end of sequence, length tag: " + totalLength
          + " But only indefinite length tag supported");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<PCElement> it = seqOf.iterator();
        if (it.hasNext()) {
          sb.append(it.next());
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            sb.append(it.next());
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }

    public byte[] getCode() {
      return code;
    }

    public void setCode(final byte[] code) {
      this.code = code;
    }

    public List<PCElement> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCElement> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  /**
   * Atom labels
   */
  public static class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCAtomString> seqOf = null;

    public Label() {
      seqOf = new ArrayList<>();
    }

    public Label(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomString> getPCAtomString() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, true);
    }

    public int decode(final InputStream is, final boolean withTag) throws IOException {
      int codeLength = 0;
      int subCodeLength = 0;
      BerTag berTag = new BerTag();
      if (withTag) {
        codeLength += tag.decodeAndCheck(is);
      }

      BerLength length = new BerLength();
      codeLength += length.decode(is);
      int totalLength = length.val;

      if (length.val == -1) {
        while (true) {
          subCodeLength += berTag.decode(is);

          if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
            int nextByte = is.read();
            if (nextByte != 0) {
              if (nextByte == -1) {
                throw new EOFException("Unexpected end of input stream.");
              }
              throw new IOException("Decoded sequence has wrong end of contents octets");
            }
            codeLength += subCodeLength + 1;
            return codeLength;
          }

          PCAtomString element = new PCAtomString();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      throw new IOException("Unexpected end of sequence, length tag: " + totalLength
          + " But only indefinite length tag supported");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<PCAtomString> it = seqOf.iterator();
        if (it.hasNext()) {
          it.next().appendAsString(sb, indentLevel + 1);
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            it.next().appendAsString(sb, indentLevel + 1);
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }

    public byte[] getCode() {
      return code;
    }

    public void setCode(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomString> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCAtomString> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  /**
   * Isotopic Information
   */
  public static class Isotope implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCAtomInt> seqOf = null;

    public Isotope() {
      seqOf = new ArrayList<>();
    }

    public Isotope(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomInt> getPCAtomInt() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, true);
    }

    public int decode(final InputStream is, final boolean withTag) throws IOException {
      int codeLength = 0;
      int subCodeLength = 0;
      BerTag berTag = new BerTag();
      if (withTag) {
        codeLength += tag.decodeAndCheck(is);
      }

      BerLength length = new BerLength();
      codeLength += length.decode(is);
      int totalLength = length.val;

      if (length.val == -1) {
        while (true) {
          subCodeLength += berTag.decode(is);

          if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
            int nextByte = is.read();
            if (nextByte != 0) {
              if (nextByte == -1) {
                throw new EOFException("Unexpected end of input stream.");
              }
              throw new IOException("Decoded sequence has wrong end of contents octets");
            }
            codeLength += subCodeLength + 1;
            return codeLength;
          }

          PCAtomInt element = new PCAtomInt();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      throw new IOException("Unexpected end of sequence, length tag: " + totalLength
          + " But only indefinite length tag supported");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<PCAtomInt> it = seqOf.iterator();
        if (it.hasNext()) {
          it.next().appendAsString(sb, indentLevel + 1);
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            it.next().appendAsString(sb, indentLevel + 1);
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }

    public byte[] getCode() {
      return code;
    }

    public void setCode(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomInt> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCAtomInt> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  /**
   * Formal Charges
   */
  public static class Charge implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCAtomInt> seqOf = null;

    public Charge() {
      seqOf = new ArrayList<>();
    }

    public Charge(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomInt> getPCAtomInt() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, true);
    }

    public int decode(final InputStream is, final boolean withTag) throws IOException {
      int codeLength = 0;
      int subCodeLength = 0;
      BerTag berTag = new BerTag();
      if (withTag) {
        codeLength += tag.decodeAndCheck(is);
      }

      BerLength length = new BerLength();
      codeLength += length.decode(is);
      int totalLength = length.val;

      if (length.val == -1) {
        while (true) {
          subCodeLength += berTag.decode(is);

          if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
            int nextByte = is.read();
            if (nextByte != 0) {
              if (nextByte == -1) {
                throw new EOFException("Unexpected end of input stream.");
              }
              throw new IOException("Decoded sequence has wrong end of contents octets");
            }
            codeLength += subCodeLength + 1;
            return codeLength;
          }

          PCAtomInt element = new PCAtomInt();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      throw new IOException("Unexpected end of sequence, length tag: " + totalLength
          + " But only indefinite length tag supported");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<PCAtomInt> it = seqOf.iterator();
        if (it.hasNext()) {
          it.next().appendAsString(sb, indentLevel + 1);
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            it.next().appendAsString(sb, indentLevel + 1);
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }

    public byte[] getCode() {
      return code;
    }

    public void setCode(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomInt> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCAtomInt> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  /**
   * Radical Information
   */
  public static class Radical implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCAtomRadical> seqOf = null;

    public Radical() {
      seqOf = new ArrayList<>();
    }

    public Radical(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomRadical> getPCAtomRadical() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, true);
    }

    public int decode(final InputStream is, final boolean withTag) throws IOException {
      int codeLength = 0;
      int subCodeLength = 0;
      BerTag berTag = new BerTag();
      if (withTag) {
        codeLength += tag.decodeAndCheck(is);
      }

      BerLength length = new BerLength();
      codeLength += length.decode(is);
      int totalLength = length.val;

      if (length.val == -1) {
        while (true) {
          subCodeLength += berTag.decode(is);

          if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
            int nextByte = is.read();
            if (nextByte != 0) {
              if (nextByte == -1) {
                throw new EOFException("Unexpected end of input stream.");
              }
              throw new IOException("Decoded sequence has wrong end of contents octets");
            }
            codeLength += subCodeLength + 1;
            return codeLength;
          }

          PCAtomRadical element = new PCAtomRadical();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      throw new IOException("Unexpected end of sequence, length tag: " + totalLength
          + " But only indefinite length tag supported");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<PCAtomRadical> it = seqOf.iterator();
        if (it.hasNext()) {
          it.next().appendAsString(sb, indentLevel + 1);
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            it.next().appendAsString(sb, indentLevel + 1);
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }

    public byte[] getCode() {
      return code;
    }

    public void setCode(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomRadical> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCAtomRadical> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  /**
   * E.g. identity of MMDB "R" groups
   */
  public static class Source implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCAtomSource> seqOf = null;

    public Source() {
      seqOf = new ArrayList<>();
    }

    public Source(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomSource> getPCAtomSource() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, true);
    }

    public int decode(final InputStream is, final boolean withTag) throws IOException {
      int codeLength = 0;
      int subCodeLength = 0;
      BerTag berTag = new BerTag();
      if (withTag) {
        codeLength += tag.decodeAndCheck(is);
      }

      BerLength length = new BerLength();
      codeLength += length.decode(is);
      int totalLength = length.val;

      if (length.val == -1) {
        while (true) {
          subCodeLength += berTag.decode(is);

          if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
            int nextByte = is.read();
            if (nextByte != 0) {
              if (nextByte == -1) {
                throw new EOFException("Unexpected end of input stream.");
              }
              throw new IOException("Decoded sequence has wrong end of contents octets");
            }
            codeLength += subCodeLength + 1;
            return codeLength;
          }

          PCAtomSource element = new PCAtomSource();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      throw new IOException("Unexpected end of sequence, length tag: " + totalLength
          + " But only indefinite length tag supported");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<PCAtomSource> it = seqOf.iterator();
        if (it.hasNext()) {
          it.next().appendAsString(sb, indentLevel + 1);
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            it.next().appendAsString(sb, indentLevel + 1);
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }

    public byte[] getCode() {
      return code;
    }

    public void setCode(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomSource> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCAtomSource> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  /**
   * Atom Comments
   */
  public static class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCAtomString> seqOf = null;

    public Comment() {
      seqOf = new ArrayList<>();
    }

    public Comment(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomString> getPCAtomString() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, true);
    }

    public int decode(final InputStream is, final boolean withTag) throws IOException {
      int codeLength = 0;
      int subCodeLength = 0;
      BerTag berTag = new BerTag();
      if (withTag) {
        codeLength += tag.decodeAndCheck(is);
      }

      BerLength length = new BerLength();
      codeLength += length.decode(is);
      int totalLength = length.val;

      if (length.val == -1) {
        while (true) {
          subCodeLength += berTag.decode(is);

          if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
            int nextByte = is.read();
            if (nextByte != 0) {
              if (nextByte == -1) {
                throw new EOFException("Unexpected end of input stream.");
              }
              throw new IOException("Decoded sequence has wrong end of contents octets");
            }
            codeLength += subCodeLength + 1;
            return codeLength;
          }

          PCAtomString element = new PCAtomString();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      throw new IOException("Unexpected end of sequence, length tag: " + totalLength
          + " But only indefinite length tag supported");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<PCAtomString> it = seqOf.iterator();
        if (it.hasNext()) {
          it.next().appendAsString(sb, indentLevel + 1);
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            it.next().appendAsString(sb, indentLevel + 1);
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }

    public byte[] getCode() {
      return code;
    }

    public void setCode(final byte[] code) {
      this.code = code;
    }

    public List<PCAtomString> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCAtomString> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  public byte[] code = null;
  private Aid aid = null;
  private Element element = null;
  private Label label = null;
  private Isotope isotope = null;
  private Charge charge = null;
  private Radical radical = null;
  private Source source = null;
  private Comment comment = null;

  public PCAtoms() {
  }

  public PCAtoms(final PCAtomsFilter pcAtomsFilter) {
    this.pcAtomsFilter = pcAtomsFilter;
  }

  public PCAtoms(final byte[] code) {
    this.code = code;
  }

  public void setAid(final Aid aid) {
    this.aid = aid;
  }

  /**
   * @return Atom Identifiers (vector)
   */
  public Aid getAid() {
    return aid;
  }

  public void setElement(final Element element) {
    this.element = element;
  }

  /**
   * @return Atomic Numbers (vector)
   */
  public Element getElement() {
    return element;
  }

  public void setLabel(final Label label) {
    this.label = label;
  }

  /**
   * @return Atom labels
   */
  public Label getLabel() {
    return label;
  }

  public void setIsotope(final Isotope isotope) {
    this.isotope = isotope;
  }

  /**
   * @return Isotopic Information
   */
  public Isotope getIsotope() {
    return isotope;
  }

  public void setCharge(final Charge charge) {
    this.charge = charge;
  }

  /**
   * @return Formal Charges
   */
  public Charge getCharge() {
    return charge;
  }

  public void setRadical(final Radical radical) {
    this.radical = radical;
  }

  /**
   * @return Radical Information
   */
  public Radical getRadical() {
    return radical;
  }

  public void setSource(final Source source) {
    this.source = source;
  }

  /**
   * @return E.g. identity of MMDB "R" groups
   */
  public Source getSource() {
    return source;
  }

  public void setComment(final Comment comment) {
    this.comment = comment;
  }

  /**
   * @return Atom Comments
   */
  public Comment getComment() {
    return comment;
  }

  public int decode(final InputStream is) throws IOException {
    return decode(is, true);
  }

  public int decode(final InputStream is, final boolean withTag) throws IOException {
    int codeLength = 0;
    int subCodeLength = 0;
    BerTag berTag = new BerTag();

    if (withTag) {
      codeLength += tag.decodeAndCheck(is);
    }

    BerLength length = new BerLength();
    codeLength += length.decode(is);

    int totalLength = length.val;
    if (totalLength == -1) {
      subCodeLength += berTag.decode(is);

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
        codeLength += length.decode(is);
        aid = new Aid();
        subCodeLength += aid.decode(is, true);
        subCodeLength += berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
        codeLength += length.decode(is);
        element = new Element();
        subCodeLength += element.decode(is, true);
        subCodeLength += berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
        codeLength += length.decode(is);
        label = new Label();
        subCodeLength += label.decode(is, true);
        if (pcAtomsFilter.isSkipOptionalAtomData()) {
          label = null;
        }
        subCodeLength += berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
        codeLength += length.decode(is);
        isotope = new Isotope();
        subCodeLength += isotope.decode(is, true);
        if (pcAtomsFilter.isSkipOptionalAtomData()) {
          isotope = null;
        }
        subCodeLength += berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
        codeLength += length.decode(is);
        charge = new Charge();
        subCodeLength += charge.decode(is, true);
        if (pcAtomsFilter.isSkipOptionalAtomData()) {
          charge = null;
        }
        subCodeLength += berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
        codeLength += length.decode(is);
        radical = new Radical();
        subCodeLength += radical.decode(is, true);
        if (pcAtomsFilter.isSkipOptionalAtomData()) {
          radical = null;
        }
        subCodeLength += berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
        codeLength += length.decode(is);
        source = new Source();
        subCodeLength += source.decode(is, true);
        if (pcAtomsFilter.isSkipOptionalAtomData()) {
          source = null;
        }
        subCodeLength += berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
        codeLength += length.decode(is);
        comment = new Comment();
        subCodeLength += comment.decode(is, true);
        if (pcAtomsFilter.isSkipOptionalAtomData()) {
          comment = null;
        }
        subCodeLength += berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }
      int nextByte = is.read();
      if (berTag.tagNumber != 0 || berTag.tagClass != 0 || berTag.primitive != 0 || nextByte != 0) {
        if (nextByte == -1) {
          throw new EOFException("Unexpected end of input stream.");
        }
        throw new IOException("Decoded sequence has wrong end of contents octets");
      }
      codeLength += subCodeLength + 1;
      return codeLength;
    }
    throw new IOException("Unexpected end of sequence, length tag: " + totalLength
        + " But only indefinite length tag supported");
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    appendAsString(sb, 0);
    return sb.toString();
  }

  public void appendAsString(final StringBuilder sb, final int indentLevel) {

    sb.append("{");
    sb.append("\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (aid != null) {
      sb.append("aid: ");
      aid.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("aid: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (element != null) {
      sb.append("element: ");
      element.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("element: <empty-required-field>");
    }

    if (label != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("label: ");
      label.appendAsString(sb, indentLevel + 1);
    }

    if (isotope != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("isotope: ");
      isotope.appendAsString(sb, indentLevel + 1);
    }

    if (charge != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("charge: ");
      charge.appendAsString(sb, indentLevel + 1);
    }

    if (radical != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("radical: ");
      radical.appendAsString(sb, indentLevel + 1);
    }

    if (source != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("source: ");
      source.appendAsString(sb, indentLevel + 1);
    }

    if (comment != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("comment: ");
      comment.appendAsString(sb, indentLevel + 1);
    }

    sb.append("\n");
    for (int i = 0; i < indentLevel; i++) {
      sb.append("\t");
    }
    sb.append("}");
  }

  public byte[] getCode() {
    return code;
  }

  public void setCode(final byte[] code) {
    this.code = code;
  }

  public static BerTag getTag() {
    return tag;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}