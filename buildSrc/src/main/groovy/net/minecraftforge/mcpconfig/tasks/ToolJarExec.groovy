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
        if (cfg.jvmargs) {
            getJvmArgs().addAll(cfg.jvmargs)
        }
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
        workDir.get().getAsFile().mkdirs()
        this.preExec()
        super.apply()
        this.postExec()
    }

    public void log(File log) {
        getLogOutput().set(log)
    }
    
    protected void preExec(){}
    protected void postExec(){}
}