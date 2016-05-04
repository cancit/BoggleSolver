package com.company;

import java.io.*;

/**
 * Created by Can on 9.02.2016.
 */

public class Main {
    static Trie trie=new Trie();
    static char[][] a =  {
            { 'D', 'O', 'T', 'Y' },
            { 'T', 'R', 'S', 'F' },
            { 'M', 'X', 'M', 'O' },
            { 'Z', 'A', 'B', 'W' }
    };
    public static void main(String[] args) {
	// write your code here
        readDict("dictionary-yawl.txt");
        //LEFT-RIGHT
        for (int i=0;i<a.length;i++){
            for (int j=1;j<a[i].length;j++){//j starts from 1 because no word with 1 letter
                String left2Right="";//Keep the word
                String right2Left="";//Also find the backword of the word

                for(int k=0;k<=j;k++){
                    left2Right+=a[i][k];
                    right2Left=a[i][k]+right2Left;
                }
          //      System.out.println(w1);
            //    System.out.println(w2);
                trie.getWord(left2Right);//getWord method handles substrings if you enter Dotq and Dot is a word and Do is a word
                trie.getWord(right2Left);
            }
        }
        //UP-DOWN
        for (int i=0;i<a.length-1;i++){
            for (int j=0;j<a[i].length;j++){
                String up2Down="";
                String down2Up="";
                for(int k=i;k<a.length;k++){//-1 because no word with 1 letter
                    up2Down+=a[k][j];
                    down2Up=a[k][j]+down2Up;
                }
                // System.out.println(w1);
                // System.out.println(w2);
                trie.getWord(up2Down);
                trie.getWord(down2Up);
            }
        }
        //DOWNRIGHT(Also finds UPLEFT)
        for (int i=0;i<a.length-1;i++){
            for (int j=0;j<a[i].length-1;j++){
                String up2Down="";
                String down2Up="";
                for(int k=i,l=j;k<a.length && l<a[i].length;k++,l++){//-1 because no word with 1 letter
                    up2Down+=a[k][l];
                    down2Up=a[k][l]+down2Up;
                }
              //   System.out.println(up2Down);
               //  System.out.println(down2Up);
                trie.getWord(up2Down);
                trie.getWord(down2Up);
            }
        }
        //DOWNLEFT(Also finds UPRIGHT)
        for (int i=0;i<a.length-1;i++){//-1 because last row can't have this
            for (int j=1;j<a[i].length;j++){//starts from 1 because first column can't have this
                String up2Down="";
                String down2Up="";
                for(int k=i,l=j;k<a.length && l>=0;k++,l--){
                    up2Down+=a[k][l];
                    down2Up=a[k][l]+down2Up;
                }
             //   System.out.println(up2Down);
              //  System.out.println(down2Up);
                 trie.getWord(up2Down);
                trie.getWord(down2Up);
            }
        }
    }
    public static void readDict(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            long start = System.currentTimeMillis();
            int i=0;

            while ((sCurrentLine = br.readLine()) != null) {
                trie.addWord(sCurrentLine);
                i++;
            }

            // writer.close();
            long end = System.currentTimeMillis();
            System.out.println((end - start) / 1000f + " seconds");
            System.out.println(i + " records read");

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
