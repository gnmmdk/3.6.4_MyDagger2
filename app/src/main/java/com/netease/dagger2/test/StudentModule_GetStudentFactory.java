package com.netease.dagger2.test;

import com.netease.dagger2.Student;
import com.netease.dagger2.StudentModule;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StudentModule_GetStudentFactory implements Factory<Student> {
  private final StudentModule module;

  public StudentModule_GetStudentFactory(StudentModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Student get() {
    return Preconditions.checkNotNull(
        module.getStudent(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Student> create(StudentModule module) {
    return new StudentModule_GetStudentFactory(module);
  }
}
