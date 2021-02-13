package br.com.patrickalmeida;

@FunctionalInterface
public interface MyInterface {
  
  void print(String s);

  default void body () {
    System.out.println("This is my functional body");
  }
  
}
