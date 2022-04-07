/* primer seccion: codigo de usuario */
package Analisis;

import Analisis.sym;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import clases.Lista;
/* segunda seccion: coonfiguracion */
%%
%class LexerServidor
%public
%line
%column
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
comilla_simple = [']
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

%{
    
    private Lista lista;;
    private ArrayList<String> errores = new ArrayList<>();
    private String nombre_clase;

    public void setNombre_clase(String nombre_clase) {
        this.nombre_clase = nombre_clase;
    }

    public void setErrores(ArrayList<String> errores) {
        this.errores = errores;
    }
      
    public void setLista(Lista lista) {
        this.lista = lista;
    }



%}

%%
        /* Palabras reservadas */

double              {return new Symbol(sym.DOUBLE, yyline+1, yycolumn+1, yytext());}
boolean             {return new Symbol(sym.BOOLEAN, yyline+1, yycolumn+1, yytext());}
String              {return new Symbol(sym.STRING, yyline+1, yycolumn+1, yytext());}
char                {return new Symbol(sym.CHAR, yyline+1, yycolumn+1, yytext());}
import              {return new Symbol(sym.IMPORT, yyline+1, yycolumn+1, yytext());}
class               {return new Symbol(sym.CLASS, yyline+1, yycolumn+1, yytext());}
int                 {return new Symbol(sym.INT, yyline+1, yycolumn+1, yytext());}
Object              {return new Symbol(sym.OBJECT, yyline+1, yycolumn+1, yytext());}
if                  {return new Symbol(sym.IF, yyline+1, yycolumn+1, yytext());}
else                {return new Symbol(sym.ELSE, yyline+1, yycolumn+1, yytext());}
for                 {return new Symbol(sym.FOR, yyline+1, yycolumn+1, yytext());}
while               {return new Symbol(sym.WHILE, yyline+1, yycolumn+1, yytext());}
do                  {return new Symbol(sym.DO, yyline+1, yycolumn+1, yytext());}
switch              {return new Symbol(sym.SWITCH, yyline+1, yycolumn+1, yytext());}
case                {return new Symbol(sym.CASE, yyline+1, yycolumn+1, yytext());}
public              {return new Symbol(sym.PUBLIC, yyline+1, yycolumn+1, yytext());}
protected           {return new Symbol(sym.PROTECTED, yyline+1, yycolumn+1, yytext());}
private             {return new Symbol(sym.PRIVATE, yyline+1, yycolumn+1, yytext());}
final               {return new Symbol(sym.FINAL, yyline+1, yycolumn+1, yytext());}
break               {return new Symbol(sym.BREAK, yyline+1, yycolumn+1, yytext());}
return              {return new Symbol(sym.RETURN, yyline+1, yycolumn+1, yytext());}
void                {return new Symbol(sym.VOID, yyline+1, yycolumn+1, yytext());}
this                {return new Symbol(sym.THIS, yyline+1, yycolumn+1, yytext());}
true                {return new Symbol(sym.TRUE, yyline+1, yycolumn+1, yytext());}
false               {return new Symbol(sym.FALSE, yyline+1, yycolumn+1, yytext());}
new                 {return new Symbol(sym.NEW, yyline+1, yycolumn+1, yytext());}
default              {return new Symbol(sym.DEFAULT, yyline+1, yycolumn+1, yytext());}

        /* Operadores matematicos */
"=="                {return new Symbol(sym.LOGICO_IGUAL, yyline+1, yycolumn+1, yytext());}
"!="                {return new Symbol(sym.LOGICO_DISTINTO, yyline+1, yycolumn+1, yytext());}
"<="                {return new Symbol(sym.MENOR_IGUAL, yyline+1, yycolumn+1, yytext());}
">="                {return new Symbol(sym.MAYOR_IGUAL, yyline+1, yycolumn+1, yytext());}
"&&"                {return new Symbol(sym.LOGICO_Y, yyline+1, yycolumn+1, yytext());}
"||"                {return new Symbol(sym.LOGICO_O, yyline+1, yycolumn+1, yytext());}
"++"                {return new Symbol(sym.INCREMENTO, yyline+1, yycolumn+1, yytext());}
"--"                {return new Symbol(sym.DECREMENTO, yyline+1, yycolumn+1, yytext());}
"+"                 {return new Symbol(sym.SUMA, yyline+1, yycolumn+1, yytext());}
"-"                 {return new Symbol(sym.RESTA, yyline+1, yycolumn+1, yytext());}
"*"                 {return new Symbol(sym.MULTIPLICACION, yyline+1, yycolumn+1, yytext());}
"/"                 {return new Symbol(sym.DIVISION, yyline+1, yycolumn+1, yytext());}
"("                 {return new Symbol(sym.PARENTESIS_A, yyline+1, yycolumn+1, yytext());}
")"                 {return new Symbol(sym.PARENTESIS_C, yyline+1, yycolumn+1, yytext());}
":"                 {return new Symbol(sym.DOS_PUNTOS, yyline+1, yycolumn+1, yytext());}
";"                 {return new Symbol(sym.PUNTO_COMA, yyline+1, yycolumn+1, yytext());}
"{"                 {return new Symbol(sym.LLAVE_A, yyline+1, yycolumn+1, yytext());}
"}"                 {return new Symbol(sym.LLAVE_C, yyline+1, yycolumn+1, yytext());}
"["                 {return new Symbol(sym.CORCHETE_A, yyline+1, yycolumn+1, yytext());}
"]"                 {return new Symbol(sym.CORCHETE_C, yyline+1, yycolumn+1, yytext());}
"="                 {return new Symbol(sym.SIGNO_IGUAL, yyline+1, yycolumn+1, yytext());}
","                 {return new Symbol(sym.COMA, yyline+1, yycolumn+1, yytext());}
"<"                 {return new Symbol(sym.MENOR, yyline+1, yycolumn+1, yytext());}
">"                 {return new Symbol(sym.MAYOR, yyline+1, yycolumn+1, yytext());}

        /*Espacios y demas */

{espacio} {/*ignorar*/}
{tab} {/*ignorar*/}
{salto} {/*ignorar*/}
{rot} {/*ignorar*/}
{decimal} { return new Symbol(sym.DECIMAL, yyline+1, yycolumn+1, yytext());}
{entero} {return new Symbol(sym.ENTERO, yyline+1, yycolumn+1, yytext());}
{id}+ {return new Symbol(sym.ID, yyline+1, yycolumn+1, yytext());}
{comilla}({id}|{entero}|{decimal}|{espacio}|{salto}|"+"|"-"|"*"|"/"|":"|","|"="|"!"|"<"|">"|"("|")"|"["|"]")*{comilla} {return new Symbol(sym.CADENA, yyline+1, yycolumn+1, yytext());}
{comilla_simple}{id}{comilla_simple} {return new Symbol(sym.LETRA, yyline+1, yycolumn+1, yytext());}
{Comment} {lista.añadirComentario(yytext());}
{punto} {return new Symbol(sym.PUNTO, yyline+1, yycolumn+1, yytext()); }

[^] {errores.add("Error Lexico en: " + nombre_clase + " | Lexema: " + yytext() + " | Linea: " + (yyline+1) + " | Columna: " + (yycolumn+1));;return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());}
