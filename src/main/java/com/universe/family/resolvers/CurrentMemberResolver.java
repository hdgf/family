package com.universe.family.resolvers;

import com.universe.family.annotation.CurrentMember;
import com.universe.family.config.Constants;
import com.universe.family.model.cronous.member.Member;
import com.universe.family.model.cronous.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 增加方法注入，将含有CurrentMember注解的方法参数注入当前登录用户
 * @see com.universe.family.annotation.CurrentMember
 * @author ScienJus
 * @date 2015/7/31.
 */
@Component
public class CurrentMemberResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是Member并且有CurrentMember注解则支持
        System.out.println("supportsParameter executed!");
        if (parameter.getParameterType().isAssignableFrom(Member.class) &&
                parameter.hasParameterAnnotation(CurrentMember.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //取出鉴权时存入的登录用户Id
        String strUserId = (String) webRequest.getAttribute(Constants.CURRENT_USER_ID, RequestAttributes.SCOPE_REQUEST);

        if (strUserId != null) {
            //从数据库中查询并返回
            return memberRepository.findOne(Integer.valueOf(strUserId));
        }

        throw new MissingServletRequestPartException(Constants.CURRENT_USER_ID);
    }
}
