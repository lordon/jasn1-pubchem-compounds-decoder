package de.uni_leipzig.dbs.jasn1.pubchem.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.PCCompound;
import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.PCCompounds;

public class FilterTest {

  @Test
  /**
   * We assume that a PCCompound has all Objects set, and we filter all we can.
   */
  public void filterTest() throws IOException {
    PCCompoundFilter filter = new PCCompoundFilter();
    filter.setAtomsFilter(new PCAtomsFilter(false, false));
    filter.setParseBonds(false);
    filter.setParseCoords(false);
    filter.setParseCount(false);
    filter.setParseStereo(false);
    filter.setParseStereogroups(false);
    filter.setParseVbalt(false);
    filter.setPropsFilter(new PropsFilter(false,
        new HashSet<>(Arrays.asList("some string that cannot be a propety"))));
    PCCompounds compounds = new PCCompounds(filter);
    PubchemGzipInputStream is = new PubchemGzipInputStream(
        PubchemResourceAnchor.getSomeGZippedCompounds());
    compounds.decode(is);
    boolean b = true;
    for (PCCompound it : compounds.getSeqOf()) {
      b &= it.getAtoms() == null;
      b &= it.getBonds() == null;
      b &= it.getCoords() == null;
      b &= it.getCount() == null;
      b &= it.getStereo() == null;
      b &= it.getStereogroups() == null;
      b &= it.getVbalt() == null;
      b &= it.getProps().getSeqOf().isEmpty();
    }
    Assert.assertTrue("Filter didnt filter all objects", b);

  }

}
