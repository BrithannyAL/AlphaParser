package parser;
import org.antlr.v4.runtime.*;
import parser.generated.*;

import java.util.ArrayList;


/**
 * Created by oviquez on 5/3/2018.
 */
public class MyErrorListener extends BaseErrorListener {


    private ArrayList<String> errorMsgs = new ArrayList<String>();

    public MyErrorListener ( )
    {
        this.errorMsgs = new ArrayList<String>();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException re) {
        if (recognizer instanceof AlphaParser)
            errorMsgs.add(new String("PARSER ERROR - line "+line+":"+charPositionInLine + " " + msg));
        else if (recognizer instanceof AlphaScanner)
            errorMsgs.add(new String("SCANNER ERROR - line "+line+":"+charPositionInLine + " " + msg ));
        else
            errorMsgs.add(new String("Other Error"));
    }

    public boolean hasErrors ( )
    {
        return this.errorMsgs.size() > 0;
    }

    @Override
    public String toString ( )
    {
        if ( !hasErrors() ) return "0 errors";
        StringBuilder builder = new StringBuilder();
        for ( String s : errorMsgs )
        {
            builder.append ( String.format( "%s\n", s ) );
        }
        return builder.toString();
    }


}