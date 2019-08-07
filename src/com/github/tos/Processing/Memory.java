package com.github.tos.Processing;

import com.github.tos.Controller;

import java.util.ArrayList;

public class Memory {
        public static int numberMove;
        public static ArrayList<Integer> rewriting = new ArrayList();
        public static int[] rewritingZeroOrCross = new int[9];
        public static boolean win=false;

        public static void record(int numberButton) {
            numberMove++;
            rewriting.add(numberButton);
            if (Controller.firstsimbol) {
                rewritingZeroOrCross[numberButton]=1;
            } else rewritingZeroOrCross[numberButton]=2;
        }


}
