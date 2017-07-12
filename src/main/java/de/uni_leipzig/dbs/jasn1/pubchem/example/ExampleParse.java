package de.uni_leipzig.dbs.jasn1.pubchem.example;

import java.io.IOException;
import java.io.InputStream;

import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.PCCompound;
import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.PCCompounds;
import de.uni_leipzig.dbs.jasn1.pubchem.util.PubchemResourceAnchor;

/**
 * @author jhuth
 */
public class ExampleParse {
  public static void main(final String[] args) throws IOException {
    InputStream is = PubchemResourceAnchor.getSomeCompounds();

    //PCCompounds compounds = new PCCompounds(PCCompoundFilter.getExampleFilter());
    PCCompounds compounds = new PCCompounds();
    compounds.decode(is);
    for (PCCompound it : compounds.getPCCompound()) {
      System.out.println(it.toString());
      System.exit(0);
    }

  }
}
