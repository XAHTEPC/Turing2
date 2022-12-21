package com.example.turing;

public class Decoding {
    public static int[][] decoding(String x){
        char[] X = x.toCharArray();
        int[][] array=new int[11][10];
        for(int i=0;i<11;i++)
            for(int j=0;j<10;j++)
                array[i][j]=0;
        int kol=0;
        for (int i = 0; i<x.length(); i++)
        {
            if (X[i]==';'&&kol!=0)
            {
                int k1 = Character.getNumericValue(X[i-2]);
                int k;
                if(X[i-6]=='&')
                    k = 10;
                else
                    k = Character.getNumericValue(X[i-6]);
                int t;
                if(X[i-3]=='>')
                    t=1;
                else
                    if(X[i-3]=='<')
                        t=2;
                else
                    t=3;
                //if(k==10)
                  //  array[k][k1]=
                array[k][k1]=(t*10+Character.getNumericValue(X[i-4]))*10+Character.getNumericValue(X[i-1]);
            }
            else
                if(X[i]==';'&&kol==0)
                    kol++;
        }
        /*for(int i=0;i<11;i++){
            for(int j=0;j<10;j++)
                System.out.print(array[i][j]+" ");
            System.out.println("\n");
        }*/
        return array;
    }
}
