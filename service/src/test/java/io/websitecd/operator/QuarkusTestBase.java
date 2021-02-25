package io.websitecd.operator;

import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ServiceSpecBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentSpecBuilder;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.kubernetes.client.KubernetesMockServerTestResource;
import io.quarkus.test.kubernetes.client.MockServer;
import org.junit.jupiter.api.BeforeEach;

@QuarkusTest
@QuarkusTestResource(KubernetesMockServerTestResource.class)
public class QuarkusTestBase {

    @MockServer
    protected KubernetesMockServer mockServer;

    @BeforeEach
    protected void setupMockServer() {
        mockServer.expect()
                .get().withPath("/apis/apiextensions.k8s.io/v1/customresourcedefinitions")
                .andReturn(200, new CustomResourceDefinitionBuilder().build())
                .always();

        mockServer.expect()
                .post().withPath("/api/v1/namespaces/websitecd-examples/configmaps")
                .andReturn(200, new ConfigMapBuilder().build())
                .always();

        mockServer.expect()
                .post().withPath("/api/v1/namespaces/websitecd-examples/services")
                .andReturn(200, new ServiceSpecBuilder().build())
                .always();

        mockServer.expect()
                .post().withPath("/apis/apps/v1/namespaces/websitecd-examples/deployments")
                .andReturn(200, new DeploymentSpecBuilder().build())
                .always();
    }
}
