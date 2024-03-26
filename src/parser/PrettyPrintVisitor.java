package parser;
import parser.generated.AlphaParserBaseVisitor;
import parser.generated.AlphaParser;

public class PrettyPrintVisitor extends AlphaParserBaseVisitor <Object> {

    private void printTabs (int cantTabs) {
        for (int i = 0; i < cantTabs; i++) {
            System.out.print("++++");
        }
    }

    private int contTabs = 0;

    @Override
    public Object visitProgramAst(AlphaParser.ProgramAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.singleCommand());
        contTabs--;

        return null;
    }

    @Override
    public Object visitCommandAst(AlphaParser.CommandAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.singleCommand(0));
        for (int i = 1; i < ctx.singleCommand().size() ; i++) {
            visit(ctx.singleCommand(i));
        }
        contTabs--;

        return null;
    }

    @Override
    public Object visitAssignSCAst(AlphaParser.AssignSCAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());
        printTabs(contTabs + 1);

        System.out.println("ID: " + ctx.ID().getSymbol().getText()); // Es un token de assign

        contTabs++;
        visit(ctx.expression());
        contTabs--;
        return null;
    }

    @Override
    public Object visitCallSCAst(AlphaParser.CallSCAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());
        printTabs(contTabs + 1);

        System.out.println("Method: " + ctx.ID().getSymbol().getText()); // Es un token de assign

        contTabs++;
        visit(ctx.expression());
        contTabs--;
        return null;
    }

    @Override
    public Object visitIfSCAst(AlphaParser.IfSCAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.expression());
        visit(ctx.singleCommand(0));
        visit(ctx.singleCommand(1));
        contTabs--;

        return null;
    }

    @Override
    public Object visitWhileSCAst(AlphaParser.WhileSCAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.expression());
        visit(ctx.singleCommand());
        contTabs--;

        return null;
    }

    @Override
    public Object visitLetSCAst(AlphaParser.LetSCAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.declaration());
        visit(ctx.singleCommand());
        contTabs--;

        return null;
    }

    //Begin - End
    @Override
    public Object visitBlockSCAst(AlphaParser.BlockSCAstContext ctx) {
        printTabs(contTabs);

        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.command());
        contTabs--;
        return null;
    }

    @Override
    public Object visitDeclarationAst(AlphaParser.DeclarationAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.singleDeclaration(0));
        for (int i = 1; i < ctx.singleDeclaration().size() ; i++) {
            visit(ctx.singleDeclaration(i));
        }
        contTabs--;

        return null;
    }

    @Override
    public Object visitConstSDAts(AlphaParser.ConstSDAtsContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        printTabs(contTabs+1);
        System.out.println("ID: " + ctx.ID().getSymbol().getText());
        contTabs++;
        visit(ctx.expression());
        contTabs--;

        return null;
    }

    @Override
    public Object visitVarSDAst(AlphaParser.VarSDAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        printTabs(contTabs+1);
        System.out.println("ID: " + ctx.ID().getSymbol().getText());
        contTabs++;
        visit(ctx.typeDenoter());
        contTabs--;

        return null;
    }

    @Override
    public Object visitTypeDenoterAst(AlphaParser.TypeDenoterAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        printTabs(contTabs+1);
        System.out.println("ID: " + ctx.ID().getSymbol().getText());

        return null;
    }

    @Override
    public Object visitExpressionAst(AlphaParser.ExpressionAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.primaryExpression(0));
        for (int i = 1; i < ctx.primaryExpression().size() ; i++) {
            visit(ctx.operator(i-1));
            visit(ctx.primaryExpression(i));
        }
        contTabs--;

        return null;
    }

    @Override
    public Object visitNumPEAst(AlphaParser.NumPEAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        printTabs(contTabs+1);
        System.out.println("ID: " + ctx.NUM().getSymbol().getText());


        return null;
    }

    @Override
    public Object visitIdPEAst(AlphaParser.IdPEAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        printTabs(contTabs+1);
        System.out.println("ID: " + ctx.ID().getSymbol().getText());


        return null;
    }

    @Override
    public Object visitGroupPEAst(AlphaParser.GroupPEAstContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        contTabs++;
        visit(ctx.expression());
        contTabs++;

        return null;
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {
        printTabs(contTabs);
        System.out.println(ctx.getClass().getSimpleName());

        if (ctx.PLUS() != null) {
            printTabs(contTabs+1);
            System.out.println("Operator: " + ctx.PLUS().getSymbol().getText());
        } else if (ctx.MINUS() != null) {
            printTabs(contTabs+1);
            System.out.println("Operator: " + ctx.MINUS().getSymbol().getText());
        } else if (ctx.ASTERISK() != null) {
            printTabs(contTabs+1);
            System.out.println("Operator: " + ctx.ASTERISK().getSymbol().getText());
        } else if (ctx.SLASH() != null) {
            printTabs(contTabs+1);
            System.out.println("Operator: " + ctx.SLASH().getSymbol().getText());
        }

        return null;
    }
}
