public class B implements  Runnable{
    int i= 0;
    String name= "";
    B(String name){
        this.name = name;
    }
    public void display(){
        while(i <100){
            System.out.println(name + " " + i);
            i++;
        }
    }

    @Override
    public void run() {
        display();
    }
}
