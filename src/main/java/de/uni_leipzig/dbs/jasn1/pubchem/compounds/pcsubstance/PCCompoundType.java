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

/**
 * Qualification used to describe the type of Compound deposited, standardized, or derived. Please
 * note that mixtures/cocktails may be specified using previously deposited substances.
 */
public class PCCompoundType implements Serializable {

  public static class PCCompoundTypeType extends PubChemTypedBerInteger {

    private static final long serialVersionUID = 1L;

    public final static int[] states = { 0, 1, 2, 3, 4, 5, 6, 255 };

    public final static String[] stateStrings = { "deposited : Original Deposited Compound ",
        "standardized : Standardized Form of a Deposited Compound",
        "component : Component of a Standardized Compound",
        "neutralized : Neutralized Form of a Standardized Compound",
        "mixture : Substance that is a component of a mixture",
        "tautomer : Predicted Tautomer Form", "pka-state : Predicted Ionized pKa Form",
        "unknown : Unknown Compound Type" };

    public PCCompoundTypeType() {
    }

    public PCCompoundTypeType(final BerInteger berInteger) {
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

  public static class Id implements Serializable {

    private static final long serialVersionUID = 1L;

    public byte[] code = null;
    private BerInteger cid = null;
    private BerInteger sid = null;
    private BerInteger xid = null;

    public Id() {
    }

    public Id(final byte[] code) {
      this.code = code;
    }

    public void setCid(final BerInteger cid) {
      this.cid = cid;
    }

    /**
     * Standardized Compound
     */
    public BerInteger getCid() {
      return cid;
    }

    public void setSid(final BerInteger sid) {
      this.sid = sid;
    }

    /**
     * @return PubChem Substance (for "mixture" type compounds)
     */
    public BerInteger getSid() {
      return sid;
    }

    public void setXid(final BerInteger xid) {
      this.xid = xid;
    }

    /**
     * @return PubChem Theoretical Compound
     */
    public BerInteger getXid() {
      return xid;
    }

    public int decode(final InputStream is) throws IOException {
      return decode(is, null);
    }

    public int decode(final InputStream is, BerTag berTag) throws IOException {

      int codeLength = 0;
      BerTag passedTag = berTag;

      if (berTag == null) {
        berTag = new BerTag();
        codeLength += berTag.decode(is);
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
        codeLength += BerLength.skip(is);
        cid = new BerInteger();
        codeLength += cid.decode(is, true);
        return codeLength;
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
        codeLength += BerLength.skip(is);
        sid = new BerInteger();
        codeLength += sid.decode(is, true);
        return codeLength;
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
        codeLength += BerLength.skip(is);
        xid = new BerInteger();
        codeLength += xid.decode(is, true);
        return codeLength;
      }

      if (passedTag != null) {
        return 0;
      }

      throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      appendAsString(sb, 0);
      return sb.toString();
    }

    public void appendAsString(final StringBuilder sb, final int indentLevel) {

      if (cid != null) {
        sb.append("cid: ").append(cid);
        return;
      }

      if (sid != null) {
        sb.append("sid: ").append(sid);
        return;
      }

      if (xid != null) {
        sb.append("xid: ").append(xid);
        return;
      }

      sb.append("<none>");
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

  }

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  public byte[] code = null;
  private PCCompoundTypeType type = null;
  private Id id = null;

  public PCCompoundType() {
  }

  public PCCompoundType(final byte[] code) {
    this.code = code;
  }

  public void setType(final BerInteger type) {
    this.type = new PCCompoundTypeType(type);
  }

  /**
   * @return Compound Qualifier or Type
   */
  public PCCompoundTypeType getType() {
    return type;
  }

  public void setId(final Id id) {
    this.id = id;
  }

  /**
   * @return Compound Namespace and ID (absent for "deposited" type compounds)
   */
  public Id getId() {
    return id;
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
        type = new PCCompoundTypeType();
        subCodeLength += type.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
        subCodeLength += length.decode(is);
        id = new Id();
        int choiceDecodeLength = id.decode(is, null);
        if (choiceDecodeLength != 0) {
          subCodeLength += choiceDecodeLength;
          subCodeLength += berTag.decode(is);
        } else {
          id = null;
        }

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
    boolean firstSelectedElement = true;
    if (type != null) {
      sb.append("\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("type: ").append(type);
      firstSelectedElement = false;
    }

    if (id != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("id: ");
      id.appendAsString(sb, indentLevel + 1);
      firstSelectedElement = false;
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
