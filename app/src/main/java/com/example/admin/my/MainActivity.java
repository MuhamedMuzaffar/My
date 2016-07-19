package com.example.admin.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    int tag,turn=1,check=0;
    int[] pri=new int[10];
    String[][] board = new String[9][9];
    String[] last =new String[1200];
    String[] fin =new String[9];
    static int k=0,l=0;
    String c;
    RelativeLayout rl1,rl2,rl3,rl4,rl5,rl6,rl7,rl8,rl9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                board[i][j]="A";

        for(int i=0;i<1200;i++)
            last[i]="SS";

        for(int i=0;i<9;i++)
            fin[i]="SS";

        for(int i=0;i<10;i++)
            pri[i]=0;

        rl1=(RelativeLayout)findViewById(R.id.rl1);
        rl2=(RelativeLayout)findViewById(R.id.rl2);
        rl3=(RelativeLayout)findViewById(R.id.rl3);
        rl4=(RelativeLayout)findViewById(R.id.rl4);
        rl5=(RelativeLayout)findViewById(R.id.rl5);
        rl6=(RelativeLayout)findViewById(R.id.rl6);
        rl7=(RelativeLayout)findViewById(R.id.rl7);
        rl8=(RelativeLayout)findViewById(R.id.rl8);
        rl9=(RelativeLayout)findViewById(R.id.rl9);

    }
    public void endsmall() {

        for(int g=0;g<9;g++)
        {if(last[g].equals("SS"))
            k=g;break;}
        smallhori();
        smallveri();
        smalldia();
        last = removeDuplicates(last);
        last=delete(last);
    }

    public static String[] delete(String[] arr) {
        for(int i=0;i<8;i++)
        {if(!arr[i].equals("SS") && arr[i+1].equals("SS") && arr[i+2].equals("SS"))
            arr[i+1]=arr[i+2];
            arr[8]="SS";
        }
        return arr;
    }
    public static String[] removeDuplicates(String[] arr) {
        int end = 9;
        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i].equals(arr[j])) {
                    arr[j]="SS";
                }
            }
        }

        return arr;
    }


    public void smallhori() {

        for(int i=0;i<9;i++)
            for(int j=0;j<9;j+=3)
            {
                if(board[i][j].equals("X")&&board[i][j+1].equals("X")&&board[i][j+2].equals("X"))
                {
                    for(int y=0;y<k+1;y++)
                    {
                        if(last[y].substring(1).matches(Integer.toString(i+1)))
                            break;
                        if(!(last[y].substring(1).matches(Integer.toString(i+1))))
                        { last[k]="X"+Integer.toString(i+1); k++; break;}
                    }
                }
            }
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j+=3)
            {
                if(board[i][j].equals("O")&&board[i][j+1].equals("O")&&board[i][j+2].equals("O"))
                { for(int y=0;y<k+1;y++)
                {
                    if(last[y].substring(1).matches(Integer.toString(i+1)))
                        break;
                    if(!(last[y].substring(1).matches(Integer.toString(i+1))))
                    { last[k]="O"+Integer.toString(i+1); k++; break;}
                }}
            }

    }
    public void smallveri() {
        for(int i=0;i<9;i++)
            for(int j=0;j<3;j+=1)
            {
                if(board[i][j].equals("X")&&board[i][j+3].equals("X")&&board[i][j+6].equals("X"))
                { for(int y=0;y<k+1;y++)
                {
                    if(last[y].substring(1).matches(Integer.toString(i+1)))
                        break;
                    if(!(last[y].substring(1).matches(Integer.toString(i+1))))
                    { last[k]="X"+Integer.toString(i+1); k++; break;}
                }}
            }
        for(int i=0;i<9;i++)
            for(int j=0;j<3;j+=1)
            {
                if(board[i][j].equals("O")&&board[i][j+3].equals("O")&&board[i][j+6].equals("O"))
                { for(int y=0;y<k+1;y++)
                {
                    if(last[y].substring(1).matches(Integer.toString(i+1)))
                        break;
                    else if(!(last[y].substring(1).matches(Integer.toString(i+1))))
                    { last[k]="O"+Integer.toString(i+1); k++; break;}
                }}
            }

    }
    public void smalldia() {
        for(int i=0;i<9;i++)
            for(int j=0;j<1;j++)
            {
                if(board[i][j].equals("X")&&board[i][j+4].equals("X")&&board[i][j+8].equals("X"))
                { for(int y=0;y<k+1;y++)
                {
                    if(last[y].substring(1).matches(Integer.toString(i+1)))
                        break;
                    else if(!(last[y].substring(1).matches(Integer.toString(i+1))))
                    { last[k]="X"+Integer.toString(i+1); k++; break;}
                }}
            }
        for(int i=0;i<9;i++)
            for(int j=0;j<1;j++)
            {
                if(board[i][j].equals("O")&&board[i][j+4].equals("O")&&board[i][j+8].equals("O"))
                { for(int y=0;y<k+1;y++)
                {
                    if(last[y].substring(1).matches(Integer.toString(i+1)))
                        break;
                    else if(!(last[y].substring(1).matches(Integer.toString(i+1))))
                    { last[k]="O"+Integer.toString(i+1); k++; break;}
                }}
            }
        for(int i=0;i<9;i++)
            for(int j=2;j<3;j++)
            {
                if(board[i][j].equals("X")&&board[i][j+2].equals("X")&&board[i][j+4].equals("X"))
                { for(int y=0;y<k+1;y++)
                {
                    if(last[y].substring(1).matches(Integer.toString(i+1)))
                        break;
                    else if(!(last[y].substring(1).matches(Integer.toString(i+1))))
                    { last[k]="X"+Integer.toString(i+1); k++; break;}
                }}
            }
        for(int i=0;i<9;i++)
            for(int j=2;j<3;j++)
            {
                if(board[i][j].equals("O") && board[i][j+2].equals("O") && board[i][j+4].equals("O"))
                { for(int y=0;y<k+1;y++)
                {
                    if(last[y].substring(1).matches(Integer.toString(i+1)))
                        break;
                    else if(!(last[y].substring(1).matches(Integer.toString(i+1))))
                    { last[k]="O"+Integer.toString(i+1); k++; break;}
                } }
            }


    }
    private void disable(RelativeLayout layout, boolean enable) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            child.setEnabled(enable);
            if (child instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) child;
                for (int j = 0; j < group.getChildCount(); j++) {
                    group.getChildAt(j).setEnabled(enable);
                }
            }

        }}

    public void visi(boolean decide,float alph)
    {
        rl1.setAlpha(alph);disable(rl1,decide);
        rl2.setAlpha(alph);disable(rl2,decide);
        rl3.setAlpha(alph);disable(rl3,decide);
        rl4.setAlpha(alph);disable(rl4,decide);
        rl5.setAlpha(alph);disable(rl5,decide);
        rl6.setAlpha(alph);disable(rl6,decide);
        rl7.setAlpha(alph);disable(rl7,decide);
        rl8.setAlpha(alph);disable(rl8,decide);
        rl9.setAlpha(alph);disable(rl9,decide);
    }
    public void show(int tag)
    {   if(check==0)
        switch(tag){
            case 1:  rl1.setAlpha(1);disable(rl1,true);break;
            case 2:  rl2.setAlpha(1);disable(rl2,true);break;
            case 3:  rl3.setAlpha(1);disable(rl3,true);break;
            case 4:  rl4.setAlpha(1);disable(rl4,true);break;
            case 5:  rl5.setAlpha(1);disable(rl5,true);break;
            case 6:  rl6.setAlpha(1);disable(rl6,true);break;
            case 7:  rl7.setAlpha(1);disable(rl7,true);break;
            case 8:  rl8.setAlpha(1);disable(rl8,true);break;
            case 9:  rl9.setAlpha(1);disable(rl9,true);break;
        }}
    public void click(View view) {

        button = (Button) view;
        tag = Integer.parseInt(button.getTag().toString());
        if (button.getText().equals(""))
            if (turn == 1) {
                turn = 2;
                button.setText("X");
                store(tag, "X");
            } else if (turn == 2) {
                turn = 1;
                button.setText("O");
                store(tag, "O");

            }
        button.setClickable(false);

        endsmall();

        for (int h = 0; h < 1200; h++) {
            {
                if (!last[h].equals("SS") && !last[h].equals(fin[0]) && !last[h].equals(fin[1]) && !last[h].equals(fin[2]) && !last[h].equals(fin[3]) && !last[h].equals(fin[4]) && !last[h].equals(fin[5]) && !last[h].equals(fin[6]) && !last[h].equals(fin[7]) && !last[h].equals(fin[8])) {
                    fin[l] = last[h];
                    l++;
                }
            }
        }
        if (check == 0) {
            visi(false, (float) 0.7);
            show(tag % 10);
        }

        for (int j = 0; j < 9; j++) {
            if (fin[j].contains("1") || fin[j].contains("2") || fin[j].contains("3") || fin[j].contains("4") || fin[j].contains("5") || fin[j].contains("6") || fin[j].contains("7") || fin[j].contains("8") || fin[j].contains("9")) {
                check = Integer.parseInt(fin[j].substring(1));
                c = fin[j].substring(0, 1);

                if (check == 1 && c.equals("X")) {
                    disable(rl1, false);
                    pri[1] = 1;
                    rl1.setTag("OVERX");
                }
                if (check == 2 && c.equals("X")) {
                    disable(rl2, false);
                    pri[2] = 2;
                    rl2.setTag("OVERX");
                }
                if (check == 3 && c.equals("X")) {
                    disable(rl3, false);
                    pri[3] = 3;
                    rl3.setTag("OVERX");
                }
                if (check == 4 && c.equals("X")) {
                    disable(rl4, false);
                    pri[4] = 4;
                    rl4.setTag("OVERX");
                }
                if (check == 5 && c.equals("X")) {
                    disable(rl5, false);
                    pri[5] = 5;
                    rl5.setTag("OVERX");
                }
                if (check == 6 && c.equals("X")) {
                    disable(rl6, false);
                    pri[6] = 6;
                    rl6.setTag("OVERX");
                }
                if (check == 7 && c.equals("X")) {
                    disable(rl7, false);
                    pri[7] = 7;
                    rl7.setTag("OVERX");
                }
                if (check == 8 && c.equals("X")) {
                    disable(rl8, false);
                    pri[8] = 8;
                    rl8.setTag("OVERX");
                }
                if (check == 9 && c.equals("X")) {
                    disable(rl9, false);
                    pri[9] = 9;
                    rl9.setTag("OVERX");
                }
                if (check == 1 && c.equals("O")) {
                    disable(rl1, false);
                    pri[1] = 1;
                    rl1.setTag("OVERO");
                }
                if (check == 2 && c.equals("O")) {
                    disable(rl2, false);
                    pri[2] = 2;
                    rl2.setTag("OVERO");
                }
                if (check == 3 && c.equals("O")) {
                    disable(rl3, false);
                    pri[3] = 3;
                    rl3.setTag("OVERO");
                }
                if (check == 4 && c.equals("O")) {
                    disable(rl4, false);
                    pri[4] = 4;
                    rl4.setTag("OVERO");
                }
                if (check == 5 && c.equals("O")) {
                    disable(rl5, false);
                    pri[5] = 5;
                    rl5.setTag("OVERO");
                }
                if (check == 6 && c.equals("O")) {
                    disable(rl6, false);
                    pri[6] = 6;
                    rl6.setTag("OVERO");
                }
                if (check == 7 && c.equals("O")) {
                    disable(rl7, false);
                    pri[7] = 7;
                    rl7.setTag("OVERO");
                }
                if (check == 8 && c.equals("O")) {
                    disable(rl8, false);
                    pri[8] = 8;
                    rl8.setTag("OVERO");
                }
                if (check == 9 && c.equals("O")) {
                    disable(rl9, false);
                    pri[9] = 9;
                    rl9.setTag("OVERO");
                }
                check = 0;
            }
        }
        nocross();

        for (int t = 1; t < 10; t++) {
            if (pri[t] == tag % 10) {
                visi(true, 1);
                if (rl1.getTag().equals("OVERX") || rl1.getTag().equals("OVERO") || rl1.getTag().equals("OVER")) {
                    disable(rl1, false);
                }
                if (rl2.getTag().equals("OVERX") || rl2.getTag().equals("OVERO") || rl2.getTag().equals("OVER")) {
                    disable(rl2, false);
                }
                if (rl3.getTag().equals("OVERX") || rl3.getTag().equals("OVERO") || rl3.getTag().equals("OVER")) {
                    disable(rl3, false);
                }
                if (rl4.getTag().equals("OVERX") || rl4.getTag().equals("OVERO") || rl4.getTag().equals("OVER")) {
                    disable(rl4, false);
                }
                if (rl5.getTag().equals("OVERX") || rl5.getTag().equals("OVERO") || rl5.getTag().equals("OVER")) {
                    disable(rl5, false);
                }
                if (rl6.getTag().equals("OVERX") || rl6.getTag().equals("OVERO") || rl6.getTag().equals("OVER")) {
                    disable(rl6, false);
                }
                if (rl7.getTag().equals("OVERX") || rl7.getTag().equals("OVERO") || rl7.getTag().equals("OVER")) {
                    disable(rl7, false);
                }
                if (rl8.getTag().equals("OVERX") || rl8.getTag().equals("OVERO") || rl8.getTag().equals("OVER")) {
                    disable(rl8, false);
                }
                if (rl9.getTag().equals("OVERX") || rl9.getTag().equals("OVERO") || rl9.getTag().equals("OVER")) {
                    disable(rl9, false);
                }
            }
        }
        endgame();
    }
    public void store(int tag, String p) {
        board[(tag/10)-1][(tag%10)-1] = p;
    }

    public void  endgame()
    { //horizontal
        if(rl1.getTag().equals("OVERX") &&rl2.getTag().equals("OVERX")&&rl3.getTag().equals("OVERX"))
        {Toast.makeText(MainActivity.this, "X WINS!!!",             Toast.LENGTH_LONG).show();}
       else if(rl1.getTag().equals("OVERO") &&rl2.getTag().equals("OVERO")&&rl3.getTag().equals("OVERO"))
        {   Toast.makeText(MainActivity.this, "O WINS!!!",                  Toast.LENGTH_LONG).show();}
        else if(rl4.getTag().equals("OVERX") &&rl5.getTag().equals("OVERX")&&rl6.getTag().equals("OVERX"))
        {   Toast.makeText(MainActivity.this, "X WINS!!!",                    Toast.LENGTH_LONG).show();}
       else if(rl4.getTag().equals("OVERO") &&rl5.getTag().equals("OVERO")&&rl6.getTag().equals("OVERO"))
        {   Toast.makeText(MainActivity.this, "O WINS!!!",                    Toast.LENGTH_LONG).show();}
        else if(rl7.getTag().equals("OVERX") &&rl8.getTag().equals("OVERX")&&rl9.getTag().equals("OVERX"))
        {   Toast.makeText(MainActivity.this, "X WINS!!!",                    Toast.LENGTH_LONG).show();}
        else if(rl7.getTag().equals("OVERO") &&rl8.getTag().equals("OVERO")&&rl9.getTag().equals("OVERO"))
        {   Toast.makeText(MainActivity.this, "O WINS!!!",                    Toast.LENGTH_LONG).show();}
      else   if(rl1.getTag().equals("OVERX") &&rl4.getTag().equals("OVERX")&&rl7.getTag().equals("OVERX"))
        {   Toast.makeText(MainActivity.this, "X WINS!!!",                    Toast.LENGTH_LONG).show();}
       else if(rl1.getTag().equals("OVERO") &&rl4.getTag().equals("OVERO")&&rl7.getTag().equals("OVERO"))
        {   Toast.makeText(MainActivity.this, "O WINS!!!",                    Toast.LENGTH_LONG).show();}
       else if(rl2.getTag().equals("OVERX") &&rl5.getTag().equals("OVERX")&&rl8.getTag().equals("OVERX"))
        {   Toast.makeText(MainActivity.this, "X WINS!!!",                    Toast.LENGTH_LONG).show();}
       else if(rl2.getTag().equals("OVERO") &&rl5.getTag().equals("OVERO")&&rl8.getTag().equals("OVERO"))
        {   Toast.makeText(MainActivity.this, "O WINS!!!",                    Toast.LENGTH_LONG).show();}
        else if(rl3.getTag().equals("OVERX") &&rl6.getTag().equals("OVERX")&&rl9.getTag().equals("OVERX"))
        {   Toast.makeText(MainActivity.this, "X WINS!!!",                    Toast.LENGTH_LONG).show();}
        else if(rl3.getTag().equals("OVERO") &&rl6.getTag().equals("OVERO")&&rl9.getTag().equals("OVERO"))
        {   Toast.makeText(MainActivity.this, "O WINS!!!",                    Toast.LENGTH_LONG).show();}
        else if(rl1.getTag().equals("OVERX") &&rl5.getTag().equals("OVERX")&&rl9.getTag().equals("OVERX"))
        {   Toast.makeText(MainActivity.this, "X WINS!!!",                    Toast.LENGTH_LONG).show();}
        else if(rl1.getTag().equals("OVERO") &&rl5.getTag().equals("OVERO")&&rl9.getTag().equals("OVERO"))
        {   Toast.makeText(MainActivity.this, "O WINS!!!",                    Toast.LENGTH_LONG).show();}
        else if(rl3.getTag().equals("OVERX") &&rl5.getTag().equals("OVERX")&&rl7.getTag().equals("OVERX"))
        {   Toast.makeText(MainActivity.this, "X WINS!!!",                    Toast.LENGTH_LONG).show();}
        else if(rl3.getTag().equals("OVERO") &&rl5.getTag().equals("OVERO")&&rl7.getTag().equals("OVERO"))
        {   Toast.makeText(MainActivity.this, "O WINS!!!",                    Toast.LENGTH_LONG).show();}

    }
    public void nocross()
    {int f = 0;
      if( rl1.getTag().equals("ONE")) {
                    {    for (int index = 0; index < rl1.getChildCount(); ++index) {

                        { Button Child = (Button) rl1.getChildAt(index);
                      if (!Child.getText().equals("")){       ++f;     }}
                  if (f==9){rl1.setTag("OVER");pri[1]=1;}
                  }}f=0;}
        if( rl2.getTag().equals("TWO")) {
            {    for (int index = 0; index < rl2.getChildCount(); ++index) {
                {   Button Child = (Button) rl2.getChildAt(index);
                    if (!Child.getText().equals("")) {       f++;     }           }
                if (f==9){rl2.setTag("OVER");pri[2]=2;}
            }}f=0;}
        if( rl3.getTag().equals("THREE")) {
            {    for (int index = 0; index < rl3.getChildCount(); ++index) {
                {   Button Child = (Button) rl3.getChildAt(index);
                    if (!Child.getText().equals("")) {       f++;     }           }
                if (f==9){rl3.setTag("OVER");pri[3]=3;}
            }}f=0;}
        if( rl4.getTag().equals("FOUR")) {
            {    for (int index = 0; index < rl4.getChildCount(); ++index) {
                {   Button Child = (Button) rl4.getChildAt(index);
                    if (!Child.getText().equals("")) {       f++;     }           }
                if (f==9){rl4.setTag("OVER");pri[4]=4;}
            }}f=0;}
        if( rl5.getTag().equals("FIVE")) {
            {    for (int index = 0; index < rl5.getChildCount(); ++index) {
                {   Button Child = (Button) rl5.getChildAt(index);
                    if (!Child.getText().equals("")) {       f++;     }           }
                if (f==9){rl5.setTag("OVER");pri[5]=5;}
            }}f=0;}
        if( rl6.getTag().equals("SIX")) {
            {    for (int index = 0; index < rl6.getChildCount(); ++index) {
                {   Button Child = (Button) rl6.getChildAt(index);
                    if (!Child.getText().equals("")) {       f++;     }           }
                if (f==9){rl6.setTag("OVER");pri[6]=6;}
            }}f=0;}
        if( rl7.getTag().equals("SEVEN")) {
            {    for (int index = 0; index < rl7.getChildCount(); ++index) {
                {   Button Child = (Button) rl7.getChildAt(index);
                    if (!Child.getText().equals("")) {       f++;     }           }
                if (f==9){rl7.setTag("OVER");pri[7]=7;}
            }}f=0;}
        if( rl8.getTag().equals("EIGHT")) {
            {    for (int index = 0; index < rl8.getChildCount(); ++index) {
                {   Button Child = (Button) rl8.getChildAt(index);
                    if (!Child.getText().equals("")) {       f++;     }           }
                if (f==9){rl8.setTag("OVER");pri[8]=8;}
            }}f=0;}
        if( rl9.getTag().equals("NINE")) {
            {    for (int index = 0; index < rl9.getChildCount(); ++index) {
                {   Button Child = (Button) rl9.getChildAt(index);
                    if (!Child.getText().equals("")) {       f++;     }           }
                if (f==9){rl9.setTag("OVER");pri[9]=9;}
            }}}

    }
}
