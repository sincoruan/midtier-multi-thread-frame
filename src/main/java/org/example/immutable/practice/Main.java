package org.example.immutable.practice;

public class Main {
    public static void main(String[] args) {
        // 创建immutable object
        ImmutableFoobarValue foobar
                = ImmutableFoobarValue.builder().bar("bar").foo(1).build();
        // 从现有的object复制生成新的,并且传入新的bar 属性
        ImmutableFoobarValue newFooBar = foobar.withBar("abc");
        System.out.println(foobar);
        System.out.println(newFooBar);
        System.out.println(newFooBar.equals(ImmutableFoobarValue.copyOf(newFooBar)));
    }
}
