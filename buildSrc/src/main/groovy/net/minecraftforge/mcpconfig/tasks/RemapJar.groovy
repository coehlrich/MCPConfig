package net.minecraftforge.mcpconfig.tasks;

import org.gradle.api.*
import org.gradle.api.tasks.*

abstract class RemapJar extends ToolJarExec {
    @InputFile File mappings
    @InputFile File input
    @InputFile File libraries
    @OutputFile File dest
    @OutputFile @Optional File log = null
    
    RemapJar() {
        setHasLog(log != null)
    }
    
    @Override
    protected List<String> filterArgs(List<String> args) {
        return replaceArgs(args, [
            '{mappings}': mappings.absolutePath,
            '{input}': input.absolutePath,
            '{output}': dest.absolutePath,
            '{libraries}': libraries.absolutePath
        ], null)
    }
    
    @Override
    protected void preExec() {
        def logStream = log == null ? JarExec.NULL_OUTPUT : log.newOutputStream()
        //standardOutput logStream // TODO: log
        //errorOutput logStream
    }
}