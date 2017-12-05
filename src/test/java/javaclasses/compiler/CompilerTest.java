package javaclasses.compiler;

import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.CompilerImpl;
import javaclasses.compiler.impl.command.AssignCommand;
import javaclasses.compiler.impl.command.DefineVariableCommand;
import javaclasses.compiler.impl.command.NumberCommand;
import javaclasses.compiler.impl.command.StatementStartCommand;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class CompilerTest {

    private Compiler compiler;
    private ByteArrayOutputStream outContent;

    @Before
    public void setCompiler(){
        compiler = new CompilerImpl();
    }

    @Before
    public void setOutput(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetOutput(){
        System.setOut(System.out);
    }


    @Test
    public void testVariableInitializationCompilation() throws Exception {
        CompilationOutput output = compiler.compile("a = 1;");
        List<Command> commands = output.getCommandList();
        Assert.assertTrue(commands.get(0) instanceof StatementStartCommand);
        Assert.assertTrue(commands.get(1) instanceof DefineVariableCommand);
        Assert.assertTrue(commands.get(2) instanceof AssignCommand);
        Assert.assertTrue(commands.get(3) instanceof NumberCommand);
        System.out.println(commands);
    }

    @Test
    public void testPrint() throws Exception {
        CompilationOutput output = new CompilerImpl().compile("print(5);");
        compiler.execute(output);
        Assert.assertEquals("5.0\r\n", outContent.toString());
    }
}
