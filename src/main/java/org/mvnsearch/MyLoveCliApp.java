package org.mvnsearch;

import picocli.CommandLine;

import java.util.concurrent.Callable;

public class MyLoveCliApp {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new FileJoinCli()).execute(args);
        System.exit(exitCode);
    }

}
