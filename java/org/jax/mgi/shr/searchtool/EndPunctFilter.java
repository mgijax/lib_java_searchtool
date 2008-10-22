package QS_Commons;

import java.io.IOException;
import java.util.HashSet;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * Filter that removes normal English punctuation from the end of a token string.
 * 
 * @author mhall
 * 
 */

public class EndPunctFilter extends TokenFilter {

    /**
     * Public constructor, which passes its arguments onto the superclass.
     * 
     * @param stream
     */

    /* 
     * This variable is used to hold the punctuation set, anything in this set will be
     * trimmed off the end of the token.
     */ 
    
    
    private HashSet punctSet = new HashSet();
    
    /**
     * Public constructor, this also sets up the punctuation set, anything added to this will be 
     * removed from the ends of our tokens.
     * 
     * @param stream
     */
    
    public EndPunctFilter(TokenStream stream) {
        super(stream);
        
        punctSet.add(',');
        punctSet.add('.');
        punctSet.add(';');
        punctSet.add('#');
        punctSet.add(':');
        
    }

    /**
     * Remove the trailing characters off of a term, if its a , . ; # or a :
     * 
     */

    public final Token next(Token result) throws IOException {
        result = input.next(result);
        if (result != null) {

            final char[] buffer = result.termBuffer();
            final int length = result.termLength();
            
            // Is the last character in the punctuation set?
            
            if (punctSet.contains(buffer[length - 1])) {

                int offset;
                for (offset = 1; offset <= length; offset++) {

                    /* 
                     * Since we have found one, remove the rest that are found on the 
                     * end of the token as well.  If we have token that has nothing BUT
                     * characters to be removed this could cause an issue.
                     * 
                     * I've made an initial attempt to fix this, but its not working. 
                     * I'm going to put this on my list of things to do, and come back to it
                     * when the rest of the general code cleanup is complete.
                     */
                    
                    if (!(punctSet.contains(buffer[length - offset]))) {
                        break;
                    }
                }
                result.setTermLength(length - (offset - 1));
            }

            return result;
        } else
            return null;
    }

}
