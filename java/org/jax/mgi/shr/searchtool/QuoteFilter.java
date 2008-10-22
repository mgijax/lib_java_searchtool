package QS_Commons;

import java.io.IOException;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * Filter the qoutes from the start or end of a string.
 * 
 * @author mhall
 * 
 */

public class QuoteFilter extends TokenFilter {

    /**
     * Public constructor, simply passes its stream onto the superclass.
     * @param stream
     */
    
    public QuoteFilter(TokenStream stream) {
        super(stream);
    }

    /**
     * This is the workhorse of this filter, it first checks to see if the ending character
     * is a ", if so it strips it off.
     * 
     * It then checks to see if the starting character is a ", if so it strips it off.
     * 
     * We then return the modified token.
     * 
     */
    
    public final Token next(Token result) throws IOException {
        result = input.next(result);
        if (result != null) {

            char[] buffer = result.termBuffer();
            int length = result.termLength();

            // Check for " at the end of a string.
            
            if (buffer[length - 1] == '"') {

                char[] copy = new char[length - 1];
                for (int i = 0; i < length - 1; i++) {
                    copy[i] = buffer[i];
                }
                result.setTermBuffer(copy, 0, length - 1);
            }

            // Check for a " at the start of a string.
            
            if (buffer[0] == '"') {
                length = result.termLength();

                char[] copy = new char[length - 1];
                for (int i = 0; i < length - 1; i++) {
                    copy[i] = buffer[i + 1];
                }
                result.setTermBuffer(copy, 0, length - 1);
            }
            return result;
        } else
            return null;
    }

}
