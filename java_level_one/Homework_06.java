/**
* Created by Anton Avraamov on 23.10.2016.
*/

import java.util.Scanner;
import java.io.*;

class Homework_06{

    public static void main(String[] args){

        /**
        * Task 1
        */
        final String FDIR_NAME = "txt/";
        String[] fn = { "1.txt", "2.txt" };
        String iFile = "1p2.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int i;
        try {
            fos = new FileOutputStream(FDIR_NAME + iFile);
            for (String name : fn) {
                fis = new FileInputStream(FDIR_NAME + name);
                do {
                    i = fis.read();
                    if (i != - 1) fos.write(i);
                } while (i != -1);
                if (fis != null) fis.close();
            }
            if (fos != null) fos.close();
        } catch (IOException e) {
                System.out.println("Error: " + e.toString());
        }
        System.out.println("File: " + iFile + " created successfully.");

        /**
        * Task 2
        */
        String line;
        boolean flag;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word for search: ");
        String sWord = in.next();

        File file1 = new File(FDIR_NAME);
        String str[] = file1.list();

        for (i = 0; i < str.length; i++){
            File file2 = new File(FDIR_NAME + str[i]);
            flag = false;
            try{
                    FileReader fr = new FileReader(FDIR_NAME + str[i]);
                    BufferedReader br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        if (line.contains(sWord)) {
                            flag = true;
                            break;
                        }
                    }
                    fr.close();
                    if (flag) {
                        System.out.println(str[i]);
                    }
            } catch (IOException e) {
                System.out.println("Error: " + e.toString());
            }
        } 
    }
}