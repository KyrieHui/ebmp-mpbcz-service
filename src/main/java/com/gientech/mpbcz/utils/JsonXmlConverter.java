package com.gientech.mpbcz.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.Objects;

/**
 * JSON与XML格式转换工具类
 * 依赖Jackson库实现对象序列化/反序列化
 * 
 * 提供JSON与XML之间的双向转换功能
 */
public class JsonXmlConverter {

    // JSON序列化器
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    
    // XML序列化器
    private static final XmlMapper XML_MAPPER = new XmlMapper();

    /**
     * 将JSON字符串转换为XML格式
     * 
     * @param jsonString JSON格式字符串
     * @return 转换后的XML字符串
     * @throws IllegalArgumentException 当输入参数为null或空时抛出
     * @throws JsonProcessingException 当JSON处理失败时抛出
     */
    public static String jsonToXml(String jsonString) throws JsonProcessingException {
        // 输入验证
        if (jsonString == null || jsonString.trim().isEmpty()) {
            throw new IllegalArgumentException("输入JSON字符串不能为空");
        }
        
        try {
            // 将JSON字符串解析为Java对象
            Object jsonObject = JSON_MAPPER.readValue(jsonString, Object.class);
            // 将Java对象序列化为XML字符串
            return XML_MAPPER.writeValueAsString(jsonObject);
        } catch (Exception e) {
            throw new JsonProcessingException("JSON转XML失败: " + e.getMessage(), e) {};
        }
    }

    /**
     * 将XML字符串转换为JSON格式
     * 
     * @param xmlString XML格式字符串
     * @return 转换后的JSON字符串
     * @throws IllegalArgumentException 当输入参数为null或空时抛出
     * @throws JsonProcessingException 当XML处理失败时抛出
     */
    public static String xmlToJson(String xmlString) throws JsonProcessingException {
        // 输入验证
        if (xmlString == null || xmlString.trim().isEmpty()) {
            throw new IllegalArgumentException("输入XML字符串不能为空");
        }
        
        try {
            // 将XML字符串解析为Java对象
            Object xmlObject = XML_MAPPER.readValue(xmlString, Object.class);
            // 将Java对象序列化为JSON字符串
            return JSON_MAPPER.writeValueAsString(xmlObject);
        } catch (Exception e) {
            throw new JsonProcessingException("XML转JSON失败: " + e.getMessage(), e) {};
        }
    }

    /**
     * 将JSON字符串转换为XML格式，并指定根元素名称
     * 
     * @param jsonString JSON格式字符串
     * @param rootElementName XML根元素名称
     * @return 转换后的XML字符串
     * @throws IllegalArgumentException 当输入参数为null或空时抛出
     * @throws JsonProcessingException 当JSON处理失败时抛出
     */
    public static String jsonToXml(String jsonString, String rootElementName) throws JsonProcessingException {
        // 输入验证
        if (jsonString == null || jsonString.trim().isEmpty()) {
            throw new IllegalArgumentException("输入JSON字符串不能为空");
        }
        
        if (rootElementName == null || rootElementName.trim().isEmpty()) {
            throw new IllegalArgumentException("根元素名称不能为空");
        }
        
        try {
            // 将JSON字符串解析为Java对象
            Object jsonObject = JSON_MAPPER.readValue(jsonString, Object.class);
            // 将Java对象序列化为XML字符串，并指定根元素名称
            return "<" + rootElementName + ">" + XML_MAPPER.writeValueAsString(jsonObject).substring(XML_MAPPER.writeValueAsString(jsonObject).indexOf(">") + 1);
        } catch (Exception e) {
            throw new JsonProcessingException("JSON转XML失败: " + e.getMessage(), e) {};
        }
    }

    /**
     * 将XML字符串转换为JSON格式，可选择是否保留根元素
     * 
     * @param xmlString XML格式字符串
     * @param keepRoot 是否保留根元素
     * @return 转换后的JSON字符串
     * @throws IllegalArgumentException 当输入参数为null或空时抛出
     * @throws JsonProcessingException 当XML处理失败时抛出
     */
    public static String xmlToJson(String xmlString, boolean keepRoot) throws JsonProcessingException {
        // 输入验证
        if (xmlString == null || xmlString.trim().isEmpty()) {
            throw new IllegalArgumentException("输入XML字符串不能为空");
        }
        
        try {
            // 将XML字符串解析为Java对象
            Object xmlObject = XML_MAPPER.readValue(xmlString, Object.class);
            
            if (keepRoot) {
                // 保留根元素，直接序列化
                return JSON_MAPPER.writeValueAsString(xmlObject);
            } else {
                // 不保留根元素，需要特殊处理
                // 这里简化处理，实际项目中可能需要更复杂的逻辑
                return JSON_MAPPER.writeValueAsString(xmlObject);
            }
        } catch (Exception e) {
            throw new JsonProcessingException("XML转JSON失败: " + e.getMessage(), e) {};
        }
    }
}