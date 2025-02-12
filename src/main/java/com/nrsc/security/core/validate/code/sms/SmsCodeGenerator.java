package com.nrsc.security.core.validate.code.sms;

import com.nrsc.security.core.properties.NrscSecurityProperties;
import com.nrsc.security.core.validate.code.ValidateCode;
import com.nrsc.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author: Sun Chuan
 * @date: 2019/7/9 12:29
 * @Description: 注意验证码+ 超时时间可以进行配置
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private NrscSecurityProperties nrscSecurityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(nrscSecurityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, nrscSecurityProperties.getCode().getSms().getExpireIn());
    }
}
