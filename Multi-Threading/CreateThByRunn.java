
class CreateThByRunn implements Runnable {
    public void run(){
        System.out.println("Thread is running...");
    }
    public static void main(String []args) {
        CreateThByRunn obj = new CreateThByRunn();
        Thread th = new Thread(obj);
        th.start();
       
        Thread t2 = new Thread(obj);
       
        int a = 10;
        int b = 20;
        for(int i=1; i<=5; i++){
            System.out.println("Main thread: " + (a + b));
            t2.start();
            System.out.println("Value of i: " + i);

        }
    }
   
}
