package com.example.k8s_controller.service;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "PodService")
public class PodService {

    private final KubernetesClient kubernetesClient;

    public List<String> getPodList(String namespace) {
        // namespace에 등록된 파드 리스트 조회
        PodList podList = kubernetesClient.pods().inNamespace(namespace).list();

        return podList.getItems().stream()
                .map(pod -> pod.getMetadata().getName())
                .toList();
    }

    public String getPodDetail(String namespace, String podName) {
        // namespace에 등록된 파드 상세 조회
        Pod pod = kubernetesClient.pods().inNamespace(namespace).withName(podName).get();

        return Serialization.asYaml(pod);
    }

    public String getPodLog(String namespace, String podName) {
        // namespace에 등록된 파드 로그 조회
        return kubernetesClient.pods().inNamespace(namespace).withName(podName).getLog();
    }
}
