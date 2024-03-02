package org.example.immutable.practice;

import org.immutables.builder.Builder;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * 从 interface 创建immutable
 */
@Value.Immutable
public interface FoobarValueInterface {
  public abstract int foo();
  public abstract String bar();
  public abstract List<Integer> buz();
  public abstract Set<Long> crux();

  @Builder.Factory
  public static int sum(Optional<Integer> a, Optional<Integer> b) {
    return a.orElse(0) + b.orElse(0);
  }
}