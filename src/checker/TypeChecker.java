package checker;

import parser.generated.AlphaParser;
import parser.generated.AlphaParserBaseVisitor;

public class TypeChecker extends AlphaParserBaseVisitor{

    private TablaSimbolos tablaSimbolos;

    public TypeChecker() {
        this.tablaSimbolos = new TablaSimbolos();
    }
    @Override
    public Object visitProgramAst(AlphaParser.ProgramAstContext ctx) {
        return super.visitProgramAst(ctx);
    }

    @Override
    public Object visitCommandAst(AlphaParser.CommandAstContext ctx) {
        return super.visitCommandAst(ctx);
    }

    @Override
    public Object visitAssignSCAst(AlphaParser.AssignSCAstContext ctx) {
        return super.visitAssignSCAst(ctx);
    }

    @Override
    public Object visitCallSCAst(AlphaParser.CallSCAstContext ctx) {
        return super.visitCallSCAst(ctx);
    }

    @Override
    public Object visitIfSCAst(AlphaParser.IfSCAstContext ctx) {
        return super.visitIfSCAst(ctx);
    }

    @Override
    public Object visitWhileSCAst(AlphaParser.WhileSCAstContext ctx) {
        return super.visitWhileSCAst(ctx);
    }

    @Override
    public Object visitLetSCAst(AlphaParser.LetSCAstContext ctx) {
        this.tablaSimbolos.openScope();
        visit(ctx.declaration());
        visit(ctx.singleCommand());
        this.tablaSimbolos.closeScope();
        return null;
    }

    @Override
    public Object visitBlockSCAst(AlphaParser.BlockSCAstContext ctx) {
        return super.visitBlockSCAst(ctx);
    }

    @Override
    public Object visitDeclarationAst(AlphaParser.DeclarationAstContext ctx) {
        return super.visitDeclarationAst(ctx);
    }

    @Override
    public Object visitConstSDAts(AlphaParser.ConstSDAtsContext ctx) {
        return super.visitConstSDAts(ctx);
    }

    @Override
    public Object visitVarSDAst(AlphaParser.VarSDAstContext ctx) {
        if (this.tablaSimbolos.buscar(ctx.ID().getText()) == null) {
            int tipo = (int) visit(ctx.typeDenoter());
            this.tablaSimbolos.insertar(ctx.ID().getSymbol(), tipo);
            this.tablaSimbolos.imprimir();
        } else {
            System.out.println("Error de identificador ya declarado");
        }


        return null;
    }

    @Override
    public Object visitTypeDenoterAst(AlphaParser.TypeDenoterAstContext ctx) {
        int result = -1;
        if (ctx.ID().getText().equals("int")) {
            result = 0;
        } else if (ctx.ID().getText().equals("char")) {
            result = -1;
        }
        return result;
    }

    @Override
    public Object visitExpressionAst(AlphaParser.ExpressionAstContext ctx) {
        return super.visitExpressionAst(ctx);
    }

    @Override
    public Object visitNumPEAst(AlphaParser.NumPEAstContext ctx) {
        return super.visitNumPEAst(ctx);
    }

    @Override
    public Object visitIdPEAst(AlphaParser.IdPEAstContext ctx) {
        return super.visitIdPEAst(ctx);
    }

    @Override
    public Object visitGroupPEAst(AlphaParser.GroupPEAstContext ctx) {
        return super.visitGroupPEAst(ctx);
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {
        return super.visitOperator(ctx);
    }
}
