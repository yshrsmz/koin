/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.koin.java

import org.koin.core.Koin
import org.koin.core.context.GlobalContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.scope.ScopeInstance

/**
 * Koin Java Helper - inject/get into Java code
 *
 * @author @fredy-mederos
 * @author Arnaud Giuliani
 */
object KoinJavaComponent {

    /**
     * Retrieve given dependency lazily
     * @param clazz - dependency class
     * @param name - bean canonicalName / optional
     * @param scope
     * @param parameters - dependency parameters / optional
     */
    @JvmOverloads
    @JvmStatic
    fun <T : Any> inject(
        clazz: Class<T>,
        name: String? = null,
        scope: ScopeInstance? = null,
        parameters: ParametersDefinition? = null
    ): Lazy<T> {
        return lazy { get(clazz, name, scope, parameters) }
    }

    /**
     * Retrieve given dependency
     * @param clazz - dependency class
     * @param name - bean canonicalName / optional
     * @param scope - scope
     * @param parameters - dependency parameters / optional
     */
    @JvmOverloads
    @JvmStatic
    fun <T : Any> get(
        clazz: Class<T>,
        name: String? = null,
        scope: ScopeInstance? = null,
        parameters: ParametersDefinition? = null
    ): T {
        return getKoin().get(
            clazz.kotlin,
            name,
            scope,
            parameters
        )
    }

    /**
     * inject lazily given property
     * @param key - key property
     */
    @JvmStatic
    fun getKoin(): Koin = GlobalContext.get().koin
}