package com.jwcjlu.demos.netty;

import io.netty.util.Recycler;

/**
 * Created by jwcjlu on 2019/5/22.
 */
public class RecycleTest {
    private static final Recycler<User> RECYCLER = new Recycler<User>() {
        //没有对象的时候，新建一个对象， 会传入一个handler，在Recycler池里，所有的对象都会转成DefaultHandle对象
        @Override
        protected User newObject(Handle handle) {
            return new User(handle);
        }
    };

    private static class User {
        private final Recycler.Handle handle;

        public User(Recycler.Handle handle) {
            this.handle = handle;
        }


    }

    public static void main(String[] args) {
        User user = RECYCLER.get();
        //直接调用user方法进行对象的回收
        RECYCLER.recycle(user,user.handle);

        User user1 = RECYCLER.get();
        //这里会返回true
        System.out.println(user1 == user);
    }
}
