package erp.infra.field;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * RegexText class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (30/01/2013 11:06)
 */
public class RegexText extends JTextField {

    private String regex = "";
    private Pattern pattern;
    private Matcher matcher;
    private RegexDocument regexDocument = new RegexDocument();

    public RegexText() {
    }

    public RegexText(String regex) {
        setRegex(regex);
    }

    public String getRegex() {
        return regex;
    }

    public final void setRegex(String regex) {
        this.regex = regex;
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher("");
        setDocument(regexDocument);
    }

    private class RegexDocument extends PlainDocument {

        @Override
        public void insertString(
                int offset, String str, AttributeSet attSet)
                throws BadLocationException {

            Character poss = null;
            String textoAtual = RegexText.this.getText();
            String left = (offset > 0 ? textoAtual.substring(0, offset) : "");
            String right = textoAtual.substring(offset);
            String preview = left + str; // + right;

            matcher.reset(preview);
            if (matcher.matches() || matcher.hitEnd()) {
                poss = getNextValidCharacter(preview);
                if (poss != null) {
                    str = str + poss;
                }
                super.remove(offset, right.length());
                super.insertString(offset, str, attSet);
            }

            Character poss2 = getNextValidCharacter(left);
            if (poss2 == null) {
                return;
            }
            preview = left + poss2 + str;
            // System.out.println("--> preview xxx = " + preview + " left=" + left + " poss2=" + poss2);

            matcher.reset(preview);
            if (matcher.matches() || matcher.hitEnd()) {
                poss = getNextValidCharacter(preview);
                if (poss != null) {
                    str = str + poss;
                }
                super.remove(offset, right.length());
                super.insertString(offset, poss2 + str, attSet);
            }

        }

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            String textoAtual = RegexText.this.getText();
            int l = textoAtual.length() - offs;
            super.remove(offs, l);
        }

        // Retorna o proximo caracter válido, null se tiver mais de um.
        private Character getNextValidCharacter(String texto) {
            Character c = null;
            int found = 0;
            for (int i = 0; i <= 255; i++) {
                matcher.reset(texto + (char) i);
                if (matcher.matches() || matcher.hitEnd()) {
                    found++;
                    if (found > 1) {
                        return null;
                    }
                    c = (char) i;
                }
            }
            return c;
        }
    }
    
}