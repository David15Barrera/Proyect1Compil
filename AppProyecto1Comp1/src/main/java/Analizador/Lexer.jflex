/* primer seccion: codigo de usuario */
package Analizador;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import reporte.ciclo.Simbolos;

%%
/* segunda seccion: coonfiguracion */
%class LexicoArch
%public
%line
%column
%ignorecase
%cup
%cupdebug

/*tercer seccion: reglase lexicas*/

punto=[.]
L=[a-zA-Z_]
D=[0-9]
espacio=[ ]+
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
%}sym

%%

        /* Palabras reservadas */

inicio                  {return new Symbol(Simbolos.INICIO, yyline+1, yycolumn+1, yytext());}
score                   {return new Symbol(Simbolos.SCORE, yyline+1, yycolumn+1, yytext());}
clases                  {return new Symbol(Simbolos.CLASES, yyline+1, yycolumn+1, yytext());}
variables               {return new Symbol(Simbolos.VARIABLES, yyline+1, yycolumn+1, yytext());}
metodos                 {return new Symbol(Simbolos.METODOS, yyline+1, yycolumn+1, yytext());}
comentarios             {return new Symbol(Simbolos.COMENTARIOS, yyline+1, yycolumn+1, yytext());}
nombre                  {return new Symbol(Simbolos.NOMBRE, yyline+1, yycolumn+1, yytext());}
tipo                    {return new Symbol(Simbolos.TIPO, yyline+1, yycolumn+1, yytext());}
funcion                 {return new Symbol(Simbolos.FUNCION, yyline+1, yycolumn+1, yytext());}
parametros              {return new Symbol(Simbolos.PARAMETROS, yyline+1, yycolumn+1, yytext());}
texto                   {return new Symbol(Simbolos.TEXTO, yyline+1, yycolumn+1, yytext());}
RESULT                  {return new Symbol(Simbolos.RESULT, yyline+1, yycolumn+1, yytext());}
h1                      {return new Symbol(Simbolos.H1, yyline+1, yycolumn+1, yytext());}
h2                      {return new Symbol(Simbolos.H2, yyline+1, yycolumn+1, yytext());}
table                   {return new Symbol(Simbolos.TABLE, yyline+1, yycolumn+1, yytext());}
tr                      {return new Symbol(Simbolos.TR, yyline+1, yycolumn+1, yytext());}
td                      {return new Symbol(Simbolos.TD, yyline+1, yycolumn+1, yytext());}
th                      {return new Symbol(Simbolos.TH, yyline+1, yycolumn+1, yytext());}
br                      {return new Symbol(Simbolos.BR, yyline+1, yycolumn+1, yytext());}

        /* Salos y comentarios */

{salto} {/*ignorar*/}
{rot} {/*ignorar*/}
{espacio} {/*ignorar*/}
{tab} {/*ignorar*/}
{decimal} { return new Symbol(Simbolos.DECIMAL, yyline+1, yycolumn+1, yytext());}
{entero} {return new Symbol(Simbolos.ENTERO, yyline+1, yycolumn+1, Integer.parseInt(yytext()));}
{comilla}({id}|{entero}|{decimal}|{espacio}|"+"|"-"|"*"|"/"|":"|";"|"<"|">")*{comilla} {return new Symbol(Simbolos.CADENA, yyline+1, yycolumn+1, yytext());}
{id}+ {return new Symbol(Simbolos.ID, yyline+1, yycolumn+1, yytext());}
{punto} {return new Symbol(Simbolos.PUNTO, yyline+1, yycolumn+1, yytext()); }

        /* Signos */
"/" {return new Symbol(Simbolos.DIVISION, yyline+1, yycolumn+1, yytext());}
"(" {return new Symbol(Simbolos.PARENTESIS_A, yyline+1, yycolumn+1, yytext());}
")" {return new Symbol(Simbolos.PARENTESIS_C, yyline+1, yycolumn+1, yytext());}
"<" {return new Symbol(Simbolos.ETIQUETA_ABRIR, yyline+1, yycolumn+1, yytext());}
"</" {return new Symbol(Simbolos.ETIQUETA_FIN, yyline+1, yycolumn+1, yytext());}
">" {return new Symbol(Simbolos.ETIQUETA_CERRAR, yyline+1, yycolumn+1, yytext());}
"$$" {return new Symbol(Simbolos.DOLAR, yyline+1, yycolumn+1, yytext());}
";" {return new Symbol(Simbolos.PUNTO_COMA, yyline+1, yycolumn+1, yytext());}
":" {return new Symbol(Simbolos.DOS_PUNTOS, yyline+1, yycolumn+1, yytext());}
"," {return new Symbol(Simbolos.COMA, yyline+1, yycolumn+1, yytext());}
"=" {return new Symbol(Simbolos.SIGNO_IGUAL, yyline+1, yycolumn+1, yytext());}
"+" {return new Symbol(Simbolos.SUMA, yyline+1, yycolumn+1, yytext());}
"-" {return new Symbol(Simbolos.RESTA, yyline+1, yycolumn+1, yytext());}
"*" {return new Symbol(Simbolos.MULTIPLICACION, yyline+1, yycolumn+1, yytext());}
"[" {return new Symbol(Simbolos.CORCHETE_A, yyline+1, yycolumn+1, yytext());}
"]" {return new Symbol(Simbolos.CORCHETE_C, yyline+1, yycolumn+1, yytext());}
[^] {errores.add("Error Lexico: | Lexema: " + yytext() + " | Linea: " + (yyline+1) + " | Columna: " + (yycolumn+1));;return new Symbol(Simbolos.ERROR, yyline+1, yycolumn+1, yytext());}




