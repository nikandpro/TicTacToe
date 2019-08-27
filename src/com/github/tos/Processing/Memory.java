package com.github.tos.Processing;

import com.github.tos.Controller;

import java.util.ArrayList;
import java.util.HashMap;

public class Memory {
        public static String currentArray="";
        public static int numberMove;
        public static ArrayList<Integer> rewriting = new ArrayList();
        public static int[] rewritingZeroOrCross = new int[9];
        public static boolean win=false;
        public static HashMap arrayGame = new HashMap();


        public static void record(int numberButton) {
            numberMove++;
            rewriting.add(numberButton);
            if (Controller.firstsimbol) {
                rewritingZeroOrCross[numberButton]=1;
                Memory.currentArray=currentArray+Integer.toString(numberButton)+"0";
            } else {
                rewritingZeroOrCross[numberButton]=2;
                Memory.currentArray=currentArray+Integer.toString(numberButton)+"1";
            }
            Memory.arrayGame.put(Memory.currentArray, false);
        }





}
