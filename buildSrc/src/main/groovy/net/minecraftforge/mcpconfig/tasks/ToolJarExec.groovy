package net.minecraftforge.mcpconfig.tasks;

import org.gradle.api.tasks.*
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.jvm.toolchain.JavaToolchainService
import net.minecraftforge.gradle.common.tasks.*

import javax.inject.Inject

abstract class ToolJarExec extends JarExec {
    def config(def cfg) {
        getTool().set(cfg.version)
        getArgs().addAll(cfg.args)
        //jvmArgs = cfg.jvmargs // TODO: JarExec doesnt allow for jvmArgs currently
    }

    ToolJarExec() {
        def javaTarget = project.ext.JAVA_TARGET
        if (javaTarget != null) {
            setRuntimeJavaVersion(javaTarget)
        }
    }

    @Inject
    JavaToolchainService getJavaToolchainService() {
        throw new UnsupportedOperationException()
    }

    @Override
    public final void apply() {
        this.preExec()
        super.apply()
        this.postExec()
    }
    
    protected void preExec(){}
    protected void postExec(){}
}