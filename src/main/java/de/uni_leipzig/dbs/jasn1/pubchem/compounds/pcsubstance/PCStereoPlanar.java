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

public class PCStereoPlanar implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  public byte[] code = null;
  private BerInteger left = null;
  private BerInteger ltop = null;
  private BerInteger lbottom = null;
  private BerInteger right = null;
  private BerInteger rtop = null;
  private BerInteger rbottom = null;
  private BerInteger parity = null;
  private BerInteger type = null;

  public PCStereoPlanar() {
  }

  public PCStereoPlanar(final byte[] code) {
    this.code = code;
  }

  public void setLeft(final BerInteger left) {
    this.left = left;
  }

  public BerInteger getLeft() {
    return left;
  }

  public void setLtop(final BerInteger ltop) {
    this.ltop = ltop;
  }

  public BerInteger getLtop() {
    return ltop;
  }

  public void setLbottom(final BerInteger lbottom) {
    this.lbottom = lbottom;
  }

  public BerInteger getLbottom() {
    return lbottom;
  }

  public void setRight(final BerInteger right) {
    this.right = right;
  }

  public BerInteger getRight() {
    return right;
  }

  public void setRtop(final BerInteger rtop) {
    this.rtop = rtop;
  }

  public BerInteger getRtop() {
    return rtop;
  }

  public void setRbottom(final BerInteger rbottom) {
    this.rbottom = rbottom;
  }

  public BerInteger getRbottom() {
    return rbottom;
  }

  public void setParity(final BerInteger parity) {
    this.parity = parity;
  }

  public BerInteger getParity() {
    return parity;
  }

  public void setType(final BerInteger type) {
    this.type = type;
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
        left = new BerInteger();
        subCodeLength += left.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
        codeLength += length.decode(is);
        ltop = new BerInteger();
        subCodeLength += ltop.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
        codeLength += length.decode(is);
        lbottom = new BerInteger();
        subCodeLength += lbottom.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
        codeLength += length.decode(is);
        right = new BerInteger();
        subCodeLength += right.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
        codeLength += length.decode(is);
        rtop = new BerInteger();
        subCodeLength += rtop.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
        codeLength += length.decode(is);
        rbottom = new BerInteger();
        subCodeLength += rbottom.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
        codeLength += length.decode(is);
        parity = new BerInteger();
        subCodeLength += parity.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
        codeLength += length.decode(is);
        type = new BerInteger();
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

    codeLength += totalLength;

    subCodeLength += berTag.decode(is);
    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
      subCodeLength += length.decode(is);
      left = new BerInteger();
      subCodeLength += left.decode(is, true);
      subCodeLength += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match the mandatory sequence element tag.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
      subCodeLength += length.decode(is);
      ltop = new BerInteger();
      subCodeLength += ltop.decode(is, true);
      subCodeLength += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match the mandatory sequence element tag.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
      subCodeLength += length.decode(is);
      lbottom = new BerInteger();
      subCodeLength += lbottom.decode(is, true);
      subCodeLength += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match the mandatory sequence element tag.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
      subCodeLength += length.decode(is);
      right = new BerInteger();
      subCodeLength += right.decode(is, true);
      subCodeLength += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match the mandatory sequence element tag.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
      subCodeLength += length.decode(is);
      rtop = new BerInteger();
      subCodeLength += rtop.decode(is, true);
      subCodeLength += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match the mandatory sequence element tag.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
      subCodeLength += length.decode(is);
      rbottom = new BerInteger();
      subCodeLength += rbottom.decode(is, true);
      if (subCodeLength == totalLength) {
        return codeLength;
      }
      subCodeLength += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match the mandatory sequence element tag.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
      subCodeLength += length.decode(is);
      parity = new BerInteger();
      subCodeLength += parity.decode(is, true);
      if (subCodeLength == totalLength) {
        return codeLength;
      }
      subCodeLength += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
      subCodeLength += length.decode(is);
      type = new BerInteger();
      subCodeLength += type.decode(is, true);
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
    if (left != null) {
      sb.append("left: ").append(left);
    } else {
      sb.append("left: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (ltop != null) {
      sb.append("ltop: ").append(ltop);
    } else {
      sb.append("ltop: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (lbottom != null) {
      sb.append("lbottom: ").append(lbottom);
    } else {
      sb.append("lbottom: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (right != null) {
      sb.append("right: ").append(right);
    } else {
      sb.append("right: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (rtop != null) {
      sb.append("rtop: ").append(rtop);
    } else {
      sb.append("rtop: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (rbottom != null) {
      sb.append("rbottom: ").append(rbottom);
    } else {
      sb.append("rbottom: <empty-required-field>");
    }

    if (parity != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("parity: ").append(parity);
    }

    if (type != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("type: ").append(type);
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
