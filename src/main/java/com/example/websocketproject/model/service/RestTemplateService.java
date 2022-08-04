package com.example.websocketproject.model.service;

import java.util.Map;

public interface RestTemplateService {
    String sendRequest(String URN);

    String buildUrn(String path, Map<String, String> parameters);
}
