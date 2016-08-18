grammar Calc;

// User input
input
    : expression
    | equation
    ;

// Equation
equation
    : expression relop expression
    ;

assignEquation
    : 'let' var EQ expression
    ;

// Expression
expression
    : multExpression (op=(PLUS | MINUS) multExpression)*
    ;

// Expression involving multiplication
multExpression
    : powExpression (op=(MULT | DIV) powExpression)*
    ;

// Expression involving powers
powExpression
    : unit (POW multExpression)?
    ;

// Unit expression
unit
    : scientific                # SciNotation
    | var                       # Variable
    | LPAREN expression RPAREN  # ParenExpression
    | func                      # Function
    | eqfunc                    # EqFunction
    ;

scientific
    : num (E num)?
    ;

func
    : id LPAREN expression RPAREN
    ;

eqfunc
    : id LPAREN equation RPAREN
    ;

num
    : MINUS? DIGIT + (POINT DIGIT +)?
    ;

var
    : MINUS? id
    ;

id
    : (LETTER | E) ((LETTER | E)+)?
    ;

relop
    : EQ    # Equal
    | GT    # Greater
    | LT    # Less
    | GTE   # GreaterOrEqual
    | LTE   # LessOrEqual
    ;

LPAREN  : '(';
RPAREN  : ')';

PLUS    : '+';
MINUS   : '-';
MULT    : '*';
DIV     : '/';
POW     : '^';

EQ      : '=';
GT      : '>';
LT      : '<';
GTE     : '>=';
LTE     : '<=';

POINT   : '.';
E       : 'e' | 'E';

LETTER
    : ('a' .. 'z') | ('A' .. 'Z')
    ;

DIGIT
    : ('0' .. '9')
    ;

WS
    : [ \r\n\t]+ -> channel (HIDDEN)
    ;
