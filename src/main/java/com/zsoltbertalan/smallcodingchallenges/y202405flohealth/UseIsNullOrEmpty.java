package com.zsoltbertalan.smallcodingchallenges.y202405flohealth;

//How to call isNullOrEmpty from Java?
public class UseIsNullOrEmpty {

    // Java
    public static void main(String[] args) {

        //Well, that's wrong
        //StringKt.Companion.isNullOrEmpty(s)

        //Correct
        String s = "";
        IsEmptyKt.isNullOrEmpty(s);
    }
}
