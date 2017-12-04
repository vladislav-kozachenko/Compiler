package javaclasses.compiler;

import javaclasses.compiler.impl.CompilerImpl;
import javaclasses.compiler.impl.command.DefineVariableCommand;
import javaclasses.compiler.impl.command.StatementStartCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CompilerTest {

    @Test
    public void testCompile() throws Exception {
        List<Command> commands = new CompilerImpl().compile("a = 1+2;" +
                "while(1 == 5) {" +
                "a = 1 + 1;" +
                "while(1 == 2) {" +
                "c = 3;" +
                "}" +
                "}" +
                "b = 2;");
        System.out.println(commands);
    }

    @Test
    public void testVariableInitialization() throws Exception {
        List<Command> commands = new CompilerImpl().compile("a = 1+2;");
        Assert.assertTrue(commands.get(0) instanceof StatementStartCommand);
        Assert.assertTrue(commands.get(1) instanceof DefineVariableCommand);
        System.out.println(commands);
    }
}
