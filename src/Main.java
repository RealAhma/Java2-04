import java.util.Arrays;

public abstract class Main implements Runnable{
    static final int size = 1000000;
    static final int h = size / 2;
    static float[] arr = new float[size];


    public static void method1(){
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public synchronized static void method2(){
        float [] a1 = new float[h];
        float [] a2 = new float[h];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println("Time of copy: " + (System.currentTimeMillis() - a));

        long b = System.currentTimeMillis();
        for (int i = 0; i < a1.length; i++) {
            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Time of counting values for a1: " + (System.currentTimeMillis() - b));

        long c = System.currentTimeMillis();
        for (int i = 0; i < a2.length; i++) {
            a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Time of counting values for a2: " + (System.currentTimeMillis() - c));

        long d = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Time for concatenation of arrays: " + (System.currentTimeMillis() - d));
    }


    public static void main(String[] args) {

        method1();

        Runnable r = new Runnable() {
            @Override
            public void run() { method2(); }
        };

        new Thread(r, "Thread#1").start();

        new Thread(r, "Thread#2").start();
    }


}
