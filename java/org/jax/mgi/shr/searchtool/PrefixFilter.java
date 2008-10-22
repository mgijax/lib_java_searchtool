package QS_Commons;

import java.io.IOException;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * This filter removes any tokens that have a prefix search in them from the stream.
 * 
 * This is used in our token count analyzers, 
 * @author mhall
 *
 */

public class PrefixFilter extends TokenFilter {

    /**
     * Public Constructor, this passes the token stream to the super class for instantiation.
     * @param stream
     */
    
    public PrefixFilter(TokenStream stream) {
        super(stream);
    }

    /**
     * The workhorse of this filter, in a nutshell it looks for items that end in *'s, 
     * when it finds them it omits that token from the token stream.
     */
    
    public final Token next(Token result) throws IOException {
        while ((result = input.next(result)) != null) {

            final char[] buffer = result.termBuffer();
            final int length = result.termLength();

            if (buffer[length - 1] != '*') {
                return result;
            }
        }
        return null;

    }

}