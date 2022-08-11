package com.xiumu.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.generator.entity.CodeTemplate;
import com.xiumu.generator.mapper.CodeTemplateMapper;
import com.xiumu.generator.service.CodeTemplateService;
import org.springframework.stereotype.Service;

/**
 * @Author XiuMu
 * @Date 2022/8/11
 **/
@Service
public class CodeTemplateServiceImpl extends ServiceImpl<CodeTemplateMapper, CodeTemplate> implements CodeTemplateService {
}
