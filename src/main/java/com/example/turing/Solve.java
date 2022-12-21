package com.example.turing;


import java.io.FileNotFoundException;
import java.io.IOException;

public class Solve {
    String input;
    String task;
    String output="";
    int[][] cond;
    public Solve(String str, String task) throws IOException {
        this.input = str;
        this.task = task;
        cond = Decoding.decoding(task);
        //System.out.println(cond);
        /*for(int i =0;i<10;i++)
        {
            for(int j=0;j<10;j++)
                System.out.println(i+" "+j+" "+cond[i][j]);
        }*/

    }
    public void start(){
        int state=0;
        char[] str = input.toCharArray();
        char[] out = str;
        int start_pos=0;
        output=input;
        boolean fl=false;
        char[] pos = task.toCharArray();
        for(int num=0; num<task.length(); num++)
        {
            if (pos[num]==';')
            {
                //System.out.println("num"+num);
                for(int j=0; j<num; j++){
                    if(pos[0]=='-' &&j==0)
                        fl=true;
                    else{
                        start_pos=start_pos*10 +Character.getNumericValue(pos[j]);
                        //System.out.println(pos[j]);
                    }

                    //System.out.println(start_pos);
                }
                if (fl)
                    start_pos*=(-1);
                break;
            }
        }
        //System.out.println(start_pos);
        if(start_pos<0){
            String add="";
            start_pos=Math.abs(start_pos);
            for(int i=0; i<start_pos;i++)
                add+="&";
            input=add+input;
            start_pos=0;
            str = input.toCharArray();
            out = str;
        }
        //System.out.println(input);
        for(int i=start_pos;i<input.length();)
        {
            int x;
            if(i<0){
                output="Ошибка в условии!";
                System.out.println("ERROR");
                return;
            }
            if(str[i]=='&')
                x=10;
            else
                x=Character.valueOf(str[i])-48;
            int code = cond[x][state];
            if(code>0){
                int code_i = code/100;
                int code_x = (code%100)/10;
                int code_state = code%10;
                out[i]= (char) (code_x+'0');
                state=code_state;
                //System.out.println(i+") " + out[i]);
                if(code_i==1)
                    i++;
                else
                    if(code_i==2)
                        i--;

                continue;

            }
            output="Ошибка в условии!";
            System.out.println("ERROR");
            return;

        }
        output=String.copyValueOf(out);
    }

    public String get_output(){
        return output;
    }


}
