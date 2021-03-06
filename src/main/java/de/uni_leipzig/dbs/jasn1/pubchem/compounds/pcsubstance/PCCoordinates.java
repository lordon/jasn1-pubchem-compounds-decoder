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

/**
 * Coordinates for the Compound of a given type
 */
public class PCCoordinates implements Serializable {

  private static final long serialVersionUID = 1L;

  public static class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCCoordinateType> seqOf = null;

    public Type() {
      seqOf = new ArrayList<>();
    }

    public Type(final byte[] code) {
      this.code = code;
    }

    public List<PCCoordinateType> getPCCoordinateType() {
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

          PCCoordinateType element = new PCCoordinateType();
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
        Iterator<PCCoordinateType> it = seqOf.iterator();
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

    public List<PCCoordinateType> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCCoordinateType> seqOf) {
      this.seqOf = seqOf;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public static BerTag getTag() {
      return tag;
    }

  }

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

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public static BerTag getTag() {
      return tag;
    }

  }

  public static class Conformers implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCConformer> seqOf = null;

    public Conformers() {
      seqOf = new ArrayList<>();
    }

    public Conformers(final byte[] code) {
      this.code = code;
    }

    public List<PCConformer> getPCConformer() {
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

          PCConformer element = new PCConformer();
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
        Iterator<PCConformer> it = seqOf.iterator();
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

    public List<PCConformer> getSeqOf() {
      return seqOf;
    }

    public void setSeqOf(final List<PCConformer> seqOf) {
      this.seqOf = seqOf;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public static BerTag getTag() {
      return tag;
    }

  }

  public static class Atomlabels implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCAtomString> seqOf = null;

    public Atomlabels() {
      seqOf = new ArrayList<>();
    }

    public Atomlabels(final byte[] code) {
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

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public static BerTag getTag() {
      return tag;
    }

  }

  public static class Data implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    public byte[] code = null;
    private List<PCInfoData> seqOf = null;

    public Data() {
      seqOf = new ArrayList<>();
    }

    public Data(final byte[] code) {
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

          PCInfoData element = new PCInfoData();
          subCodeLength += element.decode(is, false);
          if (!element.isDropMe()) {
            seqOf.add(element);
          }
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

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public static BerTag getTag() {
      return tag;
    }

  }

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  public byte[] code = null;
  private Type type = null;
  private Aid aid = null;
  private Conformers conformers = null;
  private Atomlabels atomlabels = null;
  private Data data = null;

  public PCCoordinates() {
  }

  public PCCoordinates(final byte[] code) {
    this.code = code;
  }

  public void setType(final Type type) {
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public void setAid(final Aid aid) {
    this.aid = aid;
  }

  public Aid getAid() {
    return aid;
  }

  public void setConformers(final Conformers conformers) {
    this.conformers = conformers;
  }

  public Conformers getConformers() {
    return conformers;
  }

  public void setAtomlabels(final Atomlabels atomlabels) {
    this.atomlabels = atomlabels;
  }

  public Atomlabels getAtomlabels() {
    return atomlabels;
  }

  public void setData(final Data data) {
    this.data = data;
  }

  public Data getData() {
    return data;
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
        type = new Type();
        subCodeLength += type.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
        codeLength += length.decode(is);
        aid = new Aid();
        subCodeLength += aid.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
        codeLength += length.decode(is);
        conformers = new Conformers();
        subCodeLength += conformers.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
        codeLength += length.decode(is);
        atomlabels = new Atomlabels();
        subCodeLength += atomlabels.decode(is, true);
        subCodeLength += berTag.decode(is);
        if (length.val == -1) {
          is.read();
          berTag.decode(is);
        }
      }

      if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
        codeLength += length.decode(is);
        data = new Data();
        subCodeLength += data.decode(is, true);
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
    if (type != null) {
      sb.append("type: ");
      type.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("type: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (aid != null) {
      sb.append("aid: ");
      aid.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("aid: <empty-required-field>");
    }

    if (conformers != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("conformers: ");
      conformers.appendAsString(sb, indentLevel + 1);
    }

    if (atomlabels != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("atomlabels: ");
      atomlabels.appendAsString(sb, indentLevel + 1);
    }

    if (data != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("data: ");
      data.appendAsString(sb, indentLevel + 1);
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
