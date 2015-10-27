
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.io.file.FileConnection;

/**
 * Classe responsavel pelo processamento da legenda
 */
public class Legenda {
    private String mp3FileName;
    private String lrcFileName;
    private String path;

    private String textoLegenda;
    private Vector temposLegenda, letrasLegenda;

    public boolean isOk = false;

    public Legenda(String mp3Path) {
        // http://www.cs.utk.edu/~pham/ascii_table.jpg
        path = mp3Path.substring(0, mp3Path.lastIndexOf(47) + 1);
        mp3FileName = mp3Path.substring(mp3Path.lastIndexOf(47) + 1);
        lrcFileName = mp3FileName.substring(0, mp3FileName.length() - 4) + ".lrc";

        // Verificar se o arquivo com legendas existe
        openLegenda();
    }

    public void mostraLegenda() {
        isOk = true;
    }

    public void openLegenda() {
        System.out.println("Tentar abrir: " + path + lrcFileName);
        try {
            FileConnection fc = (FileConnection) Connector.open( path + lrcFileName );
            if ( !fc.exists() ) {
                try {
                    System.out.println("Baixando:" + lrcFileName);
                    String URL = "http://localhost/lyriccel-php/busca.php?x=" + urlEncode(lrcFileName);
                    //String URL = "http://www.chiquitto.com.br/tcc/busca.php?x=" + urlEncode(lrcFileName);
                    System.out.println("Abrir URL:" + URL);
                    HttpConnection conexao = (HttpConnection)Connector.open(URL);
                    InputStream is = conexao.openInputStream();

                    System.out.println( "responseCode:" + conexao.getResponseCode() );
                    if ( conexao.getResponseCode() == 200 ) {
                        StringBuffer sb = new StringBuffer();
                        int chars = 0;
                        while ((chars = is.read()) != -1){
                            sb.append((char) chars);
                        }
                        textoLegenda = sb.toString();

                        FileConnection fileConnection = (FileConnection) Connector.open(path + lrcFileName, Connector.READ_WRITE);
                        if ( fileConnection.exists() ) fileConnection.delete();

                        System.out.println("Criando:" + lrcFileName);
                        fileConnection.create();
                        OutputStream outputStream = fileConnection.openOutputStream();
                        outputStream.write(textoLegenda.getBytes());
                        outputStream.close();
                        fileConnection.close();

                        System.out.println("Ler legenda:" + lrcFileName);
                        lerLegenda();
                    }
                    else {
                        textoLegenda = "";
                    }
                }
                catch(Exception e) {
                    System.out.println("Erro para baixar a letra.");
                    e.printStackTrace();
                }
            }
            else {
                InputStream is = (InputStream) fc.openInputStream();
                StringBuffer sb = new StringBuffer();
                try {
                    int chars = 0;
                    while ((chars = is.read()) != -1){
                        sb.append((char) chars);
                    }
                    textoLegenda = sb.toString();
                    lerLegenda();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static public String urlEncode(String sUrl) {
        int i = 0;
        String urlOK = "";
        while (i < sUrl.length()) {
            if (sUrl.charAt(i) == '<') {
                urlOK = urlOK + "%3C";
            } else if (sUrl.charAt(i) == '/') {
                urlOK = urlOK + "%2F";
            } else if (sUrl.charAt(i) == '>') {
                urlOK = urlOK + "%3E";
            } else if (sUrl.charAt(i) == ' ') {
                urlOK = urlOK + "%20";
            } else if (sUrl.charAt(i) == ':') {
                urlOK = urlOK + "%3A";
            } else if (sUrl.charAt(i) == '-') {
                urlOK = urlOK + "%2D";
            } else {
                urlOK = urlOK + sUrl.charAt(i);
            }
            i++;
        }
        return urlOK;
    }

    public void lerLegenda() {
        Vector linhas = split( textoLegenda, new String("\n").charAt(0) );
        int max = linhas.size();

        temposLegenda = new Vector();
        letrasLegenda = new Vector();

        System.out.println( textoLegenda );

        //String tmp;
        for ( int i = 0; i < max; i++ ) {
            String linha = (String) linhas.elementAt(i);

            // Verificar se a linha é valida
            int comecoLinha = 0;
            if ( (linha.startsWith("[")) && (linha.substring(3, 4).equals(":")) && (linha.substring(6, 7).equals("]")) ) {
                comecoLinha = 7;
            }
            else if ( (linha.startsWith("[")) && (linha.substring(3, 4).equals(":")) && (linha.substring(9, 10).equals("]")) ) {
                comecoLinha = 10;
            }

            if ( comecoLinha > 0 ) {
                int tempoMinuto = Integer.parseInt( linha.substring(1, 3) );
                int tempoSegundo = Integer.parseInt( linha.substring(4, 6) );
                int tempo = tempoMinuto * 60 + tempoSegundo;
                String letra = linha.substring(comecoLinha).trim();

                temposLegenda.addElement( new Integer(tempo) );
                letrasLegenda.addElement( letra );
            }
        }

        System.out.println( temposLegenda );
        System.out.println( letrasLegenda );
        mostraLegenda();
    }

    public String getTexto(int tempo) {
        String linha = "";

        for(int i = 0; i < temposLegenda.size(); i++) {
            if ( ((Integer) temposLegenda.elementAt(i)).intValue() > tempo ) break;
            linha = (String) letrasLegenda.elementAt(i);
        }
        return linha;
    }

    public Vector split(String texto, char separador) {
        if ( texto == null ) return null;

        int len = texto.length();
        if ( len == 0 ) return null;

        Vector lista = new Vector();
        int i = 0;
        int start = 0;
        while ( i < len ) {
            if ( texto.charAt(i) == separador ) {
                lista.addElement( texto.substring(start, i) );
                start = ++i;
                continue;
            }
            i++;
        }
        lista.addElement( texto.substring(start, i) );

        return lista;
    }
}
