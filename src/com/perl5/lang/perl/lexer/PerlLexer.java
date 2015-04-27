/* The following code was generated by JFlex 1.4.3 on 27.04.15 19:48 */

package com.perl5.lang.perl.lexer;

/*
    http://jflex.de/manual.html
    http://www2.cs.tum.edu/projects/cup

*/

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import com.perl5.lang.perl.util.PerlFunctionUtil;
import com.perl5.lang.perl.util.PerlScalarUtil;
import com.perl5.lang.perl.util.PerlHashUtil;
import com.perl5.lang.perl.util.PerlGlobUtil;
import com.perl5.lang.perl.util.PerlArrayUtil;
import com.perl5.lang.perl.util.PerlPackageUtil;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 27.04.15 19:48 from the specification file
 * <tt>C:/Repository/Perl5-IDEA/src/com/perl5/lang/perl/lexer/Perl.flex</tt>
 */
public class PerlLexer extends PerlLexerProto implements FlexLexer, PerlElementTypes {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int LEX_MULTILINE_WAITING = 12;
  public static final int LEX_REQUIRE = 24;
  public static final int LEX_PACKAGE_USE = 18;
  public static final int LEX_DEREFERENCE = 28;
  public static final int LEX_PACKAGE_USE_VERSION = 22;
  public static final int LEX_MULTILINE_TOKEN = 16;
  public static final int LEX_PACKAGE_DEFINITION_BLOCK = 6;
  public static final int LEX_PACKAGE_USE_PARAMS = 20;
  public static final int LEX_MULTILINE = 14;
  public static final int LEX_EOF = 8;
  public static final int LEX_PACKAGE_DEFINITION = 2;
  public static final int LEX_FUNCTION_DEFINITION = 26;
  public static final int YYINITIAL = 0;
  public static final int LEX_PACKAGE_DEFINITION_VERSION = 4;
  public static final int LEX_POD = 10;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8,  8,  9,  9, 10, 10, 11, 11, 12, 12, 13, 13,  6, 6
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\57\1\23\1\16"+
    "\1\71\1\67\1\30\1\45\1\17\1\77\1\100\1\22\1\20\1\72"+
    "\1\21\1\47\1\27\1\5\1\62\1\62\1\62\1\62\5\5\1\50"+
    "\1\4\1\32\1\26\1\33\1\25\1\70\1\13\2\6\1\12\1\10"+
    "\10\6\1\11\5\6\1\14\6\6\1\75\1\25\1\76\1\25\1\7"+
    "\1\15\1\52\1\64\1\42\1\53\1\37\1\55\1\36\1\61\1\56"+
    "\1\6\1\65\1\34\1\43\1\41\1\51\1\44\1\40\1\54\1\60"+
    "\1\35\1\66\1\63\1\6\1\31\2\6\1\73\1\46\1\74\1\24"+
    "\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\3\1\1\2\1\3\1\0\1\4\1\5\5\0"+
    "\2\6\1\7\1\1\1\10\1\11\1\12\1\11\3\6"+
    "\10\13\1\14\3\13\5\12\2\13\1\6\1\13\6\12"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\2\27\2\1\1\30\2\31\1\32\1\31"+
    "\1\33\2\34\1\2\3\3\1\13\1\12\2\4\1\35"+
    "\2\36\1\37\2\40\21\36\1\40\2\36\2\41\1\37"+
    "\3\42\2\43\1\44\2\45\21\43\1\45\2\43\2\46"+
    "\3\0\1\11\1\0\1\41\2\0\1\11\1\47\1\50"+
    "\10\0\1\51\1\0\3\13\1\52\2\12\1\13\1\53"+
    "\5\12\1\54\1\0\1\55\1\0\1\17\3\0\1\3"+
    "\1\12\2\0\2\37\2\0\1\44\1\56\1\11\1\57"+
    "\2\12\13\0\1\60\3\0\3\12\1\61\1\62\3\0"+
    "\1\3\1\37\1\57\1\0\1\44\1\57\2\0\2\12"+
    "\2\0\1\63\10\0\3\12\2\0\1\64\2\12\2\0"+
    "\1\63\3\0\2\60\3\12\2\0\1\64\1\12\1\0"+
    "\2\12\1\65\1\0\1\66\1\67\1\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[272];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\101\0\202\0\303\0\u0104\0\u0145\0\u0186\0\u01c7"+
    "\0\u0208\0\u0249\0\u028a\0\u02cb\0\u030c\0\u034d\0\u038e\0\u03cf"+
    "\0\u038e\0\u0410\0\u038e\0\u0451\0\u0492\0\u04d3\0\u0514\0\u0555"+
    "\0\u0596\0\u05d7\0\u0618\0\u0659\0\u069a\0\u06db\0\u038e\0\u071c"+
    "\0\u075d\0\u079e\0\u07df\0\u0820\0\u0861\0\u08a2\0\u08e3\0\u0924"+
    "\0\u0965\0\u09a6\0\u09e7\0\u0a28\0\u0a69\0\u0aaa\0\u0aeb\0\u0b2c"+
    "\0\u0b6d\0\u0bae\0\u0bef\0\u0c30\0\u0c71\0\u0cb2\0\u0cf3\0\u038e"+
    "\0\u038e\0\u038e\0\u038e\0\u038e\0\u038e\0\u038e\0\u038e\0\u0d34"+
    "\0\u038e\0\u0d75\0\u0db6\0\u038e\0\u0d34\0\u0df7\0\u0e38\0\u038e"+
    "\0\u038e\0\u0d34\0\u038e\0\u0e79\0\u038e\0\u0eba\0\u0efb\0\u0f3c"+
    "\0\u0f7d\0\u0fbe\0\u038e\0\u038e\0\u03cf\0\u0fff\0\u1040\0\u1081"+
    "\0\u0514\0\u0555\0\u0596\0\u05d7\0\u0618\0\u0659\0\u069a\0\u06db"+
    "\0\u0efb\0\u075d\0\u079e\0\u0820\0\u0861\0\u09e7\0\u0a28\0\u0a69"+
    "\0\u0aaa\0\u10c2\0\u0c71\0\u0cb2\0\u1103\0\u1144\0\u1185\0\u11c6"+
    "\0\u1207\0\u1248\0\u038e\0\u03cf\0\u1289\0\u12ca\0\u130b\0\u0514"+
    "\0\u0555\0\u0596\0\u05d7\0\u0618\0\u0659\0\u069a\0\u06db\0\u0efb"+
    "\0\u075d\0\u079e\0\u0820\0\u0861\0\u09e7\0\u0a28\0\u0a69\0\u0aaa"+
    "\0\u134c\0\u0c71\0\u0cb2\0\u138d\0\u13ce\0\u140f\0\u1450\0\u1491"+
    "\0\u14d2\0\u0514\0\u038e\0\u0555\0\u0596\0\u1513\0\u038e\0\u1554"+
    "\0\u1595\0\u15d6\0\u1617\0\u1658\0\u1699\0\u16da\0\u171b\0\u175c"+
    "\0\u179d\0\u079e\0\u17de\0\u181f\0\u0492\0\u1860\0\u18a1\0\u18e2"+
    "\0\u1923\0\u038e\0\u1964\0\u19a5\0\u19e6\0\u1a27\0\u1a68\0\u1aa9"+
    "\0\u0c71\0\u1aea\0\u0cb2\0\u038e\0\u0d34\0\u1b2b\0\u0e38\0\u1b6c"+
    "\0\u1860\0\u1bad\0\u1bee\0\u1c2f\0\u1c70\0\u1cb1\0\u1cf2\0\u1d33"+
    "\0\u038e\0\u1450\0\u1d74\0\u1db5\0\u1df6\0\u1e37\0\u1e78\0\u1eb9"+
    "\0\u1efa\0\u1f3b\0\u1f7c\0\u1fbd\0\u1ffe\0\u203f\0\u2080\0\u181f"+
    "\0\u20c1\0\u2102\0\u2143\0\u2184\0\u21c5\0\u2206\0\u2247\0\u0492"+
    "\0\u0492\0\u2288\0\u22c9\0\u230a\0\u234b\0\u238c\0\u23cd\0\u240e"+
    "\0\u244f\0\u2490\0\u24d1\0\u2512\0\u2553\0\u2594\0\u25d5\0\u2616"+
    "\0\u2657\0\u2698\0\u26d9\0\u271a\0\u275b\0\u279c\0\u27dd\0\u281e"+
    "\0\u285f\0\u28a0\0\u28e1\0\u2922\0\u2963\0\u29a4\0\u29e5\0\u2a26"+
    "\0\u2a67\0\u1554\0\u2aa8\0\u038e\0\u2ae9\0\u2b2a\0\u179d\0\u27dd"+
    "\0\u038e\0\u2b6b\0\u2bac\0\u2bed\0\u1aa9\0\u1aea\0\u038e\0\u2c2e"+
    "\0\u2c6f\0\u2cb0\0\u2cf1\0\u0492\0\u2d32\0\u0492\0\u0492\0\u2d73";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[272];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\5\25\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\25\1\46\1\47\1\25\1\50\1\51\1\25"+
    "\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61"+
    "\1\62\2\25\1\22\1\63\1\25\1\24\3\25\1\64"+
    "\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74"+
    "\1\75\1\76\1\77\1\100\1\101\1\102\1\77\10\103"+
    "\14\77\1\103\2\77\11\103\4\77\6\103\1\102\7\103"+
    "\12\77\1\104\1\105\1\101\1\102\1\23\1\106\51\104"+
    "\1\102\2\104\1\106\1\107\7\104\1\110\5\104\1\111"+
    "\1\112\1\101\1\102\1\23\52\111\1\102\13\111\1\110"+
    "\5\111\2\5\1\113\76\5\2\114\1\115\23\114\1\116"+
    "\52\114\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\24\5\25\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\117\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\25\1\46\1\47\1\25\1\120\1\51"+
    "\2\25\1\53\1\54\1\55\1\56\1\57\1\60\1\61"+
    "\3\25\1\22\2\25\1\24\4\25\1\65\1\66\1\67"+
    "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\121"+
    "\1\122\1\123\76\121\2\11\1\0\76\11\1\124\1\125"+
    "\1\21\1\22\1\23\1\126\1\127\1\130\5\127\1\131"+
    "\1\132\1\133\1\134\1\135\1\136\1\137\1\140\1\124"+
    "\1\141\1\142\1\143\1\127\1\144\1\145\11\127\1\146"+
    "\1\147\1\150\1\151\6\127\1\22\2\127\1\126\1\152"+
    "\3\127\1\153\1\154\1\67\1\70\6\124\1\17\1\20"+
    "\1\21\1\22\1\23\1\155\1\156\1\155\5\156\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\117\1\41\1\42\1\156\1\44\1\45\11\156\1\53"+
    "\1\54\1\55\1\56\6\156\1\22\2\156\1\155\4\156"+
    "\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74"+
    "\1\75\1\76\1\17\1\20\1\21\1\22\1\23\1\157"+
    "\1\160\1\161\5\160\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\117\1\41\1\42\1\160"+
    "\1\44\1\45\11\160\1\53\1\54\1\55\1\56\6\160"+
    "\1\22\2\160\1\157\1\162\3\160\1\65\1\66\1\67"+
    "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\163"+
    "\1\164\1\21\1\22\1\23\1\165\1\166\1\167\5\166"+
    "\1\170\1\171\1\172\1\173\1\174\1\175\1\176\1\177"+
    "\1\163\1\200\1\201\1\202\1\166\1\203\1\204\11\166"+
    "\1\205\1\206\1\207\1\210\6\166\1\22\2\166\1\165"+
    "\1\211\3\166\1\212\1\213\1\67\1\70\6\163\1\17"+
    "\1\20\1\21\1\22\1\23\1\214\1\215\1\214\5\215"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\117\1\41\1\42\1\215\1\44\1\45\11\215"+
    "\1\53\1\54\1\55\1\56\6\215\1\22\2\215\1\214"+
    "\4\215\1\65\1\66\1\67\1\70\1\71\1\72\1\73"+
    "\1\74\1\75\1\76\103\0\1\21\101\0\1\22\53\0"+
    "\1\22\26\0\1\24\1\25\1\24\5\25\4\0\1\216"+
    "\7\0\1\25\2\0\11\25\2\0\1\217\1\220\6\25"+
    "\1\0\2\25\1\24\4\25\17\0\10\25\4\0\1\216"+
    "\7\0\1\25\2\0\11\25\3\0\1\220\6\25\1\0"+
    "\7\25\17\0\1\24\1\25\1\221\5\25\4\0\1\216"+
    "\7\0\1\25\2\0\11\25\2\0\1\217\1\220\6\25"+
    "\1\0\2\25\1\24\4\25\12\0\1\222\2\0\12\222"+
    "\1\223\63\222\1\224\2\0\13\224\1\223\62\224\1\225"+
    "\2\0\14\225\1\223\61\225\20\0\1\37\5\0\1\37"+
    "\57\0\1\226\1\0\1\226\11\0\1\37\4\0\1\37"+
    "\4\0\1\227\26\0\1\226\23\0\10\230\5\0\1\37"+
    "\3\0\1\37\2\0\1\230\2\0\11\230\4\0\6\230"+
    "\1\0\7\230\1\231\35\0\1\37\1\0\1\37\76\0"+
    "\1\37\100\0\1\37\1\0\1\37\4\0\1\70\3\0"+
    "\1\232\4\0\1\233\4\0\1\234\3\0\1\235\1\236"+
    "\2\0\1\237\2\0\1\240\43\0\1\37\56\0\10\241"+
    "\14\0\1\241\2\0\11\241\4\0\6\241\1\0\7\241"+
    "\1\242\16\0\10\25\4\0\1\216\7\0\1\25\2\0"+
    "\11\25\3\0\1\220\1\57\5\25\1\0\7\25\40\0"+
    "\1\243\3\0\1\244\74\0\1\37\4\0\1\37\52\0"+
    "\10\25\4\0\1\216\7\0\1\25\2\0\1\25\1\245"+
    "\1\25\1\245\5\25\3\0\1\220\6\25\1\0\7\25"+
    "\17\0\10\25\4\0\1\216\7\0\1\25\2\0\4\25"+
    "\1\245\4\25\3\0\1\220\6\25\1\0\7\25\17\0"+
    "\10\25\4\0\1\216\7\0\1\25\2\0\3\25\1\245"+
    "\5\25\3\0\1\220\1\246\5\25\1\0\7\25\17\0"+
    "\10\25\4\0\1\216\7\0\1\25\2\0\7\25\1\247"+
    "\1\25\3\0\1\220\6\25\1\0\7\25\17\0\10\25"+
    "\4\0\1\216\7\0\1\25\2\0\11\25\3\0\1\220"+
    "\1\25\1\250\4\25\1\0\7\25\57\0\1\37\101\0"+
    "\1\37\101\0\1\251\101\0\1\252\35\0\10\25\4\0"+
    "\1\216\7\0\1\25\2\0\11\25\3\0\1\220\3\25"+
    "\1\245\2\25\1\0\7\25\17\0\10\25\4\0\1\216"+
    "\7\0\1\25\2\0\5\25\1\253\3\25\3\0\1\220"+
    "\6\25\1\0\7\25\17\0\10\25\4\0\1\216\7\0"+
    "\1\25\2\0\3\25\1\254\5\25\3\0\1\220\6\25"+
    "\1\0\7\25\17\0\10\25\4\0\1\216\7\0\1\25"+
    "\2\0\3\25\1\255\5\25\3\0\1\220\6\25\1\0"+
    "\7\25\17\0\10\25\4\0\1\216\7\0\1\25\2\0"+
    "\11\25\3\0\1\220\6\25\1\0\6\25\1\256\17\0"+
    "\10\25\4\0\1\216\7\0\1\25\2\0\11\25\3\0"+
    "\1\220\6\25\1\0\1\257\6\25\17\0\10\260\14\0"+
    "\1\260\2\0\11\260\4\0\6\260\1\0\7\260\1\261"+
    "\16\0\10\262\14\0\1\262\2\0\11\262\4\0\6\262"+
    "\1\0\7\262\1\263\11\0\2\67\1\264\76\67\2\0"+
    "\1\101\77\0\1\265\1\101\1\102\53\0\1\102\26\0"+
    "\10\103\14\0\1\103\2\0\11\103\3\0\1\266\6\103"+
    "\1\0\7\103\17\0\1\106\1\0\1\106\37\0\1\267"+
    "\12\0\1\106\23\0\1\106\54\0\1\106\16\0\2\114"+
    "\1\115\100\114\1\115\37\114\1\270\36\114\24\0\1\37"+
    "\1\0\1\37\4\0\1\70\52\0\10\25\4\0\1\216"+
    "\7\0\1\25\2\0\3\25\1\245\5\25\3\0\1\220"+
    "\1\271\5\25\1\0\7\25\12\0\2\121\1\0\100\121"+
    "\1\123\76\121\5\0\1\126\1\127\1\126\5\127\4\0"+
    "\1\216\7\0\1\127\2\0\11\127\2\0\1\272\1\273"+
    "\6\127\1\0\2\127\1\126\4\127\17\0\10\127\4\0"+
    "\1\216\7\0\1\127\2\0\11\127\3\0\1\273\6\127"+
    "\1\0\7\127\17\0\1\130\1\127\1\130\5\127\4\0"+
    "\1\216\7\0\1\127\2\0\11\127\2\0\1\217\1\273"+
    "\6\127\1\0\2\127\1\130\4\127\17\0\1\274\7\127"+
    "\4\0\1\216\7\0\1\127\2\0\11\127\3\0\1\273"+
    "\6\127\1\0\2\127\1\274\4\127\17\0\1\155\1\156"+
    "\1\155\5\156\4\0\1\216\7\0\1\156\2\0\11\156"+
    "\2\0\1\217\1\220\6\156\1\0\2\156\1\155\4\156"+
    "\17\0\10\156\4\0\1\216\7\0\1\156\2\0\11\156"+
    "\3\0\1\220\6\156\1\0\7\156\17\0\1\157\1\160"+
    "\1\157\5\160\4\0\1\216\7\0\1\160\2\0\11\160"+
    "\2\0\1\272\1\220\6\160\1\0\2\160\1\157\4\160"+
    "\17\0\10\160\4\0\1\216\7\0\1\160\2\0\11\160"+
    "\3\0\1\220\6\160\1\0\7\160\17\0\1\161\1\160"+
    "\1\161\5\160\4\0\1\216\7\0\1\160\2\0\11\160"+
    "\2\0\1\217\1\220\6\160\1\0\2\160\1\161\4\160"+
    "\17\0\1\275\7\160\4\0\1\216\7\0\1\160\2\0"+
    "\11\160\3\0\1\220\6\160\1\0\2\160\1\275\4\160"+
    "\17\0\1\165\1\166\1\165\5\166\4\0\1\216\7\0"+
    "\1\166\2\0\11\166\2\0\1\276\1\277\6\166\1\0"+
    "\2\166\1\165\4\166\17\0\10\166\4\0\1\216\7\0"+
    "\1\166\2\0\11\166\3\0\1\277\6\166\1\0\7\166"+
    "\17\0\1\167\1\166\1\167\5\166\4\0\1\216\7\0"+
    "\1\166\2\0\11\166\2\0\1\217\1\277\6\166\1\0"+
    "\2\166\1\167\4\166\17\0\1\300\7\166\4\0\1\216"+
    "\7\0\1\166\2\0\11\166\3\0\1\277\6\166\1\0"+
    "\2\166\1\300\4\166\17\0\1\214\1\215\1\214\5\215"+
    "\4\0\1\216\7\0\1\215\2\0\11\215\2\0\1\217"+
    "\1\220\6\215\1\0\2\215\1\214\4\215\17\0\10\215"+
    "\4\0\1\216\7\0\1\215\2\0\11\215\3\0\1\220"+
    "\6\215\1\0\7\215\45\0\1\301\52\0\1\302\1\0"+
    "\1\302\52\0\1\302\66\0\1\303\35\0\1\24\1\25"+
    "\1\24\1\304\1\25\1\305\2\25\4\0\1\216\7\0"+
    "\1\25\2\0\11\25\2\0\1\217\1\220\6\25\1\0"+
    "\2\25\1\24\4\25\17\0\1\226\1\0\1\226\37\0"+
    "\1\217\12\0\1\226\23\0\10\230\14\0\1\230\2\0"+
    "\11\230\3\0\1\306\6\230\1\0\7\230\17\0\10\230"+
    "\14\0\1\230\2\0\11\230\4\0\6\230\1\0\7\230"+
    "\1\231\52\0\1\307\110\0\1\310\112\0\1\311\66\0"+
    "\1\312\64\0\1\313\102\0\1\314\100\0\1\315\12\0"+
    "\1\316\33\0\10\241\14\0\1\241\2\0\11\241\3\0"+
    "\1\317\6\241\1\0\7\241\45\0\1\37\50\0\1\320"+
    "\1\0\10\321\1\322\1\323\1\324\11\0\1\321\2\0"+
    "\11\321\4\0\6\321\1\320\7\321\17\0\10\25\4\0"+
    "\1\216\7\0\1\25\2\0\1\25\1\245\7\25\3\0"+
    "\1\220\6\25\1\0\7\25\17\0\10\25\4\0\1\216"+
    "\7\0\1\25\2\0\10\25\1\245\3\0\1\220\6\25"+
    "\1\0\7\25\17\0\10\25\4\0\1\216\7\0\1\25"+
    "\2\0\6\25\1\325\2\25\3\0\1\220\6\25\1\0"+
    "\7\25\61\0\1\37\36\0\10\25\4\0\1\216\7\0"+
    "\1\25\2\0\11\25\3\0\1\220\2\25\1\245\3\25"+
    "\1\0\7\25\17\0\10\25\4\0\1\216\7\0\1\25"+
    "\2\0\11\25\3\0\1\220\4\25\1\326\1\25\1\0"+
    "\7\25\17\0\10\25\4\0\1\216\7\0\1\25\2\0"+
    "\4\25\1\327\4\25\3\0\1\220\6\25\1\0\7\25"+
    "\17\0\10\25\4\0\1\216\7\0\1\25\2\0\11\25"+
    "\3\0\1\220\6\25\1\0\4\25\1\330\2\25\17\0"+
    "\10\25\4\0\1\216\7\0\1\25\2\0\3\25\1\331"+
    "\5\25\3\0\1\220\6\25\1\0\7\25\17\0\10\260"+
    "\14\0\1\260\2\0\11\260\3\0\1\332\6\260\1\0"+
    "\7\260\17\0\10\262\14\0\1\262\2\0\11\262\3\0"+
    "\1\333\6\262\1\0\7\262\62\0\1\334\30\0\2\114"+
    "\1\115\63\114\1\335\12\114\5\0\1\336\1\0\1\302"+
    "\52\0\1\336\66\0\1\337\35\0\1\274\1\127\1\274"+
    "\5\127\4\0\1\216\7\0\1\127\2\0\11\127\2\0"+
    "\1\340\1\273\6\127\1\0\2\127\1\274\4\127\17\0"+
    "\1\275\1\160\1\275\5\160\4\0\1\216\7\0\1\160"+
    "\2\0\11\160\2\0\1\340\1\220\6\160\1\0\2\160"+
    "\1\275\4\160\17\0\1\341\1\0\1\302\52\0\1\341"+
    "\66\0\1\342\35\0\1\300\1\166\1\300\5\166\4\0"+
    "\1\216\7\0\1\166\2\0\11\166\2\0\1\343\1\277"+
    "\6\166\1\0\2\166\1\300\4\166\17\0\10\344\14\0"+
    "\1\344\2\0\11\344\4\0\6\344\1\0\7\344\17\0"+
    "\4\25\1\345\3\25\4\0\1\216\7\0\1\25\2\0"+
    "\11\25\3\0\1\220\6\25\1\0\7\25\17\0\6\25"+
    "\1\346\1\25\4\0\1\216\7\0\1\25\2\0\11\25"+
    "\3\0\1\220\6\25\1\0\7\25\62\0\1\347\72\0"+
    "\1\350\10\0\1\351\100\0\1\351\64\0\1\312\115\0"+
    "\1\351\63\0\1\352\113\0\1\353\64\0\1\354\104\0"+
    "\1\355\106\0\1\356\35\0\10\321\14\0\1\321\2\0"+
    "\11\321\4\0\6\321\1\0\7\321\12\0\1\357\2\0"+
    "\13\357\2\0\37\357\2\0\20\357\1\360\2\0\13\360"+
    "\2\0\37\360\2\0\20\360\1\361\2\0\13\361\2\0"+
    "\37\361\2\0\20\361\5\0\10\25\4\0\1\216\7\0"+
    "\1\25\2\0\11\25\3\0\1\220\6\25\1\0\5\25"+
    "\1\362\1\25\17\0\10\25\4\0\1\216\7\0\1\25"+
    "\2\0\11\25\3\0\1\220\5\25\1\363\1\0\7\25"+
    "\17\0\10\25\4\0\1\216\7\0\1\25\2\0\11\25"+
    "\3\0\1\220\6\25\1\0\6\25\1\364\62\0\1\365"+
    "\100\0\1\366\35\0\10\103\14\0\1\103\2\0\11\103"+
    "\4\0\6\103\1\0\7\103\12\0\2\114\1\115\32\114"+
    "\1\367\43\114\5\0\1\336\1\0\1\336\37\0\1\340"+
    "\12\0\1\336\23\0\10\127\14\0\1\127\2\0\11\127"+
    "\4\0\6\127\1\0\7\127\17\0\1\336\54\0\1\336"+
    "\23\0\1\341\1\0\1\341\37\0\1\343\12\0\1\341"+
    "\23\0\10\166\14\0\1\166\2\0\11\166\4\0\6\166"+
    "\1\0\7\166\17\0\1\341\54\0\1\341\23\0\10\344"+
    "\4\0\1\216\7\0\1\344\2\0\11\344\3\0\1\220"+
    "\6\344\1\0\7\344\17\0\5\25\1\370\2\25\4\0"+
    "\1\216\7\0\1\25\2\0\11\25\3\0\1\220\6\25"+
    "\1\0\7\25\17\0\7\25\1\371\4\0\1\216\7\0"+
    "\1\25\2\0\11\25\3\0\1\220\6\25\1\0\7\25"+
    "\17\0\10\372\14\0\1\372\2\0\11\372\4\0\6\372"+
    "\1\0\7\372\63\0\1\373\27\0\2\351\1\374\76\351"+
    "\43\0\1\351\110\0\1\375\103\0\1\376\107\0\1\351"+
    "\20\0\10\377\14\0\1\377\2\0\11\377\4\0\6\377"+
    "\1\0\7\377\12\0\1\357\2\0\12\357\1\u0100\2\0"+
    "\37\357\2\0\20\357\1\360\2\0\13\360\1\u0101\1\0"+
    "\37\360\2\0\20\360\1\361\2\0\13\361\1\0\1\u0101"+
    "\37\361\2\0\20\361\5\0\10\25\4\0\1\216\7\0"+
    "\1\25\2\0\11\25\3\0\1\220\1\25\1\u0102\4\25"+
    "\1\0\7\25\17\0\10\25\4\0\1\216\7\0\1\25"+
    "\2\0\5\25\1\u0103\3\25\3\0\1\220\6\25\1\0"+
    "\7\25\17\0\10\25\4\0\1\216\7\0\1\25\2\0"+
    "\11\25\3\0\1\220\5\25\1\u0104\1\0\7\25\17\0"+
    "\10\u0105\14\0\1\u0105\2\0\11\u0105\4\0\6\u0105\1\0"+
    "\7\u0105\17\0\10\u0106\14\0\1\u0106\2\0\11\u0106\4\0"+
    "\6\u0106\1\0\7\u0106\12\0\2\367\1\u0107\76\367\5\0"+
    "\2\25\1\u0108\5\25\4\0\1\216\7\0\1\25\2\0"+
    "\11\25\3\0\1\220\6\25\1\0\7\25\17\0\6\25"+
    "\1\370\1\25\4\0\1\216\7\0\1\25\2\0\11\25"+
    "\3\0\1\220\6\25\1\0\7\25\65\0\1\u0109\107\0"+
    "\1\351\57\0\1\351\44\0\10\25\4\0\1\216\7\0"+
    "\1\25\2\0\2\25\1\u010a\6\25\3\0\1\220\6\25"+
    "\1\0\7\25\17\0\10\25\4\0\1\216\7\0\1\25"+
    "\2\0\3\25\1\253\5\25\3\0\1\220\6\25\1\0"+
    "\7\25\17\0\10\25\4\0\1\216\7\0\1\25\2\0"+
    "\11\25\3\0\1\220\3\25\1\u010b\2\25\1\0\7\25"+
    "\17\0\2\25\1\u010c\5\25\4\0\1\216\7\0\1\25"+
    "\2\0\11\25\3\0\1\220\6\25\1\0\7\25\70\0"+
    "\1\u010d\27\0\10\25\4\0\1\216\7\0\1\25\2\0"+
    "\3\25\1\u010e\5\25\3\0\1\220\6\25\1\0\7\25"+
    "\17\0\10\25\4\0\1\216\7\0\1\25\2\0\3\25"+
    "\1\u010f\5\25\3\0\1\220\6\25\1\0\7\25\53\0"+
    "\1\u0110\75\0\1\351\42\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[11700];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\5\1\1\0\2\1\5\0\1\11\1\1\1\11"+
    "\1\1\1\11\13\1\1\11\30\1\10\11\1\1\1\11"+
    "\2\1\1\11\3\1\2\11\1\1\1\11\1\1\1\11"+
    "\5\1\2\11\36\1\1\11\32\1\3\0\1\1\1\0"+
    "\1\11\2\0\1\1\1\11\1\1\10\0\1\1\1\0"+
    "\7\1\1\11\6\1\1\0\1\1\1\0\1\11\3\0"+
    "\2\1\2\0\2\1\2\0\1\1\1\11\4\1\13\0"+
    "\1\1\3\0\5\1\3\0\3\1\1\0\2\1\2\0"+
    "\2\1\2\0\1\1\10\0\3\1\2\0\3\1\2\0"+
    "\1\11\3\0\1\1\1\11\3\1\2\0\1\11\1\1"+
    "\1\0\3\1\1\0\2\1\1\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[272];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
    public void setTokenStart(int position){zzCurrentPos = zzStartRead = position;}
    public int getNextTokenStart(){ return zzMarkedPos;}
    public boolean isLastToken(){ return zzMarkedPos == zzEndRead; }

