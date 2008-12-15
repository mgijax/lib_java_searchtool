package org.jax.mgi.shr.searchtool;

/**
 * This is simply a container class for storing the MGI Stopword set.
 * @author mhall
 * @has A single final static string, containing the array of mgi stopwords.
 * @does Nothing
 */

public class MGIStopWords {
    
    public static final String[] MGI_STOP_WORDS = {
        "a", "an", "and", "are", "as", "be", "but",
        "if", "is", "it", "or", "such",
        "that", "the", "their", "then", "there", "these",
        "they", "this", "was", "will"
      };

}
