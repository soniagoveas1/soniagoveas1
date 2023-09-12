import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.Comparator;

public class Generate {
    static final int max = 256;
    ArrayList<Node> nodeList = new ArrayList<Node>();
    static ArrayList<Node> nodeListCOPY = new ArrayList<Node>();
    public static class Node implements Comparator<Node> {
        char charInput;
        int count;
		//compressed symbol
        String compSym; 
        Node left;
        Node right;
		//prints the "tree"
        public String toString() {
            return "Node -> [char: " + charInput + ", frequency: " + count + ", symbol: " + compSym + "]\n" +
                    "Left Child -> " + left.charInput + "\n" +
                    "Right Child -> " + right.charInput + "\n";
        }
		//checks whether there are "children"
        public int compare(Node node1, Node node2) {
            return node1.count - node2.count;
        }
    }

    void charCount(String str) {
        int count[] = new int[max];
        int length = str.length();
        for(int i = 0; i < length; i++) {
            count[str.charAt(i)]++;
        }
        char ch[] = new char[str.length()];
        for(int i = 0; i < length; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for(int j = 0; j <= i; j++) {
                if(str.charAt(i) == ch[j]) {
                    find++;
                }
            }
            if(find == 1) {
                Node node = new Node();
                node.charInput = str.charAt(i);
                node.count = count[str.charAt(i)];
                node.compSym = "";
                nodeList.add(node);
            }
        }
    }

    public void assign(Node root, String compSym) {
		//exits if no children
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            root.compSym = compSym;
            return;
        }
        assign(root.left, compSym + "0");
        assign(root.right, compSym + "1");
    }

    public void encodeMap(Node root, String compSym, HashMap<Character, String> map) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            map.put(root.charInput, compSym);
            return;
        }
        encodeMap(root.left, compSym + "0", map);
        encodeMap(root.right, compSym + "1", map);
    }

    public static void main(String[] args) {
        Generate huff = new Generate();
        String fileString = "";
        try {
            File file = new File(args[0]);
            Scanner fileReader = new Scanner(file);
            fileString = fileReader.nextLine();
           	 	while (fileReader.hasNextLine()) {
                fileString += fileReader.nextLine();
            }

            huff.charCount(fileString);
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        huff.nodeList.sort(new Node());
        nodeListCOPY.addAll(huff.nodeList);

        while(huff.nodeList.size() > 1) {
            Node first = huff.nodeList.get(0);
            Node second = huff.nodeList.get(1);
            Node parent = new Node();
            parent.count = first.count + second.count;
            parent.compSym = "";
            parent.left = first;
            parent.right = second;
            huff.nodeList.remove(second);
            huff.nodeList.remove(first);
            huff.nodeList.add(parent);
            huff.nodeList.sort(new Node());
        }
        Node root = huff.nodeList.get(0);
        root.compSym = "";
        huff.assign(root, "");
		//prints list of nodes
        for(Node node : nodeListCOPY) {
            System.out.println(node);
        }

        try {
            File write = new File("codebook.txt");
            if(write.createNewFile()) {
                System.out.println("File created: " + write.getName());
            } else {
                System.out.println(write.getName() + ": " + "File already exists.");
            }
        } catch(IOException exception) {
            System.out.println("Error creating file.");
            exception.printStackTrace();
        }

        try {
			//creating file storage
            FileWriter myWriter = new FileWriter("codebook.txt");
            for(Node node : nodeListCOPY) {
                myWriter.write((int) node.charInput + ":" + node.compSym + "\n");
            }
            myWriter.close();
        } catch(IOException exception) {
            System.out.println("Error writing to file.");
            exception.printStackTrace();
        }

		//encoding
		//creating hashmap w/ encoded characters
        HashMap<Character, String> map = new HashMap<Character, String>();
        huff.encodeMap(root, "", map);
        System.out.println("Original String: " + fileString);

    	//decoding
        StringBuilder huffmanString = new StringBuilder();
        for(char c : fileString.toCharArray()) {
            huffmanString.append(map.get(c));
        }
     System.out.println("The huffman string is: " + huffmanString);
    }
}
