grammar FormatterFilter;

prog: expr+     # printExpr
    ;

expr 
    : expr op=( EQ | NE ) expr                  # compare
    | expr IN expr                              # contain
    | expr op=( BOOLAND | BOOLOR ) expr         # bool
    | BOOLNOT LP expr RP        # not
    | STRING                    # str
    | INTEGER                   # int
    | variable                  # var 
    | arraystr                  # arrStr 
    | arrayint                  # arrInt
    | LP expr RP                # parens
    ;


arraystr:       LBRACE STRING (COMMA STRING)* RBRACE;
arrayint:       LBRACE INTEGER (COMMA INTEGER)* RBRACE;
variable:       DOT DOTID (DOT DOTID)*;

WS: [ \t\n\r]+ -> skip;
COMMENT: ( '//' .*? [\n\r] | '/*' .*? '*/' ) -> skip;

LBRACE:    '[';
RBRACE:    ']';
LP:        '(';
RP:        ')';
DOT:       '.';
COMMA:     ',';
SEMICOLON: ';';
IN:        'in';

BOOLNOT: '!';
EQ:      '==';
NE:      '!=';
BOOLAND: '&&';
BOOLOR:  '||';

DOTID: [_a-zA-Z] [_a-zA-Z0-9]*;
INTEGER: ( '0' | [1-9] [0-9]* ) [lLfFdD]?;
STRING: ( '"' ( '\\"' | '\\\\' | ~[\\"] )*? '"' ) | ( '\'' ( '\\\'' | '\\\\' | ~[\\"] )*? '\'' );
