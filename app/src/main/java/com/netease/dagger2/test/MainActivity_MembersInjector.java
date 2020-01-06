package com.netease.dagger2.test;

import com.netease.dagger2.MainActivity;
import com.netease.dagger2.Student;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.MembersInjector;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Student> studentProvider;

  public MainActivity_MembersInjector(Provider<Student> studentProvider) {
    assert studentProvider != null;
    this.studentProvider = studentProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<Student> studentProvider) {
    return new MainActivity_MembersInjector(studentProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.student = studentProvider.get();
  }

  public static void injectStudent(MainActivity instance, Provider<Student> studentProvider) {
    instance.student = studentProvider.get();
  }
}
