package pt.upacademy.Examples.ClassExtends;

class Feline {
    public String type = "f ";

    public Feline() {
        System.out.print("feline ");
    }
}

public class FelineCougar extends Feline {
//    public String type = "c ";
    
    public FelineCougar() {
        System.out.print("cougar ");
    }

    void go() {
        type = "c ";
        System.out.print(this.type + super.type);
    }

    public static void main(String[] args) {
        new FelineCougar().go();
    }
}