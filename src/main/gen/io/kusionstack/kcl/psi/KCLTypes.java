// This is a generated file. Not intended for manual editing.
package io.kusionstack.kcl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.kusionstack.kcl.psi.impl.*;

public interface KCLTypes {

  IElementType AND_EXPR = new KCLElementType("AND_EXPR");
  IElementType AND_TEST = new KCLElementType("AND_TEST");
  IElementType ARGUMENT = new KCLElementType("ARGUMENT");
  IElementType ARGUMENTS = new KCLElementType("ARGUMENTS");
  IElementType ARITH_EXPR = new KCLElementType("ARITH_EXPR");
  IElementType ASSERT_STMT = new KCLElementType("ASSERT_STMT");
  IElementType ASSIGN_STMT = new KCLElementType("ASSIGN_STMT");
  IElementType ATTRIBUTE_STMT = new KCLElementType("ATTRIBUTE_STMT");
  IElementType BASIC_TYPE = new KCLElementType("BASIC_TYPE");
  IElementType CALL_SUFFIX = new KCLElementType("CALL_SUFFIX");
  IElementType CHECK_BLOCK = new KCLElementType("CHECK_BLOCK");
  IElementType CHECK_EXPR = new KCLElementType("CHECK_EXPR");
  IElementType CHECK_TEST = new KCLElementType("CHECK_TEST");
  IElementType COMPARISON = new KCLElementType("COMPARISON");
  IElementType COMPOUND_STMT = new KCLElementType("COMPOUND_STMT");
  IElementType COMPOUND_TYPE = new KCLElementType("COMPOUND_TYPE");
  IElementType COMP_CLAUSE = new KCLElementType("COMP_CLAUSE");
  IElementType CONFIG_ENTRIES = new KCLElementType("CONFIG_ENTRIES");
  IElementType CONFIG_ENTRY = new KCLElementType("CONFIG_ENTRY");
  IElementType CONFIG_EXPR = new KCLElementType("CONFIG_EXPR");
  IElementType DECORATORS = new KCLElementType("DECORATORS");
  IElementType DECORATOR_EXPR = new KCLElementType("DECORATOR_EXPR");
  IElementType DICT_COMP = new KCLElementType("DICT_COMP");
  IElementType DICT_TYPE = new KCLElementType("DICT_TYPE");
  IElementType DOT_NAME = new KCLElementType("DOT_NAME");
  IElementType DOUBLE_STAR_EXPR = new KCLElementType("DOUBLE_STAR_EXPR");
  IElementType ENTRY = new KCLElementType("ENTRY");
  IElementType EXECUTION_BLOCK = new KCLElementType("EXECUTION_BLOCK");
  IElementType EXPR = new KCLElementType("EXPR");
  IElementType EXPR_STMT = new KCLElementType("EXPR_STMT");
  IElementType FACTOR = new KCLElementType("FACTOR");
  IElementType FOR_MIXIN_HOST = new KCLElementType("FOR_MIXIN_HOST");
  IElementType IDENTIFIER = new KCLElementType("IDENTIFIER");
  IElementType IF_ENTRY = new KCLElementType("IF_ENTRY");
  IElementType IF_ENTRY_EXEC_BLOCK = new KCLElementType("IF_ENTRY_EXEC_BLOCK");
  IElementType IF_EXPR = new KCLElementType("IF_EXPR");
  IElementType IF_ITEM = new KCLElementType("IF_ITEM");
  IElementType IF_ITEM_EXEC_BLOCK = new KCLElementType("IF_ITEM_EXEC_BLOCK");
  IElementType IF_SIMPLE_STMT = new KCLElementType("IF_SIMPLE_STMT");
  IElementType IF_STMT = new KCLElementType("IF_STMT");
  IElementType IMPORT_STMT = new KCLElementType("IMPORT_STMT");
  IElementType LAMBDA_EXPR = new KCLElementType("LAMBDA_EXPR");
  IElementType LEADING_DOTS = new KCLElementType("LEADING_DOTS");
  IElementType LIST_COMP = new KCLElementType("LIST_COMP");
  IElementType LIST_EXPR = new KCLElementType("LIST_EXPR");
  IElementType LIST_ITEM = new KCLElementType("LIST_ITEM");
  IElementType LIST_ITEMS = new KCLElementType("LIST_ITEMS");
  IElementType LIST_TYPE = new KCLElementType("LIST_TYPE");
  IElementType LITERAL_TYPE = new KCLElementType("LITERAL_TYPE");
  IElementType LOOP_VARIABLES = new KCLElementType("LOOP_VARIABLES");
  IElementType MIXINS = new KCLElementType("MIXINS");
  IElementType MIXIN_STMT = new KCLElementType("MIXIN_STMT");
  IElementType MULTILINE_MIXINS = new KCLElementType("MULTILINE_MIXINS");
  IElementType NOT_TEST = new KCLElementType("NOT_TEST");
  IElementType OPERAND = new KCLElementType("OPERAND");
  IElementType POWER = new KCLElementType("POWER");
  IElementType PRIMARY_EXPR = new KCLElementType("PRIMARY_EXPR");
  IElementType QUANT_EXPR = new KCLElementType("QUANT_EXPR");
  IElementType QUANT_OP = new KCLElementType("QUANT_OP");
  IElementType QUANT_TARGET = new KCLElementType("QUANT_TARGET");
  IElementType SCHEMA_ARGUMENT = new KCLElementType("SCHEMA_ARGUMENT");
  IElementType SCHEMA_ARGUMENTS = new KCLElementType("SCHEMA_ARGUMENTS");
  IElementType SCHEMA_ATTRIBUTE_STMT = new KCLElementType("SCHEMA_ATTRIBUTE_STMT");
  IElementType SCHEMA_BODY = new KCLElementType("SCHEMA_BODY");
  IElementType SCHEMA_EXPR = new KCLElementType("SCHEMA_EXPR");
  IElementType SCHEMA_INDEX_SIGNATURE = new KCLElementType("SCHEMA_INDEX_SIGNATURE");
  IElementType SCHEMA_INIT_STMT = new KCLElementType("SCHEMA_INIT_STMT");
  IElementType SCHEMA_STMT = new KCLElementType("SCHEMA_STMT");
  IElementType SCHEMA_TYPE = new KCLElementType("SCHEMA_TYPE");
  IElementType SELECT_SUFFIX = new KCLElementType("SELECT_SUFFIX");
  IElementType SHIFT_EXPR = new KCLElementType("SHIFT_EXPR");
  IElementType SIMPLE_ASSIGN_STMT = new KCLElementType("SIMPLE_ASSIGN_STMT");
  IElementType SIMPLE_EXPR = new KCLElementType("SIMPLE_EXPR");
  IElementType SIMPLE_STMT = new KCLElementType("SIMPLE_STMT");
  IElementType SINGLE_NAME = new KCLElementType("SINGLE_NAME");
  IElementType SLICE_SUFFIX = new KCLElementType("SLICE_SUFFIX");
  IElementType STAR_EXPR = new KCLElementType("STAR_EXPR");
  IElementType STATEMENT = new KCLElementType("STATEMENT");
  IElementType TERM = new KCLElementType("TERM");
  IElementType TEST = new KCLElementType("TEST");
  IElementType TESTLIST_EXPR = new KCLElementType("TESTLIST_EXPR");
  IElementType TYPE = new KCLElementType("TYPE");
  IElementType TYPE_ALIAS_STMT = new KCLElementType("TYPE_ALIAS_STMT");
  IElementType TYPE_CAST_EXPR = new KCLElementType("TYPE_CAST_EXPR");
  IElementType TYPE_ELEMENT = new KCLElementType("TYPE_ELEMENT");
  IElementType UNIFICATION_STMT = new KCLElementType("UNIFICATION_STMT");
  IElementType XOR_EXPR = new KCLElementType("XOR_EXPR");

