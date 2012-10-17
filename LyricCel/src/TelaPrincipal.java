
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.List;

/**
 * Tela que o usuario seleciona as musicas
 */
public class TelaPrincipal extends List {
    private Vector musicas;
    private String path;

    public TelaPrincipal() {
        super("Principal", List.IMPLICIT);

        path = "/SDCard/Music"; // Samsumg e Emulador
        //path = "/G:/Music";
        initComponents();
    }

    private void initComponents() {
        /*Enumeration e = FileSystemRegistry.listRoots();
        while ( e.hasMoreElements() ) {
            append( "Exibir músicas de: " + (String) e.nextElement(), null );
        }*/
        
        try {
            FileConnection fc = (FileConnection) Connector.open("file://" + path + "/");
            Enumeration filelist = fc.list();

            musicas = new Vector();
            while(filelist.hasMoreElements()) {
                String fileName = (String) filelist.nextElement();
                fc = (FileConnection) Connector.open("file://" + path + "/" + fileName);

                if((!fc.isDirectory()) && (fileName.endsWith(".mp3")) ) {
                    musicas.addElement( fileName );
                    append("> " + fileName, null);
                }
            }   
            fc.close();
        } catch (IOException ex) {
            System.out.println( ex.getMessage() );
            ex.printStackTrace();
        }
    }

    public String getFileNameMusica() {
        return (String) musicas.elementAt(this.getSelectedIndex());
    }
    public String getFilePath() {
        return "file://" + path + "/" + this.getFileNameMusica();
    }
    public String getPath() {
        return path;
    }
}
