package net.minecraftforge.mcpconfig.tasks;

import org.gradle.api.*
import org.gradle.api.tasks.*

abstract class ExtractBundleLibs extends ToolJarExec {
    @InputFile File input
    @OutputDirectory File dest
    
    ExtractBundleLibs() {
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