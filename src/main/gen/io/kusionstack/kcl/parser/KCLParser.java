// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.kusionstack.kcl.psi.KCLTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class KCLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return kclFile(b, l + 1);
  }

  /* ********************************************************** */
  // shift_expr (AND shift_expr)*
  public static boolean and_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AND_EXPR, "<and expr>");
    r = shift_expr(b, l + 1);
    r = r && and_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AND shift_expr)*
  private static boolean and_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!and_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "and_expr_1", c)) break;
    }
    return true;
  }

  // AND shift_expr
  private static boolean and_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && shift_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // not_test (K_AND not_test)*
  public static boolean and_test(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_test")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AND_TEST, "<and test>");
    r = not_test(b, l + 1);
    r = r && and_test_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (K_AND not_test)*
  private static boolean and_test_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_test_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!and_test_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "and_test_1", c)) break;
    }
    return true;
  }

  // K_AND not_test
  private static boolean and_test_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_test_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AND);
    r = r && not_test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // single_name ASSIGN test | MULTIPLY test | DOUBLE_STAR test | test
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = argument_0(b, l + 1);
    if (!r) r = argument_1(b, l + 1);
    if (!r) r = argument_2(b, l + 1);
    if (!r) r = test(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // single_name ASSIGN test
  private static boolean argument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = single_name(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MULTIPLY test
  private static boolean argument_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MULTIPLY);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOUBLE_STAR test
  private static boolean argument_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_STAR);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // argument (COMMA argument)*
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENTS, "<arguments>");
    r = argument(b, l + 1);
    r = r && arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA argument)*
  private static boolean arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arguments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arguments_1", c)) break;
    }
    return true;
  }

  // COMMA argument
  private static boolean arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // term (( PLUS | MINUS ) term)*
  public static boolean arith_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arith_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARITH_EXPR, "<arith expr>");
    r = term(b, l + 1);
    r = r && arith_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (( PLUS | MINUS ) term)*
  private static boolean arith_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arith_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arith_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arith_expr_1", c)) break;
    }
    return true;
  }

  // ( PLUS | MINUS ) term
  private static boolean arith_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arith_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arith_expr_1_0_0(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS
  private static boolean arith_expr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arith_expr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // ASSERT test (COMMA test)?
  public static boolean assert_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_stmt")) return false;
    if (!nextTokenIs(b, ASSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSERT);
    r = r && test(b, l + 1);
    r = r && assert_stmt_2(b, l + 1);
    exit_section_(b, m, ASSERT_STMT, r);
    return r;
  }

  // (COMMA test)?
  private static boolean assert_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_stmt_2")) return false;
    assert_stmt_2_0(b, l + 1);
    return true;
  }

  // COMMA test
  private static boolean assert_stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_stmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier [COLON type] ASSIGN (identifier ASSIGN)* test
  //     | identifier (COMP_PLUS | COMP_MINUS | COMP_MULTIPLY | COMP_DOUBLE_STAR | COMP_DIVIDE
  //     | COMP_DOUBLE_DIVIDE | COMP_MOD | COMP_AND | COMP_OR | COMP_XOR | COMP_SHIFT_LEFT
  //     | COMP_SHIFT_RIGHT) test
  public static boolean assign_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_STMT, "<assign stmt>");
    r = assign_stmt_0(b, l + 1);
    if (!r) r = assign_stmt_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier [COLON type] ASSIGN (identifier ASSIGN)* test
  private static boolean assign_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_stmt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && assign_stmt_0_1(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && assign_stmt_0_3(b, l + 1);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COLON type]
  private static boolean assign_stmt_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_stmt_0_1")) return false;
    assign_stmt_0_1_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean assign_stmt_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_stmt_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (identifier ASSIGN)*
  private static boolean assign_stmt_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_stmt_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!assign_stmt_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assign_stmt_0_3", c)) break;
    }
    return true;
  }

  // identifier ASSIGN
  private static boolean assign_stmt_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_stmt_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier (COMP_PLUS | COMP_MINUS | COMP_MULTIPLY | COMP_DOUBLE_STAR | COMP_DIVIDE
  //     | COMP_DOUBLE_DIVIDE | COMP_MOD | COMP_AND | COMP_OR | COMP_XOR | COMP_SHIFT_LEFT
  //     | COMP_SHIFT_RIGHT) test
  private static boolean assign_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_stmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && assign_stmt_1_1(b, l + 1);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMP_PLUS | COMP_MINUS | COMP_MULTIPLY | COMP_DOUBLE_STAR | COMP_DIVIDE
  //     | COMP_DOUBLE_DIVIDE | COMP_MOD | COMP_AND | COMP_OR | COMP_XOR | COMP_SHIFT_LEFT
  //     | COMP_SHIFT_RIGHT
  private static boolean assign_stmt_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_stmt_1_1")) return false;
    boolean r;
    r = consumeToken(b, COMP_PLUS);
    if (!r) r = consumeToken(b, COMP_MINUS);
    if (!r) r = consumeToken(b, COMP_MULTIPLY);
    if (!r) r = consumeToken(b, COMP_DOUBLE_STAR);
    if (!r) r = consumeToken(b, COMP_DIVIDE);
    if (!r) r = consumeToken(b, COMP_DOUBLE_DIVIDE);
    if (!r) r = consumeToken(b, COMP_MOD);
    if (!r) r = consumeToken(b, COMP_AND);
    if (!r) r = consumeToken(b, COMP_OR);
    if (!r) r = consumeToken(b, COMP_XOR);
    if (!r) r = consumeToken(b, COMP_SHIFT_LEFT);
    if (!r) r = consumeToken(b, COMP_SHIFT_RIGHT);
    return r;
  }

  /* ********************************************************** */
  // [decorators] (FINAL)? single_name [QUESTION] COLON type [(ASSIGN|COMP_OR) test]
  public static boolean attribute_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_STMT, "<attribute stmt>");
    r = attribute_stmt_0(b, l + 1);
    r = r && attribute_stmt_1(b, l + 1);
    r = r && single_name(b, l + 1);
    r = r && attribute_stmt_3(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    r = r && attribute_stmt_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [decorators]
  private static boolean attribute_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_stmt_0")) return false;
    decorators(b, l + 1);
    return true;
  }

  // (FINAL)?
  private static boolean attribute_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_stmt_1")) return false;
    consumeToken(b, FINAL);
    return true;
  }

  // [QUESTION]
  private static boolean attribute_stmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_stmt_3")) return false;
    consumeToken(b, QUESTION);
    return true;
  }

  // [(ASSIGN|COMP_OR) test]
  private static boolean attribute_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_stmt_6")) return false;
    attribute_stmt_6_0(b, l + 1);
    return true;
  }

  // (ASSIGN|COMP_OR) test
  private static boolean attribute_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_stmt_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_stmt_6_0_0(b, l + 1);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ASSIGN|COMP_OR
  private static boolean attribute_stmt_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_stmt_6_0_0")) return false;
    boolean r;
    r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, COMP_OR);
    return r;
  }

  /* ********************************************************** */
  // STRING_TYPE | INT_TYPE | FLOAT_TYPE | BOOL_TYPE | ANY
  public static boolean basic_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASIC_TYPE, "<basic type>");
    r = consumeToken(b, STRING_TYPE);
    if (!r) r = consumeToken(b, INT_TYPE);
    if (!r) r = consumeToken(b, FLOAT_TYPE);
    if (!r) r = consumeToken(b, BOOL_TYPE);
    if (!r) r = consumeToken(b, ANY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESES [arguments [COMMA]] RIGHT_PARENTHESES
  public static boolean call_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_suffix")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESES);
    r = r && call_suffix_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESES);
    exit_section_(b, m, CALL_SUFFIX, r);
    return r;
  }

  // [arguments [COMMA]]
  private static boolean call_suffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_suffix_1")) return false;
    call_suffix_1_0(b, l + 1);
    return true;
  }

  // arguments [COMMA]
  private static boolean call_suffix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_suffix_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arguments(b, l + 1);
    r = r && call_suffix_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean call_suffix_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_suffix_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // CHECK COLON NEWLINE INDENT check_expr+ DEDENT
  public static boolean check_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "check_block")) return false;
    if (!nextTokenIs(b, CHECK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CHECK, COLON, NEWLINE, INDENT);
    r = r && check_block_4(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, CHECK_BLOCK, r);
    return r;
  }

  // check_expr+
  private static boolean check_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "check_block_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = check_expr(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!check_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "check_block_4", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // check_test [COMMA primary_expr] NEWLINE
  public static boolean check_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "check_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHECK_EXPR, "<check expr>");
    r = check_test(b, l + 1);
    r = r && check_expr_1(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COMMA primary_expr]
  private static boolean check_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "check_expr_1")) return false;
    check_expr_1_0(b, l + 1);
    return true;
  }

  // COMMA primary_expr
  private static boolean check_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "check_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && primary_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // simple_expr [IF simple_expr]
  public static boolean check_test(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "check_test")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHECK_TEST, "<check test>");
    r = simple_expr(b, l + 1);
    r = r && check_test_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [IF simple_expr]
  private static boolean check_test_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "check_test_1")) return false;
    check_test_1_0(b, l + 1);
    return true;
  }

  // IF simple_expr
  private static boolean check_test_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "check_test_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && simple_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOR loop_variables [COMMA] IN simple_expr [NEWLINE] [IF test [NEWLINE]]
  public static boolean comp_clause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_clause")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && loop_variables(b, l + 1);
    r = r && comp_clause_2(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && simple_expr(b, l + 1);
    r = r && comp_clause_5(b, l + 1);
    r = r && comp_clause_6(b, l + 1);
    exit_section_(b, m, COMP_CLAUSE, r);
    return r;
  }

  // [COMMA]
  private static boolean comp_clause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_clause_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // [NEWLINE]
  private static boolean comp_clause_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_clause_5")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // [IF test [NEWLINE]]
  private static boolean comp_clause_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_clause_6")) return false;
    comp_clause_6_0(b, l + 1);
    return true;
  }

  // IF test [NEWLINE]
  private static boolean comp_clause_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_clause_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && test(b, l + 1);
    r = r && comp_clause_6_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [NEWLINE]
  private static boolean comp_clause_6_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_clause_6_0_2")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // EQUAL_TO | NOT_EQUAL_TO | LESS_THAN | GREATER_THAN | LESS_THAN_OR_EQUAL_TO | GREATER_THAN_OR_EQUAL_TO | IN | K_NOT IN | IS | IS K_NOT | K_NOT
  static boolean comp_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_op")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL_TO);
    if (!r) r = consumeToken(b, NOT_EQUAL_TO);
    if (!r) r = consumeToken(b, LESS_THAN);
    if (!r) r = consumeToken(b, GREATER_THAN);
    if (!r) r = consumeToken(b, LESS_THAN_OR_EQUAL_TO);
    if (!r) r = consumeToken(b, GREATER_THAN_OR_EQUAL_TO);
    if (!r) r = consumeToken(b, IN);
    if (!r) r = parseTokens(b, 0, K_NOT, IN);
    if (!r) r = consumeToken(b, IS);
    if (!r) r = parseTokens(b, 0, IS, K_NOT);
    if (!r) r = consumeToken(b, K_NOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (comp_op expr)*
  public static boolean comparison(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON, "<comparison>");
    r = expr(b, l + 1);
    r = r && comparison_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (comp_op expr)*
  private static boolean comparison_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comparison_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "comparison_1", c)) break;
    }
    return true;
  }

  // comp_op expr
  private static boolean comparison_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comp_op(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // if_stmt | schema_stmt
  public static boolean compound_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPOUND_STMT, "<compound stmt>");
    r = if_stmt(b, l + 1);
    if (!r) r = schema_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // list_type | dict_type
  public static boolean compound_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_type")) return false;
    if (!nextTokenIs(b, "<compound type>", LEFT_BRACE, LEFT_BRACKETS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPOUND_TYPE, "<compound type>");
    r = list_type(b, l + 1);
    if (!r) r = dict_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // config_entry ((COMMA [NEWLINE] | [NEWLINE]) config_entry)* [COMMA] [NEWLINE]
  public static boolean config_entries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_ENTRIES, "<config entries>");
    r = config_entry(b, l + 1);
    r = r && config_entries_1(b, l + 1);
    r = r && config_entries_2(b, l + 1);
    r = r && config_entries_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((COMMA [NEWLINE] | [NEWLINE]) config_entry)*
  private static boolean config_entries_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_entries_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_entries_1", c)) break;
    }
    return true;
  }

  // (COMMA [NEWLINE] | [NEWLINE]) config_entry
  private static boolean config_entries_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_entries_1_0_0(b, l + 1);
    r = r && config_entry(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA [NEWLINE] | [NEWLINE]
  private static boolean config_entries_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_entries_1_0_0_0(b, l + 1);
    if (!r) r = config_entries_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA [NEWLINE]
  private static boolean config_entries_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && config_entries_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [NEWLINE]
  private static boolean config_entries_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries_1_0_0_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // [NEWLINE]
  private static boolean config_entries_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries_1_0_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // [COMMA]
  private static boolean config_entries_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // [NEWLINE]
  private static boolean config_entries_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entries_3")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry
  public static boolean config_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_ENTRY, "<config entry>");
    r = config_entry_0(b, l + 1);
    if (!r) r = double_star_expr(b, l + 1);
    if (!r) r = if_entry(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // test (COLON | ASSIGN | COMP_PLUS) test
  private static boolean config_entry_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entry_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = test(b, l + 1);
    r = r && config_entry_0_1(b, l + 1);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON | ASSIGN | COMP_PLUS
  private static boolean config_entry_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_entry_0_1")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, COMP_PLUS);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE [config_entries | NEWLINE INDENT config_entries DEDENT] RIGHT_BRACE
  public static boolean config_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_expr")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && config_expr_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, CONFIG_EXPR, r);
    return r;
  }

  // [config_entries | NEWLINE INDENT config_entries DEDENT]
  private static boolean config_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_expr_1")) return false;
    config_expr_1_0(b, l + 1);
    return true;
  }

  // config_entries | NEWLINE INDENT config_entries DEDENT
  private static boolean config_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_entries(b, l + 1);
    if (!r) r = config_expr_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE INDENT config_entries DEDENT
  private static boolean config_expr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_expr_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && config_entries(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TRUE | FALSE | NONE | UNDEFINED
  static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    boolean r;
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, NONE);
    if (!r) r = consumeToken(b, UNDEFINED);
    return r;
  }

  /* ********************************************************** */
  // identifier [call_suffix]
  public static boolean decorator_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECORATOR_EXPR, "<decorator expr>");
    r = identifier(b, l + 1);
    r = r && decorator_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [call_suffix]
  private static boolean decorator_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_expr_1")) return false;
    call_suffix(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (AT decorator_expr NEWLINE)+
  public static boolean decorators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorators")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = decorators_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!decorators_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "decorators", c)) break;
    }
    exit_section_(b, m, DECORATORS, r);
    return r;
  }

  // AT decorator_expr NEWLINE
  private static boolean decorators_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorators_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && decorator_expr(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE (entry comp_clause+ | NEWLINE INDENT entry comp_clause+ DEDENT) RIGHT_BRACE
  public static boolean dict_comp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_comp")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && dict_comp_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, DICT_COMP, r);
    return r;
  }

  // entry comp_clause+ | NEWLINE INDENT entry comp_clause+ DEDENT
  private static boolean dict_comp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_comp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dict_comp_1_0(b, l + 1);
    if (!r) r = dict_comp_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // entry comp_clause+
  private static boolean dict_comp_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_comp_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entry(b, l + 1);
    r = r && dict_comp_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comp_clause+
  private static boolean dict_comp_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_comp_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comp_clause(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!comp_clause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dict_comp_1_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE INDENT entry comp_clause+ DEDENT
  private static boolean dict_comp_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_comp_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && entry(b, l + 1);
    r = r && dict_comp_1_1_3(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // comp_clause+
  private static boolean dict_comp_1_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_comp_1_1_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comp_clause(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!comp_clause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dict_comp_1_1_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE (type)? COLON (type)? RIGHT_BRACE
  public static boolean dict_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_type")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && dict_type_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && dict_type_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, DICT_TYPE, r);
    return r;
  }

  // (type)?
  private static boolean dict_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_type_1")) return false;
    dict_type_1_0(b, l + 1);
    return true;
  }

  // (type)
  private static boolean dict_type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (type)?
  private static boolean dict_type_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_type_3")) return false;
    dict_type_3_0(b, l + 1);
    return true;
  }

  // (type)
  private static boolean dict_type_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_type_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (leading_dots identifier) | identifier
  public static boolean dot_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOT_NAME, "<dot name>");
    r = dot_name_0(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // leading_dots identifier
  private static boolean dot_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = leading_dots(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_STAR primary_expr
  public static boolean double_star_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "double_star_expr")) return false;
    if (!nextTokenIs(b, DOUBLE_STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_STAR);
    r = r && primary_expr(b, l + 1);
    exit_section_(b, m, DOUBLE_STAR_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // DOT DOT DOT
  static boolean ellipsis(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ellipsis")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, DOT, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT
  static boolean end_of_line_comment(PsiBuilder b, int l) {
    return consumeToken(b, COMMENT);
  }

  /* ********************************************************** */
  // test COLON test | double_star_expr | if_entry
  public static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTRY, "<entry>");
    r = entry_0(b, l + 1);
    if (!r) r = double_star_expr(b, l + 1);
    if (!r) r = if_entry(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // test COLON test
  private static boolean entry_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = test(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // if_simple_stmt | NEWLINE INDENT schema_init_stmt+ DEDENT
  public static boolean execution_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "execution_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXECUTION_BLOCK, "<execution block>");
    r = if_simple_stmt(b, l + 1);
    if (!r) r = execution_block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEWLINE INDENT schema_init_stmt+ DEDENT
  private static boolean execution_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "execution_block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && execution_block_1_2(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // schema_init_stmt+
  private static boolean execution_block_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "execution_block_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = schema_init_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!schema_init_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "execution_block_1_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // xor_expr (OR xor_expr)*
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = xor_expr(b, l + 1);
    r = r && expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OR xor_expr)*
  private static boolean expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_1", c)) break;
    }
    return true;
  }

  // OR xor_expr
  private static boolean expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && xor_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // testlist_expr
  public static boolean expr_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_STMT, "<expr stmt>");
    r = testlist_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (PLUS | MINUS | NOT) factor | power
  public static boolean factor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, FACTOR, "<factor>");
    r = factor_0(b, l + 1);
    if (!r) r = power(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PLUS | MINUS | NOT) factor
  private static boolean factor_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = factor_0_0(b, l + 1);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS | NOT
  private static boolean factor_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, NOT);
    return r;
  }

  /* ********************************************************** */
  // FOR identifier
  public static boolean for_mixin_host(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_mixin_host")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, FOR_MIXIN_HOST, r);
    return r;
  }

  /* ********************************************************** */
  // single_name (DOT single_name)*
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = single_name(b, l + 1);
    r = r && identifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DOT single_name)*
  private static boolean identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifier_1", c)) break;
    }
    return true;
  }

  // DOT single_name
  private static boolean identifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && single_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF test COLON if_entry_exec_block (ELIF test COLON if_entry_exec_block)* (ELSE COLON if_entry_exec_block)?
  public static boolean if_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && test(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && if_entry_exec_block(b, l + 1);
    r = r && if_entry_4(b, l + 1);
    r = r && if_entry_5(b, l + 1);
    exit_section_(b, m, IF_ENTRY, r);
    return r;
  }

  // (ELIF test COLON if_entry_exec_block)*
  private static boolean if_entry_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_entry_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_entry_4", c)) break;
    }
    return true;
  }

  // ELIF test COLON if_entry_exec_block
  private static boolean if_entry_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELIF);
    r = r && test(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && if_entry_exec_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE COLON if_entry_exec_block)?
  private static boolean if_entry_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_5")) return false;
    if_entry_5_0(b, l + 1);
    return true;
  }

  // ELSE COLON if_entry_exec_block
  private static boolean if_entry_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, COLON);
    r = r && if_entry_exec_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry) [NEWLINE] | NEWLINE INDENT (test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry) ((COMMA [NEWLINE] | [NEWLINE]) (test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry))* [COMMA] [NEWLINE] DEDENT
  public static boolean if_entry_exec_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_ENTRY_EXEC_BLOCK, "<if entry exec block>");
    r = if_entry_exec_block_0(b, l + 1);
    if (!r) r = if_entry_exec_block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry) [NEWLINE]
  private static boolean if_entry_exec_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_entry_exec_block_0_0(b, l + 1);
    r = r && if_entry_exec_block_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry
  private static boolean if_entry_exec_block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_entry_exec_block_0_0_0(b, l + 1);
    if (!r) r = double_star_expr(b, l + 1);
    if (!r) r = if_entry(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // test (COLON | ASSIGN | COMP_PLUS) test
  private static boolean if_entry_exec_block_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = test(b, l + 1);
    r = r && if_entry_exec_block_0_0_0_1(b, l + 1);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON | ASSIGN | COMP_PLUS
  private static boolean if_entry_exec_block_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_0_0_0_1")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, COMP_PLUS);
    return r;
  }

  // [NEWLINE]
  private static boolean if_entry_exec_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // NEWLINE INDENT (test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry) ((COMMA [NEWLINE] | [NEWLINE]) (test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry))* [COMMA] [NEWLINE] DEDENT
  private static boolean if_entry_exec_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && if_entry_exec_block_1_2(b, l + 1);
    r = r && if_entry_exec_block_1_3(b, l + 1);
    r = r && if_entry_exec_block_1_4(b, l + 1);
    r = r && if_entry_exec_block_1_5(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry
  private static boolean if_entry_exec_block_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_entry_exec_block_1_2_0(b, l + 1);
    if (!r) r = double_star_expr(b, l + 1);
    if (!r) r = if_entry(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // test (COLON | ASSIGN | COMP_PLUS) test
  private static boolean if_entry_exec_block_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = test(b, l + 1);
    r = r && if_entry_exec_block_1_2_0_1(b, l + 1);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON | ASSIGN | COMP_PLUS
  private static boolean if_entry_exec_block_1_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_2_0_1")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, COMP_PLUS);
    return r;
  }

  // ((COMMA [NEWLINE] | [NEWLINE]) (test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry))*
  private static boolean if_entry_exec_block_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_entry_exec_block_1_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_entry_exec_block_1_3", c)) break;
    }
    return true;
  }

  // (COMMA [NEWLINE] | [NEWLINE]) (test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry)
  private static boolean if_entry_exec_block_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_entry_exec_block_1_3_0_0(b, l + 1);
    r = r && if_entry_exec_block_1_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA [NEWLINE] | [NEWLINE]
  private static boolean if_entry_exec_block_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_entry_exec_block_1_3_0_0_0(b, l + 1);
    if (!r) r = if_entry_exec_block_1_3_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA [NEWLINE]
  private static boolean if_entry_exec_block_1_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && if_entry_exec_block_1_3_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [NEWLINE]
  private static boolean if_entry_exec_block_1_3_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3_0_0_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // [NEWLINE]
  private static boolean if_entry_exec_block_1_3_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3_0_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // test (COLON | ASSIGN | COMP_PLUS) test | double_star_expr | if_entry
  private static boolean if_entry_exec_block_1_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_entry_exec_block_1_3_0_1_0(b, l + 1);
    if (!r) r = double_star_expr(b, l + 1);
    if (!r) r = if_entry(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // test (COLON | ASSIGN | COMP_PLUS) test
  private static boolean if_entry_exec_block_1_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = test(b, l + 1);
    r = r && if_entry_exec_block_1_3_0_1_0_1(b, l + 1);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON | ASSIGN | COMP_PLUS
  private static boolean if_entry_exec_block_1_3_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_3_0_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, COMP_PLUS);
    return r;
  }

  // [COMMA]
  private static boolean if_entry_exec_block_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_4")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // [NEWLINE]
  private static boolean if_entry_exec_block_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_entry_exec_block_1_5")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // simple_expr IF simple_expr ELSE test
  public static boolean if_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_EXPR, "<if expr>");
    r = simple_expr(b, l + 1);
    r = r && consumeToken(b, IF);
    r = r && simple_expr(b, l + 1);
    r = r && consumeToken(b, ELSE);
    r = r && test(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF test COLON if_item_exec_block (ELIF test COLON if_item_exec_block)* (ELSE COLON if_item_exec_block)?
  public static boolean if_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && test(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && if_item_exec_block(b, l + 1);
    r = r && if_item_4(b, l + 1);
    r = r && if_item_5(b, l + 1);
    exit_section_(b, m, IF_ITEM, r);
    return r;
  }

  // (ELIF test COLON if_item_exec_block)*
  private static boolean if_item_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_item_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_item_4", c)) break;
    }
    return true;
  }

  // ELIF test COLON if_item_exec_block
  private static boolean if_item_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELIF);
    r = r && test(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && if_item_exec_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE COLON if_item_exec_block)?
  private static boolean if_item_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_5")) return false;
    if_item_5_0(b, l + 1);
    return true;
  }

  // ELSE COLON if_item_exec_block
  private static boolean if_item_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, COLON);
    r = r && if_item_exec_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // list_item [NEWLINE] | NEWLINE INDENT list_item ((COMMA [NEWLINE] | NEWLINE) list_item)* [COMMA] [NEWLINE] DEDENT
  public static boolean if_item_exec_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_ITEM_EXEC_BLOCK, "<if item exec block>");
    r = if_item_exec_block_0(b, l + 1);
    if (!r) r = if_item_exec_block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // list_item [NEWLINE]
  private static boolean if_item_exec_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_item(b, l + 1);
    r = r && if_item_exec_block_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [NEWLINE]
  private static boolean if_item_exec_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // NEWLINE INDENT list_item ((COMMA [NEWLINE] | NEWLINE) list_item)* [COMMA] [NEWLINE] DEDENT
  private static boolean if_item_exec_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && list_item(b, l + 1);
    r = r && if_item_exec_block_1_3(b, l + 1);
    r = r && if_item_exec_block_1_4(b, l + 1);
    r = r && if_item_exec_block_1_5(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((COMMA [NEWLINE] | NEWLINE) list_item)*
  private static boolean if_item_exec_block_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_item_exec_block_1_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_item_exec_block_1_3", c)) break;
    }
    return true;
  }

  // (COMMA [NEWLINE] | NEWLINE) list_item
  private static boolean if_item_exec_block_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_item_exec_block_1_3_0_0(b, l + 1);
    r = r && list_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA [NEWLINE] | NEWLINE
  private static boolean if_item_exec_block_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_item_exec_block_1_3_0_0_0(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA [NEWLINE]
  private static boolean if_item_exec_block_1_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_1_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && if_item_exec_block_1_3_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [NEWLINE]
  private static boolean if_item_exec_block_1_3_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_1_3_0_0_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // [COMMA]
  private static boolean if_item_exec_block_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_1_4")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // [NEWLINE]
  private static boolean if_item_exec_block_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_item_exec_block_1_5")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // (simple_assign_stmt | unification_stmt | expr_stmt | assert_stmt) NEWLINE
  public static boolean if_simple_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_simple_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_SIMPLE_STMT, "<if simple stmt>");
    r = if_simple_stmt_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // simple_assign_stmt | unification_stmt | expr_stmt | assert_stmt
  private static boolean if_simple_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_simple_stmt_0")) return false;
    boolean r;
    r = simple_assign_stmt(b, l + 1);
    if (!r) r = unification_stmt(b, l + 1);
    if (!r) r = expr_stmt(b, l + 1);
    if (!r) r = assert_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IF test COLON execution_block (ELIF test COLON execution_block)* (ELSE COLON execution_block)?
  public static boolean if_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_stmt")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && test(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && execution_block(b, l + 1);
    r = r && if_stmt_4(b, l + 1);
    r = r && if_stmt_5(b, l + 1);
    exit_section_(b, m, IF_STMT, r);
    return r;
  }

  // (ELIF test COLON execution_block)*
  private static boolean if_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_stmt_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_stmt_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_stmt_4", c)) break;
    }
    return true;
  }

  // ELIF test COLON execution_block
  private static boolean if_stmt_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_stmt_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELIF);
    r = r && test(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && execution_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE COLON execution_block)?
  private static boolean if_stmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_stmt_5")) return false;
    if_stmt_5_0(b, l + 1);
    return true;
  }

  // ELSE COLON execution_block
  private static boolean if_stmt_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_stmt_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, COLON);
    r = r && execution_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT dot_name (AS single_name)?
  public static boolean import_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_STMT, "<import stmt>");
    r = consumeToken(b, IMPORT);
    p = r; // pin = 1
    r = r && report_error_(b, dot_name(b, l + 1));
    r = p && import_stmt_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, recoverImport_parser_);
    return r || p;
  }

  // (AS single_name)?
  private static boolean import_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt_2")) return false;
    import_stmt_2_0(b, l + 1);
    return true;
  }

  // AS single_name
  private static boolean import_stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && single_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (NEWLINE | statement)*
  static boolean kclFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kclFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!kclFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "kclFile", c)) break;
    }
    return true;
  }

  // NEWLINE | statement
  private static boolean kclFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kclFile_0")) return false;
    boolean r;
    r = consumeToken(b, NEWLINE);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LAMBDA [schema_arguments] [RIGHT_ARROW type] LEFT_BRACE [expr_stmt | NEWLINE INDENT schema_init_stmt+ DEDENT] RIGHT_BRACE
  public static boolean lambda_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr")) return false;
    if (!nextTokenIs(b, LAMBDA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAMBDA);
    r = r && lambda_expr_1(b, l + 1);
    r = r && lambda_expr_2(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && lambda_expr_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, LAMBDA_EXPR, r);
    return r;
  }

  // [schema_arguments]
  private static boolean lambda_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr_1")) return false;
    schema_arguments(b, l + 1);
    return true;
  }

  // [RIGHT_ARROW type]
  private static boolean lambda_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr_2")) return false;
    lambda_expr_2_0(b, l + 1);
    return true;
  }

  // RIGHT_ARROW type
  private static boolean lambda_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RIGHT_ARROW);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expr_stmt | NEWLINE INDENT schema_init_stmt+ DEDENT]
  private static boolean lambda_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr_4")) return false;
    lambda_expr_4_0(b, l + 1);
    return true;
  }

  // expr_stmt | NEWLINE INDENT schema_init_stmt+ DEDENT
  private static boolean lambda_expr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_stmt(b, l + 1);
    if (!r) r = lambda_expr_4_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE INDENT schema_init_stmt+ DEDENT
  private static boolean lambda_expr_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr_4_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && lambda_expr_4_0_1_2(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // schema_init_stmt+
  private static boolean lambda_expr_4_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr_4_0_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = schema_init_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!schema_init_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambda_expr_4_0_1_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOT+
  public static boolean leading_dots(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leading_dots")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, DOT)) break;
      if (!empty_element_parsed_guard_(b, "leading_dots", c)) break;
    }
    exit_section_(b, m, LEADING_DOTS, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKETS (list_item comp_clause+ | NEWLINE INDENT list_item comp_clause+ DEDENT) RIGHT_BRACKETS
  public static boolean list_comp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comp")) return false;
    if (!nextTokenIs(b, LEFT_BRACKETS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKETS);
    r = r && list_comp_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKETS);
    exit_section_(b, m, LIST_COMP, r);
    return r;
  }

  // list_item comp_clause+ | NEWLINE INDENT list_item comp_clause+ DEDENT
  private static boolean list_comp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_comp_1_0(b, l + 1);
    if (!r) r = list_comp_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // list_item comp_clause+
  private static boolean list_comp_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comp_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_item(b, l + 1);
    r = r && list_comp_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comp_clause+
  private static boolean list_comp_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comp_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comp_clause(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!comp_clause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_comp_1_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE INDENT list_item comp_clause+ DEDENT
  private static boolean list_comp_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comp_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && list_item(b, l + 1);
    r = r && list_comp_1_1_3(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // comp_clause+
  private static boolean list_comp_1_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comp_1_1_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comp_clause(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!comp_clause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_comp_1_1_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKETS [list_items | NEWLINE INDENT list_items DEDENT] RIGHT_BRACKETS
  public static boolean list_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_expr")) return false;
    if (!nextTokenIs(b, LEFT_BRACKETS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKETS);
    r = r && list_expr_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKETS);
    exit_section_(b, m, LIST_EXPR, r);
    return r;
  }

  // [list_items | NEWLINE INDENT list_items DEDENT]
  private static boolean list_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_expr_1")) return false;
    list_expr_1_0(b, l + 1);
    return true;
  }

  // list_items | NEWLINE INDENT list_items DEDENT
  private static boolean list_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_items(b, l + 1);
    if (!r) r = list_expr_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE INDENT list_items DEDENT
  private static boolean list_expr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_expr_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && list_items(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // test | star_expr | if_item
  public static boolean list_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_ITEM, "<list item>");
    r = test(b, l + 1);
    if (!r) r = star_expr(b, l + 1);
    if (!r) r = if_item(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // list_item ((COMMA [NEWLINE] | [NEWLINE]) list_item)* [COMMA] [NEWLINE]
  public static boolean list_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_ITEMS, "<list items>");
    r = list_item(b, l + 1);
    r = r && list_items_1(b, l + 1);
    r = r && list_items_2(b, l + 1);
    r = r && list_items_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((COMMA [NEWLINE] | [NEWLINE]) list_item)*
  private static boolean list_items_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_items_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_items_1", c)) break;
    }
    return true;
  }

  // (COMMA [NEWLINE] | [NEWLINE]) list_item
  private static boolean list_items_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_items_1_0_0(b, l + 1);
    r = r && list_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA [NEWLINE] | [NEWLINE]
  private static boolean list_items_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_items_1_0_0_0(b, l + 1);
    if (!r) r = list_items_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA [NEWLINE]
  private static boolean list_items_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && list_items_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [NEWLINE]
  private static boolean list_items_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items_1_0_0_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // [NEWLINE]
  private static boolean list_items_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items_1_0_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // [COMMA]
  private static boolean list_items_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // [NEWLINE]
  private static boolean list_items_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_items_3")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // LEFT_BRACKETS (type)? RIGHT_BRACKETS
  public static boolean list_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_type")) return false;
    if (!nextTokenIs(b, LEFT_BRACKETS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKETS);
    r = r && list_type_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKETS);
    exit_section_(b, m, LIST_TYPE, r);
    return r;
  }

  // (type)?
  private static boolean list_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_type_1")) return false;
    list_type_1_0(b, l + 1);
    return true;
  }

  // (type)
  private static boolean list_type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string | number | TRUE | FALSE | NONE
  public static boolean literal_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_TYPE, "<literal type>");
    r = string(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, NONE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primary_expr (COMMA primary_expr)*
  public static boolean loop_variables(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_variables")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOOP_VARIABLES, "<loop variables>");
    r = primary_expr(b, l + 1);
    r = r && loop_variables_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA primary_expr)*
  private static boolean loop_variables_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_variables_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!loop_variables_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "loop_variables_1", c)) break;
    }
    return true;
  }

  // COMMA primary_expr
  private static boolean loop_variables_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_variables_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && primary_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MIXIN LEFT_BRACKETS [mixins | multiline_mixins] RIGHT_BRACKETS NEWLINE
  public static boolean mixin_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixin_stmt")) return false;
    if (!nextTokenIs(b, MIXIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MIXIN, LEFT_BRACKETS);
    r = r && mixin_stmt_2(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_BRACKETS, NEWLINE);
    exit_section_(b, m, MIXIN_STMT, r);
    return r;
  }

  // [mixins | multiline_mixins]
  private static boolean mixin_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixin_stmt_2")) return false;
    mixin_stmt_2_0(b, l + 1);
    return true;
  }

  // mixins | multiline_mixins
  private static boolean mixin_stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixin_stmt_2_0")) return false;
    boolean r;
    r = mixins(b, l + 1);
    if (!r) r = multiline_mixins(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier (COMMA (NEWLINE mixins | identifier))*
  public static boolean mixins(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixins")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MIXINS, "<mixins>");
    r = identifier(b, l + 1);
    r = r && mixins_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA (NEWLINE mixins | identifier))*
  private static boolean mixins_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixins_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mixins_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mixins_1", c)) break;
    }
    return true;
  }

  // COMMA (NEWLINE mixins | identifier)
  private static boolean mixins_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixins_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && mixins_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE mixins | identifier
  private static boolean mixins_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixins_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mixins_1_0_1_0(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE mixins
  private static boolean mixins_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixins_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE);
    r = r && mixins(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NEWLINE INDENT mixins NEWLINE DEDENT
  public static boolean multiline_mixins(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_mixins")) return false;
    if (!nextTokenIs(b, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && mixins(b, l + 1);
    r = r && consumeTokens(b, 0, NEWLINE, DEDENT);
    exit_section_(b, m, MULTILINE_MIXINS, r);
    return r;
  }

  /* ********************************************************** */
  // SI_N_L | SI_U_L | SI_M_L | SI_K_L | SI_K | SI_M | SI_G | SI_T | SI_P
  //     | SI_K_IEC | SI_M_IEC | SI_G_IEC | SI_T_IEC | SI_P_IEC
  static boolean multiplier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplier")) return false;
    boolean r;
    r = consumeToken(b, SI_N_L);
    if (!r) r = consumeToken(b, SI_U_L);
    if (!r) r = consumeToken(b, SI_M_L);
    if (!r) r = consumeToken(b, SI_K_L);
    if (!r) r = consumeToken(b, SI_K);
    if (!r) r = consumeToken(b, SI_M);
    if (!r) r = consumeToken(b, SI_G);
    if (!r) r = consumeToken(b, SI_T);
    if (!r) r = consumeToken(b, SI_P);
    if (!r) r = consumeToken(b, SI_K_IEC);
    if (!r) r = consumeToken(b, SI_M_IEC);
    if (!r) r = consumeToken(b, SI_G_IEC);
    if (!r) r = consumeToken(b, SI_T_IEC);
    if (!r) r = consumeToken(b, SI_P_IEC);
    return r;
  }

  /* ********************************************************** */
  // K_NOT not_test | comparison
  public static boolean not_test(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_test")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOT_TEST, "<not test>");
    r = not_test_0(b, l + 1);
    if (!r) r = comparison(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_NOT not_test
  private static boolean not_test_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_test_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_NOT);
    r = r && not_test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEC_NUMBER [multiplier] | HEX_NUMBER | BIN_NUMBER | OCT_NUMBER | FLOAT_NUMBER
  static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_0(b, l + 1);
    if (!r) r = consumeToken(b, HEX_NUMBER);
    if (!r) r = consumeToken(b, BIN_NUMBER);
    if (!r) r = consumeToken(b, OCT_NUMBER);
    if (!r) r = consumeToken(b, FLOAT_NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  // DEC_NUMBER [multiplier]
  private static boolean number_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEC_NUMBER);
    r = r && number_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [multiplier]
  private static boolean number_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0_1")) return false;
    multiplier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // quant_expr | list_expr | list_comp | config_expr | dict_comp | schema_expr | lambda_expr | LEFT_PARENTHESES test RIGHT_PARENTHESES
  // | identifier | number | string | constant | type_cast_expr
  public static boolean operand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operand")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERAND, "<operand>");
    r = quant_expr(b, l + 1);
    if (!r) r = list_expr(b, l + 1);
    if (!r) r = list_comp(b, l + 1);
    if (!r) r = config_expr(b, l + 1);
    if (!r) r = dict_comp(b, l + 1);
    if (!r) r = schema_expr(b, l + 1);
    if (!r) r = lambda_expr(b, l + 1);
    if (!r) r = operand_7(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = constant(b, l + 1);
    if (!r) r = type_cast_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LEFT_PARENTHESES test RIGHT_PARENTHESES
  private static boolean operand_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operand_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESES);
    r = r && test(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESES);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primary_expr (DOUBLE_STAR factor)?
  public static boolean power(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "power")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POWER, "<power>");
    r = primary_expr(b, l + 1);
    r = r && power_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DOUBLE_STAR factor)?
  private static boolean power_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "power_1")) return false;
    power_1_0(b, l + 1);
    return true;
  }

  // DOUBLE_STAR factor
  private static boolean power_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "power_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_STAR);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // operand (select_suffix |  call_suffix | slice_suffix)*
  public static boolean primary_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPR, "<primary expr>");
    r = operand(b, l + 1);
    r = r && primary_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (select_suffix |  call_suffix | slice_suffix)*
  private static boolean primary_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primary_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primary_expr_1", c)) break;
    }
    return true;
  }

  // select_suffix |  call_suffix | slice_suffix
  private static boolean primary_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expr_1_0")) return false;
    boolean r;
    r = select_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = slice_suffix(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // quant_op [ identifier COMMA ] identifier IN quant_target LEFT_BRACE (simple_expr [IF simple_expr] | NEWLINE INDENT simple_expr [IF simple_expr] NEWLINE DEDENT)? RIGHT_BRACE
  public static boolean quant_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUANT_EXPR, "<quant expr>");
    r = quant_op(b, l + 1);
    r = r && quant_expr_1(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && quant_target(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && quant_expr_6(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [ identifier COMMA ]
  private static boolean quant_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_1")) return false;
    quant_expr_1_0(b, l + 1);
    return true;
  }

  // identifier COMMA
  private static boolean quant_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // (simple_expr [IF simple_expr] | NEWLINE INDENT simple_expr [IF simple_expr] NEWLINE DEDENT)?
  private static boolean quant_expr_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_6")) return false;
    quant_expr_6_0(b, l + 1);
    return true;
  }

  // simple_expr [IF simple_expr] | NEWLINE INDENT simple_expr [IF simple_expr] NEWLINE DEDENT
  private static boolean quant_expr_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = quant_expr_6_0_0(b, l + 1);
    if (!r) r = quant_expr_6_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_expr [IF simple_expr]
  private static boolean quant_expr_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_6_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_expr(b, l + 1);
    r = r && quant_expr_6_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [IF simple_expr]
  private static boolean quant_expr_6_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_6_0_0_1")) return false;
    quant_expr_6_0_0_1_0(b, l + 1);
    return true;
  }

  // IF simple_expr
  private static boolean quant_expr_6_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_6_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && simple_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE INDENT simple_expr [IF simple_expr] NEWLINE DEDENT
  private static boolean quant_expr_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_6_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE, INDENT);
    r = r && simple_expr(b, l + 1);
    r = r && quant_expr_6_0_1_3(b, l + 1);
    r = r && consumeTokens(b, 0, NEWLINE, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // [IF simple_expr]
  private static boolean quant_expr_6_0_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_6_0_1_3")) return false;
    quant_expr_6_0_1_3_0(b, l + 1);
    return true;
  }

  // IF simple_expr
  private static boolean quant_expr_6_0_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_expr_6_0_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && simple_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ALL | ANY | FILTER | MAP
  public static boolean quant_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUANT_OP, "<quant op>");
    r = consumeToken(b, ALL);
    if (!r) r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, FILTER);
    if (!r) r = consumeToken(b, MAP);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // string | identifier | list_expr | list_comp | config_expr | dict_comp
  public static boolean quant_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quant_target")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUANT_TARGET, "<quant target>");
    r = string(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = list_expr(b, l + 1);
    if (!r) r = list_comp(b, l + 1);
    if (!r) r = config_expr(b, l + 1);
    if (!r) r = dict_comp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(NEWLINE)
  static boolean recoverImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recoverImport")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // single_name [COLON type] [ASSIGN test]
  public static boolean schema_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_ARGUMENT, "<schema argument>");
    r = single_name(b, l + 1);
    r = r && schema_argument_1(b, l + 1);
    r = r && schema_argument_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON type]
  private static boolean schema_argument_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_argument_1")) return false;
    schema_argument_1_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean schema_argument_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_argument_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ASSIGN test]
  private static boolean schema_argument_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_argument_2")) return false;
    schema_argument_2_0(b, l + 1);
    return true;
  }

  // ASSIGN test
  private static boolean schema_argument_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_argument_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // schema_argument (COMMA schema_argument)*
  public static boolean schema_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_ARGUMENTS, "<schema arguments>");
    r = schema_argument(b, l + 1);
    r = r && schema_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA schema_argument)*
  private static boolean schema_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_arguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!schema_arguments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schema_arguments_1", c)) break;
    }
    return true;
  }

  // COMMA schema_argument
  private static boolean schema_arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && schema_argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // attribute_stmt NEWLINE
  public static boolean schema_attribute_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_attribute_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_ATTRIBUTE_STMT, "<schema attribute stmt>");
    r = attribute_stmt(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INDENT (string NEWLINE)* [mixin_stmt] (schema_attribute_stmt|schema_init_stmt|schema_index_signature)* [check_block] DEDENT
  public static boolean schema_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_body")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && schema_body_1(b, l + 1);
    r = r && schema_body_2(b, l + 1);
    r = r && schema_body_3(b, l + 1);
    r = r && schema_body_4(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, SCHEMA_BODY, r);
    return r;
  }

  // (string NEWLINE)*
  private static boolean schema_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!schema_body_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schema_body_1", c)) break;
    }
    return true;
  }

  // string NEWLINE
  private static boolean schema_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [mixin_stmt]
  private static boolean schema_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_body_2")) return false;
    mixin_stmt(b, l + 1);
    return true;
  }

  // (schema_attribute_stmt|schema_init_stmt|schema_index_signature)*
  private static boolean schema_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_body_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!schema_body_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schema_body_3", c)) break;
    }
    return true;
  }

  // schema_attribute_stmt|schema_init_stmt|schema_index_signature
  private static boolean schema_body_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_body_3_0")) return false;
    boolean r;
    r = schema_attribute_stmt(b, l + 1);
    if (!r) r = schema_init_stmt(b, l + 1);
    if (!r) r = schema_index_signature(b, l + 1);
    return r;
  }

  // [check_block]
  private static boolean schema_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_body_4")) return false;
    check_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier (LEFT_PARENTHESES [arguments] RIGHT_PARENTHESES)? config_expr
  public static boolean schema_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_EXPR, "<schema expr>");
    r = identifier(b, l + 1);
    r = r && schema_expr_1(b, l + 1);
    r = r && config_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LEFT_PARENTHESES [arguments] RIGHT_PARENTHESES)?
  private static boolean schema_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_expr_1")) return false;
    schema_expr_1_0(b, l + 1);
    return true;
  }

  // LEFT_PARENTHESES [arguments] RIGHT_PARENTHESES
  private static boolean schema_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESES);
    r = r && schema_expr_1_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESES);
    exit_section_(b, m, null, r);
    return r;
  }

  // [arguments]
  private static boolean schema_expr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_expr_1_0_1")) return false;
    arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LEFT_BRACKETS [single_name COLON] [ellipsis] basic_type RIGHT_BRACKETS COLON type [ASSIGN test] NEWLINE
  public static boolean schema_index_signature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_index_signature")) return false;
    if (!nextTokenIs(b, LEFT_BRACKETS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKETS);
    r = r && schema_index_signature_1(b, l + 1);
    r = r && schema_index_signature_2(b, l + 1);
    r = r && basic_type(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_BRACKETS, COLON);
    r = r && type(b, l + 1);
    r = r && schema_index_signature_7(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, SCHEMA_INDEX_SIGNATURE, r);
    return r;
  }

  // [single_name COLON]
  private static boolean schema_index_signature_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_index_signature_1")) return false;
    schema_index_signature_1_0(b, l + 1);
    return true;
  }

  // single_name COLON
  private static boolean schema_index_signature_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_index_signature_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = single_name(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ellipsis]
  private static boolean schema_index_signature_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_index_signature_2")) return false;
    ellipsis(b, l + 1);
    return true;
  }

  // [ASSIGN test]
  private static boolean schema_index_signature_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_index_signature_7")) return false;
    schema_index_signature_7_0(b, l + 1);
    return true;
  }

  // ASSIGN test
  private static boolean schema_index_signature_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_index_signature_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // if_simple_stmt | if_stmt
  public static boolean schema_init_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_init_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_INIT_STMT, "<schema init stmt>");
    r = if_simple_stmt(b, l + 1);
    if (!r) r = if_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [decorators] (SCHEMA|MIXIN|PROTOCOL) [RELAXED] single_name [LEFT_BRACKETS [schema_arguments] RIGHT_BRACKETS] [LEFT_PARENTHESES identifier (COMMA identifier)* RIGHT_PARENTHESES] [for_mixin_host] COLON NEWLINE [schema_body]
  public static boolean schema_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_STMT, "<schema stmt>");
    r = schema_stmt_0(b, l + 1);
    r = r && schema_stmt_1(b, l + 1);
    r = r && schema_stmt_2(b, l + 1);
    r = r && single_name(b, l + 1);
    r = r && schema_stmt_4(b, l + 1);
    r = r && schema_stmt_5(b, l + 1);
    r = r && schema_stmt_6(b, l + 1);
    r = r && consumeTokens(b, 0, COLON, NEWLINE);
    r = r && schema_stmt_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [decorators]
  private static boolean schema_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_0")) return false;
    decorators(b, l + 1);
    return true;
  }

  // SCHEMA|MIXIN|PROTOCOL
  private static boolean schema_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_1")) return false;
    boolean r;
    r = consumeToken(b, SCHEMA);
    if (!r) r = consumeToken(b, MIXIN);
    if (!r) r = consumeToken(b, PROTOCOL);
    return r;
  }

  // [RELAXED]
  private static boolean schema_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_2")) return false;
    consumeToken(b, RELAXED);
    return true;
  }

  // [LEFT_BRACKETS [schema_arguments] RIGHT_BRACKETS]
  private static boolean schema_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_4")) return false;
    schema_stmt_4_0(b, l + 1);
    return true;
  }

  // LEFT_BRACKETS [schema_arguments] RIGHT_BRACKETS
  private static boolean schema_stmt_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKETS);
    r = r && schema_stmt_4_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKETS);
    exit_section_(b, m, null, r);
    return r;
  }

  // [schema_arguments]
  private static boolean schema_stmt_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_4_0_1")) return false;
    schema_arguments(b, l + 1);
    return true;
  }

  // [LEFT_PARENTHESES identifier (COMMA identifier)* RIGHT_PARENTHESES]
  private static boolean schema_stmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_5")) return false;
    schema_stmt_5_0(b, l + 1);
    return true;
  }

  // LEFT_PARENTHESES identifier (COMMA identifier)* RIGHT_PARENTHESES
  private static boolean schema_stmt_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESES);
    r = r && identifier(b, l + 1);
    r = r && schema_stmt_5_0_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESES);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA identifier)*
  private static boolean schema_stmt_5_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_5_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!schema_stmt_5_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schema_stmt_5_0_2", c)) break;
    }
    return true;
  }

  // COMMA identifier
  private static boolean schema_stmt_5_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_5_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [for_mixin_host]
  private static boolean schema_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_6")) return false;
    for_mixin_host(b, l + 1);
    return true;
  }

  // [schema_body]
  private static boolean schema_stmt_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_stmt_9")) return false;
    schema_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean schema_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_TYPE, "<schema type>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [QUESTION] DOT single_name
  public static boolean select_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "select_suffix")) return false;
    if (!nextTokenIs(b, "<select suffix>", DOT, QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SELECT_SUFFIX, "<select suffix>");
    r = select_suffix_0(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && single_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [QUESTION]
  private static boolean select_suffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "select_suffix_0")) return false;
    consumeToken(b, QUESTION);
    return true;
  }

  /* ********************************************************** */
  // arith_expr (( SHIFT_LEFT | SHIFT_RIGHT ) arith_expr)*
  public static boolean shift_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHIFT_EXPR, "<shift expr>");
    r = arith_expr(b, l + 1);
    r = r && shift_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (( SHIFT_LEFT | SHIFT_RIGHT ) arith_expr)*
  private static boolean shift_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!shift_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shift_expr_1", c)) break;
    }
    return true;
  }

  // ( SHIFT_LEFT | SHIFT_RIGHT ) arith_expr
  private static boolean shift_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shift_expr_1_0_0(b, l + 1);
    r = r && arith_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SHIFT_LEFT | SHIFT_RIGHT
  private static boolean shift_expr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, SHIFT_LEFT);
    if (!r) r = consumeToken(b, SHIFT_RIGHT);
    return r;
  }

  /* ********************************************************** */
  // identifier ASSIGN test
  //     | identifier (COMP_PLUS | COMP_MINUS | COMP_MULTIPLY | COMP_DOUBLE_STAR | COMP_DIVIDE
  //     | COMP_DOUBLE_DIVIDE | COMP_MOD | COMP_AND | COMP_OR | COMP_XOR | COMP_SHIFT_LEFT
  //     | COMP_SHIFT_RIGHT) test
  public static boolean simple_assign_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_assign_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_ASSIGN_STMT, "<simple assign stmt>");
    r = simple_assign_stmt_0(b, l + 1);
    if (!r) r = simple_assign_stmt_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier ASSIGN test
  private static boolean simple_assign_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_assign_stmt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier (COMP_PLUS | COMP_MINUS | COMP_MULTIPLY | COMP_DOUBLE_STAR | COMP_DIVIDE
  //     | COMP_DOUBLE_DIVIDE | COMP_MOD | COMP_AND | COMP_OR | COMP_XOR | COMP_SHIFT_LEFT
  //     | COMP_SHIFT_RIGHT) test
  private static boolean simple_assign_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_assign_stmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && simple_assign_stmt_1_1(b, l + 1);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMP_PLUS | COMP_MINUS | COMP_MULTIPLY | COMP_DOUBLE_STAR | COMP_DIVIDE
  //     | COMP_DOUBLE_DIVIDE | COMP_MOD | COMP_AND | COMP_OR | COMP_XOR | COMP_SHIFT_LEFT
  //     | COMP_SHIFT_RIGHT
  private static boolean simple_assign_stmt_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_assign_stmt_1_1")) return false;
    boolean r;
    r = consumeToken(b, COMP_PLUS);
    if (!r) r = consumeToken(b, COMP_MINUS);
    if (!r) r = consumeToken(b, COMP_MULTIPLY);
    if (!r) r = consumeToken(b, COMP_DOUBLE_STAR);
    if (!r) r = consumeToken(b, COMP_DIVIDE);
    if (!r) r = consumeToken(b, COMP_DOUBLE_DIVIDE);
    if (!r) r = consumeToken(b, COMP_MOD);
    if (!r) r = consumeToken(b, COMP_AND);
    if (!r) r = consumeToken(b, COMP_OR);
    if (!r) r = consumeToken(b, COMP_XOR);
    if (!r) r = consumeToken(b, COMP_SHIFT_LEFT);
    if (!r) r = consumeToken(b, COMP_SHIFT_RIGHT);
    return r;
  }

  /* ********************************************************** */
  // and_test (K_OR and_test)*
  public static boolean simple_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_EXPR, "<simple expr>");
    r = and_test(b, l + 1);
    r = r && simple_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (K_OR and_test)*
  private static boolean simple_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simple_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simple_expr_1", c)) break;
    }
    return true;
  }

  // K_OR and_test
  private static boolean simple_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_OR);
    r = r && and_test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (assign_stmt | unification_stmt | expr_stmt | assert_stmt | type_alias_stmt | import_stmt ) NEWLINE
  public static boolean simple_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_STMT, "<simple stmt>");
    r = simple_stmt_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // assign_stmt | unification_stmt | expr_stmt | assert_stmt | type_alias_stmt | import_stmt
  private static boolean simple_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_stmt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assign_stmt(b, l + 1);
    if (!r) r = unification_stmt(b, l + 1);
    if (!r) r = expr_stmt(b, l + 1);
    if (!r) r = assert_stmt(b, l + 1);
    if (!r) r = type_alias_stmt(b, l + 1);
    if (!r) r = import_stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NAME | multiplier
  public static boolean single_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_NAME, "<single name>");
    r = consumeToken(b, NAME);
    if (!r) r = multiplier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [QUESTION] LEFT_BRACKETS ([test] COLON [test] [COLON [test]] | test) RIGHT_BRACKETS
  public static boolean slice_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix")) return false;
    if (!nextTokenIs(b, "<slice suffix>", LEFT_BRACKETS, QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SLICE_SUFFIX, "<slice suffix>");
    r = slice_suffix_0(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACKETS);
    r = r && slice_suffix_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKETS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [QUESTION]
  private static boolean slice_suffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix_0")) return false;
    consumeToken(b, QUESTION);
    return true;
  }

  // [test] COLON [test] [COLON [test]] | test
  private static boolean slice_suffix_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_suffix_2_0(b, l + 1);
    if (!r) r = test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [test] COLON [test] [COLON [test]]
  private static boolean slice_suffix_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_suffix_2_0_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_suffix_2_0_2(b, l + 1);
    r = r && slice_suffix_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [test]
  private static boolean slice_suffix_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix_2_0_0")) return false;
    test(b, l + 1);
    return true;
  }

  // [test]
  private static boolean slice_suffix_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix_2_0_2")) return false;
    test(b, l + 1);
    return true;
  }

  // [COLON [test]]
  private static boolean slice_suffix_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix_2_0_3")) return false;
    slice_suffix_2_0_3_0(b, l + 1);
    return true;
  }

  // COLON [test]
  private static boolean slice_suffix_2_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix_2_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && slice_suffix_2_0_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [test]
  private static boolean slice_suffix_2_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix_2_0_3_0_1")) return false;
    test(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MULTIPLY primary_expr
  public static boolean star_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "star_expr")) return false;
    if (!nextTokenIs(b, MULTIPLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MULTIPLY);
    r = r && primary_expr(b, l + 1);
    exit_section_(b, m, STAR_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // simple_stmt | compound_stmt
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = simple_stmt(b, l + 1);
    if (!r) r = compound_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING | LONG_STRING
  static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, "", LONG_STRING, STRING)) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, LONG_STRING);
    return r;
  }

  /* ********************************************************** */
  // factor (( MULTIPLY | DIVIDE | MOD | DOUBLE_DIVIDE ) factor)*
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = factor(b, l + 1);
    r = r && term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (( MULTIPLY | DIVIDE | MOD | DOUBLE_DIVIDE ) factor)*
  private static boolean term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_1", c)) break;
    }
    return true;
  }

  // ( MULTIPLY | DIVIDE | MOD | DOUBLE_DIVIDE ) factor
  private static boolean term_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = term_1_0_0(b, l + 1);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MULTIPLY | DIVIDE | MOD | DOUBLE_DIVIDE
  private static boolean term_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, DIVIDE);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, DOUBLE_DIVIDE);
    return r;
  }

  /* ********************************************************** */
  // if_expr | simple_expr
  public static boolean test(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "test")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEST, "<test>");
    r = if_expr(b, l + 1);
    if (!r) r = simple_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // test (COMMA test)*
  public static boolean testlist_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testlist_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TESTLIST_EXPR, "<testlist expr>");
    r = test(b, l + 1);
    r = r && testlist_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA test)*
  private static boolean testlist_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testlist_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!testlist_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "testlist_expr_1", c)) break;
    }
    return true;
  }

  // COMMA test
  private static boolean testlist_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testlist_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && test(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type_element (OR type_element)*
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = type_element(b, l + 1);
    r = r && type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OR type_element)*
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_1", c)) break;
    }
    return true;
  }

  // OR type_element
  private static boolean type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && type_element(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_TYPE single_name ASSIGN type
  public static boolean type_alias_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_alias_stmt")) return false;
    if (!nextTokenIs(b, K_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_TYPE);
    r = r && single_name(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && type(b, l + 1);
    exit_section_(b, m, TYPE_ALIAS_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // basic_type LEFT_PARENTHESES test RIGHT_PARENTHESES
  public static boolean type_cast_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_cast_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_CAST_EXPR, "<type cast expr>");
    r = basic_type(b, l + 1);
    r = r && consumeToken(b, LEFT_PARENTHESES);
    r = r && test(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESES);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // schema_type | basic_type | compound_type | literal_type
  public static boolean type_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ELEMENT, "<type element>");
    r = schema_type(b, l + 1);
    if (!r) r = basic_type(b, l + 1);
    if (!r) r = compound_type(b, l + 1);
    if (!r) r = literal_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier COLON schema_expr
  public static boolean unification_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unification_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNIFICATION_STMT, "<unification stmt>");
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && schema_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // and_expr (XOR and_expr)*
  public static boolean xor_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xor_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XOR_EXPR, "<xor expr>");
    r = and_expr(b, l + 1);
    r = r && xor_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (XOR and_expr)*
  private static boolean xor_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xor_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!xor_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xor_expr_1", c)) break;
    }
    return true;
  }

  // XOR and_expr
  private static boolean xor_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xor_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, XOR);
    r = r && and_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  static final Parser recoverImport_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return recoverImport(b, l + 1);
    }
  };
}
