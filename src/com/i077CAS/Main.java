package com.i077CAS;

import com.i077CAS.app.Shell;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Shell shell = new Shell();
        try {
            shell.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
