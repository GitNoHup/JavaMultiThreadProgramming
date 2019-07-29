package com.zhang.demo03;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Description pipeInputStream pipeOutputStream
 * @Date 2019-05-08 17:20
 * @Created Mr.zhang
 */
public class Demo14 {
    public static void main(String[] args) {
        MyDemo14Write myDemo14Write = new MyDemo14Write();
        MyDemo14Read myDemo14Read = new MyDemo14Read();

        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        try{
            //pipedInputStream.connect(pipedOutputStream);
            pipedOutputStream.connect(pipedInputStream);

            MyThread14Read myThread14Read = new MyThread14Read(myDemo14Read, pipedInputStream);

            myThread14Read.start();

            Thread.sleep(2000);

            MyThread14Write myThread14Write = new MyThread14Write(myDemo14Write, pipedOutputStream);
            myThread14Write.start();
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyThread14Write extends Thread{
    private MyDemo14Write myDemo14Write;
    private PipedOutputStream pipedOutputStream;

    public MyThread14Write(MyDemo14Write myDemo14Write, PipedOutputStream pipedOutputStream){
         this.myDemo14Write = myDemo14Write;
         this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        myDemo14Write.writeMethod(pipedOutputStream);
    }
}

class MyThread14Read extends Thread{
    private MyDemo14Read myDemo14Read;
    private PipedInputStream pipedInputStream;

    public MyThread14Read(MyDemo14Read myDemo14Read, PipedInputStream pipedInputStream){
        this.myDemo14Read = myDemo14Read;
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        myDemo14Read.readMethod(pipedInputStream);
    }
}

class MyDemo14Write{
    public void writeMethod(PipedOutputStream pipedOutputStream){
        try{
            System.out.println("write:");
            for(int i=0; i<300; i++){
                String outData = " "+(i+1);
                pipedOutputStream.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(pipedOutputStream != null){
                    pipedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyDemo14Read{
    public void readMethod(PipedInputStream pipedInputStream){
        try {
            System.out.println("read:");
            byte[] byteArray = new byte[20];
            int readLength = pipedInputStream.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = pipedInputStream.read(byteArray);
            }
            System.out.println();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(pipedInputStream != null){
                    pipedInputStream.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
