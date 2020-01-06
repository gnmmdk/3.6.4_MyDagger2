package com.netease.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
/**
  * @Description: dagger2 可以理解为快递
 *  假设要送耳机（Student），需要先把耳机包裹一层（Module），然后快递员（Component）
 *  取到包裹(modules = StudentModule.class)，送到收货地址（injectMainActivity）
  * @Author:        jj.kang
  * @Email:         345498912@qq.com
  * @ProjectName:   ${PROJECT_NAME}
  * @Package:       ${PACKAGE_NAME}
  * @CreateDate:    ${DATE} ${TIME}
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Inject
    public Student student;

    @Inject
    String stt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // student = new Student();

        //  把自己MainActivity--this 交给 Dagger2
        //todo 用法第三步 创建并且注入      原理看create方法
        com.netease.dagger2.test.DaggerStudentComponent.create().injectMainActivity(this); // this MainActivity


        Log.d(TAG, "onCreate: studnet.hashCode():" + student.hashCode() + "     student.name:" + student.name);
    }
}
