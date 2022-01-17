package org.mvnsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.StringUtils;
import org.javalite.http.Get;
import org.javalite.http.Http;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * Created by lihao on 2021/11/21.
 *
 * @author lihao
 * @date 2021/11/21
 */
@Command(name = "file-join", mixinStandardHelpOptions = true, version = "1.0",
    description = "@|fg(green) file join |@")
public class FileJoinCli implements Callable<Integer> {

    @Parameters(index = "0", description = "request filePath")
    private String filePath;

    @Override
    public Integer call() throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder builder = new StringBuilder();
        int number = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line.trim()).append(",");
            number++;
        }
        System.out.println("file line number is " + number);
        String ret = StringUtils.removeEnd(builder.toString(), ",");
        System.out.println(ret);

        return 0;
    }

    private String render(String result) {
        return Ansi.AUTO.string("@|bold,blue " + result + "|@");
    }
}
