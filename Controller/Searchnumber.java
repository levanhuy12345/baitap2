/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.Algorithm;
import Common.Library;
import Model.Element;
import View.Menu;

/**
 *
 * @author PC
 */
public class Searchnumber extends Menu<String> {

    static String[] mc = {"Search","Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public Searchnumber(Element element) {
        super("PROGRAMMING", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                search();
                break;
            case 2:
                System.exit(0);
        }
    }

   public void search() {
    final String[] mcSearch = {"Linear Search", "Binary Search", "Exit"};
    class SearchMenu extends Menu<String> {
        public SearchMenu() {
            super("Search Option", mcSearch);
        }

        @Override
        public synchronized void execute(int n) {
            algorithm.buddleSort(array);  // Typo: Should be "bubbleSort" instead of "buddleSort"
            library.display(array);
            int value = library.getInt("\nEnter number to find: ", 1, 1000);
            switch (n) {
                case 1:
                    System.out.println("Found value: " + value + " at index: " + algorithm.linearSearch(array, value));  
                    break;
                case 2:
                    System.out.println("Found value: " + value + " at index: " + algorithm.binarySearch(array, value));
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
    SearchMenu sm = new SearchMenu();
    sm.run();
}   
}