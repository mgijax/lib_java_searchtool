package org.jax.mgi.shr.searchtool;

import java.io.Reader;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WhitespaceTokenizer;
import org.apache.lucene.analysis.snowball.SnowballFilter;

/**
 * Custom MGI Analyzer
 * 
 * This analyzers Lower cases words, removes stop words, strips off ending
 * English punctuation, removes any tokens containing prefix searches, removes
 * encompassing Double quotes, and then stems the tokens.
 * 
 * @author mhall
 * 
 */

public class StemmedMGITokenCountAnalyzer extends Analyzer {

    private Set stopWords;

    /**
     * Create a new analyzer, and construct its stop word list.
     */

    public StemmedMGITokenCountAnalyzer() {
        stopWords = StopFilter.makeStopSet(MGIStopWords.MGI_STOP_WORDS);
    }

    /**
     * Worker for this Analyzer.
     * 
     * Specifically this analyzer chains together WhitespaceTokenizer ->
     * LowerCaseFilter -> StopFilter -> EndPunctFilter together to form
     * customized MGI Tokens
     */

    public TokenStream tokenStream(String fieldName, Reader reader) {
        return new SnowballFilter(new QuoteFilter(new PrefixFilter(
                new EndPunctFilter(new StopFilter(new LowerCaseFilter(
                        new WhitespaceTokenizer(reader)), stopWords)))),
                "English");
    }

}
