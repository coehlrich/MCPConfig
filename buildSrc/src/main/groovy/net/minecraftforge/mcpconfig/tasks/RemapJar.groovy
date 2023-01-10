package net.minecraftforge.mcpconfig.tasks;

import org.gradle.api.*
import org.gradle.api.tasks.*

abstract class RemapJar extends ToolJarExec {
    @InputFile File mappings
    @InputFile File input
    @InputFile File libraries
    @OutputFile File dest
    
    @Override
    protected List<String> filterArgs(List<String> args) {
        return replaceArgs(args, [
            '{mappings}': mappings.absolutePath,
            '{input}': input.absolutePath,
            '{output}': dest.absolutePath,
            '{libraries}': libraries.absolutePath
        ], null)
    }
}