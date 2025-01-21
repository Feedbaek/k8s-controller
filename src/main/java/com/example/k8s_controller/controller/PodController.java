package com.example.k8s_controller.controller;

import com.example.k8s_controller.service.PodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pod")
public class PodController {

    private final PodService podService;

    /**
     * namespace에 등록된 파드 조회
     * */
    @GetMapping("")
    public List<String> pod(@RequestParam String namespace) {
        return podService.getPodList(namespace);
    }

    /**
     * namespace에 등록된 파드 상세 조회
     * */
    @GetMapping("/detail")
    public String podDetail(@RequestParam String namespace, @RequestParam String podName) {
        return podService.getPodDetail(namespace, podName);
    }

    /**
     * namespace에 등록된 파드 로그 조회
     * */
    @GetMapping("/log")
    public String podLog(@RequestParam String namespace, @RequestParam String podName) {
        return podService.getPodLog(namespace, podName);
    }
}
