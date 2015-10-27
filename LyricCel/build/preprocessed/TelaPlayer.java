
import javax.microedition.lcdui.*;

/**
 * Tela onde é exibido a letra
 */
public class TelaPlayer extends TextBox {

    public TelaPlayer() {
        super("Musica", "", 1000, TextField.ANY);
    }

    public void setTitulo(String titulo) {
        this.setTitle(titulo);
    }

    public void setLetra(String letra) {
        this.setString(letra);
    }
}