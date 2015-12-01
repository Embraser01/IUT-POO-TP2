import views.MainFrame;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class Main {

    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();

        mainFrame.setLocationRelativeTo(mainFrame.getParent());
        mainFrame.setVisible(true);
    }
}
