//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package OpenCalculatorExample;
import java.io.IOException;

public class OpenCalculatorExample {
    static OpenCalculatorExample example = new OpenCalculatorExample();

    public OpenCalculatorExample() {
        System.out.println("Hi");

        try {
            String command = "calc";
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (InterruptedException | IOException var3) {
            var3.printStackTrace();
        }

    }
}
