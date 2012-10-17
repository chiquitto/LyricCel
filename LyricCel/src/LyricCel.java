
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.midlet.*;

/**
 * Classe principal do aplicativo
 */
public class LyricCel extends MIDlet implements CommandListener, PlayerListener {

    private Display display;

    public void startApp() {
        this.display = Display.getDisplay(this);

        initCommand();

        initTelaPrincipal();
        initTelaPlayer();

        this.display.setCurrent(telaPrincipal);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    // TELAS
    private TelaPrincipal telaPrincipal;
    public static TelaPlayer telaPlayer;

    private void initTelaPrincipal() {
        telaPrincipal = new TelaPrincipal();
        telaPrincipal.setCommandListener(this);
        telaPrincipal.addCommand(sairCommand);
        telaPrincipal.addCommand(selecionarCommand);
    }

    private void initTelaPlayer() {
        telaPlayer = new TelaPlayer();
        telaPlayer.setCommandListener(this);
        telaPlayer.addCommand(sairCommand);
        telaPlayer.addCommand(voltarCommand);
    }

    // Threads
    Thread threadMusica;
    private void initThreadMusica() {
        threadMusica = new Thread() {
            public void run() {
                System.out.println( "Tentar tocar: " + LyricCel.pathMusica );
                try {
                    /*FileConnection fconn = (FileConnection) Connector.open( LyricCel.pathMusica );
                    player = Manager.createPlayer((InputStream) fconn.openInputStream(), "audio/mpeg");*/

                    //player = Manager.createPlayer(getClass().getResourceAsStream(LyricCel.pathMusica), "audio/mpeg");
                    player = Manager.createPlayer( LyricCel.pathMusica );
                    //InputStream is = null;//getClass().getResourceAsStream( LyricCel.pathMusica );

                    player.realize();
                    vc = (VolumeControl) player.getControl("VolumeControl");
                    if (vc != null) vc.setLevel(100);
                    player.prefetch();
                    player.start();
                } catch (Exception e) {
                    System.out.println( e.getMessage() );
                    e.printStackTrace();
                } finally {
                    initThreadLegenda();
                    threadLegenda.start();
                }
            }
        };
    }

    Thread threadLegenda;
    private void initThreadLegenda() {
        threadLegenda = new Thread() {
            public void run() {
                Legenda legenda = new Legenda(telaPrincipal.getFilePath());
                if ( legenda.isOk ) {
                    while( legenda.isOk ) {
                        try {
                            telaPlayer.setLetra( (String) legenda.getTexto( (int) player.getMediaTime() / 1000000 ) );
                            System.out.println( player.getMediaTime() / 1000000 );
                            sleep(500);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                else {
                    telaPlayer.setLetra( "Letra da música não encontrada." );
                    legenda.isOk = false;
                }
            }
        };
    }

    // COMMAND
    private Command sairCommand;
    private Command tocarCommand;
    private Command selecionarCommand;
    private Command voltarCommand;

    private void initCommand() {
        sairCommand = new Command("Sair", Command.EXIT, 0);
        selecionarCommand = new Command("Selecionar", Command.SCREEN, 0);
        tocarCommand = new Command("Tocar", Command.SCREEN, 0);
        voltarCommand = new Command("Voltar", Command.BACK, 0);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == sairCommand) {
            destroyApp(true);
        }

        if (displayable == telaPrincipal) {
            if (command == selecionarCommand) {
                tocaMusica( telaPrincipal.getFilePath() );

                telaPlayer.setTitulo(telaPrincipal.getFileNameMusica());
                display.setCurrent(telaPlayer);
            }
        } else if (displayable == telaPlayer) {
            if (command == voltarCommand) {
                pararMusica();
                display.setCurrent(telaPrincipal);
            }
        }
    }

    public void playerUpdate(Player player, String event, Object eventData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Tocar musica
    public Player player;
    public VolumeControl vc;
    public static String pathMusica;
    private void tocaMusica( String pathMusica ) {
        LyricCel.pathMusica = pathMusica;

        initThreadMusica();
        threadMusica.start();
    }
    private void pararMusica() {
        try {
            player.stop();
            threadMusica.interrupt();
            threadLegenda.interrupt();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }
}
