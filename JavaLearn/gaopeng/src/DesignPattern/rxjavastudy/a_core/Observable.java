package DesignPattern.rxjavastudy.a_core;

import DesignPattern.rxjavastudy.b_observableimpl.ObservableCreate;
import DesignPattern.rxjavastudy.d_operator_decorator.Function;
import DesignPattern.rxjavastudy.d_operator_decorator.ObservableMap;

/***
 * 被观察者的核心抽象类
 * 也是使用框架的入口.
 */
abstract  public class Observable<T> implements ObservableSource<T> {
    @Override
    public void subscribe(Observer<T> observer) {
        /// 和谁建立订阅?
        //  怎么建立订阅?
        //  为了保证拓展性交给子类或者开发人员去实现.
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);

    /// 创建一个 create 操作符 就是被观察者。
    /// java 静态方法的泛型不能使用类的泛型，需要定义为 方法的泛型。
    /// 参数为一个 ObservableOnSubscribe 接口的实例。
    /// ObservableOnSubscribe 是调用的时候动态的实现的。
    public static <T> Observable<T> create(ObservableOnSubscribe<T> source) {
        return new ObservableCreate<>(source);
    }

    /// 创建一个 map 操作符 map 操作符是个对象的实例方法 不在需要是静态方法了

    /**
     * map操作符
     * @param function 要做的具体操作的实例对象，开发中可用lambda 表达式等。
     * @return 包装了原来的被观察者的 新的被观察者
     * @param <U> map 操作符以后 返回的类
     */
    public <U> ObservableMap<T, U> map(Function<T,U> function) {
       return new ObservableMap(this, function);
    }


}