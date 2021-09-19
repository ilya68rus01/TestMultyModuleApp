package com.example.moduleinjector

import java.lang.ref.WeakReference

class ComponentHolderDelegate<API : BaseFeatureApi, DEPENDENCIES : BaseFeatureDependencies, COMPONENT : API>(
    private val componentFactory: (DEPENDENCIES) -> COMPONENT
) : ComponentHolder<API, DEPENDENCIES> {

    override var dependencyProvider: (() -> DEPENDENCIES)? = null

    private var componentWeakRef: WeakReference<COMPONENT>? = null

    fun getComponentImpl(): COMPONENT {
        var component: COMPONENT? = null

        synchronized(this) {
            dependencyProvider?.let { dependencyProvider ->
                component = componentWeakRef?.get()
                if (component == null) {
                    component = componentFactory(dependencyProvider())
                    componentWeakRef = WeakReference(component)
                }
            } ?: throw IllegalStateException("dependencyProvider for component with factory $componentFactory is not initialized")
        }

        return component ?: throw IllegalStateException("Component holder with component factory $componentFactory is not initialized")
    }

    override fun get(): API {
        return getComponentImpl()
    }
}