  IElementType ALL = new KCLTokenType("ALL");
  IElementType AND = new KCLTokenType("AND");
  IElementType ANY = new KCLTokenType("ANY");
  IElementType AS = new KCLTokenType("AS");
  IElementType ASSERT = new KCLTokenType("ASSERT");
  IElementType ASSIGN = new KCLTokenType("ASSIGN");
  IElementType AT = new KCLTokenType("AT");
  IElementType BIN_NUMBER = new KCLTokenType("BIN_NUMBER");
  IElementType BOOL_TYPE = new KCLTokenType("BOOL_TYPE");
  IElementType CHECK = new KCLTokenType("CHECK");
  IElementType COLON = new KCLTokenType("COLON");
  IElementType COMMA = new KCLTokenType("COMMA");
  IElementType COMMENT = new KCLTokenType("COMMENT");
  IElementType COMP_AND = new KCLTokenType("COMP_AND");
  IElementType COMP_DIVIDE = new KCLTokenType("COMP_DIVIDE");
  IElementType COMP_DOUBLE_DIVIDE = new KCLTokenType("COMP_DOUBLE_DIVIDE");
  IElementType COMP_DOUBLE_STAR = new KCLTokenType("COMP_DOUBLE_STAR");
  IElementType COMP_MINUS = new KCLTokenType("COMP_MINUS");
  IElementType COMP_MOD = new KCLTokenType("COMP_MOD");
  IElementType COMP_MULTIPLY = new KCLTokenType("COMP_MULTIPLY");
  IElementType COMP_OR = new KCLTokenType("COMP_OR");
  IElementType COMP_PLUS = new KCLTokenType("COMP_PLUS");
  IElementType COMP_SHIFT_LEFT = new KCLTokenType("COMP_SHIFT_LEFT");
  IElementType COMP_SHIFT_RIGHT = new KCLTokenType("COMP_SHIFT_RIGHT");
  IElementType COMP_XOR = new KCLTokenType("COMP_XOR");
  IElementType DEC_NUMBER = new KCLTokenType("DEC_NUMBER");
  IElementType DEDENT = new KCLTokenType("DEDENT");
  IElementType DIVIDE = new KCLTokenType("DIVIDE");
  IElementType DOT = new KCLTokenType("DOT");
  IElementType DOUBLE_DIVIDE = new KCLTokenType("DOUBLE_DIVIDE");
  IElementType DOUBLE_STAR = new KCLTokenType("DOUBLE_STAR");
  IElementType ELIF = new KCLTokenType("ELIF");
  IElementType ELSE = new KCLTokenType("ELSE");
  IElementType EQUAL_TO = new KCLTokenType("EQUAL_TO");
  IElementType FALSE = new KCLTokenType("FALSE");
  IElementType FILTER = new KCLTokenType("FILTER");
  IElementType FINAL = new KCLTokenType("FINAL");
  IElementType FLOAT_NUMBER = new KCLTokenType("FLOAT_NUMBER");
  IElementType FLOAT_TYPE = new KCLTokenType("FLOAT_TYPE");
  IElementType FOR = new KCLTokenType("FOR");
  IElementType GREATER_THAN = new KCLTokenType("GREATER_THAN");
  IElementType GREATER_THAN_OR_EQUAL_TO = new KCLTokenType("GREATER_THAN_OR_EQUAL_TO");
  IElementType HEX_NUMBER = new KCLTokenType("HEX_NUMBER");
  IElementType IF = new KCLTokenType("IF");
  IElementType IMPORT = new KCLTokenType("IMPORT");
  IElementType IN = new KCLTokenType("IN");
  IElementType INDENT = new KCLTokenType("INDENT");
  IElementType INT_TYPE = new KCLTokenType("INT_TYPE");
  IElementType IS = new KCLTokenType("IS");
  IElementType K_AND = new KCLTokenType("K_AND");
  IElementType K_NOT = new KCLTokenType("K_NOT");
  IElementType K_OR = new KCLTokenType("K_OR");
  IElementType K_TYPE = new KCLTokenType("K_TYPE");
  IElementType LAMBDA = new KCLTokenType("LAMBDA");
  IElementType LEFT_BRACE = new KCLTokenType("LEFT_BRACE");
  IElementType LEFT_BRACKETS = new KCLTokenType("LEFT_BRACKETS");
  IElementType LEFT_PARENTHESES = new KCLTokenType("LEFT_PARENTHESES");
  IElementType LESS_THAN = new KCLTokenType("LESS_THAN");
  IElementType LESS_THAN_OR_EQUAL_TO = new KCLTokenType("LESS_THAN_OR_EQUAL_TO");
  IElementType LONG_STRING = new KCLTokenType("LONG_STRING");
  IElementType MAP = new KCLTokenType("MAP");
  IElementType MINUS = new KCLTokenType("MINUS");
  IElementType MIXIN = new KCLTokenType("MIXIN");
  IElementType MOD = new KCLTokenType("MOD");
  IElementType MULTIPLY = new KCLTokenType("MULTIPLY");
  IElementType NAME = new KCLTokenType("NAME");
  IElementType NEWLINE = new KCLTokenType("NEWLINE");
  IElementType NONE = new KCLTokenType("NONE");
  IElementType NOT = new KCLTokenType("NOT");
  IElementType NOT_EQUAL_TO = new KCLTokenType("NOT_EQUAL_TO");
  IElementType OCT_NUMBER = new KCLTokenType("OCT_NUMBER");
  IElementType OR = new KCLTokenType("OR");
  IElementType PLUS = new KCLTokenType("PLUS");
  IElementType PROTOCOL = new KCLTokenType("PROTOCOL");
  IElementType QUESTION = new KCLTokenType("QUESTION");
  IElementType RELAXED = new KCLTokenType("RELAXED");
  IElementType RIGHT_ARROW = new KCLTokenType("RIGHT_ARROW");
  IElementType RIGHT_BRACE = new KCLTokenType("RIGHT_BRACE");
  IElementType RIGHT_BRACKETS = new KCLTokenType("RIGHT_BRACKETS");
  IElementType RIGHT_PARENTHESES = new KCLTokenType("RIGHT_PARENTHESES");
  IElementType SCHEMA = new KCLTokenType("SCHEMA");
  IElementType SHIFT_LEFT = new KCLTokenType("SHIFT_LEFT");
  IElementType SHIFT_RIGHT = new KCLTokenType("SHIFT_RIGHT");
  IElementType SI_G = new KCLTokenType("SI_G");
  IElementType SI_G_IEC = new KCLTokenType("SI_G_IEC");
  IElementType SI_K = new KCLTokenType("SI_K");
  IElementType SI_K_IEC = new KCLTokenType("SI_K_IEC");
  IElementType SI_K_L = new KCLTokenType("SI_K_L");
  IElementType SI_M = new KCLTokenType("SI_M");
  IElementType SI_M_IEC = new KCLTokenType("SI_M_IEC");
  IElementType SI_M_L = new KCLTokenType("SI_M_L");
  IElementType SI_N_L = new KCLTokenType("SI_N_L");
  IElementType SI_P = new KCLTokenType("SI_P");
  IElementType SI_P_IEC = new KCLTokenType("SI_P_IEC");
  IElementType SI_T = new KCLTokenType("SI_T");
  IElementType SI_T_IEC = new KCLTokenType("SI_T_IEC");
  IElementType SI_U_L = new KCLTokenType("SI_U_L");
  IElementType STRING = new KCLTokenType("STRING");
  IElementType STRING_TYPE = new KCLTokenType("STRING_TYPE");
  IElementType TRUE = new KCLTokenType("TRUE");
  IElementType UNDEFINED = new KCLTokenType("UNDEFINED");
  IElementType XOR = new KCLTokenType("XOR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_EXPR) {
        return new KCLAndExprImpl(node);
      }
      else if (type == AND_TEST) {
        return new KCLAndTestImpl(node);
      }
      else if (type == ARGUMENT) {
        return new KCLArgumentImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new KCLArgumentsImpl(node);
      }
      else if (type == ARITH_EXPR) {
        return new KCLArithExprImpl(node);
      }
      else if (type == ASSERT_STMT) {
        return new KCLAssertStmtImpl(node);
      }
      else if (type == ASSIGN_STMT) {
        return new KCLAssignStmtImpl(node);
      }
      else if (type == ATTRIBUTE_STMT) {
        return new KCLAttributeStmtImpl(node);
      }
      else if (type == BASIC_TYPE) {
        return new KCLBasicTypeImpl(node);
      }
      else if (type == CALL_SUFFIX) {
        return new KCLCallSuffixImpl(node);
      }
      else if (type == CHECK_BLOCK) {
        return new KCLCheckBlockImpl(node);
      }
      else if (type == CHECK_EXPR) {
        return new KCLCheckExprImpl(node);
      }
      else if (type == CHECK_TEST) {
        return new KCLCheckTestImpl(node);
      }
      else if (type == COMPARISON) {
        return new KCLComparisonImpl(node);
      }
      else if (type == COMPOUND_STMT) {
        return new KCLCompoundStmtImpl(node);
      }
      else if (type == COMPOUND_TYPE) {
        return new KCLCompoundTypeImpl(node);
      }
      else if (type == COMP_CLAUSE) {
        return new KCLCompClauseImpl(node);
      }
      else if (type == CONFIG_ENTRIES) {
        return new KCLConfigEntriesImpl(node);
      }
      else if (type == CONFIG_ENTRY) {
        return new KCLConfigEntryImpl(node);
      }
      else if (type == CONFIG_EXPR) {
        return new KCLConfigExprImpl(node);
      }
      else if (type == DECORATORS) {
        return new KCLDecoratorsImpl(node);
      }
      else if (type == DECORATOR_EXPR) {
        return new KCLDecoratorExprImpl(node);
      }
      else if (type == DICT_COMP) {
        return new KCLDictCompImpl(node);
      }
      else if (type == DICT_TYPE) {
        return new KCLDictTypeImpl(node);
      }
      else if (type == DOT_NAME) {
        return new KCLDotNameImpl(node);
      }
      else if (type == DOUBLE_STAR_EXPR) {
        return new KCLDoubleStarExprImpl(node);
      }
      else if (type == ENTRY) {
        return new KCLEntryImpl(node);
      }
      else if (type == EXECUTION_BLOCK) {
        return new KCLExecutionBlockImpl(node);
      }
      else if (type == EXPR) {
        return new KCLExprImpl(node);
      }
      else if (type == EXPR_STMT) {
        return new KCLExprStmtImpl(node);
      }
      else if (type == FACTOR) {
        return new KCLFactorImpl(node);
      }
      else if (type == FOR_MIXIN_HOST) {
        return new KCLForMixinHostImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new KCLIdentifierImpl(node);
      }
      else if (type == IF_ENTRY) {
        return new KCLIfEntryImpl(node);
      }
      else if (type == IF_ENTRY_EXEC_BLOCK) {
        return new KCLIfEntryExecBlockImpl(node);
      }
      else if (type == IF_EXPR) {
        return new KCLIfExprImpl(node);
      }
      else if (type == IF_ITEM) {
        return new KCLIfItemImpl(node);
      }
      else if (type == IF_ITEM_EXEC_BLOCK) {
        return new KCLIfItemExecBlockImpl(node);
      }
      else if (type == IF_SIMPLE_STMT) {
        return new KCLIfSimpleStmtImpl(node);
      }
      else if (type == IF_STMT) {
        return new KCLIfStmtImpl(node);
      }
      else if (type == IMPORT_STMT) {
        return new KCLImportStmtImpl(node);
      }
      else if (type == LAMBDA_EXPR) {
        return new KCLLambdaExprImpl(node);
      }
      else if (type == LEADING_DOTS) {
        return new KCLLeadingDotsImpl(node);
      }
      else if (type == LIST_COMP) {
        return new KCLListCompImpl(node);
      }
      else if (type == LIST_EXPR) {
        return new KCLListExprImpl(node);
      }
      else if (type == LIST_ITEM) {
        return new KCLListItemImpl(node);
      }
      else if (type == LIST_ITEMS) {
        return new KCLListItemsImpl(node);
      }
      else if (type == LIST_TYPE) {
        return new KCLListTypeImpl(node);
      }
      else if (type == LITERAL_TYPE) {
        return new KCLLiteralTypeImpl(node);
      }
      else if (type == LOOP_VARIABLES) {
        return new KCLLoopVariablesImpl(node);
      }
      else if (type == MIXINS) {
        return new KCLMixinsImpl(node);
      }
      else if (type == MIXIN_STMT) {
        return new KCLMixinStmtImpl(node);
      }
      else if (type == MULTILINE_MIXINS) {
        return new KCLMultilineMixinsImpl(node);
      }
      else if (type == NOT_TEST) {
        return new KCLNotTestImpl(node);
      }
      else if (type == OPERAND) {
        return new KCLOperandImpl(node);
      }
      else if (type == POWER) {
        return new KCLPowerImpl(node);
      }
      else if (type == PRIMARY_EXPR) {
        return new KCLPrimaryExprImpl(node);
      }
      else if (type == QUANT_EXPR) {
        return new KCLQuantExprImpl(node);
      }
      else if (type == QUANT_OP) {
        return new KCLQuantOpImpl(node);
      }
      else if (type == QUANT_TARGET) {
        return new KCLQuantTargetImpl(node);
      }
      else if (type == SCHEMA_ARGUMENT) {
        return new KCLSchemaArgumentImpl(node);
      }
      else if (type == SCHEMA_ARGUMENTS) {
        return new KCLSchemaArgumentsImpl(node);
      }
      else if (type == SCHEMA_ATTRIBUTE_STMT) {
        return new KCLSchemaAttributeStmtImpl(node);
      }
      else if (type == SCHEMA_BODY) {
        return new KCLSchemaBodyImpl(node);
      }
      else if (type == SCHEMA_EXPR) {
        return new KCLSchemaExprImpl(node);
      }
      else if (type == SCHEMA_INDEX_SIGNATURE) {
        return new KCLSchemaIndexSignatureImpl(node);
      }
      else if (type == SCHEMA_INIT_STMT) {
        return new KCLSchemaInitStmtImpl(node);
      }
      else if (type == SCHEMA_STMT) {
        return new KCLSchemaStmtImpl(node);
      }
      else if (type == SCHEMA_TYPE) {
        return new KCLSchemaTypeImpl(node);
      }
      else if (type == SELECT_SUFFIX) {
        return new KCLSelectSuffixImpl(node);
      }
      else if (type == SHIFT_EXPR) {
        return new KCLShiftExprImpl(node);
      }
      else if (type == SIMPLE_ASSIGN_STMT) {
        return new KCLSimpleAssignStmtImpl(node);
      }
      else if (type == SIMPLE_EXPR) {
        return new KCLSimpleExprImpl(node);
      }
      else if (type == SIMPLE_STMT) {
        return new KCLSimpleStmtImpl(node);
      }
      else if (type == SINGLE_NAME) {
        return new KCLSingleNameImpl(node);
      }
      else if (type == SLICE_SUFFIX) {
        return new KCLSliceSuffixImpl(node);
      }
      else if (type == STAR_EXPR) {
        return new KCLStarExprImpl(node);
      }
      else if (type == STATEMENT) {
        return new KCLStatementImpl(node);
      }
      else if (type == TERM) {
        return new KCLTermImpl(node);
      }
      else if (type == TEST) {
        return new KCLTestImpl(node);
      }
      else if (type == TESTLIST_EXPR) {
        return new KCLTestlistExprImpl(node);
      }
      else if (type == TYPE) {
        return new KCLTypeImpl(node);
      }
      else if (type == TYPE_ALIAS_STMT) {
        return new KCLTypeAliasStmtImpl(node);
      }
      else if (type == TYPE_CAST_EXPR) {
        return new KCLTypeCastExprImpl(node);
      }
      else if (type == TYPE_ELEMENT) {
        return new KCLTypeElementImpl(node);
      }
      else if (type == UNIFICATION_STMT) {
        return new KCLUnificationStmtImpl(node);
      }
      else if (type == XOR_EXPR) {
        return new KCLXorExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
