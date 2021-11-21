package org.mvnsearch;

import java.util.concurrent.Callable;

import org.javalite.http.Get;
import org.javalite.http.Http;
import picocli.CommandLine;
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
@Command(name = "curl-for", mixinStandardHelpOptions = true, version = "hello 1.0",
    description = "Print hello to @|fg(green) STDOUT|@")
public class ColorDemoCli implements Callable<Integer> {

    @Parameters(index = "0", description = "request url")
    private String url;
    @Option(names = "-n", description = "for each times")
    private int times = 1;

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < times; i++) {
            Get get = Http.get(url);
            System.out.println(render(get.text()));
            System.out.println("=============================================");
        }
        return 0;
    }

    private String render(String result) {
        return Ansi.AUTO.string("@|bold,blue " + result + "|@");
    }
}