    public void yybegin_YYINITIAL(){yybegin(YYINITIAL);}
    public void yybegin_LEX_MULTILINE(){yybegin(LEX_MULTILINE);}
    public void yybegin_LEX_MULTILINE_TOKEN(){yybegin(LEX_MULTILINE_TOKEN);}
    public void yybegin_LEX_MULTILINE_WAITING(){yybegin(LEX_MULTILINE_WAITING);}
    public void yybegin_LEX_EOF(){yybegin(LEX_EOF);}
    public void yybegin_LEX_POD(){yybegin(LEX_POD);}

    public boolean yystate_LEX_MULTILINE_WAITING(){return yystate() == LEX_MULTILINE_WAITING;}



  public PerlLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public PerlLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 162) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 55: 
          { yybegin(LEX_REQUIRE); return PerlFunctionUtil.getFunctionType(yytext().toString());
          }
        case 56: break;
        case 45: 
          { return PERL_ARRAY;
          }
        case 57: break;
        case 5: 
          { yybegin(YYINITIAL);return PERL_MULTILINE_MARKER;
          }
        case 58: break;
        case 51: 
          { processPodOpener();break;
          }
        case 59: break;
        case 9: 
          { return PERL_NUMBER;
          }
        case 60: break;
        case 38: 
          { yybegin(YYINITIAL);return PERL_FUNCTION;
          }
        case 61: break;
        case 36: 
          { yybegin(YYINITIAL);
        return PERL_VERSION;
          }
        case 62: break;
        case 34: 
          { yybegin(LEX_PACKAGE_USE_PARAMS);
        return PERL_STRING;
          }
        case 63: break;
        case 53: 
          { processDataOpener(); break;
          }
        case 64: break;
        case 11: 
          { return PERL_OPERATOR;
          }
        case 65: break;
        case 1: 
          { return TokenType.WHITE_SPACE;
          }
        case 66: break;
        case 41: 
          { return PERL_HASH;
          }
        case 67: break;
        case 16: 
          { return PERL_COMMA;
          }
        case 68: break;
        case 31: 
          { yybegin(LEX_PACKAGE_USE_PARAMS);
        return PERL_VERSION;
          }
        case 69: break;
        case 49: 
          { yybegin(LEX_FUNCTION_DEFINITION); return PerlFunctionUtil.getFunctionType(yytext().toString());
          }
        case 70: break;
        case 3: 
          { if( isLastToken() )
        {
            endPodBlock();
        }
        break;
          }
        case 71: break;
        case 26: 
          { yybegin(LEX_PACKAGE_DEFINITION_BLOCK); return PERL_VERSION;
          }
        case 72: break;
        case 24: 
          { yybegin(LEX_PACKAGE_DEFINITION_VERSION); return PERL_PACKAGE;
          }
        case 73: break;
        case 54: 
          { yybegin(LEX_PACKAGE_DEFINITION); return PerlFunctionUtil.getFunctionType(yytext().toString());
          }
        case 74: break;
        case 47: 
          { yypushback(2);
    return PerlPackageUtil.getPackageType(yytext().toString());
          }
        case 75: break;
        case 8: 
          { return processSemicolon();
          }
        case 76: break;
        case 29: 
          { if( isLastToken() )
        {
            return endMultiline();
        }
        break;
          }
        case 77: break;
        case 40: 
          { return PERL_GLOB;
          }
        case 78: break;
        case 2: 
          { if( isLastToken() )
            return endDataBlock();
        break;
          }
        case 79: break;
        case 43: 
          { return PERL_DEPACKAGE;
          }
        case 80: break;
        case 35: 
          { yypushback(1);yybegin(YYINITIAL);break;
          }
        case 81: break;
        case 15: 
          { return PERL_COMMENT;
          }
        case 82: break;
        case 32: 
          { yybegin(LEX_PACKAGE_USE_VERSION);
        return PerlPackageUtil.getPackageType(yytext().toString());
          }
        case 83: break;
        case 48: 
          { return processMultilineOpener();
          }
        case 84: break;
        case 37: 
          { yybegin(YYINITIAL);
        return PerlPackageUtil.getPackageType(yytext().toString());
          }
        case 85: break;
        case 7: 
          { return processNewLine();
          }
        case 86: break;
        case 27: 
          { yybegin(YYINITIAL); return PERL_LBRACE;
          }
        case 87: break;
        case 33: 
          { return PERL_STRING;
          }
        case 88: break;
        case 21: 
          { return PERL_LPAREN;
          }
        case 89: break;
        case 12: 
          { return PERL_SIGIL_HASH;
          }
        case 90: break;
        case 10: 
          { return PERL_FUNCTION;
          }
        case 91: break;
        case 6: 
          { return TokenType.BAD_CHARACTER;
          }
        case 92: break;
        case 44: 
          { return PERL_SCALAR;
          }
        case 93: break;
        case 23: 
          { yybegin(YYINITIAL);  return TokenType.BAD_CHARACTER;
          }
        case 94: break;
        case 22: 
          { return PERL_RPAREN;
          }
        case 95: break;
        case 39: 
          { yybegin(LEX_DEREFERENCE);return PERL_DEREFERENCE;
          }
        case 96: break;
        case 13: 
          { return PERL_SIGIL_SCALAR;
          }
        case 97: break;
        case 14: 
          { return PERL_SIGIL_ARRAY;
          }
        case 98: break;
        case 30: 
          { yypushback(1); yybegin(YYINITIAL); break;
          }
        case 99: break;
        case 4: 
          { if( isMultilineEnd() || isLastToken())
        {
            return endMultiline();
        }
        break;
          }
        case 100: break;
        case 42: 
          { yybegin(LEX_PACKAGE_USE); return PerlFunctionUtil.getFunctionType(yytext().toString());
          }
        case 101: break;
        case 25: 
          { yybegin(YYINITIAL);
        return TokenType.BAD_CHARACTER;
          }
        case 102: break;
        case 50: 
          { yybegin(LEX_PACKAGE_USE);return PerlFunctionUtil.getFunctionType(yytext().toString());
          }
        case 103: break;
        case 46: 
          { yypushback(2);
    return PERL_PACKAGE;
          }
        case 104: break;
        case 17: 
          { return PERL_LBRACE;
          }
        case 105: break;
        case 18: 
          { return PERL_RBRACE;
          }
        case 106: break;
        case 52: 
          { return endPodBlock();
          }
        case 107: break;
        case 28: 
          { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER;
          }
        case 108: break;
        case 20: 
          { return PERL_RBRACK;
          }
        case 109: break;
        case 19: 
          { return PERL_LBRACK;
          }
        case 110: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
