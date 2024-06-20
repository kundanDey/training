public class Sem {

    int bound =0;
    int signal =0;
    public Sem(int bound){
        this.bound = bound;
    }

    public synchronized void acquire() throws  Exception{
        if (signal == bound){
            wait();
        }
        signal++;
    }

    public synchronized void release() throws  Exception{
        if(signal > 0){
            signal--;
            this.notifyAll();
        }
    }
}
