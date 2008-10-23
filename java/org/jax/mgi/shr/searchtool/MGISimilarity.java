package org.jax.mgi.shr.searchtool;

import org.apache.lucene.search.DefaultSimilarity;

/**
 * This is our custom similarity class, which removes document frequency from the
 * calculation of score.
 *
 * It extends the DefaultSimilarity class, and thusly inherits most of its methods
 * from it.
 *
 * @author mhall
 *
 */

public class MGISimilarity extends DefaultSimilarity {

    /**
     * If we have any doc frequency at all in the index, normalize it to 1 (The document exists)
     * Otherwise, return 0 (Does not exist)
     *
     * @param docFreq This items doc frequency
     * @param numDocs How many documents this item appears in.
     *
     * This API is enforced by the DefaultSimilarity class.
     *
     */

    public float idf(int docFreq, int numDocs) {
        if (docFreq > 0) {
            return 1.0f;
        } else {
            return 0.0f;
        }
    }

}
