import java.util.concurrent.Semaphore;

public class ThreadTest {


    public static void main(String args[]){

        Resource rs= new Resource();
        Sem sm = new Sem(1);
        Thread t = new Thread(new Producer(rs,sm));
        Thread t2 = new Thread(new Producer(rs,sm));


        t.start();

        t2.start();
    }

    static class Producer implements  Runnable{

        private Resource rs;
        private Sem sm;

        Producer(Resource rs,Sem sm){
            this.rs  = rs;
            this.sm =sm;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(100);
                sm.acquire();
                for(int i=0;i< 10; i++){

                    rs.count++;
                    System.out.println(rs.count);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            finally {
                try {
                    sm.release();
                }catch(Exception e){}
            }
        }
    }

    static class Resource{

        public  int count = 1;
    }
}
