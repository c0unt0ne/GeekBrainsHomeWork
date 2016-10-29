/**
* JAVA 1. Homework 07. Notepad
* @Autor Anton Avraamov
* dated October 27
*/
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Notepad{
    public static void main(String[] args) {
        FWindow frame;
        frame = new FWindow("Simple Notepad");
        frame.setVisible(true);
    }
}

/**
* Class FWindow
*/
class FWindow extends Frame implements ActionListener, WindowListener {
    TextArea ta;
    MenuBar mb;

    Menu mFile;
    MenuItem miOpen;
    MenuItem miSave;
    MenuItem miSaveAS;
    MenuItem miExit;

    String currFileName = "";
    byte buffer[];

    public FWindow(String szTitle) {
        super(szTitle);
        setSize(800, 600);

        mb = new MenuBar();
        mFile = new Menu("File");

        miOpen = new MenuItem("Open");
        mFile.add(miOpen);
        miSave = new MenuItem("Save");
        mFile.add(miSave);
        miSaveAS = new MenuItem("Save As");
        mFile.add(miSaveAS);
        mFile.add("-");
        miExit = new MenuItem("Exit");
        mFile.add(miExit);

        mb.add(mFile);

        miOpen.addActionListener(this);
        miSave.addActionListener(this);
        miSaveAS.addActionListener(this);
        miExit.addActionListener(this);
        setMenuBar(mb);
        this.addWindowListener(this);

        ta = new TextArea(10, 30);
        setLayout(new BorderLayout());
        add("Center", ta);
    }

    /**
    *   actionPerformed
    */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(miOpen)){
            openFile();
        }
        else if (e.getSource().equals(miSave)) {
            saveFile();
        }
        else if (e.getSource().equals(miSaveAS)) {
            saveAsFile();
        }
        else if (e.getSource().equals(miExit)) {
            setVisible(false);
            System.exit(0);
        }
    }

    public void windowClosing(WindowEvent e) {
        setVisible(false);
        System.exit(0);
    }

    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    /**
    * Open file
    */
    void openFile() {
        FileDialog fdlg;
        FileInputStream fis = null;

        fdlg = new FileDialog(this, "Open file", FileDialog.LOAD);
        fdlg.setVisible(true);

        currFileName = fdlg.getDirectory() + fdlg.getFile();

        if(fdlg.getDirectory() == null || fdlg.getFile() == null)
            return;

        setTitle("Simple notepad" + " - " + currFileName);
        try {
            fis = new FileInputStream(currFileName);
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (SecurityException e) {
            System.out.println(e.toString());
        }
        try {
            buffer = new byte[fis.available()];
            fis.read(buffer);
        } catch (IOException e){
            System.out.println(e.toString());
        }

        ta.selectAll();
        ta.replaceRange("", 0, ta.getSelectionEnd());

        String sStr = new String(buffer);
        StringTokenizer st;
        st = new StringTokenizer(sStr, "\r\n");

        while(st.hasMoreElements()) {
            sStr = new String((String)st.nextElement());
            ta.append(sStr + "\r\n");
        }

        try {
            fis.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    /**
    * Save file
    */
    void saveFile() {
        FileOutputStream fos = null;
        String save = ta.getText();
        buffer = save.getBytes();

        try {
            fos = new FileOutputStream(currFileName);
            fos.write(buffer);
            fos.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (SecurityException e) {
            System.out.println(e.toString());
        }
    }
    /**
    * Save As
    */
    void saveAsFile() {
        FileDialog fdlg;
        fdlg = new FileDialog(this, "Save file as", FileDialog.SAVE);
        fdlg.setVisible(true);

        currFileName = fdlg.getDirectory() + fdlg.getFile();
        setTitle("Simple Notepad" + " - " + currFileName);
        saveFile();
    }
}