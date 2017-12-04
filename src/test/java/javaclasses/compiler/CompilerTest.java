package javaclasses.compiler;

import javaclasses.compiler.impl.CompilerImpl;
import javaclasses.compiler.impl.command.DefineVariableCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CompilerTest {

    @Test
    public void testVariableInitialization() throws Exception {
        List<Command> commands = new CompilerImpl().compile("a = 1+2;");
        Assert.assertTrue(commands.get(0) instanceof DefineVariableCommand);
        System.out.println(commands);
    }
}
