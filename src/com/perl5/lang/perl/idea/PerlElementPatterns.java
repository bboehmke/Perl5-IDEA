/*
 * Copyright 2015 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.idea;

import com.intellij.patterns.ElementPattern;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.perl5.lang.mojolicious.psi.impl.MojoliciousFileImpl;
import com.perl5.lang.perl.lexer.PerlElementTypes;
import com.perl5.lang.perl.psi.*;
import com.perl5.lang.perl.psi.impl.PerlStringContentElementImpl;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.PlatformPatterns.psiFile;

/**
 * Created by hurricup on 31.05.2015.
 */
public interface PerlElementPatterns extends PerlElementTypes
{
	PsiElementPattern.Capture<PerlStringContentElementImpl> STRING_CONENT_PATTERN = psiElement(PerlStringContentElementImpl.class);
	ElementPattern<PsiElement> SQ_OPENING_QUOTE = psiElement(QUOTE_SINGLE_OPEN);
	PsiElementPattern.Capture<PerlStringContentElementImpl> SQ_STRING_BEGIN = STRING_CONENT_PATTERN.afterLeaf(SQ_OPENING_QUOTE).inside(PsiPerlStringSq.class);
	ElementPattern<PsiElement> DQ_OPENING_QUOTE = psiElement(QUOTE_DOUBLE_OPEN);
	PsiElementPattern.Capture<PerlStringContentElementImpl> DQ_STRING_BEGIN = STRING_CONENT_PATTERN.afterLeaf(DQ_OPENING_QUOTE).inside(PsiPerlStringDq.class);
	PsiElementPattern.Capture<PerlStringContentElementImpl> QW_STRING_LIST = STRING_CONENT_PATTERN.inside(PsiPerlStringList.class);

	PsiElementPattern.Capture<PerlNamespaceElement> NAMESPACE_NAME_PATTERN = psiElement(PerlNamespaceElement.class);
	PsiElementPattern.Capture<PsiPerlUseStatement> USE_STATEMENT_PATTERN = psiElement(PsiPerlUseStatement.class);
	PsiElementPattern.Capture<PerlSubNameElement> SUB_NAME_PATTERN = psiElement(PerlSubNameElement.class);

	PsiElementPattern.Capture<PsiPerlMethod> METHOD_PATTERN = psiElement(PsiPerlMethod.class);
	PsiElementPattern.Capture IN_OBJECT_CALL_PATTERN = psiElement().withParent(PsiPerlNestedCall.class);

	PsiElementPattern.Capture IN_STATIC_METHOD_PATTERN = psiElement().withParent(METHOD_PATTERN.andNot(IN_OBJECT_CALL_PATTERN));
	PsiElementPattern.Capture IN_OBJECT_METHOD_PATTERN = psiElement().withParent(METHOD_PATTERN.and(IN_OBJECT_CALL_PATTERN));

	PsiElementPattern.Capture<PerlVariable> VARIABLE_PATTERN = psiElement(PerlVariable.class);
	PsiElementPattern.Capture<PerlGlobVariable> GLOB_PATTERN = psiElement(PerlGlobVariable.class);

	PsiElementPattern.Capture IN_VARIABLE_PATTERN = psiElement().inside(VARIABLE_PATTERN);
	PsiElementPattern.Capture IN_GLOB_PATTERN = psiElement().inside(GLOB_PATTERN);

	// fixme move this to mojo patterns
	PsiElementPattern.Capture IN_MOJOLICIOUS_FILE = psiElement().inFile(psiFile(MojoliciousFileImpl.class));

	PsiElementPattern.Capture<PerlVariableNameElement> VARIABLE_NAME_PATTERN = psiElement(PerlVariableNameElement.class);
	PsiElementPattern.Capture<PsiElement> UNKNOWN_ANNOTATION_PATTERN = psiElement(PerlElementTypes.ANNOTATION_UNKNOWN_KEY);

	PsiElementPattern.Capture INSIDE_SUB_SIGNATURE = psiElement().inside(PsiPerlSubSignatureContent.class);
	PsiElementPattern.Capture INSIDE_LEXICAL_DECLARATION = psiElement().inside(PsiPerlVariableDeclarationLexical.class);
	PsiElementPattern.Capture INSIDE_GLOBAL_DECLARATION = psiElement().inside(PsiPerlVariableDeclarationGlobal.class);
	PsiElementPattern.Capture INSIDE_USE_VARS = psiElement().inside(IPerlUseVars.class);


	PsiElementPattern.Capture<PerlVariableNameElement> VARIABLE_COMPLETION_PATTERN =
			VARIABLE_NAME_PATTERN.andOr(IN_VARIABLE_PATTERN, IN_GLOB_PATTERN)
					.andNot(INSIDE_GLOBAL_DECLARATION)
					.andNot(INSIDE_LEXICAL_DECLARATION)
					.andNot(INSIDE_SUB_SIGNATURE)
					.andNot(INSIDE_USE_VARS);


	PsiElementPattern.Capture<PsiPerlIfCompound> INCOMPLETED_IF_COMPOUND =
			psiElement(PsiPerlIfCompound.class)
					.andNot(
							psiElement()
									.withLastChild(psiElement(PsiPerlUnconditionalBlock.class)));
	PsiElementPattern.Capture<PerlSubNameElement> ELSE_ELSIF_PLACE =
			psiElement(PerlSubNameElement.class)
					.withParent(PsiPerlMethod.class)
					.withSuperParent(2, psiElement(PsiPerlNamedListExpr.class))
					.withSuperParent(3, psiElement(PsiPerlStatement.class).afterSibling(INCOMPLETED_IF_COMPOUND));

}
