public class test {
    public static void main(String[] args){
        for (int i = 0; i< args.length; ++i){   //for loop
            System.out.println(args[i]);    //System is a class native to Java. out is a class variable of System, and the object out has several methods including pringln()
        }
        for (String value : args){  //for each loop
            System.out.println(value);
        }

        Integer anInt = 9;
    }
}
