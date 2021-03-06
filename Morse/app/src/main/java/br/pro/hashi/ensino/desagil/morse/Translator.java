package br.pro.hashi.ensino.desagil.morse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Translator {
    // ESTA CLASSE NÃO PODE SER MODIFICADA!
    private class Node {
        private char value;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node() {
            this.value = ' ';
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }
        public Node(char value) {
            this.value = value;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        public char getValue() {
            return value;
        }
        public Node getParent() {
            return parent;
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }
        public Node getLeftChild() {
            return leftChild;
        }
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        public Node getRightChild() {
            return rightChild;
        }
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }


    // ESTE CONJUNTO DE ATRIBUTOS NÃO PODE SER MODIFICADO, OU
    // SEJA, NÃO É PERMITIDO ADICIONAR NEM REMOVER ATRIBUTOS!
    private Node root;
    private HashMap<Character, Node> map;


    // ESTE CONSTRUTOR DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public Translator() {
        map = new HashMap<Character, Node>();
        root =  new Node();
        //Para cada caractere dessa string(que representa a árvore morse) cria um node no hashmap
        String letters = "etianmsurwdkgohvflpjbxcyzq5432+16=/7890";
        for(int i=0;i < letters.length(); i++){
            Character character = letters.charAt(i);
            map.put(character, new Node(character));
        }



        root.setRightChild(map.get('t'));
        root.setLeftChild(map.get('e'));

        map.get('e').setParent(root);
        map.get('e').setLeftChild(map.get('i'));
        map.get('e').setRightChild(map.get('a'));

        map.get('t').setParent(root);
        map.get('t').setLeftChild(map.get('n'));
        map.get('t').setRightChild(map.get('m'));

        map.get('i').setParent(map.get('e'));
        map.get('i').setLeftChild(map.get('s'));
        map.get('i').setRightChild(map.get('u'));

        map.get('a').setParent(map.get('e'));
        map.get('a').setLeftChild(map.get('r'));
        map.get('a').setRightChild(map.get('w'));

        map.get('n').setParent(map.get('t'));
        map.get('n').setLeftChild(map.get('d'));
        map.get('n').setRightChild(map.get('k'));

        map.get('m').setParent(map.get('t'));
        map.get('m').setLeftChild(map.get('g'));
        map.get('m').setRightChild(map.get('o'));

        map.get('s').setParent(map.get('i'));
        map.get('s').setLeftChild(map.get('h'));
        map.get('s').setRightChild(map.get('v'));

        map.get('u').setParent(map.get('i'));
        map.get('u').setLeftChild(map.get('f'));
        map.get('u').setRightChild(new Node());
        map.get('u').getRightChild().setParent(map.get('u'));
        map.get('u').getRightChild().setRightChild(map.get('2'));
        map.get('u').getRightChild().setLeftChild(new Node());

        map.get('r').setParent(map.get('a'));
        map.get('r').setLeftChild(map.get('l'));
        map.get('r').setRightChild(new Node());
        map.get('r').getRightChild().setParent(map.get('r'));
        map.get('r').getRightChild().setLeftChild(new Node());
        map.get('r').getRightChild().setRightChild(new Node());

        map.get('w').setParent(map.get('a'));
        map.get('w').setLeftChild(map.get('p'));
        map.get('w').setRightChild(map.get('j'));

        map.get('d').setParent(map.get('n'));
        map.get('d').setLeftChild(map.get('b'));
        map.get('d').setRightChild(map.get('x'));

        map.get('k').setParent(map.get('n'));
        map.get('k').setLeftChild(map.get('c'));
        map.get('k').setRightChild(map.get('y'));

        map.get('g').setParent(map.get('m'));
        map.get('g').setLeftChild(map.get('z'));
        map.get('g').setRightChild(map.get('q'));

        map.get('o').setParent(map.get('m'));
        map.get('o').setLeftChild(new Node());
        map.get('o').getLeftChild().setParent(map.get('o'));
        map.get('o').getLeftChild().setLeftChild(map.get('8'));
        map.get('o').getLeftChild().setRightChild(new Node());
        map.get('o').setRightChild(new Node());
        map.get('o').getRightChild().setParent(map.get('o'));
        map.get('o').getRightChild().setLeftChild(map.get('9'));
        map.get('o').getRightChild().setRightChild(map.get('0'));

        map.get('h').setParent(map.get('s'));
        map.get('h').setLeftChild(map.get('5'));
        map.get('h').setRightChild(map.get('4'));

        map.get('v').setParent(map.get('s'));
        map.get('v').setRightChild(map.get('3'));
        map.get('v').setLeftChild(new Node());

        map.get('f').setParent(map.get('u'));
        map.get('f').setRightChild(new Node());
        map.get('f').setLeftChild(new Node());

        map.get('l').setParent(map.get('r'));
        map.get('l').setRightChild(new Node());
        map.get('l').setLeftChild(new Node());

        map.get('p').setParent(map.get('w'));
        map.get('p').setRightChild(new Node());
        map.get('p').setLeftChild(new Node());

        map.get('j').setParent(map.get('w'));
        map.get('j').setRightChild(map.get('1'));
        map.get('j').setLeftChild(new Node());

        map.get('b').setParent(map.get('d'));
        map.get('b').setLeftChild(map.get('6'));
        map.get('b').setRightChild(new Node());

        map.get('x').setParent(map.get('d'));
        map.get('x').setLeftChild(new Node());
        map.get('x').setRightChild(new Node());

        map.get('c').setParent(map.get('k'));
        map.get('c').setRightChild(new Node());
        map.get('c').setLeftChild(new Node());

        map.get('y').setParent(map.get('k'));
        map.get('y').setRightChild(new Node());
        map.get('y').setLeftChild(new Node());

        map.get('z').setParent(map.get('g'));
        map.get('z').setLeftChild(map.get('7'));
        map.get('z').setRightChild(new Node());

        map.get('q').setParent(map.get('g'));
        map.get('q').setRightChild(new Node());
        map.get('q').setLeftChild(new Node());

        map.get('0').setParent(map.get('o').getRightChild());
        map.get('1').setParent(map.get('j'));
        map.get('2').setParent(map.get('u').getRightChild());
        map.get('3').setParent(map.get('v'));
        map.get('4').setParent(map.get('h'));
        map.get('5').setParent(map.get('h'));
        map.get('6').setParent(map.get('b'));
        map.get('7').setParent(map.get('z'));
        map.get('8').setParent(map.get('o').getLeftChild());
        map.get('9').setParent(map.get('o').getRightChild());
    }

    // ESTE MÉTODO DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public char morseToChar(String code) {
        char traduzido;
        Node currentNode = root;
        for (int i = 0; i < code.length(); i++) {
            char caractere = code.charAt(i);
            if(caractere == '.') {
                currentNode = currentNode.getLeftChild();
            }
            else if(caractere == '-') {
                currentNode = currentNode.getRightChild();
            }
            else {
                currentNode = root;
                break;
            }
        }
        traduzido = currentNode.getValue();
        return traduzido;
    }


    // ESTE MÉTODO DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public String charToMorse(char c) {

        Stack<String> stack = new Stack<>();
        Node node = map.get(c);
        String string = new String();

        while (node != root){
            Node parent = node.getParent();
            if (node == parent.getLeftChild()){
                stack.push("left");
            }
            else if (node == parent.getRightChild()){
                stack.push("right");
            }
            node = parent;
        }
        while(!stack.isEmpty()){
            if (stack.peek() == "right"){
                string += "-";
                stack.pop();
            }
            else if (stack.peek() == "left"){
                string += ".";
                stack.pop();
            }
        }
        return string;
    }

    // ESTE MÉTODO DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public LinkedList<String> getCodes() {

       // LinkedList lista = new LinkedList();

       // String letters = "etianmsurwdkgohvflpjbxcyzq5432167890";
       // for(int i=0;i < letters.length(); i++){
       //     Character character = letters.charAt(i);
       //     lista.add(charToMorse(character));
       // }

        Queue<Node> queue = new LinkedList<>();
        LinkedList list = new LinkedList();

        queue.add(root);
        Node pollRoot = queue.poll();
        queue.add(pollRoot.getLeftChild());
        queue.add(pollRoot.getRightChild());

        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if (poll.getLeftChild()!= null){
                queue.add(poll.getLeftChild());
            }
            if (poll.getRightChild()!= null) {
                queue.add(poll.getRightChild());
            }

            Character c = poll.getValue();

            if(c != ' ') {
                System.out.println(charToMorse(c));
                list.add(charToMorse(c));
            }

            if (c == '0') {
                break;
            }
        }

        return list;
    }
}
