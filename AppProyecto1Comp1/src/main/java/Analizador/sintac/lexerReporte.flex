/* primer seccion: codigo de usuario */

package Analizador.sintac.lexico;

import Analizador.sintac.sym;
import java_cup.runtime.Symbol;
import java.util.ArrayList;

/* segunda seccion: coonfiguracion */

%%
%class LexerReporte
%public
%line
%column
%ignorecase
%cup
%cupdebug

/*tercer seccion: reglase lexicas*/

punto=[.]
espacio=[ ]+
L=[a-zA-Z_ñÑ]
D=[0-9]
tab = [\t]+
salto = [\n]+
rot = [\r]+
comilla = [\"]
decimal = ({D}+{punto}{D}+)
entero = {D}+
id = {L}({L}|{D})*
Comment = "</" {CommentContent} "/"+ ">"
CommentContent       = ( [^*] | \*+ [^/*] )*

%{
    private ArrayList<String> errores = new ArrayList<>();

    public void setErrores(ArrayList<String> errores) {
        this.errores = errores;
    }
%}

%%
        /* Palabras reservadas */

score                   {return new Symbol(sym.SCORE, yyline+1, yycolumn+1, yytext());}
clases                  {return new Symbol(sym.CLASES, yyline+1, yycolumn+1, yytext());}
variables               {return new Symbol(sym.VARIABLES, yyline+1, yycolumn+1, yytext());}
metodos                 {return new Symbol(sym.METODOS, yyline+1, yycolumn+1, yytext());}
comentarios             {return new Symbol(sym.COMENTARIOS, yyline+1, yycolumn+1, yytext());}
nombre                  {return new Symbol(sym.NOMBRE, yyline+1, yycolumn+1, yytext());}
tipo                    {return new Symbol(sym.TIPO, yyline+1, yycolumn+1, yytext());}
funcion                 {return new Symbol(sym.FUNCION, yyline+1, yycolumn+1, yytext());}
parametros              {return new Symbol(sym.PARAMETROS, yyline+1, yycolumn+1, yytext());}
texto                   {return new Symbol(sym.TEXTO, yyline+1, yycolumn+1, yytext());}
RESULT                  {return new Symbol(sym.RESULT, yyline+1, yycolumn+1, yytext());}
integer                 {return new Symbol(sym.INTEGER, yyline+1, yycolumn+1, yytext());}
String                  {return new Symbol(sym.STRING, yyline+1, yycolumn+1, yytext());}
html                    {return new Symbol(sym.HTML, yyline+1, yycolumn+1, yytext());}
h1                      {return new Symbol(sym.H1, yyline+1, yycolumn+1, yytext());}
h2                      {return new Symbol(sym.H2, yyline+1, yycolumn+1, yytext());}
table                   {return new Symbol(sym.TABLE, yyline+1, yycolumn+1, yytext());}
for                     {return new Symbol(sym.FOR, yyline+1, yycolumn+1, yytext());}
iterador                {return new Symbol(sym.ITERADOR, yyline+1, yycolumn+1, yytext());}
hasta                   {return new Symbol(sym.HASTA, yyline+1, yycolumn+1, yytext());}
tr                      {return new Symbol(sym.TR, yyline+1, yycolumn+1, yytext());}
td                      {return new Symbol(sym.TD, yyline+1, yycolumn+1, yytext());}
th                      {return new Symbol(sym.TH, yyline+1, yycolumn+1, yytext());}
br                      {return new Symbol(sym.BR, yyline+1, yycolumn+1, yytext());}
        
/* ESpacios y signos */

{espacio} {/*ignorar*/}
{tab} {/*ignorar*/}
{salto} {/*ignorar*/}
{rot} {/*ignorar*/}
{decimal} { return new Symbol(sym.DECIMAL, yyline+1, yycolumn+1, yytext());}
{entero} {return new Symbol(sym.ENTERO, yyline+1, yycolumn+1, Integer.parseInt(yytext()));}
{comilla}({id}|{entero}|{decimal}|{espacio}|{punto}|"+"|"-"|"*"|"/"|":"|";"|"<"|">"|"="|"["|"]"|"("|")"|"$"|",")*{comilla} {return new Symbol(sym.CADENA, yyline+1, yycolumn+1, yytext());}
{id}+ {return new Symbol(sym.ID, yyline+1, yycolumn+1, yytext());}
"</".*"/>" {}
{punto} {return new Symbol(sym.PUNTO, yyline+1, yycolumn+1, yytext()); }

        /* SImbolos */

"$$"                    {return new Symbol(sym.DOLAR, yyline+1, yycolumn+1, yytext());}
"+"                     {return new Symbol(sym.SUMA, yyline+1, yycolumn+1, yytext());}
"-"                     {return new Symbol(sym.RESTA, yyline+1, yycolumn+1, yytext());}
"*"                     {return new Symbol(sym.MULTIPLICACION, yyline+1, yycolumn+1, yytext());}
"/"                     {return new Symbol(sym.DIVISION, yyline+1, yycolumn+1, yytext());}
"("                     {return new Symbol(sym.PARENTESIS_A, yyline+1, yycolumn+1, yytext());}
")"                     {return new Symbol(sym.PARENTESIS_C, yyline+1, yycolumn+1, yytext());}
";"                     {return new Symbol(sym.PUNTO_COMA, yyline+1, yycolumn+1, yytext());}
":"                     {return new Symbol(sym.DOS_PUNTOS, yyline+1, yycolumn+1, yytext());}
","                     {return new Symbol(sym.COMA, yyline+1, yycolumn+1, yytext());}
"="                     {return new Symbol(sym.SIGNO_IGUAL, yyline+1, yycolumn+1, yytext());}
"<"                     {return new Symbol(sym.ETIQUETA_ABRIR, yyline+1, yycolumn+1, yytext());}
"</"                    {return new Symbol(sym.ETIQUETA_FIN, yyline+1, yycolumn+1, yytext());}
">"                     {return new Symbol(sym.ETIQUETA_CERRAR, yyline+1, yycolumn+1, yytext());}
"["                     {return new Symbol(sym.CORCHETE_A, yyline+1, yycolumn+1, yytext());}
"]"                     {return new Symbol(sym.CORCHETE_C, yyline+1, yycolumn+1, yytext());}
[^] {errores.add("Error Lexico: | Lexema: " + yytext() + " | Linea: " + (yyline+1) + " | Columna: " + (yycolumn+1));;return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());}



