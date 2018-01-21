package com.ckkj.zct.door.presenter;

import com.ckkj.zct.baselibrary.presenter.BasePresenter;
import com.ckkj.zct.baselibrary.presenter.view.BaseView;
import com.ckkj.zct.door.data.respository.UserRepository_java;
import com.ckkj.zct.door.presenter.view.UserView_java;
import com.ckkj.zct.door.service.impl.UserServiceImpl_java;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zct11 on 2018/1/21.
 */

public class UserPresenter_java extends BasePresenter<UserView_java> {

    private UserServiceImpl_java userServiceImpl_java=new UserServiceImpl_java();

    public void register(String username,String password,String verityCode){
          /*业务逻辑*/

        userServiceImpl_java.register(username, password, verityCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Flowable<Boolean>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Flowable<Boolean> booleanFlowable) {
                        mView.result("注册成功");
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                });
    }
}
