parser grammar AlphaParser;

//Import the lexer tokens

options {
    tokenVocab = AlphaScanner;
}
//REGLAS PARA EL LENGUAJE                                               NOMBRES DE LAS CLASES PARA EL ARBOL
program :           singleCommand                                                   #programAst
                    ;
command :           singleCommand (COMADOTS singleCommand)*                         #commandAst
                    ;
singleCommand :     ID ASSING expression                                            #assignSCAst
                        | ID PIZQ expression PDER                                   #callSCAst
                        | IF expression THEN singleCommand ELSE singleCommand       #ifSCAst
                        | WHILE expression DO singleCommand                         #whileSCAst
                        | LET declaration IN singleCommand                          #letSCAst
                        | BEGIN command END                                         #blockSCAst
                        ;
declaration  :      singleDeclaration (COMADOTS singleDeclaration)*                 #declarationAst
                    ;
singleDeclaration : CONST ID VERGIRILLA expression                                  #constSDAts
    	            | VAR ID TWODOTS typeDenoter                                    #varSDAst
    	            ;
typeDenoter :       ID                                                              #typeDenoterAst
                    ;
expression :        primaryExpression (operator primaryExpression)*                 #expressionAst
                    ;
primaryExpression : NUM                                                             #numPEAst
                    | ID                                                            #idPEAst
                    | PIZQ expression PDER                                          #groupPEAst
                    ;
operator :          PLUS | MINUS | ASTERISK | SLASH                                 #operatorAst
                    ;
