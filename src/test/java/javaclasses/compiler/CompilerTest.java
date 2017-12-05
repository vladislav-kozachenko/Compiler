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
        CompilationOutput output = compiler.compile("print(5);");
        compiler.execute(output);
        Assert.assertEquals("5.0\r\n", outContent.toString());
    }

    @Test
    public void testPrintMaxFunction() throws Exception {
        CompilationOutput output = compiler.compile("print(max(5, 1));");
        compiler.execute(output);
        Assert.assertEquals("5.0\r\n", outContent.toString());
    }

    @Test
    public void testPrintMinFunction() throws Exception {
        CompilationOutput output = compiler.compile("print(min(5, 1));");
        compiler.execute(output);
        Assert.assertEquals("1.0\r\n", outContent.toString());
    }

    @Test
    public void testPrintSumFunction() throws Exception {
        CompilationOutput output = compiler.compile("print(sum(5, 1));");
        compiler.execute(output);
        Assert.assertEquals("6.0\r\n", outContent.toString());
    }

    @Test
    public void testPrintAverageFunction() throws Exception {
        CompilationOutput output = compiler.compile("print(avg(5, 1, 3));");
        compiler.execute(output);
        Assert.assertEquals("3.0\r\n", outContent.toString());
    }

    @Test
    public void testPrintLog10Function() throws Exception {
        CompilationOutput output = compiler.compile("print(log10(100));");
        compiler.execute(output);
        Assert.assertEquals("2.0\r\n", outContent.toString());
    }

    @Test
    public void testOperatorPlus() throws Exception {
        CompilationOutput output = compiler.compile("print(2+2);");
        compiler.execute(output);
        Assert.assertEquals("4.0\r\n", outContent.toString());
    }

    @Test
    public void testOperatorMinus() throws Exception {
        CompilationOutput output = compiler.compile("print(22-10);");
        compiler.execute(output);
        Assert.assertEquals("12.0\r\n", outContent.toString());
    }

    @Test
    public void testOperatorMultiplication() throws Exception {
        CompilationOutput output = compiler.compile("print(22.2*10);");
        compiler.execute(output);
        Assert.assertEquals("222.0\r\n", outContent.toString());
    }

    @Test
    public void testOperatorDivision() throws Exception {
        CompilationOutput output = compiler.compile("print(22/10);");
        compiler.execute(output);
        Assert.assertEquals("2.2\r\n", outContent.toString());
    }

    @Test
    public void testOperatorExponentiation() throws Exception {
        CompilationOutput output = compiler.compile("print(10^2);");
        compiler.execute(output);
        Assert.assertEquals("100.0\r\n", outContent.toString());
    }

    @Test
    public void testOperatorsOrder() throws Exception {
        CompilationOutput output = compiler.compile("print(2+2*2^2);");
        compiler.execute(output);
        Assert.assertEquals("10.0\r\n", outContent.toString());
    }

    @Test
    public void testBrackets() throws Exception {
        CompilationOutput output = compiler.compile("print((2+2)*2);");
        compiler.execute(output);
        Assert.assertEquals("8.0\r\n", outContent.toString());
    }

}
