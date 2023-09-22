package com.example.android_rxjavastudy.rxjavastudy.d_operator_decorator;

public interface Function<T, R> {
    /// 转换的具体操作 交给子类
    R apply(T t); ///入参是 T，  返回的是 R类型
}
