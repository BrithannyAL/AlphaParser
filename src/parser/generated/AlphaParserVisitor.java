// Generated from C:/Users/brije/Documents/Proyectos_Java/AlphaParser/AlphaParser.g4 by ANTLR 4.13.1
package parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlphaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlphaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code programAst}
	 * labeled alternative in {@link AlphaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramAst(AlphaParser.ProgramAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commandAst}
	 * labeled alternative in {@link AlphaParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandAst(AlphaParser.CommandAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignSCAst}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSCAst(AlphaParser.AssignSCAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callSCAst}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSCAst(AlphaParser.CallSCAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifSCAst}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSCAst(AlphaParser.IfSCAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileSCAst}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileSCAst(AlphaParser.WhileSCAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letSCAst}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetSCAst(AlphaParser.LetSCAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockSCAst}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSCAst(AlphaParser.BlockSCAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationAst}
	 * labeled alternative in {@link AlphaParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationAst(AlphaParser.DeclarationAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constSDAts}
	 * labeled alternative in {@link AlphaParser#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstSDAts(AlphaParser.ConstSDAtsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varSDAst}
	 * labeled alternative in {@link AlphaParser#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSDAst(AlphaParser.VarSDAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDenoterAst}
	 * labeled alternative in {@link AlphaParser#typeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDenoterAst(AlphaParser.TypeDenoterAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAst}
	 * labeled alternative in {@link AlphaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAst(AlphaParser.ExpressionAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numPEAst}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumPEAst(AlphaParser.NumPEAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idPEAst}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdPEAst(AlphaParser.IdPEAstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupPEAst}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupPEAst(AlphaParser.GroupPEAstContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlphaParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(AlphaParser.OperatorContext ctx);
}