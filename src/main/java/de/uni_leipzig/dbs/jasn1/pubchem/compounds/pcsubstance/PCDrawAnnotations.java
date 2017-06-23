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

import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.BerInteger;

public class PCDrawAnnotations implements Serializable {

  private static final long serialVersionUID = 1L;

  public static class Annotation implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCBondAnnotation> seqOf = null;

    public Annotation() {
      seqOf = new ArrayList<>();
    }

    public Annotation(final byte[] code) {
      this.code = code;
    }

    public List<PCBondAnnotation> getPCBondAnnotation() {
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

          PCBondAnnotation element = new PCBondAnnotation();
          subCodeLength += element.decode(is, false);
          seqOf.add(element);
        }
      }
      while (subCodeLength < totalLength) {
        PCBondAnnotation element = new PCBondAnnotation();
        subCodeLength += element.decode(is, true);
        seqOf.add(element);
      }
      if (subCodeLength != totalLength) {
        throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected "
            + totalLength + " but has " + subCodeLength);

      }
      codeLength += subCodeLength;

      return codeLength;
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
        Iterator<PCBondAnnotation> it = seqOf.iterator();
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

    public List<PCBondAnnotation> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCBondAnnotation> seqOf) {
      this.seqOf = seqOf;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public static BerTag getTag() {
      return tag;
    }

  }

  public static class Aid1 implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<BerInteger> seqOf = null;

    public Aid1() {
      seqOf = new ArrayList<>();
    }

    public Aid1(final byte[] code) {
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
      while (subCodeLength < totalLength) {
        BerInteger element = new BerInteger();
        subCodeLength += element.decode(is, true);
        seqOf.add(element);
      }
      if (subCodeLength != totalLength) {
        throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected "
            + totalLength + " but has " + subCodeLength);

      }
      codeLength += subCodeLength;

      return codeLength;
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

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public static BerTag getTag() {
      return tag;
    }

  }

  public static class Aid2 implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<BerInteger> seqOf = null;

    public Aid2() {
      seqOf = new ArrayList<>();
    }

    public Aid2(final byte[] code) {
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
      while (subCodeLength < totalLength) {
        BerInteger element = new BerInteger();
        subCodeLength += element.decode(is, true);
        seqOf.add(element);
      }
      if (subCodeLength != totalLength) {
        throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected "
            + totalLength + " but has " + subCodeLength);

      }
      codeLength += subCodeLength;

      return codeLength;
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

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public static BerTag getTag() {
      return tag;
    }

  }

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  public byte[] code = null;
  private Annotation annotation = null;
  private Aid1 aid1 = null;
  private Aid2 aid2 = null;

  public PCDrawAnnotations() {
  }

  public PCDrawAnnotations(final byte[] code) {
    this.code = code;
  }

  public void setAnnotation(final Annotation annotation) {
    this.annotation = annotation;
  }

  public Annotation getAnnotation() {
    return annotation;
  }

  public void setAid1(final Aid1 aid1) {
    this.aid1 = aid1;
  }

  public Aid1 getAid1() {
    return aid1;
  }

  public void setAid2(final Aid2 aid2) {
    this.aid2 = aid2;
  }

  public Aid2 getAid2() {
    return aid2;
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
        annotation = new Annotation();
        subCodeLength += annotation.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
        codeLength += length.decode(is);
        aid1 = new Aid1();
        subCodeLength += aid1.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
        codeLength += length.decode(is);
        aid2 = new Aid2();
        subCodeLength += aid2.decode(is, true);
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

    codeLength += totalLength;

    subCodeLength += berTag.decode(is);
    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
      subCodeLength += length.decode(is);
      annotation = new Annotation();
      subCodeLength += annotation.decode(is, true);
      subCodeLength += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match the mandatory sequence element tag.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
      subCodeLength += length.decode(is);
      aid1 = new Aid1();
      subCodeLength += aid1.decode(is, true);
      subCodeLength += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match the mandatory sequence element tag.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
      subCodeLength += length.decode(is);
      aid2 = new Aid2();
      subCodeLength += aid2.decode(is, true);
      if (subCodeLength == totalLength) {
        return codeLength;
      }
    }
    throw new IOException("Unexpected end of sequence, length tag: " + totalLength
        + ", actual sequence length: " + subCodeLength);

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
    if (annotation != null) {
      sb.append("annotation: ");
      annotation.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("annotation: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (aid1 != null) {
      sb.append("aid1: ");
      aid1.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("aid1: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (aid2 != null) {
      sb.append("aid2: ");
      aid2.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("aid2: <empty-required-field>");
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

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public static BerTag getTag() {
    return tag;
  }

}
