package com.netease.dagger2.test;

import com.netease.dagger2.MainActivity;
import com.netease.dagger2.MainActivity2;
import com.netease.dagger2.MainActivity2_MembersInjector;
import com.netease.dagger2.MainActivity3;
import com.netease.dagger2.MainActivity3_MembersInjector;
import com.netease.dagger2.MainActivity4;
import com.netease.dagger2.MainActivity4_MembersInjector;
import com.netease.dagger2.Student;
import com.netease.dagger2.StudentComponent;
import com.netease.dagger2.StudentModule;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.MembersInjector;
import dagger.internal.Preconditions;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerStudentComponent implements StudentComponent {
  private Provider<Student> getStudentProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private MembersInjector<MainActivity2> mainActivity2MembersInjector;

  private MembersInjector<MainActivity3> mainActivity3MembersInjector;

  private MembersInjector<MainActivity4> mainActivity4MembersInjector;

  private DaggerStudentComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }
  //todo 1 在DaggerStudentComponent中 通过构造者模式创建了 studentModule 和 DaggerStudentComponent
  //  new DaggerStudentComponent的时候走到了todo 2
  public static StudentComponent create() {
    return builder().build();
  }

  //todo 2 首先实例化了 StudentModule_GetStudentFactory(对应到了StudentModule里面的方法，有两个方法的话，会有两个Factory)，然后将实例化的对象传递给MainActivity_MembersInjector进行实例化
  // StudentModule_GetStudentFactory实现了interface Provider<T> { T get(); }， 并且会实现get方法，get方法最后调用到了module.getStudent()
  // todo3最后调用的就是module.getStudent()
  // MainActivity_MembersInjector实现了interface MembersInjector<T> { void injectMembers(T instance);}
  // StudentComponent里面的injectMainActivity 对应到了MainActivity_MembersInjector
  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getStudentProvider = StudentModule_GetStudentFactory.create(builder.studentModule);

    this.mainActivityMembersInjector = MainActivity_MembersInjector.create(getStudentProvider);

    this.mainActivity2MembersInjector = MainActivity2_MembersInjector.create(getStudentProvider);

    this.mainActivity3MembersInjector = MainActivity3_MembersInjector.create(getStudentProvider);

    this.mainActivity4MembersInjector = MainActivity4_MembersInjector.create(getStudentProvider);
  }

  //todo 3 注入，注入的本质就是赋值。injectMembers的内部代码是： mainActivity.student = studentProvider.get();
  @Override
  public void injectMainActivity(MainActivity mainActivity) {
    mainActivityMembersInjector.injectMembers(mainActivity);
  }

  @Override
  public void injectMainActivity(MainActivity2 mainActivity) {
    mainActivity2MembersInjector.injectMembers(mainActivity);
  }

  @Override
  public void injectMainActivity(MainActivity3 mainActivity) {
    mainActivity3MembersInjector.injectMembers(mainActivity);
  }

  @Override
  public void injectMainActivity(MainActivity4 mainActivity) {
    mainActivity4MembersInjector.injectMembers(mainActivity);
  }

  public static final class Builder {
    private StudentModule studentModule;

    private Builder() {}

    public StudentComponent build() {
      if (studentModule == null) {
        this.studentModule = new StudentModule();
      }
      return new DaggerStudentComponent(this);
    }

    public Builder studentModule(StudentModule studentModule) {
      this.studentModule = Preconditions.checkNotNull(studentModule);
      return this;
    }
  }
}
