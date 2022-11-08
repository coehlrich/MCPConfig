package net.minecraftforge.mcpconfig.tasks;

import org.gradle.api.*
import org.gradle.api.tasks.*

abstract class ExtractBundleJar extends ToolJarExec {
    @InputFile File input
    @OutputFile File dest
    
    ExtractBundleJar() {
        setHasLog(false)
    }
    
    @Override
    protected List<String> filterArgs(List<String> args) {
        return replaceArgs(args, [
            '{input}': input.absolutePath,
            '{output}': dest.absolutePath
        ], null)
    }
}