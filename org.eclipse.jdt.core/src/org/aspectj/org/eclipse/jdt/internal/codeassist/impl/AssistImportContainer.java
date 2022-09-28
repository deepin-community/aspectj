/*******************************************************************************
 * Copyright (c) 2008, 2013 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.aspectj.org.eclipse.jdt.internal.codeassist.impl;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.aspectj.org.eclipse.jdt.core.IImportDeclaration;
import org.aspectj.org.eclipse.jdt.core.JavaModelException;
import org.aspectj.org.eclipse.jdt.internal.core.CompilationUnit;
import org.aspectj.org.eclipse.jdt.internal.core.ImportContainer;

@SuppressWarnings("rawtypes")
public class AssistImportContainer extends ImportContainer {
	private Map infoCache;
	public AssistImportContainer(CompilationUnit parent, Map infoCache) {
		super(parent);
		this.infoCache = infoCache;
	}

	@Override
	public Object getElementInfo(IProgressMonitor monitor) throws JavaModelException {
		return this.infoCache.get(this);
	}

	@Override
	protected IImportDeclaration getImport(String importName, boolean isOnDemand) {
		return new AssistImportDeclaration(this, importName, isOnDemand, this.infoCache);
	}
}
