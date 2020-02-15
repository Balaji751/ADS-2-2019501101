import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TST;

public class BoggleSolver
{
    private TST<Integer> dict;
    private class Node {
        public boolean marked[][];
        public String string;
        public Node(String str, boolean marked[][]) {
            this.marked = new boolean[marked.length][];
            for(int i = 0; i < marked.length; i++) {
                this.marked[i] = Arrays.copyOf(marked[i], marked[i].length);
            }            
            this.string = str;            
        }
    }
    public BoggleSolver(String[] dictionary) {
        dict = new TST<>();
        int points = 0;
        int length = 0;
        for(String word : dictionary) {
            length = word.length();
            if(length >= 0 && length <= 2) {
                points = 0;
            } else if(length >= 3 && length <= 4) {
                points = 1;
            } else if(length == 5) {
                points = 2;
            } else if(length == 6) {
                points = 3;
            } else if(length == 7) {
                points = 5;
            } else {
                points = 11;
            }
            dict.put(word, points);
        }        
    } 
    public Iterable<String> getAllValidWords(BoggleBoard board){
        SET<String> validWords = new SET<>();
        for(int i = 0; i < board.rows(); i++) {
            for(int j = 0; j < board.cols(); j++) {
                boolean[][] marked = new boolean[board.rows()][board.cols()];
                marked[i][j] = true;
                String ch;
                if(board.getLetter(i, j) == 'Q') {
                    ch = "QU";
                } else ch = String.valueOf(board.getLetter(i, j));
                Node rootNode = new Node(ch,marked);                
                boggleDFS(i,j,rootNode,validWords,board);             
            }
        }
        return validWords;
    }
    
    private void boggleDFS(int i, int j, Node root, SET<String> validWords, BoggleBoard board) {
        String temp;
        Node next;
        if(i != 0) {
            if(!root.marked[i-1][j]) {
                temp = root.string;
                if(board.getLetter(i-1, j) == 'Q') {
                    temp = temp.concat("QU");
                } else temp = temp.concat(String.valueOf(board.getLetter(i-1, j)));
                if(temp.length() >= 3) {
                    if(dict.contains(temp)) validWords.add(temp);
                }
                if(dict.keysWithPrefix(temp).iterator().hasNext()) {
                    next = new Node(temp,root.marked);
                    next.marked[i][j] = true;
                    boggleDFS(i-1, j, next, validWords, board);
                }
            }
            
        }
        
        if(i != board.rows()-1) {
            if(!root.marked[i+1][j]) {
                temp = root.string;
                if(board.getLetter(i+1, j) == 'Q') {
                    temp = temp.concat("QU");
                } else temp = temp.concat(String.valueOf(board.getLetter(i+1, j)));
                if(temp.length() >= 3) {
                    if(dict.contains(temp)) validWords.add(temp);
                }
                if(dict.keysWithPrefix(temp).iterator().hasNext()) {
                    next = new Node(temp,root.marked);
                    next.marked[i][j] = true;
                    boggleDFS(i+1, j, next, validWords, board);
                }
            }
        }
        
        if(j != 0) {
            if(!root.marked[i][j-1]) {
                temp = root.string;
                if(board.getLetter(i, j-1) == 'Q') {
                    temp = temp.concat("QU");
                } else temp = temp.concat(String.valueOf(board.getLetter(i, j-1)));
                if(temp.length() >= 3) {
                    if(dict.contains(temp)) validWords.add(temp);
                }
                if(dict.keysWithPrefix(temp).iterator().hasNext()) {
                    next = new Node(temp,root.marked);
                    next.marked[i][j] = true;
                    boggleDFS(i, j-1, next, validWords, board);
                }
            }
        }
        
        if(j != board.cols()-1) {
            if(!root.marked[i][j+1]) {
                temp = root.string;
                if(board.getLetter(i, j+1) == 'Q') {
                    temp = temp.concat("QU");
                } else temp = temp.concat(String.valueOf(board.getLetter(i, j+1)));
                if(temp.length() >= 3) {
                    if(dict.contains(temp)) validWords.add(temp);
                }
                if(dict.keysWithPrefix(temp).iterator().hasNext()) {
                    next = new Node(temp,root.marked);
                    next.marked[i][j] = true;
                    boggleDFS(i, j+1, next, validWords, board);
                }
            }
        }
        
        if(i != 0 && j != 0) {
            if(!root.marked[i-1][j-1]) {
                temp = root.string;
                if(board.getLetter(i-1, j-1) == 'Q') {
                    temp = temp.concat("QU");
                } else temp = temp.concat(String.valueOf(board.getLetter(i-1, j-1)));
                if(temp.length() >= 3) {
                    if(dict.contains(temp)) validWords.add(temp);
                }
                if(dict.keysWithPrefix(temp).iterator().hasNext()) {
                    next = new Node(temp,root.marked);
                    next.marked[i][j] = true;
                    boggleDFS(i-1, j-1, next, validWords, board);
                }
            }
        }
        
        if(i != 0 && j != board.cols()-1) {
            if(!root.marked[i-1][j+1]) {
                temp = root.string;
                if(board.getLetter(i-1, j+1) == 'Q') {
                    temp = temp.concat("QU");
                } else temp = temp.concat(String.valueOf(board.getLetter(i-1, j+1)));
                if(temp.length() >= 3) {
                    if(dict.contains(temp)) validWords.add(temp);
                }
                if(dict.keysWithPrefix(temp).iterator().hasNext()) {
                    next = new Node(temp,root.marked);
                    next.marked[i][j] = true;
                    boggleDFS(i-1, j+1, next, validWords, board);
                }
            }
        }
        
        if(i != board.rows()-1 && j != 0) {
            if(!root.marked[i+1][j-1]) {
                temp = root.string;
                if(board.getLetter(i+1, j-1) == 'Q') {
                    temp = temp.concat("QU");
                } else temp = temp.concat(String.valueOf(board.getLetter(i+1, j-1)));
                if(temp.length() >= 3) {
                    if(dict.contains(temp)) validWords.add(temp);
                }
                if(dict.keysWithPrefix(temp).iterator().hasNext()) {
                    next = new Node(temp,root.marked);
                    next.marked[i][j] = true;
                    boggleDFS(i+1, j-1, next, validWords, board);
                }
            }
        }
        
        if(i != board.rows()-1 && j != board.cols()-1) {
            if(!root.marked[i+1][j+1]) {
                temp = root.string;
                if(board.getLetter(i+1, j+1) == 'Q') {
                    temp = temp.concat("QU");
                } else temp = temp.concat(String.valueOf(board.getLetter(i+1, j+1)));
                if(temp.length() >= 3) {
                    if(dict.contains(temp)) validWords.add(temp);
                }
                if(dict.keysWithPrefix(temp).iterator().hasNext()) {
                    next = new Node(temp,root.marked);
                    next.marked[i][j] = true;
                    boggleDFS(i+1, j+1, next, validWords, board);
                }
            }
        }
        return;        
    }
    public int scoreOf(String word) {
        if(dict.get(word) == null) {
            return 0;
        } else return dict.get(word);
        
    }
}