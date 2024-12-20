package com.lox;

import com.lox.ast.Expr;

public class PrettyPrinter {
  public String printExpr(Expr expr) {
    return switch (expr) {
      case Expr.Unary u -> String.format("(%s %s)", u.op.lexeme, this.printExpr(u.inner));
      case Expr.Binary b -> String.format("(%s %s %s)", b.op.lexeme, this.printExpr(b.left), this.printExpr(b.right));
      case Expr.Literal l -> l.value.lexeme;
      case Expr.Grouping g -> String.format("(group %s)", this.printExpr(g.inner));
      case Expr.Variable v -> String.format("%s", v.var.lexeme);
      default -> throw new Error("Non-exhaustive check");
    };
  }
}
