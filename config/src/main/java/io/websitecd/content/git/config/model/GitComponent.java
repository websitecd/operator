package io.websitecd.content.git.config.model;

public class GitComponent {
    String dir;
    String kind;
    GitSpec spec;

    public GitComponent(String dir, String kind, GitSpec spec) {
        this.dir = dir;
        this.kind = kind;
        this.spec = spec;
    }

    public GitComponent(String dir, String kind, String gitUrl, String gitRef, String gitDir) {
        this.dir = dir;
        this.kind = kind;
        this.spec = new GitSpec(gitUrl, gitRef, gitDir);
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public GitSpec getSpec() {
        return spec;
    }

    public void setSpec(GitSpec spec) {
        this.spec = spec;
    }
}
