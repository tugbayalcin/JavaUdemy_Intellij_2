package JavaClasses.objectClass.cloneMethod;

class basicClone
{
    // protected Object clone() throws CloneNotSupportedException
    // protected bir methoddur
    // methodu kullanan class'in clonable interface'ini implement etmesi gerekmektedir
    // methodu kullanan methodlarin throws exception almasi gereklidir
}
// example javatpoint: clone() nasil kullanilir
class Student18 implements Cloneable{
    int rollno;
    String name;

    Student18(int rollno,String name){
        this.rollno=rollno;
        this.name=name;
    }

    public Object clone()throws CloneNotSupportedException{ // clonlama methodu
        return super.clone(); // diyor ki u class'in baba class'i Object class'ina git ve oradaki clone() methodunu calistir ve sonucu retrun et
    }

    public static void main(String args[]){
        try{
            Student18 s1=new Student18(101,"amit");

            Student18 s2=(Student18)s1.clone(); // yeni bir obje olusturdu

            Student18 s3 = s1; // referansini atadi

            System.out.println(s1.rollno+" "+s1.name);
            System.out.println(s2.rollno+" "+s2.name);

            System.out.println("s1 icin referance: " + s1); // Student18@13fee20c
            System.out.println("s2 icin referance: " + s2); // Student18@4e04a765 yeni bir obje olusturdugu icin referance farkli
            System.out.println("s3 icin referance: " + s3); // Student18@13fee20c s1 referansini paylastigi icin ayni

        }catch(CloneNotSupportedException c){}

    }
}
