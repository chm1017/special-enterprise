package com.cm.special_enterprise.de.play;

public class client {

    static class Annoyance extends Exception {}
    static class Sneeze extends Annoyance {}

    public static int ok() throws Exception {
            try {
                try {
                    throw new Sneeze();
                }
                catch ( Annoyance a ) {
                    System.out.println("Caught Annoyance");
                    throw a;
                }
            }
            catch ( Sneeze s ) {
                System.out.println("Caught Sneeze");
                return 1;
            }
            finally {
                System.out.println("Hello World!");
                return 2;
            }



    }

    public static void main(String[] args) throws Exception {
        System.out.println(ok());

    }


//    public static void main(String[] args) {
//        dog dog = new dog("stirng", "s");
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program";
//        String s4 = "ming";
//        String s5 = "Program" + "ming";
//        String s6 = s3 + s4;
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s5);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s6.intern());
//        System.out.println(s2 == s2.intern());
//    }


}
