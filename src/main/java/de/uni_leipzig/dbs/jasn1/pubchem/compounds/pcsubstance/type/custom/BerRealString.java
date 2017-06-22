package de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.type.custom;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.string.BerUniversalString;

/**
 * Created by elias on 14.06.17.
 */
public class BerRealString extends BerUniversalString {
  /**
   *
   */
  private static final long serialVersionUID = -754028716182264770L;
  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.PRIMITIVE,
      BerTag.REAL_TAG);
  public double value;

  @Override
  public int decode(final InputStream is, final boolean withTag) throws IOException {
    if (withTag) {
      tag.decodeAndCheck(is);
    }
    int codeLength = super.decode(is, false);

    this.value = Double.parseDouble(new String(super.value).substring(1));
    return codeLength;
  }

  @Override
  public String toString() {
    return Double.toString(this.value);
  }
}
