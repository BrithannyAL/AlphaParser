import checker.TypeChecker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.PrettyPrintVisitor;
import parser.generated.AlphaParser;
import parser.generated.AlphaScanner;
import parser.MyErrorListener;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AlphaParser parser = null;
        AlphaScanner inst = null;

        ParseTree tree = null;

        CharStream input=null;
        CommonTokenStream tokens = null;

        try {
            // Se lee el archivo de texto "test.txt"
            input = CharStreams.fromFileName("test.txt");

            inst = new AlphaScanner(input);
            tokens = new CommonTokenStream(inst);
            parser = new AlphaParser(tokens);

            // Se crea un listener personalizado para manejar errores
            MyErrorListener myErrorListener = new MyErrorListener();

            //Quitar la del parser
            parser.removeErrorListeners();
            parser.addErrorListener(myErrorListener);

            // Configuración del manejo de errores
            inst.removeErrorListeners();
            inst.addErrorListener(myErrorListener);
            try {
                tree = parser.program();

                if (!myErrorListener.hasErrors()) {
                    System.out.println("Compilación exitosa!!\n");

                    //PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
                    //prettyPrintVisitor.visit(tree);

                    TypeChecker typeChecker = new TypeChecker();
                    typeChecker.visit(tree);
                } else {
                    System.out.println("Compilación Fallida!!\n" + myErrorListener);
                }

                parser.program();
                System.out.println("\nCompilación Terminada!!\n");
                //java.util.concurrent.Future<JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree, parser);
                //treeGUI.get().setVisible(true);
            }
            catch(RecognitionException e){
                System.out.println("Error!!!");
                e.printStackTrace();
            }
        }
        catch(Exception e){System.out.println("No hay archivo");e.printStackTrace();}
    }
}
