    lexer grammar AlphaScanner;

    //Palabras reservadas

    IF      : 'if'|'IF';
    THEN    : 'then'|'THEN';
    ELSE    : 'else'|'ELSE';
    WHILE   : 'while'|'WHILE';
    DO      : 'do'|'DO';
    LET     : 'let'|'LET';
    IN      : 'in'|'IN';
    BEGIN   : 'begin'|'BEGIN';
    END     : 'end'|'END';
    CONST   : 'const'|'CONST';
    VAR     : 'var'|'VAR';

    //Símbolos

    ASSING          : ':=';
    NOT_EQ          : '=!='|'!=';
    VERGIRILLA      : '~';
    TWODOTS         : ':';
    PIZQ            : '(';
    PDER            : ')';
    PLUS            : '+';
    MINUS           : '-';
    ASTERISK        : '*';
    SLASH           : '/';
    PERCENT         : '%';
    EQUAL           : '==';
    LESSTHAN        : '<';
    GREATERTHAN     : '>';
    LESSEQUALTO     : '<=';
    GREATEREQUALTO  : '>=';
    COMADOTS        : ';';
    COMA            : ',';


    //Otras expresiones

    ID      : '_'? LETTER(LETTER|DIGIT|'_')*;
    NUM     : DIGIT+;

    //Grupos de caracteres
    fragment LETTER : 'a'..'z'|'A'..'Z';
    fragment DIGIT : '0'..'9';

    //Se ignora
    WS      : [ \t\n\r]+ -> skip; //Skip: que ignore lo indicado que venga 1 o más veces
    COMMENT : '//' ~[\r\n]* -> skip;