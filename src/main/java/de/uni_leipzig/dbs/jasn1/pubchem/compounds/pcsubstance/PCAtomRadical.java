/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.BerInteger;

import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.type.custom.PubChemTypedBerInteger;

public class PCAtomRadical implements Serializable {

  static class PCAtomRadicalType extends PubChemTypedBerInteger {

    private static final long serialVersionUID = 1L;

    static final int[] states = { 1, 2, 3, 4, 5, 6, 7, 8, 255 };

    static final String[] stateStrings = { "singlet : Open-Shell Singlet",
        "doublet : Open-Shell Doublet", "triplet : Open-Shell Triplet",
        "quartet : Open-Shell Quartet", "quintet : Open-Shell Quintet",
        "hextet : Open-Shell Hextet", "heptet : Open-Shell Quintet", "octet : Open-Shell Octet",
        "none : Closed-Shell Singlet" };

    public PCAtomRadicalType() {
    }

    public PCAtomRadicalType(final BerInteger berInteger) {
      super(berInteger);
    }

    @Override
    public int[] getStates() {
      return states;
    }

    @Override
    public String[] getStateStrings() {
      return stateStrings;
    }

  }

  private static final long serialVersionUID = 1L;

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  public byte[] code = null;
  private BerInteger aid = null;
  private PubChemTypedBerInteger type = null;

  public PCAtomRadical() {
  }

  public PCAtomRadical(final byte[] code) {
    this.code = code;
  }

  public void setAid(final BerInteger aid) {
    this.aid = aid;
  }

  public BerInteger getAid() {
    return aid;
  }

  public void setType(final BerInteger type) {
    this.type = new PCAtomRadicalType(type);
  }

  public BerInteger getType() {
    return type;
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
        aid = new BerInteger();
        subCodeLength += aid.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
        codeLength += length.decode(is);
        type = new PCAtomRadicalType();
        subCodeLength += type.decode(is, true);
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
      sb.append("aid: ").append(aid);
    } else {
      sb.append("aid: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (type != null) {
      sb.append("type: ").append(type);
    } else {
      sb.append("type: <empty-required-field>");
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
