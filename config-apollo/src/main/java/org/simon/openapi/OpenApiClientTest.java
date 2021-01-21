package org.simon.openapi;

import com.google.common.annotations.VisibleForTesting;

import com.ctrip.framework.apollo.openapi.client.ApolloOpenApiClient;
import com.ctrip.framework.apollo.openapi.dto.NamespaceReleaseDTO;
import com.ctrip.framework.apollo.openapi.dto.OpenAppNamespaceDTO;
import com.ctrip.framework.apollo.openapi.dto.OpenItemDTO;
import com.ctrip.framework.apollo.openapi.dto.OpenNamespaceDTO;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @since 2020-08-25 10:44
 */
@Slf4j
public class OpenApiClientTest {

    private String token = "81a7c7a733cdd741afa6529571c669d3474e00f3";
    private String portalUrl = "http://192.168.251.169:10000/";
    private String modifiedBy = "apollo";
    private String env = "PROD";

    private ApolloOpenApiClient client;

    @Before
    public void init(){
        this.client = ApolloOpenApiClient.newBuilder()
                .withPortalUrl(portalUrl)
                .withToken(token)
                .build();
    }


    @Test
    public void createOrUpdateItemTest(){
        try {
            System.setProperty("idc", "CDNODE02");
            OpenNamespaceDTO ns = client.getNamespace("Project-Yusp", "PROD", null, "test01");


            OpenItemDTO item = new OpenItemDTO();
            item.setKey("k01");
            item.setValue("v01222");
            item.setDataChangeCreatedBy(modifiedBy);
            //item.setDataChangeLastModifiedBy(modifiedBy);
            item.setDataChangeCreatedTime(new Date());
            //必须namespace存在，否则报错
            client.createOrUpdateItem("test-App01", env, null, "file02", item);

            Thread.sleep(500L); // 2个接口之间暂停一会儿
            NamespaceReleaseDTO releaseDTO = new NamespaceReleaseDTO();
            releaseDTO.setReleaseTitle("update by program");
            releaseDTO.setReleasedBy(modifiedBy);
            releaseDTO.setEmergencyPublish(true);
            releaseDTO.setReleaseComment("");
            client.publishNamespace("test-App01", env, null, "file01", releaseDTO);
        } catch (Exception e) {
            log.error("Failed to publish Apollo configuration items!", e);
        }
    }


    @Test
    public void createAppNamespace(){
        OpenAppNamespaceDTO dto = new OpenAppNamespaceDTO();
        dto.setAppId("test-App01");
        dto.setName("file01");
        dto.setFormat("properties");
        dto.setPublic(false);
        dto.setDataChangeCreatedBy(modifiedBy);
        OpenAppNamespaceDTO ret = client.createAppNamespace(dto);
        System.out.println(ret);
    }

    @Test
    public void createOrUpdateItemTest02(){
        try {
            OpenItemDTO item = new OpenItemDTO();
            item.setKey("content");
            item.setValue("{'k1:':'v1111',\r\n 'k2':'v22222', 'k3':'v3333'}");
            item.setDataChangeCreatedBy(modifiedBy);
            //item.setDataChangeLastModifiedBy(modifiedBy);
            item.setDataChangeCreatedTime(new Date());
            //必须namespace存在，否则报错
            client.createOrUpdateItem("test-App01", env, null, "file04.json", item);

            Thread.sleep(500L); // 2个接口之间暂停一会儿
            NamespaceReleaseDTO releaseDTO = new NamespaceReleaseDTO();
            releaseDTO.setReleaseTitle("update by program");
            releaseDTO.setReleasedBy(modifiedBy);
            releaseDTO.setEmergencyPublish(true);
            releaseDTO.setReleaseComment("");
            client.publishNamespace("test-App01", env, null, "file04.json", releaseDTO);
        } catch (Exception e) {
            log.error("Failed to publish Apollo configuration items!", e);
        }
    }

    @Test
    public void createOrUpdateItemTest03(){
        try {
            OpenItemDTO item = new OpenItemDTO();
            item.setKey("content");
            item.setValue("{'k1:':'v1111',\r\n 'k2':'v22222', 'k3':'v3333'}");
            item.setDataChangeCreatedBy(modifiedBy);
            //item.setDataChangeLastModifiedBy(modifiedBy);
            item.setDataChangeCreatedTime(new Date());
            //必须namespace存在，否则报错
            client.createOrUpdateItem("test-App01", env, null, "file04.json", item);

            Thread.sleep(500L); // 2个接口之间暂停一会儿
            NamespaceReleaseDTO releaseDTO = new NamespaceReleaseDTO();
            releaseDTO.setReleaseTitle("update by program");
            releaseDTO.setReleasedBy(modifiedBy);
            releaseDTO.setEmergencyPublish(true);
            releaseDTO.setReleaseComment("");
            client.publishNamespace("test-App01", env, null, "file04.json", releaseDTO);
        } catch (Exception e) {
            log.error("Failed to publish Apollo configuration items!", e);
        }
    }

    @Test
    public void getItem(){
        try {
            OpenItemDTO ret = client.getItem("test-App01", env, null, "file03", "kkkkk1");
            System.out.println(ret.getValue());
        } catch (Exception e) {
            log.error("Failed to publish Apollo configuration items!", e);
        }
    }

    @Test
    public void getItem2(){
        try {
            OpenItemDTO ret = client.getItem("test-App01", env, null, "file04.json", "content");
            System.out.println(ret.getValue());
        } catch (Exception e) {
            log.error("Failed to publish Apollo configuration items!", e);
        }
    }
}