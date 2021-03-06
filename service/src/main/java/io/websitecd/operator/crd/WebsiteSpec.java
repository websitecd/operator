package io.websitecd.operator.crd;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;

@RegisterForReflection
public class WebsiteSpec {

    String gitUrl;
    String branch;
    String dir;
    Boolean sslVerify = true;
    String secretToken;
    WebsiteEnvs envs;

    public WebsiteSpec() {
    }

    public WebsiteSpec(String gitUrl, String branch, String dir, Boolean sslVerify, String secretToken) {
        this.gitUrl = gitUrl;
        this.branch = branch;
        this.dir = dir;
        this.sslVerify = sslVerify;
        this.secretToken = secretToken;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Boolean getSslVerify() {
        return sslVerify;
    }

    public void setSslVerify(Boolean sslVerify) {
        this.sslVerify = sslVerify;
    }

    public String getSecretToken() {
        return secretToken;
    }

    public void setSecretToken(String secretToken) {
        this.secretToken = secretToken;
    }

    public WebsiteEnvs getEnvs() {
        return envs;
    }

    public void setEnvs(WebsiteEnvs envs) {
        this.envs = envs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WebsiteSpec{");
        sb.append("gitUrl='").append(gitUrl).append('\'');
        sb.append(", branch='").append(branch).append('\'');
        sb.append(", dir='").append(dir).append('\'');
        sb.append(", sslVerify=").append(sslVerify);
        sb.append(", envs=").append(envs);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebsiteSpec that = (WebsiteSpec) o;
        return gitUrl.equals(that.gitUrl) && Objects.equals(branch, that.branch) && Objects.equals(dir, that.dir) && Objects.equals(sslVerify, that.sslVerify) && Objects.equals(secretToken, that.secretToken) && Objects.equals(envs, that.envs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gitUrl, branch, dir, sslVerify, secretToken, envs);
    }
}
