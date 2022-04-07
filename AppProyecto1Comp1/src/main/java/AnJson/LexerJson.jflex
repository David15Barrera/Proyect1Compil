/* primer seccion: codigo de usuario */
package AnJson;

import AnJson.sym;
import java_cup.runtime.Symbol;
import java.util.ArrayList;

/* segunda seccion: coonfiguracion */
%%
%class LexerJISON
%public
%line
%column
%ignorecase
%cup
%cupdebug

/*tercer seccion: reglase lexicas*/
L=[a-zA-Z_nÑ]
D=[0-9]
punto=[.]
espacio=[ ]+
tab = [\t]+
salto = [\n]+
rot = [\r]+
comilla = [\"]
decimal = ({D}+{punto}{D}+)
entero = {D}+
id = {L}({L}|{D})*

%{
    private ArrayList<String> errores = new ArrayList<>();

    public void setErrores(ArrayList<String> errores) {
        this.errores = errores;
    }
%}

%%
        /* Palabras reservadas */

metodos                 {return new Symbol(sym.METODOS, yyline+1, yycolumn+1, yytext());}
comentarios             {return new Symbol(sym.COMENTARIOS, yyline+1, yycolumn+1, yytext());}
nombre                  {return new Symbol(sym.NOMBRE, yyline+1, yycolumn+1, yytext());}
tipo                    {return new Symbol(sym.TIPO, yyline+1, yycolumn+1, yytext());}
funcion                 {return new Symbol(sym.FUNCION, yyline+1, yycolumn+1, yytext());}
parametros              {return new Symbol(sym.PARAMETROS, yyline+1, yycolumn+1, yytext());}
texto                   {return new Symbol(sym.TEXTO, yyline+1, yycolumn+1, yytext());}
score                   {return new Symbol(sym.SCORE, yyline+1, yycolumn+1, yytext());}
clases                  {return new Symbol(sym.CLASES, yyline+1, yycolumn+1, yytext());}
variables               {return new Symbol(sym.VARIABLES, yyline+1, yycolumn+1, yytext());}
        /* Comentarios y saltos */

{espacio} {/*ignorar*/}
{tab} {/*ignorar*/}
{salto} {/*ignorar*/}
{rot} {/*ignorar*/}
{decimal} { return new Symbol(sym.DECIMAL, yyline+1, yycolumn+1, yytext());}
{entero} {return new Symbol(sym.ENTERO, yyline+1, yycolumn+1, Integer.parseInt(yytext()));}
{id}+ {return new Symbol(sym.ID, yyline+1, yycolumn+1, yytext());}
{comilla} {return new Symbol(sym.COMILLA, yyline+1, yycolumn+1, yytext()); }
        /* Signos */

"/*".*"*/" {return new Symbol(sym.COMENTARIO, yyline+1, yycolumn+1, yytext()); }
"//".*{comilla} {return new Symbol(sym.COMENTARIO, yyline+1, yycolumn+1, yytext()); }
":" {return new Symbol(sym.DOS_PUNTOS, yyline+1, yycolumn+1, yytext());}
"{" {return new Symbol(sym.LLAVE_A, yyline+1, yycolumn+1, yytext());}
"}" {return new Symbol(sym.LLAVE_C, yyline+1, yycolumn+1, yytext());}
"[" {return new Symbol(sym.CORCHETE_A, yyline+1, yycolumn+1, yytext());}
"]" {return new Symbol(sym.CORCHETE_C, yyline+1, yycolumn+1, yytext());}
"," {return new Symbol(sym.COMA, yyline+1, yycolumn+1, yytext());}
[^] {errores.add("Error Lexico: | Lexema: " + yytext() + " | Linea: " + (yyline+1) + " | Columna: " + (yycolumn+1));;return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());}


