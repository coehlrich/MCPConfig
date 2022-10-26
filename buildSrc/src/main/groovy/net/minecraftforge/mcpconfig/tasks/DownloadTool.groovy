package net.minecraftforge.mcpconfig.tasks

import org.gradle.api.*
import org.gradle.api.tasks.*
import net.minecraftforge.gradle.common.tasks.*

public abstract class DownloadTool extends DownloadMavenArtifact {
    @Input config
    @Input root
    
    def config(def cfg, def root) {
        this.config = cfg
        this.root = root
        setArtifact cfg.version
        getOutput().set new File(root + cfg.path)
    }
}