package br.com.patrickalmeida;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    // Start old thread run
    Runnable run = new Runnable(){
      @Override
      public void run() {
        System.out.println("Hello World!");
      }
    };
    
    new Thread(run).start();
    // End old thread run
    
    // Start new thread implementation with lambda
    Runnable run1 = () -> System.out.println("Hello World!");
    new Thread(run1).start();
    // End new thread implementation with lambda
    
    // Start new alternative thread implementation with lambda
    new Thread(() -> System.out.println("Hello World!")).start();
    // End new alternative thread implementation with lambda

    List<String> names = Arrays.asList("Patrick", "Bill", "Foo", "Lewis");

    // Start old iteration
    for(String name: names) {
      System.out.println(name);
    }
    // End old iteration

    // Start new iteration with lambda
    names.forEach(name -> System.out.println(name));
    // End new iteration with lambda

    // Start lambda filtering
    names.stream()
      .filter(name -> name.startsWith("L"))
      .collect(Collectors.toList());
    // End lambda filtering

    // Start method reference example
    names.forEach(Person::say);
    // End method reference example

    // Start old method to implement interface
    MyInterface myInterface = new MyInterface(){
      @Override
      public void print() {
        System.out.println("Java 7 functional interface");        
      }
    };
    // End old method to implement interface

    // Start new functional interface with lambda
    MyInterface my1 = (String s) -> {
      System.out.println("Java 8 functional interface " + s);
    };

    my1.print("Teste");

    names.forEach(my1::print);
    my1.body();
    // End new functional interface with lambda
  }

}