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

import de.uni_leipzig.dbs.jasn1.pubchem.util.PCCompoundFilter;
import de.uni_leipzig.dbs.jasn1.pubchem.util.PropsFilter;

/**
 * Compound Record
 */
public class PCCompound implements Serializable {

  private static final long serialVersionUID = 1L;

  private PCCompoundFilter pcFilter = new PCCompoundFilter();

  public static class Stereo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCStereoCenter> seqOf = null;

    public Stereo() {
      seqOf = new ArrayList<>();
    }

    public Stereo(final byte[] code) {
      this.code = code;
    }

    public List<PCStereoCenter> getPCStereoCenter() {
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

          PCStereoCenter element = new PCStereoCenter();
          subCodeLength += element.decode(is, berTag);
          seqOf.add(element);

          is.read();
          berTag.decode(is);
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
        Iterator<PCStereoCenter> it = seqOf.iterator();
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

    public List<PCStereoCenter> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCStereoCenter> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  public static class Coords implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCCoordinates> seqOf = null;

    public Coords() {
      seqOf = new ArrayList<>();
    }

    public Coords(final byte[] code) {
      this.code = code;
    }

    public List<PCCoordinates> getPCCoordinates() {
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

          PCCoordinates element = new PCCoordinates();
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
        Iterator<PCCoordinates> it = seqOf.iterator();
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

    public List<PCCoordinates> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCCoordinates> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  public static class Props implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCInfoData> seqOf = null;
    private PropsFilter propsFilter = null;

    public Props() {
      seqOf = new ArrayList<>();
    }

    public Props(final PropsFilter filter) {
      this();
      this.propsFilter = filter;
    }

    public Props(final byte[] code) {
      this.code = code;
    }

    public List<PCInfoData> getPCInfoData() {
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

          PCInfoData element = new PCInfoData(propsFilter);
          subCodeLength += element.decode(is, false);
          if (!element.isDropMe()) {
            seqOf.add(element);
          }

          is.read();
          berTag.decode(is);
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
        Iterator<PCInfoData> it = seqOf.iterator();
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

    public List<PCInfoData> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCInfoData> seqOf) {
      this.seqOf = seqOf;
    }

    public static BerTag getTag() {
      return tag;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

  }

  public static class Stereogroups implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCStereoGroup> seqOf = null;

    public Stereogroups() {
      seqOf = new ArrayList<>();
    }

    public Stereogroups(final byte[] code) {
      this.code = code;
    }

    public List<PCStereoGroup> getPCStereoGroup() {
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

          PCStereoGroup element = new PCStereoGroup();
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
        Iterator<PCStereoGroup> it = seqOf.iterator();
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

    public List<PCStereoGroup> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCStereoGroup> seqOf) {
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
  private PCCompoundType id = null;
  private PCAtoms atoms = null;
  private PCBonds bonds = null;
  private Stereo stereo = null;
  private Coords coords = null;
  private BerInteger charge = null;
  private Props props = null;
  private Stereogroups stereogroups = null;
  private PCCount count = null;
  private PCCompounds vbalt = null;

  public PCCompound() {
  }

  /**
   * If pcFilter is null, a empty Filter will be used.
   *
   * @param pcFilter
   */
  public PCCompound(final PCCompoundFilter pcFilter) {
    if (pcFilter != null) {
      this.pcFilter = pcFilter;
    }

  }

  public PCCompound(final byte[] code) {
    this.code = code;
  }

  public void setId(final PCCompoundType id) {
    this.id = id;
  }

  public PCCompoundType getId() {
    return id;
  }

  public void setAtoms(final PCAtoms atoms) {
    this.atoms = atoms;
  }

  /**
   * @return AtomID/Type Information
   */
  public PCAtoms getAtoms() {
    return atoms;
  }

  public void setBonds(final PCBonds bonds) {
    this.bonds = bonds;
  }

  /**
   * @return BondID/Type/Atom Information
   */
  public PCBonds getBonds() {
    return bonds;
  }

  public void setStereo(final Stereo stereo) {
    this.stereo = stereo;
  }

  /**
   * @return StereoCenter Descriptions
   */
  public Stereo getStereo() {
    return stereo;
  }

  public void setCoords(final Coords coords) {
    this.coords = coords;
  }

  /**
   * @return 2D/3D Coordinate Sets of Compound
   */
  public Coords getCoords() {
    return coords;
  }

  public void setCharge(final BerInteger charge) {
    this.charge = charge;
  }

  /**
   * @return Provided Total Formal Charge (Signed Integer)
   */
  public BerInteger getCharge() {
    return charge;
  }

  public void setProps(final Props props) {
    this.props = props;
  }

  /**
   * @return Derived (computed) Properties
   */
  public Props getProps() {
    return props;
  }

  public void setStereogroups(final Stereogroups stereogroups) {
    this.stereogroups = stereogroups;
  }

  /**
   * @return Relative stereochemistry groups
   */
  public Stereogroups getStereogroups() {
    return stereogroups;
  }

  public void setCount(final PCCount count) {
    this.count = count;
  }

  /**
   * @return Counts of various properties
   */
  public PCCount getCount() {
    return count;
  }

  public void setVbalt(final PCCompounds vbalt) {
    this.vbalt = vbalt;
  }

  /**
   * @return Alternate Valence-Bond Forms
   */
  public PCCompounds getVbalt() {
    return vbalt;
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
        id = new PCCompoundType();
        subCodeLength += id.decode(is, true);
        subCodeLength += berTag.decode(is);

        // Do not understand why those two 00 Octets are there
        is.read();
        berTag.decode(is);

        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
        codeLength += length.decode(is);
        atoms = new PCAtoms(pcFilter.getAtomsFilter());
        subCodeLength += atoms.decode(is, true);
        if (!pcFilter.getAtomsFilter().isParseAtoms()) {
          atoms = null;
        }
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
        codeLength += length.decode(is);
        bonds = new PCBonds();
        subCodeLength += bonds.decode(is, true);
        if (!pcFilter.isParseBonds()) {
          bonds = null;
        }
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
        codeLength += length.decode(is);
        stereo = new Stereo();
        subCodeLength += stereo.decode(is, true);
        if (!pcFilter.isParseStereo()) {
          stereo = null;
        }
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
        codeLength += length.decode(is);
        coords = new Coords();
        subCodeLength += coords.decode(is, true);
        if (!pcFilter.isParseCoords()) {
          coords = null;
        }
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
        codeLength += length.decode(is);
        charge = new BerInteger();
        subCodeLength += charge.decode(is, true);

        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
        codeLength += length.decode(is);
        props = new Props(pcFilter.getPropsFilter());
        subCodeLength += props.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
        codeLength += length.decode(is);
        stereogroups = new Stereogroups();
        subCodeLength += stereogroups.decode(is, true);
        if (!pcFilter.isParseStereogroups()) {
          stereogroups = null;
        }
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 8)) {
        codeLength += length.decode(is);
        count = new PCCount();
        subCodeLength += count.decode(is, true);
        if (!pcFilter.isParseCount()) {
          count = null;
        }
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 9)) {
        codeLength += length.decode(is);
        vbalt = new PCCompounds();
        subCodeLength += vbalt.decode(is, true);
        if (!pcFilter.isParseVbalt()) {
          vbalt = null;
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
    if (id != null) {
      sb.append("id: ");
      id.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("id: <empty-required-field>");
    }

    if (atoms != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("atoms: ");
      atoms.appendAsString(sb, indentLevel + 1);
    }

    if (bonds != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("bonds: ");
      bonds.appendAsString(sb, indentLevel + 1);
    }

    if (stereo != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("stereo: ");
      stereo.appendAsString(sb, indentLevel + 1);
    }

    if (coords != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("coords: ");
      coords.appendAsString(sb, indentLevel + 1);
    }

    if (charge != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("charge: ").append(charge);
    }

    if (props != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("props: ");
      props.appendAsString(sb, indentLevel + 1);
    }

    if (stereogroups != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("stereogroups: ");
      stereogroups.appendAsString(sb, indentLevel + 1);
    }

    if (count != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("count: ");
      count.appendAsString(sb, indentLevel + 1);
    }

    if (vbalt != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("vbalt: ");
      vbalt.appendAsString(sb, indentLevel + 1);
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