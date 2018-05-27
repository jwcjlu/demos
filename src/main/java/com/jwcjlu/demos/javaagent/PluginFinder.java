/*
package com.jwcjlu.demos.javaagent;

import com.jwcjlu.demos.javaagent.plugin.Plugins;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.StringMatcher;

import java.util.*;

import static net.bytebuddy.matcher.ElementMatchers.isInterface;
import static net.bytebuddy.matcher.ElementMatchers.not;

public class PluginFinder {
    private final Map<String, LinkedList<Plugins>> nameMatchDefine = new HashMap<String, LinkedList<Plugins>>();
    private final List<Plugins> signatureMatchDefine = new LinkedList<Plugins>();
    public PluginFinder(){

    }
    public void initialization(){
        ServiceLoader<Plugins> services=ServiceLoader.load(Plugins.class);
        Iterator<Plugins> plugins = services.iterator();
        while(plugins.hasNext()){
            Plugins plugin=  plugins.next();
            plugin.getClass();

        }
    }

    public ElementMatcher<? super TypeDescription> buildMatch() {
        ElementMatcher.Junction  judge = new AbstractJunction<NamedElement>() {
            @Override
            public boolean matches(NamedElement target) {
                return nameMatchDefine.containsKey(target.getActualName());
            }
        };

        judge = judge.and(not(isInterface()));
        for (Plugins define : signatureMatchDefine) {
                judge = judge.or(new StringMatcher(define.enhanceClass(), StringMatcher.Mode.EQUALS_FULLY));
        }
        return judge;
    }
}
abstract class AbstractJunction <V> implements ElementMatcher.Junction<V> {
    @Override
    public <U extends V> Junction<U> and(ElementMatcher<? super U> other) {
        return new Conjunction<U>(this, other);
    }

    @Override
    public <U extends V> Junction<U> or(ElementMatcher<? super U> other) {
        return new Disjunction<U>(this, other);
    }
}
*/
