package org.example.immutable.practice;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.immutables.value.Value;

/**
 * cong 抽象类 创建immutable class
 */
@Value.Immutable
public interface FoobarValue {
  public int foo();
  public String bar();
  public List<Integer> buz();
  public Set<Long> crux();
  public List<Animal> animalList();
  public Map<String, Animal> animalMap();

}