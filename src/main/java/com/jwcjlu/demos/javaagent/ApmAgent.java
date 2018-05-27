package com.jwcjlu.demos.javaagent;

import com.jwcjlu.demos.bytebuddy.InstMethodInter;
import com.jwcjlu.demos.bytebuddy.LostTimeMethodAroundInterceptor;
import com.jwcjlu.demos.javaagent.annotation.Apm;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;


public class ApmAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation)  {
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(new Transformer())
                .installOn(instrumentation);


    }
    private static class Transformer implements AgentBuilder.Transformer {


        @Override
        public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
            DynamicType.Builder<?>  newClassBuilder= builder.method(ElementMatchers.isAnnotatedWith(Apm.class)).intercept(
                    MethodDelegation.to(new InstMethodInter(new LostTimeMethodAroundInterceptor()))
                            .andThen(SuperMethodCall.INSTANCE)
            );
            if(newClassBuilder!=null){
                return newClassBuilder;
            }
            return builder;
        }
    }

}
